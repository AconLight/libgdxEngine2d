package com.redartedgames.libgdxengine2d.gameWorld;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.viewport.FillViewport;
import com.redartedgames.libgdxengine2d.LibgdxEngine2dGame;
import com.redartedgames.libgdxengine2d.intro.IntroScreen;
import com.redartedgames.libgdxengine2d.main.GameScreen;
import com.redartedgames.libgdxengine2d.main.Window;

public class GameWindow extends Window {

	public GameWindow(float x, float y, int width, int height, LibgdxEngine2dGame game) {
		super(x, y, width, height, game);
		viewport = new FillViewport(width, height, new OrthographicCamera(100, 100));
		addScreen(new MyGameScreen(viewport, 1, x, y, width, height, this));
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
