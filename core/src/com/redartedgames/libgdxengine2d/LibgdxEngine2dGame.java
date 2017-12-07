package com.redartedgames.libgdxengine2d;

import java.util.ArrayList;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.redartedgames.libgdxengine2d.intro.IntroWindow;
import com.redartedgames.libgdxengine2d.main.Window;

public class LibgdxEngine2dGame extends ApplicationAdapter {
	
	IntroWindow introWin;
	int gameWidth = 1920, gameHeight = 1080;
	ArrayList<Window> windows;
	
	@Override
	public void create () {
		windows = new ArrayList<Window>();
		introWin = new IntroWindow(0, 0, gameWidth, gameHeight);
		introWin.resize(Gdx.graphics.getWidth()/gameWidth, Gdx.graphics.getHeight()/gameHeight);
		
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
	public void dispose () {
		
	}
}
