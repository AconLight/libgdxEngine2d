package com.redartedgames.libgdxengine2d.gameobject;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.redartedgames.libgdxengine2d.physics.CollisionHandle;
import com.redartedgames.libgdxengine2d.physics.Hitbox;
import com.redartedgames.libgdxengine2d.physics.Movement;
import com.redartedgames.libgdxengine2d.physics.Hitbox.BehaviorMode;

public class GameObject {
	protected CollisionHandle c;
	protected boolean isAttached;
	public Movement movement;
	public GameObject parent;
	protected ArrayList<GameObject> gameObjects;
	public Hitbox hitbox;
	public float collisionAccX;
	public float collisionAccY;
	public ArrayList<GameObject> collidableObjects;
	public float translationAlfa = 0;
	
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
	}
	
	public void updateBefore(float delta, float vx, float vy) {
		movement.updateBefore(delta);
		//hitbox.update(movement.getPosition().x, movement.getPosition().y);
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
		oldx += this.movement.getPosition().x;
		if(this.parent != null) this.parent.getRealpositionX(oldx);
		return oldx;
	}
	public float getRealpositionY(float oldy) {
		oldy += this.movement.getPosition().y;
		if(this.parent != null) this.parent.getRealpositionY(oldy) ;
		return oldy;
	}
	
	public void collide(GameObject obj) {
		
	}
	
	public void applyPhysicsToAcceleration() {
		//if (hitbox.bMode == BehaviorMode.dynamic || hitbox.bMode == BehaviorMode.kinematic) {
			
			collisionAccX = 0;
			collisionAccY = 0;
			
			for(int i = 0; i < collidableObjects.size(); i++) {
				collide(collidableObjects.get(i));
			}

		//}
		for (GameObject obj : gameObjects) {
			//obj.applyPhysicsToAcceleration();
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
	
	public Vector2 getFinalPosition() {
		if (parent != null)
			return movement.getPosition().add(parent.getFinalPosition());
		else 
			return movement.getPosition();
	}
	
	public void render(SpriteBatch batch, int priority, float dx, float dy, float visibility) {
		for(int i=0; i<gameObjects.size();i++)
			if (isAttached) gameObjects.get(i).render(batch, priority, dx + getTranslatedX(), dy + getTranslatedY(), visibility);
			else gameObjects.get(i).render(batch, priority, getTranslatedX(), getTranslatedY(), visibility);
	}
	
	public void render(ShapeRenderer batch, int priority, float dx, float dy, float visibility) {
		for(int i=0; i<gameObjects.size();i++)
			if (isAttached) gameObjects.get(i).render(batch, priority, dx + movement.getPosition().x, dy + movement.getPosition().y, visibility);
			else gameObjects.get(i).render(batch, priority, movement.getPosition().x, movement.getPosition().y, visibility);
	}

	public void dispose(){
		for(int i=0; i<gameObjects.size();i++)
			gameObjects.get(i).dispose();
	}
	
	private float getTranslatedX() {
		float x = movement.getPosition().x;
		float y = movement.getPosition().y;
		float alfa = (float) Math.toRadians(movement.getPosition().angle());
		return (float) (Math.cos(translationAlfa + alfa)*Math.sqrt(x*x + y*y));
	}
	private float getTranslatedY() {
		float x = movement.getPosition().x;
		float y = movement.getPosition().y;
		float alfa = (float) Math.toRadians(movement.getPosition().angle());
		return (float) (Math.sin(translationAlfa + alfa)*Math.sqrt(x*x + y*y));
	}
}

