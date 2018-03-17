package com.redartedgames.libgdxengine2d.smartphones;

import com.badlogic.gdx.Gdx;
import com.redartedgames.libgdxengine2d.assets.PowerMediaSprite;
import com.redartedgames.libgdxengine2d.gameobject.GameObject;

public class PowerMedia extends GameObject{
	
	private PowerMediaSprite sprite;
	
	public PowerMedia(float x, float y, GameObject parent, boolean isAttached) {
		super(x, y, parent, isAttached);
		sprite = new PowerMediaSprite(0, 0, this, true);
		sprite.sclX = 0.2f;
		sprite.sclY = 0.2f;
		addSprite(sprite);
	}
	
	public void updateLast(float delta, float vx, float vy) {
		super.updateLast(delta, vx, vy);
		Gdx.app.log("PowerMedia", "" + movement.getPosition());
	}

}
