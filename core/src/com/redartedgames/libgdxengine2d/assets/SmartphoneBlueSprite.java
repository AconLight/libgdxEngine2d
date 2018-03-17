package com.redartedgames.libgdxengine2d.assets;

import com.redartedgames.libgdxengine2d.gameobject.GameObject;
import com.redartedgames.libgdxengine2d.gameobject.SpriteObject;

public class SmartphoneBlueSprite extends SpriteObject{

	public SmartphoneBlueSprite(float x, float y, GameObject parent, boolean isAttached) {
		super(x, y, parent, isAttached);
		addTexture("graphic/bluesmartphone.png");
	}

}
