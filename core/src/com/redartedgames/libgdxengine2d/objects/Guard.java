package com.redartedgames.libgdxengine2d.objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.redartedgames.libgdxengine2d.assets.GuardAnimation;
import com.redartedgames.libgdxengine2d.main.GameObject;
import com.redartedgames.libgdxengine2d.main.Hitbox;
import com.redartedgames.libgdxengine2d.main.Hitbox.BehaviorMode;

public class Guard extends GameObject{
	
	private GuardAnimation guardAnimation;
	
	public Guard(float x, float y, GameObject parent, boolean isAttached, float alfa) {
		super(x, y, parent, isAttached);
		guardAnimation = new GuardAnimation(0, 0, this, true);
		guardAnimation.setalfa(alfa);
		setHitbox(new Hitbox(x,y,80,Hitbox.dynamic));
		addGameObject(guardAnimation);
		//movement.setVelocity(new Vector2(-80, 0));
		//guardAnimation.beginWalking(new Vector2(-80,0));
	}
	
	public void move(float accx, float accy) {
		
	}
	
	public void update(float delta) {
		hitbox.update(movement.getPosition().x, movement.getPosition().y);
		
		guardAnimation.update(delta);
		//System.out.println("alfa = "+movement.getVelocity().angle());
	}
	
	
	
	public Hitbox getHitbox() {
		return guardAnimation.hitbox;
	}
	
	
	public void collide(GameObject obj) {
		hitbox.update(movement.getPosition().x, movement.getPosition().y);
		super.collide(obj);
		c = hitbox.checkCol(obj.getHitbox());
		collisionAccX = collisionAccX+c.disX;
		collisionAccY = collisionAccY+c.disY;
		//Gdx.app.log("ColSpriteObject", "collide - col: " + collisionAccY );
		//if (getHitbox().bMode == BehaviorMode.dynamic)
		movement.addCollisionAcc(new Vector2(c.disX, c.disY));
		
		//Gdx.app.log("guard", "hb: " + hitbox.rectangle.x + ", " + hitbox.rectangle.y);
	}

}
