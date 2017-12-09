package com.redartedgames.libgdxengine2d.assets;

import com.badlogic.gdx.Game;
import com.redartedgames.libgdxengine2d.main.GameObject;
import com.redartedgames.libgdxengine2d.main.Hitbox;
import com.redartedgames.libgdxengine2d.main.SpriteObject;

public class Automat extends GameObject {
    SpriteObject Automatsprite;
    SpriteObject AutomatPoswiata;
    SpriteObject AutomatGlitch;
    SpriteObject AutomatGlitch2;
    public Automat(float x, float y, int alfa, GameObject parent, boolean isAttached){
        super(x, y, parent, isAttached);
        Hitbox AutomatHitbox;
        switch (alfa){
            case 0:
                AutomatHitbox = new Hitbox(x,y,148,156,Hitbox.none);
                setHitbox(AutomatHitbox);
                Automatsprite = new SpriteObject(0,0,this,true);
                addSprite(Automatsprite);
                Automatsprite.addTexture("graphic/automat/automat0.png");
                break;
            case 90:
                AutomatHitbox = new Hitbox(x,y,156,148,Hitbox.none);
                setHitbox(AutomatHitbox);
                Automatsprite = new SpriteObject(0,0,this,true);
                addSprite(Automatsprite);
                Automatsprite.addTexture("graphic/automat/automat0.png");
                Automatsprite.alfa = 270;
                break;
            case 180:
                AutomatHitbox = new Hitbox(x,y,156,148,Hitbox.none);
                setHitbox(AutomatHitbox);
                Automatsprite = new SpriteObject(0,0,this,true);
                addSprite(Automatsprite);
                Automatsprite.addTexture("graphic/automat/automat0.png");
                Automatsprite.alfa = 180;
                break;
            case 270:
                AutomatHitbox = new Hitbox(x,y,148,156,Hitbox.none);
                setHitbox(AutomatHitbox);
                Automatsprite = new SpriteObject(0,0,this,true);
                addSprite(Automatsprite);
                Automatsprite.addTexture("graphic/automat/automat0.png");
                Automatsprite.alfa = 90;
                break;
            default:
                AutomatHitbox = new Hitbox(x,y,148,156,Hitbox.none);
                setHitbox(AutomatHitbox);
                Automatsprite = new SpriteObject(0,0,this,true);
                addSprite(Automatsprite);
                Automatsprite.addTexture("graphic/automat/automat0.png");
                break;
        }
    }
}
