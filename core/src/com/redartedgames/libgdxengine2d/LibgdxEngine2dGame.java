package com.redartedgames.libgdxengine2d;

import java.util.ArrayList;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.redartedgames.libgdxengine2d.gameWorld.GameWindow;
import com.redartedgames.libgdxengine2d.gameWorld.GameWorld;
import com.redartedgames.libgdxengine2d.intro.IntroWindow;
import com.redartedgames.libgdxengine2d.main.InputHandler;
import com.redartedgames.libgdxengine2d.main.SpriteObject;
import com.redartedgames.libgdxengine2d.main.Window;
import com.redartedgames.libgdxengine2d.sound.MySound;
import com.redartedgames.libgdxengine2d.sound.SoundGlitch;

public class LibgdxEngine2dGame extends ApplicationAdapter {
	
	boolean isVerticalBlack = true;
	IntroWindow introWin;
	public GameWindow gw;
	float gameWidth = 1920, gameHeight = 1080;
	ArrayList<Window> windows;
	SoundGlitch g;
	SpriteObject menu;
	public void startGame() {
		
		windows.remove(introWin);
		windows.add(gw);
	}
	
	@Override
	public void create () {
		
		windows = new ArrayList<Window>();
		introWin = new IntroWindow(0, 0, (int)gameWidth, (int) gameHeight, this);
		gw = new GameWindow(0, 0, (int)gameWidth, (int) gameHeight, this);
		if(gameWidth/gameHeight < Gdx.graphics.getWidth()/Gdx.graphics.getHeight())
			introWin.resize(Gdx.graphics.getWidth()*gameHeight/Gdx.graphics.getHeight(), gameHeight);
		else
		introWin.resize(gameWidth, Gdx.graphics.getHeight()*gameWidth/Gdx.graphics.getWidth());
		
		if(gameWidth/gameHeight < Gdx.graphics.getWidth()/Gdx.graphics.getHeight())
			gw.resize(Gdx.graphics.getWidth()*gameHeight/Gdx.graphics.getHeight(), gameHeight);
		else
		gw.resize(gameWidth, Gdx.graphics.getHeight()*gameWidth/Gdx.graphics.getWidth());
		
		//gw.screens.get(0).visibility = 0;
		//windows.add(gw);
		
		windows.add(introWin);
		Gdx.input.setInputProcessor(new InputHandler((GameWorld) gw.screens.get(0).world));
	}

	@Override
	public void render () {

		for (Window window : windows) {
			window.update(Gdx.graphics.getDeltaTime());
		}
		
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		for (Window window : windows) {
			window.render();
		}
		
	}
	
	@Override
	public void resize (int width, int height) {
		introWin.updateWindow(width, height);
		if (true)
			for (Window window : windows) {
				//window.resize(width*gameHeight/height, gameHeight);
				//window.resize(1280, 720);
			}
		else {
			for (Window window : windows) {
				window.resize(gameWidth, Gdx.graphics.getHeight()*gameWidth/Gdx.graphics.getWidth());
			}
		}
	}
	
	@Override
	public void dispose () {
		
	}
}
