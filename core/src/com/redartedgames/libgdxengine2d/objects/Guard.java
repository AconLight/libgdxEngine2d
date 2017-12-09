package com.redartedgames.libgdxengine2d.objects;

import com.redartedgames.libgdxengine2d.assets.GuardAnimation;
import com.redartedgames.libgdxengine2d.main.GameObject;

public class Guard extends GameObject{
	
	private GuardAnimation guardAnimation;
	
	public Guard(float x, float y, GameObject parent, boolean isAttached) {
		super(x, y, parent, isAttached);
		guardAnimation = new GuardAnimation(x, y, parent, isAttached);
		addGameObject(guardAnimation);
	}
	
	public void move(float accx, float accy) {
		
	}
	
	public GameObject getHitboxObj() {
		return null;
	}

}
