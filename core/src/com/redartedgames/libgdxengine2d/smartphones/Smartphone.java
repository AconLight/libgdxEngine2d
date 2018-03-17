package com.redartedgames.libgdxengine2d.smartphones;

import com.redartedgames.libgdxengine2d.gameobject.GameObject;
import com.redartedgames.libgdxengine2d.gameobject.SpriteObject;

public class Smartphone extends GameObject{
	SpriteObject sprite;
	protected final float scl = 0.4f;
	public Smartphone(float x, float y, GameObject parent) {
		super(x, y, parent, true);
	}
	
	public void startSkill(int i) {
		
	}
	
	public void updateLast(float delta, float vx, float vy) {
		super.updateLast(delta, vx, vy);
		for(GameObject obj: gameObjects) {
			//obj.translationAlfa = translationAlfa;
		}
	}
	

}
