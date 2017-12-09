package com.redartedgames.libgdxengine2d.assets;

import com.redartedgames.libgdxengine2d.main.GameObject;
import com.redartedgames.libgdxengine2d.main.Hitbox;
import com.redartedgames.libgdxengine2d.main.SpriteObject;

public class GuardAnimation extends GameObject{
	public Hitbox hitbox;
	public SpriteObject guardsprite;
	public SpriteObject guardhead;
	public GuardAnimation(float x, float y, GameObject parent, boolean isAttached) {
		super(x, y, parent, isAttached);
		// TODO Auto-generated constructor stub
		//GameObject guadHitbox = new GameObject(23, 0,this, true);
		hitbox = new Hitbox(getRealpositionX(0),getRealpositionY(0),90,90,Hitbox.none);
		setHitbox(hitbox);
		guardsprite = new SpriteObject(0,0,this,true);
		addSprite(guardsprite);
		guardsprite.addTexture("graphic/plajer/s0.png");
		guardhead = new SpriteObject(47,0,this,true);
		addSprite(guardhead);
		guardhead.addTexture("graphic/plajer/glowa.png");
	}
	 public void update (float delta){
		super.update(delta);
		float deltamod;
		delta *= 100;
		deltamod = delta % 180;
		guardhead.alfa += deltamod;
		
	}
	//TODO Dopisaæ get hitbox 
}
