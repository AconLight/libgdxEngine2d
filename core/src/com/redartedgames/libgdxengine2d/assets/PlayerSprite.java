package com.redartedgames.libgdxengine2d.assets;

import com.redartedgames.libgdxengine2d.gameobject.GameObject;
import com.redartedgames.libgdxengine2d.gameobject.SpriteObject;

public class PlayerSprite extends SpriteObject{

	public PlayerSprite(float x, float y, GameObject parent, boolean isAttached) {
		super(x, y, parent, isAttached);
		addTexture("graphic/player.png");
	}
}
