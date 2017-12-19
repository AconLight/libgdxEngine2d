package com.redartedgames.libgdxengine2d.assets;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.redartedgames.libgdxengine2d.main.GameObject;
import com.redartedgames.libgdxengine2d.main.Hitbox;
import com.redartedgames.libgdxengine2d.main.SpriteObject;

public class GuardAnimation extends GameObject{
	public Hitbox hitbox;
	public SpriteObject guardspritenotWalking;
	public SpriteObject guardspriteisWalking;
	public Vector2 mov;
	public float alfa;
	public SpriteObject guardhead, guardhead360;
	public GameObject guadHitbox;
	public boolean isWalking=false;
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
		
		guardhead360 = new SpriteObject(0,0,this,true);
		addSprite(guardhead360);
		guardhead360.visibility=0;
		guardhead360.addTexture("graphic/plajer/glowa360/1.png");
		guardhead360.addTexture("graphic/plajer/glowa360/2.png");
		guardhead360.addTexture("graphic/plajer/glowa360/3.png");
		guardhead360.addTexture("graphic/plajer/glowa360/4.png");
		guardhead360.addTexture("graphic/plajer/glowa360/5.png");
		guardhead360.addTexture("graphic/plajer/glowa360/6.png");
		guardhead360.addTexture("graphic/plajer/glowa360/7.png");
		guardhead360.addTexture("graphic/plajer/glowa360/8.png");
		guardhead360.addTexture("graphic/plajer/glowa360/9.png");
		guardhead360.addTexture("graphic/plajer/glowa360/10.png");
		guardhead360.addTexture("graphic/plajer/glowa360/11.png");
	
		endWalking();
	}
	public void beginWalking(){
		
		guardspritenotWalking.visibility=0;
		guardspriteisWalking.visibility= 1;
	}
	public void endWalking(){
		guardspriteisWalking.visibility= 0;
		movement.setVelocity(new Vector2(0,0));
		guardspritenotWalking.visibility=1;
	}
	public void setalfa(float alfa){
		guardspriteisWalking.alfa = alfa;
		guardspritenotWalking.alfa = alfa;
		guardhead.alfa =alfa;
		guardhead360.alfa = alfa;
	}
	float wdupe;
	
	public void update (float delta){
		super.update(delta);
		wdupe += Gdx.graphics.getDeltaTime();
		delta *= 50;
		movement.updateAfter(delta/40);
		guardspriteisWalking.updateFrames(delta/20);
		if (isWalking){
		guardspriteisWalking.alfa=(parent.movement.getVelocity().angle()+180);
		guardhead.alfa=(parent.movement.getVelocity().angle()+180);
		guardhead360.alfa=(parent.movement.getVelocity().angle()+180);
		}
		guardspritenotWalking.updateFrames(delta);
		guardhead360.updateFrames(delta/2);
		
		if(wdupe >= 5){
			guardhead.isVisible = false;
			guardhead360.visibility = 1;
			
			System.out.println("dupaadupa" + wdupe);
			if(wdupe>=5.25){
				guardhead.isVisible = true;
				guardhead360.visibility = 0;
				wdupe = 0;
			}
		}
		else
			guardhead.updateFrames(delta/20);	
	}
	//TODO Dopisaæ get hitbox 
	
}
