package com.wcfjb.spaceshooter.game;

import com.wcfjb.spaceshooter.framework.Game;
import com.wcfjb.spaceshooter.framework.Graphics;
import com.wcfjb.spaceshooter.framework.Screen;
import com.wcfjb.spaceshooter.framework.Graphics.ImageFormat;

public class LoadingScreen extends Screen {
	public LoadingScreen(Game game) {
		
		super(game);
	}

	// Loads all assets that are used in the game. You can find all the assets in the assets folder
	@Override
	public void update(float deltaTime) {
		
		Graphics g = game.getGraphics();
		Assets.menu = g.newImage("menu.png", ImageFormat.ARGB4444);
		Assets.menu_back = g.newImage("menu_back.png", ImageFormat.RGB565);
		Assets.highScores = g.newImage("highscores.png", ImageFormat.RGB565);
		Assets.background = g.newImage("background.jpg", ImageFormat.RGB565);
		Assets.background1 = g.newImage("background1.jpg", ImageFormat.RGB565);
		Assets.background2 = g.newImage("background2.jpg", ImageFormat.RGB565);
		Assets.background3 = g.newImage("background3.jpg", ImageFormat.RGB565);
		Assets.lives = g.newImage("lives.png", ImageFormat.RGB565);
		Assets.trishot = g.newImage("trishot.png", ImageFormat.RGB565);
		Assets.pause = g.newImage("pause.png", ImageFormat.RGB565);
		Assets.oneplus = g.newImage("oneplus.png", ImageFormat.RGB565);
		Assets.ship_respawn = g.newImage("ship_respawn.png", ImageFormat.ARGB4444);
		Assets.bomb = g.newImage("bomb.png", ImageFormat.RGB565);
		Assets.bombia = g.newImage("bomb_icon_active.png", ImageFormat.RGB565);
		Assets.bombii = g.newImage("bomb_icon_inactive.png", ImageFormat.RGB565);
		Assets.soundoff = g.newImage("soundoff.png", ImageFormat.RGB565);
		Assets.soundon = g.newImage("soundon.png", ImageFormat.RGB565);
		Assets.musicoff = g.newImage("musicoff.png", ImageFormat.RGB565);
		Assets.musicon = g.newImage("musicon.png", ImageFormat.RGB565);
		Assets.warning = g.newImage("warning.png", ImageFormat.ARGB4444);
		Assets.taptostart = g.newImage("taptostart.png", ImageFormat.ARGB4444);
		Assets.menubutton = g.newImage("menubutton.png", ImageFormat.ARGB4444);
		Assets.resumebutton = g.newImage("resumebutton.png", ImageFormat.ARGB4444);
		Assets.gameover = g.newImage("gameover.png", ImageFormat.ARGB4444);

		Assets.bomb00 = g.newImage("bomb00.png", ImageFormat.RGB565);
		Assets.bomb01 = g.newImage("bomb01.png", ImageFormat.RGB565);
		Assets.bomb02 = g.newImage("bomb02.png", ImageFormat.RGB565);
		Assets.bomb03 = g.newImage("bomb03.png", ImageFormat.RGB565);
		Assets.gun00 = g.newImage("gun00.png", ImageFormat.RGB565);
		Assets.gun01 = g.newImage("gun01.png", ImageFormat.RGB565);
		Assets.gun02 = g.newImage("gun02.png", ImageFormat.RGB565);
		Assets.gun03 = g.newImage("gun03.png", ImageFormat.RGB565);
		Assets.life00 = g.newImage("life00.png", ImageFormat.RGB565);
		Assets.life01 = g.newImage("life01.png", ImageFormat.RGB565);
		Assets.life02 = g.newImage("life02.png", ImageFormat.RGB565);
		Assets.life03 = g.newImage("life03.png", ImageFormat.RGB565);
		
		Assets.ship = g.newImage("ship.png", ImageFormat.RGB565);
		Assets.shipL1 = g.newImage("ship_bank_left1.png", ImageFormat.RGB565);
		Assets.shipL2 = g.newImage("ship_bank_left2.png", ImageFormat.RGB565);
		Assets.shipL3 = g.newImage("ship_bank_left3.png", ImageFormat.RGB565);
		Assets.shipR1 = g.newImage("ship_bank_right1.png", ImageFormat.RGB565);
		Assets.shipR2 = g.newImage("ship_bank_right2.png", ImageFormat.RGB565);
		Assets.shipR3 = g.newImage("ship_bank_right3.png", ImageFormat.RGB565);

		
		Assets.grunt = g.newImage("enemy.png", ImageFormat.RGB565);
		Assets.drone = g.newImage("drone.png", ImageFormat.RGB565);
		Assets.laserguy = g.newImage("laserguy.png", ImageFormat.RGB565);
		Assets.doppleganger = g.newImage("doppleganger.png", ImageFormat.RGB565);
		Assets.lineshooter = g.newImage("lineshooter.png", ImageFormat.RGB565);
		Assets.laser = g.newImage("laser.png", ImageFormat.RGB565);
		Assets.elaser = g.newImage("elaser.png", ImageFormat.RGB565);
		Assets.lsLas = g.newImage("LSlas.png", ImageFormat.RGB565);
		Assets.mine = g.newImage("mine.png", ImageFormat.RGB565);
		Assets.mSpike = g.newImage("MineSpike.png", ImageFormat.RGB565);
		
		Assets.explosion1 = g.newImage("explosion1.png", ImageFormat.RGB565);
		Assets.explosion2 = g.newImage("explosion2.png", ImageFormat.RGB565);
		Assets.explosion3 = g.newImage("explosion3.png", ImageFormat.RGB565);
		Assets.explosion4 = g.newImage("explosion4.png", ImageFormat.RGB565);
		Assets.explosion5 = g.newImage("explosion5.png", ImageFormat.RGB565);
		
		// Load sounds
		Assets.explode = game.getAudio().createSound("explode.wav");
		Assets.shoot = game.getAudio().createSound("laser.ogg");
		Assets.click = game.getAudio().createSound("click.ogg");
		Assets.playerDeath = game.getAudio().createSound("playerdeath.wav");
		Assets.powerup = game.getAudio().createSound("powerup.wav");
		Assets.LSshoot = game.getAudio().createSound("LSshoot.ogg");
		Assets.LSlasCharge = game.getAudio().createSound("LSlasCharge.ogg");
		
		// Load music
		Assets.ingame = game.getAudio().createMusic("ingamemusic.mp3");
		Assets.ingame.setLooping(true);
		Assets.ingame.setVolume(0.04f);
		
		game.setScreen(new MainMenuScreen(game));
	}

	// Paints the loading screen on the display
	@Override
	public void paint(float deltaTime) {
		Graphics g = game.getGraphics();
		g.drawImage(Assets.splash, 0, 0);	
	}

	@Override
	public void pause() {

	}

	@Override
	public void resume() {

	}

	@Override
	public void dispose() {

	}

	@Override
	public void backButton() {

	}
}