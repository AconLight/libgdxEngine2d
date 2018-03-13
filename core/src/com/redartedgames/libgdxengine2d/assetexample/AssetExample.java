package com.redartedgames.libgdxengine2d.assetexample;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.math.Vector2;
import com.redartedgames.libgdxengine2d.gameobject.GameObject;

public class AssetExample extends GameObject{

	public AssetExampleSpriteHead head;
	public AssetExample(float x, float y) {
		super(x, y, null, false);
		head = new AssetExampleSpriteHead(0, 0, this, true);
		addSprite(head);
	}
	
	public void updateLast(float delta, float vx, float vy) {
		super.updateLast(delta, vx, vy);
		if (Gdx.input.isKeyJustPressed(Keys.A)) head.animate();
	}
	
	public void collide(GameObject obj) {
		head.collide(obj);
	}
	
	public void addCollidable(GameObject obj) {
		collidableObjects.add(obj);
	}

}
