package com.redartedgames.libgdxengine2d.objects;

import com.redartedgames.libgdxengine2d.main.GameObject;

public class Wall extends GameObject{

	private WallElement we1, we2, we3, we4; // poszczególne kawa³ki kafelka 50x50
	public Wall(float x, float y, GameObject parent, boolean isAttached/*args*/, int wallType) {
		super(x, y, parent, isAttached);
		generate(/*args*/);
	}
	
	public void generate(/*args*/) {
		//TODO
	}

}
