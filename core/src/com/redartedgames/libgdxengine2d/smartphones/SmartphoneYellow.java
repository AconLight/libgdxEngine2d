package com.redartedgames.libgdxengine2d.smartphones;

import java.util.ArrayList;

import com.badlogic.gdx.math.Vector2;
import com.redartedgames.libgdxengine2d.assets.SmartphoneYellowSprite;
import com.redartedgames.libgdxengine2d.gameobject.GameObject;
import com.redartedgames.libgdxengine2d.moveObiect.MovingObjects;
import com.redartedgames.libgdxengine2d.physics.CollisionHandle;

public class SmartphoneYellow extends Smartphone{

	private ArrayList<SmartphoneRed> reds;
	private SmartphoneYellowSprite sprite;
	private float skillTime;
	private CollisionHandle c;
	
	public SmartphoneYellow(float x, float y, GameObject parent) {
		super(x, y, parent);
		reds = new ArrayList<SmartphoneRed>();
		sprite = new SmartphoneYellowSprite(0, 0, this, true);
		gameObjects.add(sprite);
		sprite.sclX = scl;
		sprite.sclY = scl;
		skillTime = 0;
	}
	
	public void setReds(ArrayList<SmartphoneRed> reds) {
		this.reds.clear();
		this.reds.addAll(reds);
	}
	
	public void addRed(SmartphoneRed red) {
		this.reds.add(red);
	}
	
	public void updateLast(float delta, float vx, float vy) {
		super.updateLast(delta, vx, vy);
		skillTime += delta;
		c = MovingObjects.animationUpAndDown(skillTime);
		for(SmartphoneRed s: reds) {
			s.sprite.movement.setPosition(new Vector2(c.disX, c.disY));
		}
	}
	
	
	
	
	
	public void startSkill(int i) {
		
	}

}
