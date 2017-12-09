package com.redartedgames.libgdxengine2d.objects;

import java.util.ArrayList;

import com.redartedgames.libgdxengine2d.main.GameObject;
import com.redartedgames.libgdxengine2d.main.SpriteObject;

public class WallElement extends GameObject{
	GameObject hitbox1, hitbox2, hitbox3, hitbox4; //poszczególne hitboxy 25x25
	SpriteObject sprite1, sprite2, sprite3, sprite4; //poszczególne pixele 25x25
	public WallElement(float x, float y, GameObject parent, boolean isAttached/*args*/) {
		super(x, y, parent, isAttached);
		//TODO
	}
	
	//TODO
	public ArrayList<GameObject> getHitboxes() {
		return null;
	}

}
