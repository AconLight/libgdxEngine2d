package com.redartedgames.libgdxengine2d.player;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.redartedgames.libgdxengine2d.assets.PlayerSprite;
import com.redartedgames.libgdxengine2d.formation.Formation;
import com.redartedgames.libgdxengine2d.formation.MyFormationGenerator;
import com.redartedgames.libgdxengine2d.gameobject.GameObject;
import com.redartedgames.libgdxengine2d.smartphones.SmartphoneBlue;
import com.redartedgames.libgdxengine2d.smartphones.SmartphoneRed;
import com.redartedgames.libgdxengine2d.smartphones.SmartphoneYellow;

public class Player extends GameObject{

	Formation formation;
	PlayerSprite sprite;
	public static final int playerV = 1500;
	public static final float playerDrag = 0.9f;
	public SmartphoneRed sr;
	private Vector2 direction;
	
	public Player(float x, float y, GameObject parent, boolean isAttached) {
		super(x, y, parent, isAttached);
		direction = new Vector2();
		ArrayList<GameObject> objects = new ArrayList<>();
		sr = new SmartphoneRed(0, 0, this);
		objects.add(new SmartphoneBlue(0, 0, this));
		objects.add(sr);
		objects.add(sr);
		objects.add(new SmartphoneBlue(0, 0, this));
		objects.add(new SmartphoneYellow(0, 0, this));
		
		((SmartphoneYellow)objects.get(4)).addRed((SmartphoneRed) objects.get(1));
		((SmartphoneYellow)objects.get(4)).addRed((SmartphoneRed) objects.get(2));
		
		collidableObjects.add(this); // just to asure that collide is performed
		

		formation = new Formation(0, 0, objects, this, true, new MyFormationGenerator());
		
		gameObjects.addAll(objects);
		gameObjects.add(formation);
		
		sprite = new PlayerSprite(0, 0, this, true);
		gameObjects.add(sprite);
	}
	
	public void updateLast(float delta, float vx, float vy) {
		movement.setG(new Vector2((direction.x + movement.getG().x*29)/30, (direction.y + movement.getG().y*29)/30));
		movement.setVelocity(new Vector2(movement.getVelocity().x*playerDrag, movement.getVelocity().y*playerDrag));
		movement.addG(new Vector2 (0, 100));
		for(GameObject obj: gameObjects) {

			obj.translationAlfa = (float) (Math.toRadians(movement.getG().angle()) + Math.PI/2);
		}
		movement.addG(new Vector2 (0, -100));
		sprite.alfa = (float) (movement.getG().angle() - 90);
	}

	@Override
	public void update(float delta) {
		super.update(delta);
	}

	public void collide(GameObject obj) {
		if (obj == this) {
			formation.collide(obj);
			for(GameObject obj1 :gameObjects) {
				obj1.collide(obj);
			}
		}
		else {
			super.collide(obj);
		}
	}
	
	public void moveVel(int x, int y) {
		if (Math.abs(x) > 0 && Math.abs(y) > 0) {
			direction.add(new Vector2(x/1.47f, y/1.47f));
		}
		else {
			direction.add(new Vector2(x, y));
		}
		
	}

}
