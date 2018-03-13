package com.redartedgames.libgdxengine2d.assetexample;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.redartedgames.libgdxengine2d.gameobject.GameObject;
import com.redartedgames.libgdxengine2d.physics.ColSpriteObject;
import com.redartedgames.libgdxengine2d.physics.Hitbox;
import com.redartedgames.libgdxengine2d.physics.Hitbox.BehaviorMode;

public class AssetExampleHitboxCircle extends ColSpriteObject{

	public AssetExampleHitboxCircle(float x, float y, float radius, GameObject parent, boolean isAttached) {
		super(x, y, parent, 0, isAttached);
		setHitbox(new Hitbox(parent.parent.movement.getPosition().x, parent.parent.movement.getPosition().y, radius, BehaviorMode.dynamic));
	}
	
	@Override
	public void updateLast(float delta, float vx, float vy) { 
		super.updateLast(delta, vx, vy);
		// we need to update hitbox to match in our case the position of super parent
		hitbox.update(parent.parent.movement.getPosition().x, parent.parent.movement.getPosition().y);
	}
	
	public void collide(GameObject obj) {
		//super.collide(obj); 
		// super.collidate actually moves only this AssetExampleHitboxCircle which is not desired here
		//if you want to move parents you need to implement it:
		c = hitbox.checkCol(obj.getHitbox());
		if (c.isTrue)
		parent.parent.movement.addCollisionAcc(new Vector2(c.disX, c.disY));
		
		//put additional collision handle
		//here
		//read ColSpriteObject to learn how to handle c
		
		//example of c
		if (c.isTrue) {
			((AssetExampleSpriteHead) parent).animate();
		}
	}

}
