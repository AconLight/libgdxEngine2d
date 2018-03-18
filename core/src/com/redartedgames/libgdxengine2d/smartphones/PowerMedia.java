package com.redartedgames.libgdxengine2d.smartphones;

import com.badlogic.gdx.Gdx;
import com.redartedgames.libgdxengine2d.assets.PowerMediaSprite;
import com.redartedgames.libgdxengine2d.gameobject.GameObject;

public class PowerMedia extends GameObject{
	
	public PowerMediaSprite sprite;
	
	public PowerMedia(float x, float y, GameObject parent, boolean isAttached, int type) {
		super(x, y, parent, isAttached);
		sprite = new PowerMediaSprite(0, 0, this, true);
		if (type == 0) {
			sprite.R = 1f;
			sprite.G = 0f;	
			sprite.B = 0f;
		}
		if (type == 1) {
			sprite.R = 1f;
			sprite.G = 1f;	
			sprite.B = 0f;
		}
		if (type == 2) {
			sprite.R = 0f;
			sprite.G = 0f;	
			sprite.B = 1f;
		}
		sprite.sclX = 0.2f;
		sprite.sclY = 0.2f;
		addSprite(sprite);
	}
	
	public void updateLast(float delta, float vx, float vy) {
		super.updateLast(delta, vx, vy);
		//sprite.translationAlfa = translationAlfa;
	}

}
