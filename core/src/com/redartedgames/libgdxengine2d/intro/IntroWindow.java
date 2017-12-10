package com.redartedgames.libgdxengine2d.intro;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.viewport.FillViewport;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.redartedgames.libgdxengine2d.assets.Biurko;
import com.redartedgames.libgdxengine2d.main.GameScreen;
import com.redartedgames.libgdxengine2d.main.Window;
import com.redartedgames.libgdxengine2d.objects.Guard;

public class IntroWindow extends Window{
	
	public IntroWindow(float x, float y, int width, int height) {
		super(x, y, width, height);
		viewport = new FillViewport(width, height, new OrthographicCamera(100, 100));
		addScreen(new IntroScreen(viewport, x, y, width, height, this));
	}
	
	public void update(float delta) {
		for (GameScreen screen : screens) {
			screen.update(delta);
		}
	}
	
	public void render() {
		for (GameScreen screen : screens) {
			//viewport.setCamera(screen.getCam());
			screen.render();
		}
	}

}
