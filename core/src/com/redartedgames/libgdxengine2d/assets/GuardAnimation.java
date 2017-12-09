package com.redartedgames.libgdxengine2d.assets;

import com.badlogic.gdx.math.Vector2;
import com.redartedgames.libgdxengine2d.main.GameObject;
import com.redartedgames.libgdxengine2d.main.Hitbox;
import com.redartedgames.libgdxengine2d.main.SpriteObject;

public class GuardAnimation extends GameObject{
	public Hitbox hitbox;
	public SpriteObject guardspritenotWalking;
	public SpriteObject guardspriteisWalking;
	public Vector2 mov;
	public int alfa;
	public SpriteObject guardhead;
	public GameObject guadHitbox;
	public boolean isWalking = false;
	public GuardAnimation(float x, float y, GameObject parent, boolean isAttached) {
		super(x, y, parent, isAttached);
		// TODO Auto-generated constructor stub
		guadHitbox = new GameObject(23, 0,this, true);
		hitbox = new Hitbox(getRealpositionX(0),getRealpositionY(0),90,90,Hitbox.none);
		guadHitbox.setHitbox(hitbox);
		
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

		guardhead = new SpriteObject(0,0,this,true);
		addSprite(guardhead);
		guardhead.addTexture("graphic/plajer/glowa_v2.png");
		guardhead.addTexture("graphic/plajer/glowa_ob1_5.png");
		guardhead.addTexture("graphic/plajer/glowa_ob1.png");
		guardhead.addTexture("graphic/plajer/glowa_ob1_5.png");
		guardhead.addTexture("graphic/plajer/glowa_v2.png");
		guardhead.addTexture("graphic/plajer/glowa_ob2_5.png");
		guardhead.addTexture("graphic/plajer/glowa_ob2.png");
		guardhead.addTexture("graphic/plajer/glowa_ob2_5.png");
		
	}
	public void beginWalking(Vector2 mov){
		guardspritenotWalking.visibility=0;
		this.movement.setVelocity(mov);
		guardspriteisWalking.visibility= 1;
	}
	public void endWalking(){
		guardspriteisWalking.visibility= 0;
		this.movement.setVelocity(new Vector2(0,0));
		guardspritenotWalking.visibility=1;
	}
	public void setalfa(int alfa){
		guardspriteisWalking.alfa = alfa;
		guardspritenotWalking.alfa = alfa;
		guardhead.alfa =alfa;
	}
	int dupa=0;
	 public void update (float delta){
		super.update(delta);
		delta *= 50;
		movement.updateAfter(delta/40);
		guardspriteisWalking.updateFrames(delta/50);
		guardspritenotWalking.updateFrames(delta/40);
		guardhead.updateFrames(delta/20);
		System.out.println("pos x= " + guadHitbox.getRealpositionX(0) + " pos y= "+ guadHitbox.getRealpositionY(0));
	}
	//TODO Dopisaæ get hitbox 
}
