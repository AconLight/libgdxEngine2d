package com.redartedgames.libgdxengine2d.assets;

import com.redartedgames.libgdxengine2d.gameobject.GameObject;
import com.redartedgames.libgdxengine2d.gameobject.SpriteObject;

public class PlayerSprite extends SpriteObject{

	public PlayerSprite(float x, float y, GameObject parent, boolean isAttached, int type) {
		super(x, y, parent, isAttached);
		if (type == 0)
			addTexture("graphic/player.png");
		else {
			addTexture("graphic/player2.png");
		}
	}
}
