package com.wcfjb.spaceshooter.game;

public class MineField extends Enemy {
	
	public MineField(int bossCount){
		
		GameScreen.mineFieldCount = 10 * (bossCount / 2);
		
		for(int i = 0; i < 10 * (bossCount / 2); i++){
			
			Mine mine =	new Mine((int)(Math.random() * 500) + 50, (int)((Math.random()) * (800*bossCount/2)) - (800*bossCount/2));
			mine.health = 3;
			GameScreen.enemies.add(mine);
		}	
	}
	
	@Override
	public void update() {
	}

	@Override
	public void shoot() {
	}

}
