package com.wcfjb.spaceshooter.game;

import java.util.List;

import com.wcfjb.spaceshooter.framework.Game;
import com.wcfjb.spaceshooter.framework.Graphics;
import com.wcfjb.spaceshooter.framework.Music;
import com.wcfjb.spaceshooter.framework.Screen;
import com.wcfjb.spaceshooter.framework.Input.TouchEvent;

public class MainMenuScreen extends Screen {
	public MainMenuScreen(Game game) {
		super(game);
	}
	
	private Music theme = Assets.theme;

	@Override
	public void update(float deltaTime) {
		
		Graphics g = game.getGraphics();
		List<TouchEvent> touchEvents = game.getInput().getTouchEvents();
		
		if(GameScreen.playMusic && !theme.isPlaying())
			theme.play();
		
		int len = touchEvents.size();
		for (int i = 0; i < len; i++) {
			TouchEvent event = touchEvents.get(i);
			if (event.type == TouchEvent.TOUCH_UP) {

				if(inBounds(event, 170, 495, 260, 55))	{							
					if(GameScreen.playSound)
						Assets.click.play(0.2f);
					if(theme.isPlaying())
						theme.stop();
					game.setScreen(new GameScreen(game));
				}
				
				if(inBounds(event, 170, 600, 260, 55)){
					if(GameScreen.playSound)
						Assets.click.play(0.2f);
					game.setScreen(new HighScoresScreen(game));
				}
					
				if(inBounds(event, 170, 695, 260, 55)){
					if(GameScreen.playSound)
						Assets.click.play(0.2f);
					android.os.Process.killProcess(android.os.Process.myPid());
				}
				
				if(inBounds(event, 495, 0, 50, 50)) {
					
					if(GameScreen.playSound)
						Assets.click.play(0.2f);
					
					if(GameScreen.playMusic) {
						if(theme.isPlaying())
							theme.stop();
						GameScreen.playMusic = false;
					}
					else {
						theme.play();
						GameScreen.playMusic = true;
					}
					game.setAudio();
				}
				if(inBounds(event, 550, 0, 50, 50)) {
					
					if(!GameScreen.playSound)
						Assets.click.play(0.2f);
					
					GameScreen.playSound = !GameScreen.playSound;
					game.setAudio();
				}

			}
		}
	}

	private boolean inBounds(TouchEvent event, int x, int y, int width,
			int height) {
		if (event.x > x && event.x < x + width - 1 && event.y > y
				&& event.y < y + height - 1)
			return true;
		else
			return false;
	}

	@Override
	public void paint(float deltaTime) {
		
		Graphics g = game.getGraphics();
		g.drawImage(Assets.menu, 0, 0);
		
		if(GameScreen.playMusic)
			g.drawImage(Assets.musicon, 495, 0);
		else
			g.drawImage(Assets.musicoff, 495, 0);
		
		if(GameScreen.playSound)
			g.drawImage(Assets.soundon, 550, 0);
		else
			g.drawImage(Assets.soundoff, 550, 0);
		
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
        android.os.Process.killProcess(android.os.Process.myPid());

	}
}
