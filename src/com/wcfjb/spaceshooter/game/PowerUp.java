package com.wcfjb.spaceshooter.game;

import android.graphics.Rect;

import com.wcfjb.spaceshooter.framework.Image;
import com.wcfjb.spaceshooter.framework.Sound;

public class PowerUp {
	
	// Variable declarations
	private int x, y, speedY, type;
	private boolean visible;
	private Sound powerUp = Assets.powerup;
	
	private Animation poweranim;
	
	private Image bomb00 = Assets.bomb00, bomb01 = Assets.bomb01, bomb02 = Assets.bomb02, bomb03 = Assets.bomb03, 
			gun00 = Assets.gun00, gun01 = Assets.gun01, gun02 = Assets.gun02, gun03 = Assets.gun03, 
			life00 = Assets.life00, life01 = Assets.life01, life02 = Assets.life02, life03 = Assets.life03;
	
	private Image typeImage;
	
	private Rect r;
	
	public PowerUp(int startX, int startY, int type){
		
		x = startX;
		y = startY;
		this.type = type;
		speedY = 3;
		
		poweranim = new Animation();
		
		visible = true;
		
		// Switch statement to get the correct type of image for the PowerUp
		switch(this.type) {
			case 1:
				poweranim.addFrame(gun00, 100);
				poweranim.addFrame(gun01, 100);
				poweranim.addFrame(gun02, 100);
				poweranim.addFrame(gun03, 100);
				break;
			case 2:
				poweranim.addFrame(life00, 100);
				poweranim.addFrame(life01, 100);
				poweranim.addFrame(life02, 100);
				poweranim.addFrame(life03, 100);
				break;
			case 3:
				poweranim.addFrame(bomb00, 100);
				poweranim.addFrame(bomb01, 100);
				poweranim.addFrame(bomb02, 100);
				poweranim.addFrame(bomb03, 100);
				break;
		}
		
		typeImage = poweranim.getImage();
		r = new Rect(0, 0, 0, 0);
	}
	
	// Behaves almost exactly like a projectile
	public void update(){
		
		// Increases the yCoordinate of the PowerUp, moving it downscreen towards the player
		y += speedY;
		
		// Setting the rectangle that will be used for collision detection
		r.set(x-11, y-18, x+11, y+18);

		// Checks if the PowerUp has moved off screen
		if (y > 800){
			visible = false;
			r = null;
		}
		if (visible){
			checkCollision();
		}
		
		poweranim.update(10);
		typeImage = poweranim.getImage();
		
	}
	
	// Checks collision between the player and the PowerUp
	private void checkCollision() {
		
		if (Rect.intersects(r, Player.rect)|| Rect.intersects(r, Player.rect2)) {
			
			visible = false;
			
			if(GameScreen.playSound)
				powerUp.play(0.5f);
			
			// Depending on the PowerUp, certain properties are modified. Pretty 
			// self-explanatory by the variable names
			switch(this.type) {
				case 1:
					GameScreen.getPlayer().triShot = true;
					GameScreen.getPlayer().triShotCounter = 50;
					break;
				case 2:
					if(GameScreen.livesLeft < 5)
						GameScreen.livesLeft++;
					break;
				case 3:
					GameScreen.bombs++;
					break;
			}
		}
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getSpeedY() {
		return speedY;
	}

	public boolean isVisible() {
		return visible;
	}

	public Image getTypeImage() {
		return typeImage;
	}

	public void setTypeImage(Image typeImage) {
		this.typeImage = typeImage;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void setSpeedY(int speedY) {
		this.speedY = speedY;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}
	
	

}
