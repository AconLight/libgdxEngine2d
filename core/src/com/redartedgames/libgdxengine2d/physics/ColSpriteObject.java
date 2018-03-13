package com.redartedgames.libgdxengine2d.physics;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.redartedgames.libgdxengine2d.gameobject.GameObject;
import com.redartedgames.libgdxengine2d.gameobject.SpriteObject;
import com.redartedgames.libgdxengine2d.physics.Hitbox.BehaviorMode;

public class ColSpriteObject extends SpriteObject{

	protected CollisionHandle c;
	
	public ColSpriteObject(float x, float y, GameObject parent, int id, boolean isAttached) {
		super(x, y, parent, isAttached);
	}

	@Override
	public void collide(GameObject obj) {
		super.collide(obj);
		c = hitbox.checkCol(obj.getHitbox());
		collisionAccX += c.disX;
		collisionAccY += c.disY;
		if (getHitbox().bMode == BehaviorMode.dynamic)
			movement.addCollisionAcc(new Vector2(c.disX, c.disY));
	}
}
