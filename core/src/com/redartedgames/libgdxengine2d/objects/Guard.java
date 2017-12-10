package com.redartedgames.libgdxengine2d.objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.redartedgames.libgdxengine2d.assets.GuardAnimation;
import com.redartedgames.libgdxengine2d.main.GameObject;
import com.redartedgames.libgdxengine2d.main.Hitbox;
import com.redartedgames.libgdxengine2d.main.Hitbox.BehaviorMode;

public class Guard extends GameObject{
	
	private GuardAnimation guardAnimation;
	public Vector2 pos;
	public boolean isTriggerd=false;
	public Vector2 init_pos;
	
	public Guard(float x, float y, GameObject parent, boolean isAttached, float alfa) {
		super(x, y, parent, isAttached);
		guardAnimation = new GuardAnimation(0, 0, this, true);
		guardAnimation.setalfa(alfa);
		setHitbox(new Hitbox(x,y,80,Hitbox.dynamic));
		addGameObject(guardAnimation);
		init_pos = new Vector2(x,y);
	}
	
	public void move(float accx, float accy) {
		
	}
	
	public void update(float delta) {
		hitbox.update(movement.getPosition().x, movement.getPosition().y);
		guardAnimation.update(delta);
		if(isTriggerd){
			float alfa2=0;
			Vector2 dupa;
			Vector2 dupa2=new Vector2((float) Math.sin(alfa2)*1,(float) Math.cos(alfa2)*1);
			dupa = new Vector2 ((movement.getPosition().x + pos.x)/10 ,(movement.getPosition().y+pos.y)/10);
			alfa2 +=delta*5;
			movement.setVelocity(dupa.add(dupa2));
			if(movement.getPosition().x -pos.x<0.01f && movement.getPosition().y-pos.y<0.01){
				guardAnimation.endWalking();
				isTriggerd =false;
			}
		}
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
	public void trigger(Vector2 pos_trig){
		guardAnimation.beginWalking();
		isTriggerd=true;
		pos = pos_trig;
		
		
		
	}

}
