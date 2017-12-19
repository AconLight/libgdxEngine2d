package com.redartedgames.libgdxengine2d.objects;

import java.util.ArrayList;

import com.redartedgames.libgdxengine2d.assets.Biurko;
import com.redartedgames.libgdxengine2d.main.GameObject;

public class Player extends GameObject{

	public ArrayList<Biurko> biurka;
	
	Biurko biurko;
	
	public boolean isInPerson;
	
	public Player(float x, float y, GameObject parent, boolean isAttached, ArrayList<Biurko> biurka) {
		super(x, y, parent, isAttached);
	}
	
	public void update(float delta) {
		super.update(delta);
		for(Biurko b : biurka) {
			
		}
	}
	
	public void goinPerson(GameObject obj) {
		parent = obj;
	}
	
	public void goinBiurko(GameObject obj) {
		parent = obj;
	}

}
