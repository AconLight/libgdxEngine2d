package com.redartedgames.libgdxengine2d.objects;

import com.badlogic.gdx.Gdx;
import com.redartedgames.libgdxengine2d.main.GameObject;
import com.redartedgames.libgdxengine2d.main.SpriteObject;

public class Kafelek extends GameObject{

	GameObject podloga, object;
	public int x, y;
	public enum KafelekType {
		origin, normal, path, covered
	}
	
	
	public Guard guard;
	
	public int alfa_biurko;
	
	public KafelekType type;
	
	SpriteObject sprite;
	
	public Kafelek(int x, int y, GameObject parent, boolean isAttached, KafelekType type) {
		super((x-75)*20, (y-75)*20, parent, isAttached);
		this.x = x;
		this.y = y;
		this.type = type;
		// TODO Auto-generated constructor stub
		
		addSprite(sprite = new SpriteObject(0, 0, this, true)).addTexture("graphic/badlogic.jpg");
	}
	
	public void update(float delta) {
		if (type == KafelekType.covered) sprite.visibility = 0f;
		if (type == KafelekType.path) sprite.visibility = 0.5f;
		if (type == KafelekType.normal) sprite.visibility = 1f;
		if (type == KafelekType.origin) sprite.visibility = 0.8f;
		Gdx.app.log("Kafelek", "update");
	}

}
