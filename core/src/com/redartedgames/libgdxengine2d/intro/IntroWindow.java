package com.redartedgames.libgdxengine2d.intro;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.redartedgames.libgdxengine2d.main.GameScreen;
import com.redartedgames.libgdxengine2d.main.Window;

public class IntroWindow extends Window{

	public IntroWindow(float x, float y, int width, int height) {
		super(x, y, width, height);
		viewport = new ScreenViewport(new OrthographicCamera(width, height));
		addScreen(new IntroScreen(viewport, width, height));
	}
	
	public void update(float delta) {
		for (GameScreen screen : screens) {
			screen.update(delta);
		}
	}
	
	public void render() {
		for (GameScreen screen : screens) {
			viewport.setCamera(screen.getCam());
			screen.render();
		}
	}

}
