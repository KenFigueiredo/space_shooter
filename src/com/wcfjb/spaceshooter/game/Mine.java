package com.wcfjb.spaceshooter.game;

import android.graphics.Rect;

public class Mine extends Enemy{
	
	private int missileSpeed = 4;
	
	public Mine(int x, int y){
		
		centerX = x;
		centerY = y;
		
		speedY = 3;
		health = 5;
		
		image = Assets.mine;
		
		r = new Rect(0,0,0,0);
		
	}
	
	@Override
	public void update() {
		
		centerY += speedY;
		
		if(centerY >= 50)
			r.set(centerX-32, centerY-32, centerX + 32, centerY + 32);
		
		if(Rect.intersects(r, Player.yellowRed))
			checkCollision();
		
		if(health == 1 || centerY > 800) {
			die();
			
			if(GameScreen.mineFieldCount > 0) {
				GameScreen.mineFieldCount--;
				
				if(GameScreen.mineFieldCount == 0) {
					GameScreen.bossBattle = false;
					GameScreen.bossCounter = 500;
				}
				
			}
		}
	}
	
	@Override
	public void die(){
		
		shoot();
		
		setCenterY(900);
		r.set(centerX - 25, centerY - 25, centerX + 25, centerY + 35);
		health = 0;
		speedY = 0; speedX = 0;	
	} 
	
	@Override
	public void shoot() {
			
		Projectile TopLSpike = new Projectile(centerX-32, centerY-32);
			TopLSpike.setSpeedY(missileSpeed);
			TopLSpike.setSpeedX(missileSpeed);
			projectiles.add(TopLSpike);
		
		Projectile TopSpike = new Projectile(centerX, centerY - 32);
			TopSpike.setSpeedY(missileSpeed);		
			TopSpike.setSpeedX(0);
			projectiles.add(TopSpike);
		
		Projectile TopRSpike = new Projectile(centerX + 32, centerY - 32);
			TopRSpike.setSpeedY(missileSpeed);
			TopRSpike.setSpeedX(-missileSpeed);
			projectiles.add(TopRSpike);
			
		Projectile LeftSpike = new Projectile(centerX - 32, centerY);
			LeftSpike.setSpeedY(0);	
			LeftSpike.setSpeedX(missileSpeed);
			projectiles.add(LeftSpike);
		
		Projectile RightSpike = new Projectile(centerX + 32, centerY);
			RightSpike.setSpeedY(0);
			RightSpike.setSpeedX(-missileSpeed);
			projectiles.add(RightSpike);
			
		Projectile BotLSpike = new Projectile(centerX - 32, centerY + 32);
			BotLSpike.setSpeedY(-missileSpeed);
			BotLSpike.setSpeedX(missileSpeed);
			projectiles.add(BotLSpike);
			
		Projectile BotSpike = new Projectile(centerX, centerY + 32);					
			BotSpike.setSpeedY(-missileSpeed);
			BotSpike.setSpeedX(0);
			projectiles.add(BotSpike);
		
		Projectile BotRSpike = new Projectile(centerX + 32, centerY + 32);
			BotRSpike.setSpeedY(-missileSpeed);
			BotRSpike.setSpeedX(-missileSpeed);
			projectiles.add(BotRSpike);

	}

}
