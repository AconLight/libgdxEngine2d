package com.redartedgames.libgdxengine2d.smartphones;

import java.util.ArrayList;

import com.badlogic.gdx.math.Vector2;
import com.redartedgames.libgdxengine2d.assets.SmartphoneYellowSprite;
import com.redartedgames.libgdxengine2d.gameobject.GameObject;
import com.redartedgames.libgdxengine2d.moveObiect.MovingObjects;
import com.redartedgames.libgdxengine2d.physics.CollisionHandle;

public class SmartphoneYellow extends Smartphone{

	private ArrayList<SmartphoneRed> reds;
	private SmartphoneYellowSprite sprite;
	private float skillTime;
	private CollisionHandle c;
	Vector2 deltaPos;
	private int animationCase=-1;

	public SmartphoneYellow(float x, float y, GameObject parent) {
		super(x, y, parent);
		
		reds = new ArrayList<SmartphoneRed>();
		sprite = new SmartphoneYellowSprite(0, 0, this, true);
		gameObjects.add(sprite);
		sprite.sclX = scl;
		sprite.sclY = scl;
		skillTime = 0;
		c = new CollisionHandle();
		deltaPos = new Vector2(0, 0);
	}
	
	public void setReds(ArrayList<SmartphoneRed> reds) {
		this.reds.clear();
		this.reds.addAll(reds);
	}
	
	public void addRed(SmartphoneRed red) {
		this.reds.add(red);
	}
	
	public void updateLast(float delta, float vx, float vy) {
        super.updateLast(delta, vx, vy);
        
	}
	
	public void startSkill(int i) {
		switch (i){
            case 0:
                animationCase=0;
                break;
            case 1:
                animationCase=1;
                break;
            case 2:
                animationCase=2;
                break;
            default:
                animationCase=-1;
                break;
		}
		skillTime = 0;
	}

}
