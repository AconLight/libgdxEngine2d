package com.redartedgames.libgdxengine2d.assets;

import com.redartedgames.libgdxengine2d.main.GameObject;
import com.redartedgames.libgdxengine2d.main.Hitbox;
import com.redartedgames.libgdxengine2d.main.SpriteObject;

public class Doniczkowiec extends GameObject {

    SpriteObject DoniczkowiecSprite;

    public Doniczkowiec(float x, float y, int alfa, GameObject parent, boolean isAttached){
        super(x,y,parent,isAttached);
        Hitbox DoniczkowiecHitbox;

        switch (alfa){
            case 0:
                DoniczkowiecHitbox = new Hitbox(x,y,100,100, Hitbox.BehaviorMode.kinematic);
                setHitbox(DoniczkowiecHitbox);
                DoniczkowiecSprite = new SpriteObject(0,0,this,true);
                addSprite(DoniczkowiecSprite);
                DoniczkowiecSprite.addTexture("graphic/roslinki/doniczkowiec.png");
                DoniczkowiecSprite.visibility = 1;
                break;
            case 90:
                DoniczkowiecHitbox = new Hitbox(x,y,100,100, Hitbox.BehaviorMode.kinematic);
                setHitbox(DoniczkowiecHitbox);
                DoniczkowiecSprite = new SpriteObject(0,0,this,true);
                addSprite(DoniczkowiecSprite);
                DoniczkowiecSprite.addTexture("graphic/roslinki/doniczkowiec.png");
                DoniczkowiecSprite.visibility = 1;
                DoniczkowiecSprite.alfa = 270;
                break;
            case 180:
                DoniczkowiecHitbox = new Hitbox(x,y,100,100, Hitbox.BehaviorMode.kinematic);
                setHitbox(DoniczkowiecHitbox);
                DoniczkowiecSprite = new SpriteObject(0,0,this,true);
                addSprite(DoniczkowiecSprite);
                DoniczkowiecSprite.addTexture("graphic/roslinki/doniczkowiec.png");
                DoniczkowiecSprite.visibility = 1;
                DoniczkowiecSprite.alfa = 180;
                break;
            case 270:
                DoniczkowiecHitbox = new Hitbox(x,y,100,100, Hitbox.BehaviorMode.kinematic);
                setHitbox(DoniczkowiecHitbox);
                DoniczkowiecSprite = new SpriteObject(0,0,this,true);
                addSprite(DoniczkowiecSprite);
                DoniczkowiecSprite.addTexture("graphic/roslinki/doniczkowiec.png");
                DoniczkowiecSprite.visibility = 1;
                DoniczkowiecSprite.alfa = 90;
                break;
            default:
                DoniczkowiecHitbox = new Hitbox(x,y,100,100, Hitbox.BehaviorMode.kinematic);
                setHitbox(DoniczkowiecHitbox);
                DoniczkowiecSprite = new SpriteObject(0,0,this,true);
                addSprite(DoniczkowiecSprite);
                DoniczkowiecSprite.addTexture("graphic/roslinki/doniczkowiec.png");
                DoniczkowiecSprite.visibility = 1;
                break;
        }
    }
    public void update(float delta){ super.update(delta); }
}
