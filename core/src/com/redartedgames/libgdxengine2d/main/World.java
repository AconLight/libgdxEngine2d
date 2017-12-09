package com.redartedgames.libgdxengine2d.main;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class World {

	protected ArrayList<GameObject> gameObjects;
	protected OrthographicCamera cam;
	protected GameScreen gameScreen;
	
	public World(OrthographicCamera cam, GameScreen gameScreen) {
		gameObjects = new ArrayList<GameObject>();
		this.gameScreen = gameScreen;
		this.cam = cam;
	}
	
	public void update(float delta) {
		
	}
	
	public ArrayList<GameObject> getGameObjects() {
		return gameObjects;
	}
	
	protected GameObject addGameObject(GameObject obj) {
		gameObjects.add(obj);
		return obj;
	}
	
	protected SpriteObject addSpriteObject(SpriteObject obj) {
		gameObjects.add(obj);
		return obj;
	}
	
	public void render(SpriteBatch batch, float visibility) {
		cam.update();
		batch.setProjectionMatrix(cam.combined);
		for (GameObject obj: gameObjects) {
			obj.render(batch, 1, 0, 0, visibility);
		}
	}
	
	public void render(ShapeRenderer batch, float visibility) {
		cam.update();
		batch.setProjectionMatrix(cam.combined);
		for (GameObject obj: gameObjects) {
			obj.render(batch, 1, 0, 0, visibility);
		}
	}
	
}
