package com.wcfjb.spaceshooter.game;

import com.wcfjb.spaceshooter.framework.Image;


public class Background {
	
	private int bgX, bgY, speedY;
	private Image image, bg, bg1, bg2, bg3;
	
	public Background(int x, int y){
		bgX = x;
		bgY = y;
		speedY = 1;
		
		bg = Assets.background;
		bg1 = Assets.background1;
		bg2 = Assets.background2;
		bg3 = Assets.background3;
		
		image = bg;
	}
	
	// THIS UPDATED ON GITHUB, AND AGAIN, AND AGAIN, and again?
	
	public void update() {
		
		// Scrolls the background down, so it looks like the player is moving
		bgY += speedY;

		// Once the background has moved far enough off screen, it is reset at the top with a new randomly chosen background image
		if (bgY >= 800){ 
			bgY -= 1600;
			this.image = changeBackground();		
		}
		
	}

	public int getBgX() {
		return bgX;
	}

	public int getBgY() {
		return bgY;
	}

	public int getSpeedY() {
		return speedY;
	}

	public void setBgX(int bgX) {
		this.bgX = bgX;
	}

	public void setBgY(int bgY) {
		this.bgY = bgY;
	}

	public void setSpeedY(int speedY) {
		this.speedY = speedY;
	}
	
	public Image changeBackground(){
		
		//Random Background is chosen here, changing the numbers in the if/else statements
		//will change the probability of that certain background to be chosen.
		//These backgrounds are loaded in LoadingScreen as background.jpg, background1.jpg, etc.
			int bgPick = (int) (Math.random() * 100);
			
				if(bgPick <= 15)
					return bg1;
				
				else if(bgPick > 15 && bgPick <= 30)
					return bg2;
				
				else if(bgPick > 30 && bgPick <= 45)
					return bg3;
				
				else // 75 > bgPick < 100
					return bg;	
	}

	public Image getImage(){
		return image;
	}
	
	
}
