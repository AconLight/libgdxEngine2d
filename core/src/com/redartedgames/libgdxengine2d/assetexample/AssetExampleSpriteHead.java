package com.redartedgames.libgdxengine2d.assetexample;

import com.badlogic.gdx.Gdx;
import com.redartedgames.libgdxengine2d.gameobject.GameObject;
import com.redartedgames.libgdxengine2d.gameobject.SpriteObject;

public class AssetExampleSpriteHead extends SpriteObject{

	public AssetExampleHitboxCircle hitbox1;
	
	public AssetExampleSpriteHead(float x, float y, GameObject parent, boolean isAttached) {
		super(x, y, parent, isAttached);
		addTexture("graphic/badlogic.jpg");
		addTexture("graphic/badlogic2.jpg");
		addTexture("graphic/badlogic3.jpg");
		addTexture("graphic/badlogic4.jpg");
		//sclX = 5;
		//sclY = 5;
		setStoped(true);
		isOnce = true;
		frameTime = 0.8f;
		frameNum = 0;
		hitbox1 = new AssetExampleHitboxCircle(0, 0, 20, this, true);
		addSprite(hitbox1);
	}
	
	public void animate() {
		if (isStoped) {
			setStoped(false);
			frameNum = 0;
		}
	}
	
	@Override
	public void updateLast(float delta, float vx, float vy) { 
		super.updateLast(delta, vx, vy);
		// update
		// put ur code here
	}
	
	public void collide(GameObject obj) {
		hitbox1.collide(obj);
	}
	

}
