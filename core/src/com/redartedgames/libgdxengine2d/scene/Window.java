package com.redartedgames.libgdxengine2d.scene;

import java.util.ArrayList;

import com.badlogic.gdx.utils.viewport.Viewport;
import com.redartedgames.libgdxengine2d.LibgdxEngine2dGame;

public class Window {

	protected Viewport viewport;
	public ArrayList<Screen> screens;
	protected float x, y, width, height, sclX, sclY;
	public LibgdxEngine2dGame game;
	
	public Window(float x, float y, float width, float height, LibgdxEngine2dGame game) {
		screens = new ArrayList<Screen>();
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
	
	public void addScreen(Screen screen) {
		screens.add(screen);
	}
	
	public void update(float delta) {
		for (Screen screen : screens) {
			screen.update(delta);
		}
	}
	
	public void render() {
		for (Screen screen : screens) {
			screen.render();
		}
	}
	public void updateWindow(int width, int height) {
		viewport.update(width, height);
	}
}
