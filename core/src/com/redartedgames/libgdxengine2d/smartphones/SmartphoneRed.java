package com.redartedgames.libgdxengine2d.smartphones;

import java.util.ArrayList;

import com.redartedgames.libgdxengine2d.assets.SmartphoneRedSprite;
import com.redartedgames.libgdxengine2d.formation.Formation;
import com.redartedgames.libgdxengine2d.formation.MyFormationGenerator;
import com.redartedgames.libgdxengine2d.gameobject.GameObject;

public class SmartphoneRed extends Smartphone{

	ArrayList<GameObject> powerMedias;
	
	Formation mediaFormation;
	
	public SmartphoneRed(float x, float y, GameObject parent) {
		super(x, y, parent);
		sprite = new SmartphoneRedSprite(0, 0, this, true);
		gameObjects.add(sprite);
		sprite.sclX = scl;
		sprite.sclY = scl;
		
		powerMedias = new ArrayList<GameObject>();
		powerMedias.add(new PowerMedia(0, 0, sprite, true));
		powerMedias.add(new PowerMedia(0, 0, sprite, true));
		powerMedias.add(new PowerMedia(0, 0, sprite, true));
		mediaFormation = new Formation(0, 0, powerMedias, this, new MyFormationGenerator());
		sprite.getGameObjects().addAll(powerMedias);
		sprite.getGameObjects().add(mediaFormation);
		collidableObjects.add(this); // just to perform collide once
	}
	
	public void collide(GameObject obj) {
		if (obj == this) {
			mediaFormation.collide(obj);
		}
		else {
			super.collide(obj);
		}
	}

}
