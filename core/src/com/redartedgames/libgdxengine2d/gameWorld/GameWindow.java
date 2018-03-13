package com.redartedgames.libgdxengine2d.gameWorld;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.viewport.FillViewport;
import com.redartedgames.libgdxengine2d.LibgdxEngine2dGame;
import com.redartedgames.libgdxengine2d.intro.IntroScreen;
import com.redartedgames.libgdxengine2d.scene.Screen;
import com.redartedgames.libgdxengine2d.scene.ScreenConsts;
import com.redartedgames.libgdxengine2d.scene.Window;

public class GameWindow extends Window {

	
	public GameWindow(float x, float y, int width, int height, LibgdxEngine2dGame game) {
		super(x, y, width, height, game);
		viewport = new FillViewport(width, height, new OrthographicCamera(100, 100));
		addScreen(new GameScreen(viewport, 1, x, y, width, height, this));
		if(ScreenConsts.gameWidth/ScreenConsts.gameHeight < Gdx.graphics.getWidth()/Gdx.graphics.getHeight())
			resize(Gdx.graphics.getWidth()*ScreenConsts.gameHeight/Gdx.graphics.getHeight(), ScreenConsts.gameHeight);
		else
			resize(ScreenConsts.gameWidth, Gdx.graphics.getHeight()*ScreenConsts.gameWidth/Gdx.graphics.getWidth());
	}
	
	public void update(float delta) {
		for (Screen screen : screens) {
			screen.update(delta);
		}
	}
	
	public void render() {
		for (Screen screen : screens) {
			//viewport.setCamera(screen.getCam());
			screen.render();
		}
	}
}
