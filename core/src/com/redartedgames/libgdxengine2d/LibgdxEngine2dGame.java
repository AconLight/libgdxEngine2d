package com.redartedgames.libgdxengine2d;

import java.util.ArrayList;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.redartedgames.libgdxengine2d.gameWorld.GameWindow;
import com.redartedgames.libgdxengine2d.gameWorld.GameWorld;
import com.redartedgames.libgdxengine2d.gameWorld.GameWorldInputHandler;
import com.redartedgames.libgdxengine2d.intro.IntroWindow;
import com.redartedgames.libgdxengine2d.scene.ScreenConsts;
import com.redartedgames.libgdxengine2d.scene.Window;

public class LibgdxEngine2dGame extends ApplicationAdapter {
	
	IntroWindow introWin;
	GameWindow gw;
	ArrayList<Window> windows;
	ArrayList<Window> presentation;
	int presentationI = 0;
	
	public void presentationNext() {
		windows.remove(presentation.get(presentationI));
		presentationI++;
		if (presentationI < presentation.size())
		windows.add(presentation.get(presentationI));
	}
	
	private void loadPresentation() {
		introWin = new IntroWindow(0, 0, (int)ScreenConsts.gameWidth, (int) ScreenConsts.gameHeight, this);
		gw = new GameWindow(0, 0, (int)ScreenConsts.gameWidth, (int) ScreenConsts.gameHeight, this);
		presentation.add(introWin);
		presentation.add(gw);
	}
	
	@Override
	public void create () {
		presentation = new ArrayList<Window>();
		windows = new ArrayList<Window>();
		loadPresentation();
		windows.add(presentation.get(0));
		Gdx.input.setInputProcessor(new GameWorldInputHandler((GameWorld) gw.screens.get(0).world));
	}

	@Override
	public void render () {

		for (Window window : windows) {
			window.update(Gdx.graphics.getDeltaTime());
		}
		
		Gdx.gl.glClearColor(0.1f, 0.1f, 0.1f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		for (Window window : windows) {
			window.render();
		}
		
	}
	
	@Override
	public void resize (int width, int height) {
		
	}
	
	@Override
	public void dispose () {
		
	}
}
