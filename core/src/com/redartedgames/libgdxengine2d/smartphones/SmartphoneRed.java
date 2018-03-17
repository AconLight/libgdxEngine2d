package com.redartedgames.libgdxengine2d.smartphones;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.redartedgames.libgdxengine2d.assets.SmartphoneRedSprite;
import com.redartedgames.libgdxengine2d.formation.Formation;
import com.redartedgames.libgdxengine2d.formation.MyFormationGenerator;
import com.redartedgames.libgdxengine2d.gameobject.GameObject;
import com.redartedgames.libgdxengine2d.lightnings.Lightning;

public class SmartphoneRed extends Smartphone{

	ArrayList<GameObject> powerMedias;
	
	ArrayList<Lightning> lightnings;
	
	Formation mediaFormation;
	
	public SmartphoneRed(float x, float y, GameObject parent) {
		super(x, y, parent);
		lightnings = new ArrayList<Lightning>();
		sprite = new SmartphoneRedSprite(0, 0, this, true);
		gameObjects.add(sprite);
		sprite.sclX = scl;
		sprite.sclY = scl;
		
		powerMedias = new ArrayList<GameObject>();
		powerMedias.add(new PowerMedia(100, 0, sprite, true));
		powerMedias.add(new PowerMedia(-100, 0, sprite, true));
		powerMedias.add(new PowerMedia(0, 100, sprite, true));
		mediaFormation = new Formation(0, 0, powerMedias, this, true, new MyFormationGenerator());
		sprite.getGameObjects().addAll(powerMedias);
		sprite.getGameObjects().add(mediaFormation);
		collidableObjects.add(this); // just to perform collide once
		
		for(GameObject p: powerMedias) {
			for(GameObject p2: powerMedias) {
				if(p != p2) {
					boolean b = true;
					for(Lightning l : lightnings) {
						if((l.getFirst() == p && l.getSecond() == p2) || (l.getSecond() == p && l.getFirst() == p2))
							b = false;
					}
					if(b) {
						lightnings.add(new Lightning((PowerMedia)p, (PowerMedia)p2, this, true));
						addGameObject(lightnings.get(lightnings.size()-1));
					}
				}
			}
		}
	}
	
	public void collide(GameObject obj) {
		if (obj == parent) {
			mediaFormation.collide(obj);
		}
		else {
			super.collide(obj);
		}
	}
	
	public void startSparkle() {
		for(Lightning l : lightnings) {
			for(GameObject p : powerMedias) {
				if(l.getFirst() == p) {
					l.start();
				}
			}
		}
	}

	@Override
	public void update(float delta) {
		for(Lightning l : lightnings) {
			l.update(delta);
		}
	}
}
