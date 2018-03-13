package com.redartedgames.libgdxengine2d.gameWorld;

import com.badlogic.gdx.utils.viewport.Viewport;
import com.redartedgames.libgdxengine2d.intro.IntroWorld;
import com.redartedgames.libgdxengine2d.scene.Screen;
import com.redartedgames.libgdxengine2d.scene.Window;

public class GameScreen extends Screen{

	public GameScreen(Viewport viewport, float visibility, float x, float y, int width, int height, Window window) {
		super(viewport, visibility, x, y, width, height, window);
		world = new GameWorld(cam, this);
	}

}
