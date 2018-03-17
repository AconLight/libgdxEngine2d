package com.redartedgames.libgdxengine2d.assets;

import com.badlogic.gdx.Gdx;
import com.redartedgames.libgdxengine2d.gameobject.GameObject;
import com.redartedgames.libgdxengine2d.physics.ColSpriteObject;
import com.redartedgames.libgdxengine2d.physics.Hitbox;
import com.redartedgames.libgdxengine2d.physics.Hitbox.BehaviorMode;
import com.redartedgames.libgdxengine2d.player.Player;

public class HitboxCharge extends ColSpriteObject{

	public HitboxCharge(float x, float y, float radius, GameObject parent, boolean isAttached) {
		super(x, y, parent, 0, isAttached);
		setHitbox(new Hitbox(parent.realPosition.x, parent.realPosition.y, radius, BehaviorMode.dynamic));
	}
	
	@Override
	public void updateLast(float delta, float vx, float vy) { 
		super.updateLast(delta, vx, vy);
		// we need to update hitbox to match in our case the position of super parent
		//hitbox.update(parent.parent.realPosition.x, parent.parent.realPosition.y);
		Gdx.app.log("hitbox", parent.parent.realPosition.x + parent.realPosition.x+ "");
	}
	
	public void collide(GameObject obj) {

		c = hitbox.checkCol(obj.getHitbox());
		//Gdx.app.log("charge: " + realPosition, "Obj: " +obj.realPosition);
		if (c.isTrue) {
			//Gdx.app.log("coll", "hitboxCharge");
			((Player)obj.parent).life -= 1f;
			
		}
		//parent.parent.movement.addCollisionAcc(new Vector2(c.disX, c.disY));

	}

}
