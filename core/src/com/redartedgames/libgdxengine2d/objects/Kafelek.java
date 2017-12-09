package com.redartedgames.libgdxengine2d.objects;

import com.redartedgames.libgdxengine2d.main.GameObject;
import com.redartedgames.libgdxengine2d.main.SpriteObject;

public class Kafelek extends GameObject{

	GameObject podloga, object;
	public int x, y;
	public enum KafelekType {
		origin, normal, path, covered
	}
	
	public KafelekType type;
	
	SpriteObject sprite;
	
	public Kafelek(int x, int y, GameObject parent, boolean isAttached, KafelekType type) {
		super(x*20, y*20, parent, isAttached);
		this.x = x;
		this.y = y;
		this.type = type;
		// TODO Auto-generated constructor stub
		
		addSprite(sprite = new SpriteObject(0, 0, this, true)).addTexture("graphic/badlogic.jpg");
	}
	
	public void update(float delta) {
		if (type == KafelekType.covered) sprite.visibility = 0.6f;
		if (type == KafelekType.path) sprite.visibility = 0.1f;
		if (type == KafelekType.normal) sprite.visibility = 0.3f;
		if (type == KafelekType.origin) sprite.visibility = 0.8f;
		
	}

}