package com.redartedgames.libgdxengine2d.scene;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.redartedgames.libgdxengine2d.gameobject.GameObject;
import com.redartedgames.libgdxengine2d.gameobject.SpriteObject;

public class World {

	protected ArrayList<GameObject> gameObjects;
	protected OrthographicCamera cam;
	protected Screen gameScreen;
	
	public World(OrthographicCamera cam, Screen gameScreen) {
		gameObjects = new ArrayList<GameObject>();
		this.gameScreen = gameScreen;
		this.cam = cam;
	}
	
	public void update(float delta) {
		
		
		
		for (GameObject obj: gameObjects) {
			obj.update(delta);
		}
		
		for (GameObject obj: gameObjects) {
			obj.updateBefore(delta, 0, 0);
		}
		
		for (GameObject obj: gameObjects) {
			//Gdx.app.log("world size: ", "" + obj.collidableObjects.size());
		}
		
		for (GameObject obj: gameObjects) {
			obj.applyPhysicsToAcceleration();
		}
		
		for (GameObject obj: gameObjects) {
			obj.updateAfter(delta, 0, 0);
		}
		
		for (GameObject obj: gameObjects) {
			obj.updateLast(delta, 0, 0);
		}
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
