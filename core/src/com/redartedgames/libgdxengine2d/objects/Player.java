package com.redartedgames.libgdxengine2d.objects;

import java.util.ArrayList;

import com.redartedgames.libgdxengine2d.assets.Biurko;
import com.redartedgames.libgdxengine2d.main.GameObject;

public class Player extends GameObject{

	public ArrayList<Biurko> biurka;
	
	public boolean isInPerson;
	
	public Player(float x, float y, GameObject parent, boolean isAttached, ArrayList<Biurko> biurka) {
		super(x, y, parent, isAttached);
	}
	
	public void update(float delta) {
		super.update(delta);
		
	}
	
	public void goin(GameObject obj) {
		parent = obj;
	}

}
