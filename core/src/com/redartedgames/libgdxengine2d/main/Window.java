package com.redartedgames.libgdxengine2d.main;

import java.util.ArrayList;

import com.badlogic.gdx.utils.viewport.Viewport;

public class Window {

	protected Viewport viewport;
	protected ArrayList<GameScreen> screens;
	protected float x, y, width, height, sclX, sclY;
	
	public Window(float x, float y, float width, float height) {
		screens = new ArrayList<GameScreen>();
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		sclX = 1;
		sclY = 1;
	}
	
	public void resize(float sclx, float scly) {
		sclX = sclx;
		sclY = scly;
		viewport.setScreenBounds((int)(x*sclX), (int)(y*sclY), (int)(width*sclX), (int)(height*sclY));
	}
	
	public void addScreen(GameScreen screen) {
		screens.add(screen);
	}
	
	public void update(float delta) {
		for (GameScreen screen : screens) {
			screen.update(delta);
		}
	}
	
	public void render() {
		for (GameScreen screen : screens) {
			screen.render();
		}
	}
}
