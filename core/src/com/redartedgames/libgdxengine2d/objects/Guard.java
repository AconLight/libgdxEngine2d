package com.redartedgames.libgdxengine2d.objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.redartedgames.libgdxengine2d.assets.GuardAnimation;
import com.redartedgames.libgdxengine2d.main.GameObject;
import com.redartedgames.libgdxengine2d.main.Hitbox;
import com.redartedgames.libgdxengine2d.main.Hitbox.BehaviorMode;

public class Guard extends GameObject{
	
	private GuardAnimation guardAnimation;
	
	public Guard(float x, float y, GameObject parent, boolean isAttached) {
		super(x, y, parent, isAttached);
		guardAnimation = new GuardAnimation(0, 0, this, true);
		setHitbox(new Hitbox(x+15,y,120,90,Hitbox.dynamic));
		addGameObject(guardAnimation);
		movement.setVelocity(new Vector2(-80, 0));
	}
	
	public void move(float accx, float accy) {
		
	}
	
	public void update(float delta) {
		//hitbox.update(movement.getPosition().x+29, movement.getPosition().y);
	}
	
	
	
	public Hitbox getHitbox() {
		return guardAnimation.hitbox;
	}
	
	
	public void collide(GameObject obj) {
		hitbox.update(movement.getPosition().x+15, movement.getPosition().y);
		super.collide(obj);
		c = hitbox.checkCol(obj.getHitbox());
		collisionAccX = collisionAccX+c.disX;
		collisionAccY = collisionAccY+c.disY;
		//Gdx.app.log("ColSpriteObject", "collide - col: " + collisionAccY );
		//if (getHitbox().bMode == BehaviorMode.dynamic)
			movement.addCollisionAcc(new Vector2(c.disX, c.disY));
		
		Gdx.app.log("guard", "hb: " + hitbox.rectangle.x + ", " + hitbox.rectangle.y);
	}

}
