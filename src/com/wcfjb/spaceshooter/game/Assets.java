package com.wcfjb.spaceshooter.game;

import com.wcfjb.spaceshooter.framework.Image;
import com.wcfjb.spaceshooter.framework.Music;
import com.wcfjb.spaceshooter.framework.Sound;

public class Assets {
	
	public static Image menu, menu_back, splash, background, background1, background2, background3, highScores, pause, bombia, bombii, soundon, soundoff, musicon, musicoff, warning;
	public static Image trishot, laserlong, shipL1, shipL2, shipL3, shipR1, shipR2, shipR3, lineshooter;
	public static Image bomb, ship, ship_respawn, oneplus, lives, doppleganger, grunt, drone, laserguy, laser, elaser, mine, mSpike, lsLas;
	public static Image explosion1, explosion2, explosion3, explosion4, explosion5, taptostart, menubutton, resumebutton, gameover;
	public static Image bomb00, bomb01, bomb02, bomb03, gun00, gun01, gun02, gun03, life00, life01, life02, life03;
	public static Sound click, explode, shoot, playerDeath, powerup, LSshoot, LSlasCharge;
	public static Music theme, ingame, bossmusic;
	
	public static void load(SampleGame sampleGame) {
		// TODO Auto-generated method stub
		Assets.theme = sampleGame.getAudio().createMusic("menutheme.mp3");
		Assets.theme.setLooping(true);
		Assets.theme.setVolume(0.2f);
	}
	
}
