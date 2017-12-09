package com.redartedgames.libgdxengine2d;

import java.util.ArrayList;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.redartedgames.libgdxengine2d.gameWorld.GameWindow;
import com.redartedgames.libgdxengine2d.intro.IntroWindow;
import com.redartedgames.libgdxengine2d.main.Window;

public class LibgdxEngine2dGame extends ApplicationAdapter {
	
	boolean isVerticalBlack = true;
	IntroWindow introWin;
	GameWindow gw;
	float gameWidth = 1280*1.5f, gameHeight = 720*1.5f;
	ArrayList<Window> windows;
	
	@Override
	public void create () {
		windows = new ArrayList<Window>();
		introWin = new IntroWindow(0, 0, (int)gameWidth, (int) gameHeight);
		gw = new GameWindow(0, 0, (int)gameWidth, (int) gameHeight);
		if(gameWidth/gameHeight < Gdx.graphics.getWidth()/Gdx.graphics.getHeight())
		introWin.resize(Gdx.graphics.getWidth()*gameHeight/Gdx.graphics.getHeight(), gameHeight);
		else
		introWin.resize(gameWidth, Gdx.graphics.getHeight()*gameWidth/Gdx.graphics.getWidth());
		windows.add(introWin);
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
