package com.redartedgames.libgdxengine2d.main;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.redartedgames.libgdxengine2d.main.Hitbox.BehaviorMode;

public class GameObject {
	protected boolean isAttached;
	protected Movement movement;
	protected GameObject parent;
	protected ArrayList<GameObject> gameObjects;
	protected Hitbox hitbox;
	private float collisionAccX, collisionAccY;
	public ArrayList<GameObject> collidableObjects;
	
	public ArrayList<GameObject> getGameObjects() {
		return gameObjects;
	}
	
	public Hitbox getHitbox() {
		return hitbox;
	}

	public GameObject(float x, float y, GameObject parent, boolean isAttached) {
		movement = new Movement(new Vector2(x, y));			
		this.parent = parent;
		gameObjects = new ArrayList<GameObject>();
		collidableObjects = new ArrayList<GameObject>();
		hitbox = new Hitbox();
		this.isAttached = isAttached;
	}
	
	public void setHitbox(Hitbox hitbox) {
		this.hitbox = hitbox;
	}
	
	public void transformOnlyThis(float x, float y) {
		movement.getPosition().x += x;
		movement.getPosition().y += y;
		for(int i=0; i<gameObjects.size();i++)
			gameObjects.get(i).transform(-x, -y);
	}
	
	public void transform(float x, float y) {
		movement.getPosition().x += x;
		movement.getPosition().y += y;
	}
	public void update(float delta) {
		for (GameObject obj : gameObjects) {
			obj.update(delta);
		}
		updateBefore(delta, 0, 0);
	}
	
	public void updateBefore(float delta, float vx, float vy) {
		movement.updateBefore(delta);
		hitbox.update(movement.position.x, movement.position.y);
		movement.setColToZero();
		for (GameObject obj : gameObjects) {
			obj.updateBefore(delta, vx, vy);
		}
	}
	

	public void updateAfter(float delta, float vx, float vy) {
		movement.setAccToG();
		movement.addColToAcc();			
		movement.updateAfter(delta);
		for (GameObject obj : gameObjects) {
			obj.updateAfter(delta, vx, vy);
		}
	}
	
	public void updateLast(float delta, float vx, float vy) {
		for (GameObject obj : gameObjects) {
			obj.updateLast(delta, vx, vy);
		}
	}
	
	public GameObject getSuperParent() {
		GameObject itr = this;
		while (this.parent != null) itr = itr.parent; 
		return itr;
	}
	
	public float getRealpositionX(float oldx) {
		oldx = this.movement.getPosition().x;
		if(this.parent != null) parent.getRealpositionX(oldx) ;
		return oldx;
	}
	public float getRealpositionY(float oldy) {
		oldy = this.movement.getPosition().y;
		if(this.parent != null) parent.getRealpositionX(oldy) ;
		return oldy;
	}
	
	public void collide(GameObject obj) {
		
	}
	
	public void applyPhysicsToAcceleration() {
		if (hitbox.bMode == BehaviorMode.dynamic || hitbox.bMode == BehaviorMode.kinematic) {
			

			collisionAccX = 0;
			collisionAccY = 0;
			
			for(int i = 0; i < collidableObjects.size(); i++) {
				collide(collidableObjects.get(i));
			}

		}
		for (GameObject obj : gameObjects) {
			obj.applyPhysicsToAcceleration();
		}
	}
	
	public Movement getMovement() {
		return movement;
	}

	public SpriteObject addSprite(SpriteObject e) {
		gameObjects.add(e);
		return (SpriteObject) gameObjects.get(gameObjects.size()-1);
	}
	
	public GameObject addGameObject(GameObject obj) {
		gameObjects.add(obj);
		return gameObjects.get(gameObjects.size()-1);
	}
	
	public void render(SpriteBatch batch, int priority, float dx, float dy, float visibility) {
		for(int i=0; i<gameObjects.size();i++)
			if (isAttached) gameObjects.get(i).render(batch, priority, dx + movement.position.x, dy + movement.position.y, visibility);
			else gameObjects.get(i).render(batch, priority, movement.position.x, movement.position.y, visibility);
	}
	
	public void render(ShapeRenderer batch, int priority, float dx, float dy, float visibility) {
		for(int i=0; i<gameObjects.size();i++)
			if (isAttached) gameObjects.get(i).render(batch, priority, dx + movement.position.x, dy + movement.position.y, visibility);
			else gameObjects.get(i).render(batch, priority, movement.position.x, movement.position.y, visibility);
	}

	public void dispose(){
		for(int i=0; i<gameObjects.size();i++)
			gameObjects.get(i).dispose();
	}
}

