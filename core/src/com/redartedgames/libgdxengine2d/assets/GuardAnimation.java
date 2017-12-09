package com.redartedgames.libgdxengine2d.assets;

import com.badlogic.gdx.math.Vector2;
import com.redartedgames.libgdxengine2d.main.GameObject;
import com.redartedgames.libgdxengine2d.main.Hitbox;
import com.redartedgames.libgdxengine2d.main.SpriteObject;

public class GuardAnimation extends GameObject{
	public Hitbox hitbox;
	public SpriteObject guardspritenotWalking;
	public SpriteObject guardspriteisWalking;

	public SpriteObject guardhead;
	public boolean isWalking = false;
	public GuardAnimation(float x, float y, GameObject parent, boolean isAttached) {
		super(x, y, parent, isAttached);
		// TODO Auto-generated constructor stub
		//GameObject guadHitbox = new GameObject(23, 0,this, true);
		hitbox = new Hitbox(getRealpositionX(0),getRealpositionY(0),90,90,Hitbox.none);
		setHitbox(hitbox);
		guardspritenotWalking = new SpriteObject(0,0,this,true);
		addSprite(guardspritenotWalking);
		guardspritenotWalking.addTexture("graphic/plajer/s0.png");
		guardspritenotWalking.addTexture("graphic/plajer/s1.png");
		guardspriteisWalking = new SpriteObject(0,0,this,true);
		addSprite(guardspriteisWalking);
		guardspriteisWalking.visibility=0;
		guardspriteisWalking.addTexture("graphic/plajer/w1.png");
		guardspriteisWalking.addTexture("graphic/plajer/w2.png");
		guardspriteisWalking.addTexture("graphic/plajer/w3.png");
		guardspriteisWalking.setIsPingpong(true);

		guardhead = new SpriteObject(47,0,this,true);
		addSprite(guardhead);
		guardhead.addTexture("graphic/plajer/glowa.png");
		
	}
	public void beginWalking(){
		guardspritenotWalking.visibility=0;
		this.movement.setVelocity(new Vector2(20,0));
		guardspriteisWalking.visibility= 1;
	}
	public void endWalking(){
		guardspriteisWalking.visibility= 0;
		this.movement.setVelocity(new Vector2(0,0));
		guardspritenotWalking.visibility=1;

		
	}
	int dupa=0;
	 public void update (float delta){
		super.update(delta);
		delta *= 50;
		guardspriteisWalking.updateFrames(delta/50);
		guardspritenotWalking.updateFrames(delta/40);
		if (guardhead.alfa >=65) dupa = 1;
		if (dupa == 0) guardhead.alfa += delta;
		if (guardhead.alfa <=-65) dupa = 0;
		if (dupa == 1) guardhead.alfa -= delta;
		
		
		
	}
	//TODO Dopisa� get hitbox 
}
