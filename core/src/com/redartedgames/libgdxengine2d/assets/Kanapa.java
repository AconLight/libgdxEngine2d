package com.redartedgames.libgdxengine2d.assets;

import com.redartedgames.libgdxengine2d.main.GameObject;
import com.redartedgames.libgdxengine2d.main.Hitbox;
import com.redartedgames.libgdxengine2d.main.SpriteObject;

public class Kanapa extends GameObject{
    SpriteObject KanapaSprite;

    public Kanapa(float x, float y, int alfa, GameObject parent, boolean isAttached){
        super(x,y,parent,isAttached);
        Hitbox KanapaHitbox;

        switch (alfa){
            case 0:
                KanapaHitbox = new Hitbox(x,y,200,100, Hitbox.BehaviorMode.kinematic);
                setHitbox(KanapaHitbox);
                KanapaSprite = new SpriteObject(0,0,this,true);
                addSprite(KanapaSprite);
                KanapaSprite.addTexture("graphic/kanapa/kanapa.png");
                KanapaSprite.visibility = 1;
                break;
            case 90:
                KanapaHitbox = new Hitbox(x,y,100,200, Hitbox.BehaviorMode.kinematic);
                setHitbox(KanapaHitbox);
                KanapaSprite = new SpriteObject(0,0,this,true);
                addSprite(KanapaSprite);
                KanapaSprite.addTexture("graphic/kanapa/kanapa.png");
                KanapaSprite.visibility = 1;
                KanapaSprite.alfa = 270;
                break;
            case 180:
                KanapaHitbox = new Hitbox(x,y,200,100, Hitbox.BehaviorMode.kinematic);
                setHitbox(KanapaHitbox);
                KanapaSprite = new SpriteObject(0,0,this,true);
                addSprite(KanapaSprite);
                KanapaSprite.addTexture("graphic/kanapa/kanapa.png");
                KanapaSprite.visibility = 1;
                KanapaSprite.alfa = 180;
                break;
            case 270:
                KanapaHitbox = new Hitbox(x,y,100,200, Hitbox.BehaviorMode.kinematic);
                setHitbox(KanapaHitbox);
                KanapaSprite = new SpriteObject(0,0,this,true);
                addSprite(KanapaSprite);
                KanapaSprite.addTexture("graphic/kanapa/kanapa.png");
                KanapaSprite.visibility = 1;
                KanapaSprite.alfa = 90;
                break;
            default:
                KanapaHitbox = new Hitbox(x,y,100,100, Hitbox.BehaviorMode.kinematic);
                setHitbox(KanapaHitbox);
                KanapaSprite = new SpriteObject(0,0,this,true);
                addSprite(KanapaSprite);
                KanapaSprite.addTexture("graphic/kanapa/kanapa.png");
                KanapaSprite.visibility = 1;
                break;
        }
    }
    public void update(float delta){ super.update(delta); }
}
