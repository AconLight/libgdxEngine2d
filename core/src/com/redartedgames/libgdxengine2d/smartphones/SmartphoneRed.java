package com.redartedgames.libgdxengine2d.smartphones;

import java.util.ArrayList;

import com.badlogic.gdx.math.Vector2;
import com.redartedgames.libgdxengine2d.assets.SmartphoneRedSprite;
import com.redartedgames.libgdxengine2d.formation.*;
import com.redartedgames.libgdxengine2d.gameobject.GameObject;
import com.redartedgames.libgdxengine2d.lightnings.Lightning;
import com.redartedgames.libgdxengine2d.moveObiect.MovingObjects;
import com.redartedgames.libgdxengine2d.physics.CollisionHandle;

public class SmartphoneRed extends Smartphone{

	ArrayList<GameObject> powerMedias;
	
	public ArrayList<Lightning> lightnings;
	
	Formation mediaFormation;
	
	Formation mediaFormation1, mediaFormation2, mediaFormation3;
	
	Formation none;
	
	float timer;
	
	
	
	private float skillTime;
	private CollisionHandle c;
	private int animationCase=-1;
	
	
	
	
	public SmartphoneRed(float x, float y, GameObject parent) {
		super(x, y, parent);
		lightnings = new ArrayList<Lightning>();
		sprite = new SmartphoneRedSprite(0, 0, this, true);
		gameObjects.add(sprite);
		sprite.sclX = scl;
		sprite.sclY = scl;
		timer = 0;
		

		
		
		powerMedias = new ArrayList<GameObject>();
		powerMedias.add(new PowerMedia(100, 0, sprite, true));
		powerMedias.add(new PowerMedia(-100, 0, sprite, true));
		powerMedias.add(new PowerMedia(0, 100, sprite, true));
		
		//formacje
		mediaFormation1 = new Formation(0, 0, powerMedias, this, true, new FormationSpiral());
		mediaFormation2 = new Formation(0, 0, powerMedias, this, true, new FormationBigCircle());
		mediaFormation3 = new Formation(0, 0, powerMedias, this, true, new FormationShield());
		none = new Formation(0, 0, powerMedias, this, true, new FormationNone());
		//
		
		
		mediaFormation = none;
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
	
	public void updateLast(float delta, float vx, float vy) {
		super.updateLast(delta, vx, vy);
		if (timer > 4) {
			mediaFormation = none;
			stopSparkle();
		}
		else {
			timer += delta;
		}
		mediaFormation.translationAlfa = translationAlfa;
		
		float d = 0;
	    if (animationCase == 0) {
            skillTime += 4 * delta;
            c = MovingObjects.animationUpAndDown(skillTime);
            d = (float) Math.sqrt(c.disX*c.disX + c.disY*c.disY);
        }
        if (animationCase == 1) {
            skillTime += 8 *delta;
            c = MovingObjects.animationCurve(skillTime);
            d = (float) Math.sqrt(c.disX*c.disX + c.disY*c.disY);
        }
        if (animationCase == 2) {
	        skillTime += 6*delta;
	        c = MovingObjects.animationTangens(skillTime);
	        d = (float) Math.sqrt(c.disX*c.disX + c.disY*c.disY);
        }
        sprite.movement.setPosition(new Vector2((float)(Math.cos(translationAlfa - Math.PI/2)*d), (float)(Math.sin(translationAlfa - Math.PI/2)*d)));
		
	}
	
	public void collide(GameObject obj) {
		if (obj == parent) {
			mediaFormation.collide(obj);
		}
		else {
			super.collide(obj);
			for(Lightning l : lightnings) {
				l.collide(obj);
			}
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
	
	public void stopSparkle() {
		for(Lightning l : lightnings) {
			for(GameObject p : powerMedias) {
				if(l.getFirst() == p) {
					l.stop();
				}
			}
		}
	}
	
	public void startSkill1(int i) {
		if (i == 0) {
			animationCase=0;
		}
		if (i == 1) {
			animationCase=1;
		}
		if (i == 2) {
			animationCase=2;
		}

	}
	
	public void startSkill2(int i) {
		if (i == 0) {
			mediaFormation = mediaFormation1;
		}
		if (i == 1) {
			mediaFormation = mediaFormation2;
		}
		if (i == 2) {
			mediaFormation = mediaFormation3;
		}
		timer = 0;
		startSparkle();
	}

	@Override
	public void update(float delta) {
		for(Lightning l : lightnings) {
			l.update(delta);
		}
	}
}
