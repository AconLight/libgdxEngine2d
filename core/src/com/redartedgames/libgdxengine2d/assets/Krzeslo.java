package com.redartedgames.libgdxengine2d.assets;

import com.redartedgames.libgdxengine2d.main.GameObject;
import com.redartedgames.libgdxengine2d.main.Hitbox;
import com.redartedgames.libgdxengine2d.main.SpriteObject;

public class Krzeslo extends GameObject{

    SpriteObject KszesloSprite;

    public Krzeslo(float x, float y, int alfa, GameObject parent, boolean isAttached){
        super(x,y,parent,isAttached);
        Hitbox KrzesloHitbox;
        switch (alfa) {
            case 0:
                KrzesloHitbox = new Hitbox(x,y,100,100, Hitbox.BehaviorMode.kinematic);
                setHitbox(KrzesloHitbox);
                KszesloSprite = new SpriteObject(0,0,this,true);
                addSprite(KszesloSprite);
                KszesloSprite.addTexture("graphic/krzeslo/krzeslo.png");
                KszesloSprite.visibility = 1;
                break;
            case 90:
                KrzesloHitbox = new Hitbox(x,y,100,100, Hitbox.BehaviorMode.kinematic);
                setHitbox(KrzesloHitbox);
                KszesloSprite = new SpriteObject(0,0,this,true);
                addSprite(KszesloSprite);
                KszesloSprite.addTexture("graphic/krzeslo/krzeslo.png");
                KszesloSprite.alfa = 270;
                KszesloSprite.visibility = 1;
                break;
            case 180:
                KrzesloHitbox = new Hitbox(x,y,100,100, Hitbox.BehaviorMode.kinematic);
                setHitbox(KrzesloHitbox);
                KszesloSprite = new SpriteObject(0,0,this,true);
                addSprite(KszesloSprite);
                KszesloSprite.addTexture("graphic/krzeslo/krzeslo.png");
                KszesloSprite.alfa = 180;
                KszesloSprite.visibility = 1;
                break;
            case 270:
                KrzesloHitbox = new Hitbox(x,y,100,100, Hitbox.BehaviorMode.kinematic);
                setHitbox(KrzesloHitbox);
                KszesloSprite = new SpriteObject(0,0,this,true);
                addSprite(KszesloSprite);
                KszesloSprite.addTexture("graphic/krzeslo/krzeslo.png");
                KszesloSprite.alfa = 90;
                KszesloSprite.visibility = 1;
                break;
            default:
                KrzesloHitbox = new Hitbox(x,y,100,100, Hitbox.BehaviorMode.kinematic);
                setHitbox(KrzesloHitbox);
                KszesloSprite = new SpriteObject(0,0,this,true);
                addSprite(KszesloSprite);
                KszesloSprite.addTexture("graphic/krzeslo/krzeslo.png");
                KszesloSprite.visibility = 1;
                break;
        }
    }

    public void update(float delta){
        super.update(delta);

    }
}
