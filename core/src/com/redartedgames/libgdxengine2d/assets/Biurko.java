package com.redartedgames.libgdxengine2d.assets;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.redartedgames.libgdxengine2d.main.GameObject;
import com.redartedgames.libgdxengine2d.main.Hitbox;
import com.redartedgames.libgdxengine2d.main.SpriteObject;

public class Biurko extends GameObject {
	public Biurko (float x, float y, int alfa, GameObject parent,boolean isAttached){
		super(x, y, parent,isAttached);
		Hitbox biurkoHitbox;
		SpriteObject biurkoSprite;
		switch(alfa){
		case 0:
		biurkoHitbox = new Hitbox(x, y, 200, 100, Hitbox.none);
		setHitbox(biurkoHitbox);
		biurkoSprite = new SpriteObject(0,0,this,true);
		addSprite(biurkoSprite);
		biurkoSprite.addTexture("graphic/biurko/biurko0.png");
		break;
		case 90:
			biurkoHitbox = new Hitbox(x, y, 100, 200, Hitbox.none);
			setHitbox(biurkoHitbox);
			biurkoSprite = new SpriteObject(0,0,this,true);
			addSprite(biurkoSprite);
			
			biurkoSprite.addTexture("graphic/biurko/biurko90.png");
		break;
		case 180:
			biurkoHitbox = new Hitbox(x, y, 200, 100, Hitbox.none);
			setHitbox(biurkoHitbox);
			biurkoSprite = new SpriteObject(0,0,this,true);
			addSprite(biurkoSprite);
			biurkoSprite.addTexture("graphic/biurko/biurko180.png");
		break;
		case 270:
			biurkoHitbox = new Hitbox(x, y, 200, 100, Hitbox.none);
			setHitbox(biurkoHitbox);
			biurkoSprite = new SpriteObject(0,0,this,true);
			addSprite(biurkoSprite);
			biurkoSprite.addTexture("graphic/biurko/biurko270.png");
		break;
		default:
			biurkoHitbox = new Hitbox(x, y, 200, 100, Hitbox.none);
			setHitbox(biurkoHitbox);
			biurkoSprite = new SpriteObject(0,0,this,true);
			addSprite(biurkoSprite);
			biurkoSprite.addTexture("graphic/biurko/biurko0.png");
		break;
		}
	}
	

}
