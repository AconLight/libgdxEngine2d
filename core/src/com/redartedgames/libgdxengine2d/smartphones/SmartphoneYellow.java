package com.redartedgames.libgdxengine2d.smartphones;

import java.util.ArrayList;

import com.redartedgames.libgdxengine2d.assets.SmartphoneYellowSprite;
import com.redartedgames.libgdxengine2d.gameobject.GameObject;

public class SmartphoneYellow extends Smartphone{

	private ArrayList<SmartphoneRed> reds;
	private SmartphoneYellowSprite sprite;
	
	public SmartphoneYellow(float x, float y, GameObject parent) {
		super(x, y, parent);
		reds = new ArrayList<SmartphoneRed>();
		sprite = new SmartphoneYellowSprite(0, 0, this, true);
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
