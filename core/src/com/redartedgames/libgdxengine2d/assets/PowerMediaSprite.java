package com.redartedgames.libgdxengine2d.assets;

import com.redartedgames.libgdxengine2d.gameobject.GameObject;
import com.redartedgames.libgdxengine2d.gameobject.SpriteObject;

public class PowerMediaSprite extends SpriteObject{

	public PowerMediaSprite(float x, float y, GameObject parent, boolean isAttached) {
		super(x, y, parent, isAttached);
		addTexture("graphic/redsmartphone.png");
	}

}
