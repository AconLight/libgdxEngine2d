package com.redartedgames.libgdxengine2d.intro;

import com.badlogic.gdx.utils.viewport.Viewport;
import com.redartedgames.libgdxengine2d.scene.Screen;
import com.redartedgames.libgdxengine2d.scene.Window;

public class IntroScreen extends Screen{
	public IntroScreen(Viewport viewport, float x, float y, int width, int height, Window window) {
		super(viewport, 1, x, y, width, height, window);
		world = new IntroWorld(cam, this);
		
	}

}
