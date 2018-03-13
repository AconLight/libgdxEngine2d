package com.redartedgames.libgdxengine2d.gameWorld;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.redartedgames.libgdxengine2d.assetexample.AssetExampleLoader;
import com.redartedgames.libgdxengine2d.scene.Screen;
import com.redartedgames.libgdxengine2d.scene.World;

public class GameWorld extends World{
	
	public GameWorld(OrthographicCamera cam, Screen gameScreen) {
		super(cam, gameScreen);
		gameObjects.addAll(AssetExampleLoader.getObjects());
	}
	
	public void update(float delta) {
		super.update(delta);
	}

}
