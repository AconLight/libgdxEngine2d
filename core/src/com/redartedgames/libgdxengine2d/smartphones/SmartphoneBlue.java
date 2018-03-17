package com.redartedgames.libgdxengine2d.smartphones;

import java.util.ArrayList;

import com.redartedgames.libgdxengine2d.assets.SmartphoneBlueSprite;
import com.redartedgames.libgdxengine2d.gameobject.GameObject;

public class SmartphoneBlue extends Smartphone{

	private ArrayList<SmartphoneRed> reds;
	
	public SmartphoneBlue(float x, float y, GameObject parent) {
		super(x, y, parent);
		reds = new ArrayList<SmartphoneRed>();
		sprite = new SmartphoneBlueSprite(0, 0, this, true);
		gameObjects.add(sprite);
		sprite.sclX = scl;
		sprite.sclY = scl;
	}
	
	public void setReds(ArrayList<SmartphoneRed> reds) {
		this.reds.clear();
		this.reds.addAll(reds);
	}
	
	public void startSkill(int i) {
		
	}

}
