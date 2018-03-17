package com.redartedgames.libgdxengine2d.assets;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.redartedgames.libgdxengine2d.assetexample.AssetExampleSpriteHead;
import com.redartedgames.libgdxengine2d.gameobject.GameObject;
import com.redartedgames.libgdxengine2d.gameobject.SpriteObject;
import com.redartedgames.libgdxengine2d.physics.ColSpriteObject;
import com.redartedgames.libgdxengine2d.physics.Hitbox;
import com.redartedgames.libgdxengine2d.physics.Hitbox.BehaviorMode;
import com.redartedgames.libgdxengine2d.player.Player;

public class HitboxPlayer extends ColSpriteObject{

	public HitboxPlayer(float x, float y, float radius, GameObject parent, boolean isAttached) {
		super(x, y, parent, 0, isAttached);
		setHitbox(new Hitbox(parent.realPosition.x, parent.realPosition.y, radius, BehaviorMode.dynamic));
	}
	
	@Override
	public void updateLast(float delta, float vx, float vy) { 
		super.updateLast(delta, vx, vy);
		// we need to update hitbox to match in our case the position of super parent
		hitbox.update(parent.parent.realPosition.x, parent.parent.realPosition.y);
	}
	
	public void collide(GameObject obj) {
		//obj.hitbox.update(obj.parent.parent.realPosition.x, obj.parent.parent.realPosition.y);
		hitbox.update(parent.realPosition.x, parent.realPosition.y);
		c = hitbox.checkCol(obj.getHitbox());
		//Gdx.app.log("Player: " + parent.realPosition, "Obj: " +obj.parent.parent.realPosition);
		if (c.isTrue) {
			//Gdx.app.log("collqq", "hitboxCharge");
			if (((SpriteObject)obj.parent).isVisible)
			((Player)parent).life -= 0.01f;
		}
		//parent.parent.movement.addCollisionAcc(new Vector2(c.disX, c.disY));

	}

}
