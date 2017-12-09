package com.redartedgames.libgdxengine2d.objects;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.redartedgames.libgdxengine2d.main.GameObject;
import com.redartedgames.libgdxengine2d.main.Hitbox;
import com.redartedgames.libgdxengine2d.main.SpriteObject;

public class WallElement extends GameObject{
	private int wallType;
	private int rot;
	private GameObject hitbox1, hitbox2, hitbox3, hitbox4; //poszczególne hitboxy 25x25
	private SpriteObject sprite; //poszczególne pixele 25x25
	public WallElement(float x, float y, GameObject parent, int wallType, int rotation) {
		super(x, y, parent, true);
		hitbox1 = new GameObject(-12.5f,12.5f,this,true);
		hitbox2 = new GameObject(12.5f,12.5f,this,true);
		hitbox3 = new GameObject(-12.5f,-12.5f,this,true);
		hitbox4 = new GameObject(12.5f,-12.5f,this,true);
		sprite = new SpriteObject(0,0,this,true);
		this.wallType = wallType;
		this.rot = rotation%360;
		setType();
		setRotation();
		addSprite(sprite);
	}
	
	//TODO
	public ArrayList<GameObject> getHitboxes() {
		return null;
	}

	private void setType(){
		switch (wallType){
			default:
			case 1:
				sprite.addTexture("graphic/sciany/sciana4.png");
				break;
			case 2:
				break;
			case 3:
				sprite.addTexture("graphic/sciany/sciana3.png");
				break;
			case 4:
				sprite.addTexture("graphic/sciany/sciana1.png");
				break;
		}

	}

	private void hitboxSet(GameObject hitbox){
		hitbox.setHitbox(new Hitbox(0,0,25,25,Hitbox.kinematic));
	}

	private void setRotation(){
		switch (rot) {
			default:
			case 0:
				if(wallType==2)sprite.addTexture("graphic/sciany/sciana2.png");
				switch (wallType) {
					default:
					case 1:
						hitboxSet(hitbox4);
						break;
					case 2:
						//sprite.addTexture("graphic/sciany/sciana2.png");
						hitboxSet(hitbox3);
						break;
					case 3:
						hitboxSet(hitbox1);
						break;
					case 4:
						hitboxSet(hitbox2);
						break;
				}
				break;
			case 90:
				if(wallType==2)sprite.addTexture("graphic/sciany/sciana2p.png");
				sprite.regionList.get(0).flip(true, false);
				switch (wallType) {
					default:
					case 1:
						hitboxSet(hitbox2);
						hitboxSet(hitbox4);
						break;
					case 2:
						hitboxSet(hitbox3);
						hitboxSet(hitbox4);
						break;
					case 3:
						hitboxSet(hitbox1);
						hitboxSet(hitbox3);
						break;
					case 4:
						hitboxSet(hitbox1);
						hitboxSet(hitbox2);
						break;
				}
				break;
			case 180:
				if(wallType==2)sprite.addTexture("graphic/sciany/sciana2.png");
				sprite.regionList.get(0).flip(true, true);
				switch (wallType) {
					default:
					case 1:
						hitboxSet(hitbox2);
						hitboxSet(hitbox4);
						hitboxSet(hitbox3);
						break;
					case 2:
						hitboxSet(hitbox1);
						hitboxSet(hitbox4);
						hitboxSet(hitbox3);
						break;
					case 3:
						hitboxSet(hitbox2);
						hitboxSet(hitbox1);
						hitboxSet(hitbox3);
						break;
					case 4:
						hitboxSet(hitbox2);
						hitboxSet(hitbox4);
						hitboxSet(hitbox1);
						break;
				}
				break;
			case 270:
				if(wallType==2)sprite.addTexture("graphic/sciany/sciana2p.png");
				sprite.regionList.get(0).flip(false,true);
				switch (wallType) {
					default:
					case 1:
						hitboxSet(hitbox2);
						hitboxSet(hitbox4);
						hitboxSet(hitbox3);
						break;
					case 2:
						hitboxSet(hitbox1);
						hitboxSet(hitbox4);
						hitboxSet(hitbox3);
						break;
					case 3:
						hitboxSet(hitbox2);
						hitboxSet(hitbox1);
						hitboxSet(hitbox3);
						break;
					case 4:
						hitboxSet(hitbox2);
						hitboxSet(hitbox4);
						hitboxSet(hitbox1);
						break;
				}
				hitbox1.setHitbox(new Hitbox(0,0,25,25,Hitbox.kinematic));
				hitbox2.setHitbox(new Hitbox(0,0,25,25,Hitbox.kinematic));
				hitbox3.setHitbox(new Hitbox(0,0,25,25,Hitbox.kinematic));
				hitbox4.setHitbox(new Hitbox(0,0,25,25,Hitbox.kinematic));
				break;
		}
	}

	public void rotate(){
		if(sprite.regionList.get(0).isFlipX()){
			if(sprite.regionList.get(0).isFlipY()) {
				Gdx.app.log("Test rotacji",Boolean.toString(sprite.regionList.get(0).isFlipX()));
				Gdx.app.log("Test rotacji",Boolean.toString(sprite.regionList.get(0).isFlipY()));
				sprite.regionList.get(0).flip(true, false);
			}
			else
				sprite.regionList.get(0).flip(false,false);
		}
		else{
			if(sprite.regionList.get(0).isFlipY())
				sprite.regionList.get(0).flip(true,true);
			else
				sprite.regionList.get(0).flip(false,true);
		}

	}
}
