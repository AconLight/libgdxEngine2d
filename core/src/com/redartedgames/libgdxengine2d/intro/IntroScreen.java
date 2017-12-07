package com.redartedgames.libgdxengine2d.intro;

import com.badlogic.gdx.utils.viewport.Viewport;
import com.redartedgames.libgdxengine2d.main.GameScreen;

public class IntroScreen extends GameScreen{

	public IntroScreen(Viewport viewport, int width, int height) {
		super(viewport, 1, width, height);
		world = new IntroWorld(cam);
	}

}
