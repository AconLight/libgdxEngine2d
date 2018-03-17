package com.redartedgames.libgdxengine2d.smartphones;

import com.redartedgames.libgdxengine2d.assets.SmartphoneRedSprite;
import com.redartedgames.libgdxengine2d.gameobject.GameObject;

public class SmartphoneRed extends Smartphone{

	
	public SmartphoneRed(float x, float y, GameObject parent) {
		super(x, y, parent);
		sprite = new SmartphoneRedSprite(0, 0, this, true);
		gameObjects.add(sprite);
		sprite.sclX = scl;
		sprite.sclY = scl;
	}

}
