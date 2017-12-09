package com.redartedgames.libgdxengine2d.intro;

import com.badlogic.gdx.utils.viewport.Viewport;
import com.redartedgames.libgdxengine2d.main.GameScreen;
import com.redartedgames.libgdxengine2d.main.Window;

public class IntroScreen extends GameScreen{

	public IntroScreen(Viewport viewport, float x, float y, int width, int height, Window window) {
		super(viewport, 1, x, y, width, height, window);
		world = new IntroWorld(cam, this);
	}

}
