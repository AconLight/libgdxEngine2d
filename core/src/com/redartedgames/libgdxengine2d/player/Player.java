package com.redartedgames.libgdxengine2d.player;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
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
	
	public Player(float x, float y, GameObject parent, boolean isAttached) {
		super(x, y, parent, isAttached);
		ArrayList<GameObject> objects = new ArrayList<>();
		
		objects.add(new SmartphoneBlue(0, 0, this));
		objects.add(new SmartphoneRed(0, 0, this));
		objects.add(new SmartphoneRed(0, 0, this));
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
	public void collide(GameObject obj) {
		if (obj == this) {
			formation.collide(obj);
			for(GameObject obj1 :gameObjects) {
				Gdx.app.log("collide Formation1", "");
				obj1.collide(obj);
			}
		}
		else {
			super.collide(obj);
		}
	}

}
