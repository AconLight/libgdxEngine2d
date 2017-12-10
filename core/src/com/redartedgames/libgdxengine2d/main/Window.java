package com.redartedgames.libgdxengine2d.main;

import java.util.ArrayList;

import com.badlogic.gdx.utils.viewport.Viewport;
import com.redartedgames.libgdxengine2d.LibgdxEngine2dGame;

public class Window {

	protected Viewport viewport;
	public ArrayList<GameScreen> screens;
	protected float x, y, width, height, sclX, sclY;
	public LibgdxEngine2dGame game;
	
	public Window(float x, float y, float width, float height, LibgdxEngine2dGame game) {
		screens = new ArrayList<GameScreen>();
		this.game = game;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		sclX = 1;
		sclY = 1;
	}
	
	public void resize(float width, float height) {

		//viewport.setScreenBounds((int)(x*sclX), (int)(y*sclY), (int)(width*sclX), (int)(height*sclY));
		//viewport.setScreenSize(100, 100);
		//viewport.apply();
		
		viewport.setWorldSize((int)(width), (int)(height));
		viewport.apply();
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
	public void updateWindow(int width, int height) {
		viewport.update(width, height);
	}
}
