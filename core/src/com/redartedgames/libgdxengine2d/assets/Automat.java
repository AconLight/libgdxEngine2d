package com.redartedgames.libgdxengine2d.assets;

import com.badlogic.gdx.Game;
import com.redartedgames.libgdxengine2d.main.GameObject;
import com.redartedgames.libgdxengine2d.main.Hitbox;
import com.redartedgames.libgdxengine2d.main.SpriteObject;

import java.util.Random;

public class Automat extends GameObject {

    SpriteObject Automatsprite;
    SpriteObject AutomatPoswiata;
    SpriteObject AutomatGlitch;
    SpriteObject AutomatGlitch2;
    boolean IsEnabled=false;

    public Automat(float x, float y, int alfa, GameObject parent, boolean isAttached){
        super(x, y, parent, isAttached);
        Hitbox AutomatHitbox;
        switch (alfa){
            case 0:
                AutomatHitbox = new Hitbox(x,y,148,156, Hitbox.BehaviorMode.kinematic);
                setHitbox(AutomatHitbox);
                Automatsprite = new SpriteObject(0,0,this,true);
                addSprite(Automatsprite);
                Automatsprite.addTexture("graphic/automat/automat0.png");

                AutomatGlitch = new SpriteObject(0,0,this,true);
                addSprite(AutomatGlitch);
                AutomatGlitch.addTexture("graphic/automat/automatGlitch.png");

                AutomatPoswiata = new SpriteObject(0,0,this,true);
                addSprite(AutomatPoswiata);
                AutomatPoswiata.addTexture("graphic/automat/automatPos.png");
                AutomatPoswiata.visibility = 0;
                break;

            case 90:
                AutomatHitbox = new Hitbox(x,y,156,148,Hitbox.BehaviorMode.kinematic);
                setHitbox(AutomatHitbox);
                Automatsprite = new SpriteObject(0,0,this,true);
                addSprite(Automatsprite);
                Automatsprite.addTexture("graphic/automat/automat0.png");
                Automatsprite.alfa = 270;

                AutomatGlitch = new SpriteObject(0,0,this,true);
                addSprite(AutomatGlitch);
                AutomatGlitch.addTexture("graphic/automat/automatGlitch.png");
                AutomatGlitch.alfa = 270;

                AutomatPoswiata = new SpriteObject(0,0,this,true);
                addSprite(AutomatPoswiata);
                AutomatPoswiata.addTexture("graphic/automat/automatPos.png");
                AutomatPoswiata.visibility = 0;
                AutomatPoswiata.alfa = 270;
                break;

            case 180:
                AutomatHitbox = new Hitbox(x,y,156,148,Hitbox.BehaviorMode.kinematic);
                setHitbox(AutomatHitbox);
                Automatsprite = new SpriteObject(0,0,this,true);
                addSprite(Automatsprite);
                Automatsprite.addTexture("graphic/automat/automat0.png");
                Automatsprite.alfa = 180;

                AutomatGlitch = new SpriteObject(0,0,this,true);
                addSprite(AutomatGlitch);
                AutomatGlitch.addTexture("graphic/automat/automatGlitch.png");
                AutomatGlitch.alfa = 180;

                AutomatPoswiata = new SpriteObject(0,0,this,true);
                addSprite(AutomatPoswiata);
                AutomatPoswiata.addTexture("graphic/automat/automatPos.png");
                AutomatPoswiata.visibility = 0;
                AutomatPoswiata.alfa = 180;
                break;

            case 270:
                AutomatHitbox = new Hitbox(x,y,148,156,Hitbox.BehaviorMode.kinematic);
                setHitbox(AutomatHitbox);
                Automatsprite = new SpriteObject(0,0,this,true);
                addSprite(Automatsprite);
                Automatsprite.addTexture("graphic/automat/automat0.png");
                Automatsprite.alfa = 90;

                AutomatGlitch = new SpriteObject(0,0,this,true);
                addSprite(AutomatGlitch);
                AutomatGlitch.addTexture("graphic/automat/automatGlitch.png");
                AutomatGlitch.alfa = 90;

                AutomatPoswiata = new SpriteObject(0,0,this,true);
                addSprite(AutomatPoswiata);
                AutomatPoswiata.addTexture("graphic/automat/automatPos.png");
                AutomatPoswiata.visibility = 0;
                AutomatPoswiata.alfa = 90;
                break;

            default:
                AutomatHitbox = new Hitbox(x,y,148,156,Hitbox.BehaviorMode.kinematic);
                setHitbox(AutomatHitbox);
                Automatsprite = new SpriteObject(0,0,this,true);
                addSprite(Automatsprite);
                Automatsprite.addTexture("graphic/automat/automat0.png");

                AutomatGlitch = new SpriteObject(0,0,this,true);
                addSprite(AutomatGlitch);
                AutomatGlitch.addTexture("graphic/automat/automatGlitch.png");

                AutomatPoswiata = new SpriteObject(0,0,this,true);
                addSprite(AutomatPoswiata);
                AutomatPoswiata.addTexture("graphic/automat/automatPos.png");
                AutomatPoswiata.visibility = 0;
                break;
        }
    }

    public void setIsEnabled(boolean set){
        IsEnabled=set;
    }

    private float licznik=0;

    public void update(float delta){
        super.update(delta);

        Random generator = new Random();
        int podzielna = generator.nextInt(150)+5;

        Random generrator = new Random();
        int podzielna_poswiata = generrator.nextInt(25)+5;

        Random generrrator = new Random();
        float colour = generrrator.nextFloat();

        Random generrrrator = new Random();
        float colourr = generrrrator.nextFloat();

        if (AutomatGlitch.visibility == 1f) AutomatGlitch.visibility = 0f;
        if (licznik%podzielna == 0){
            if (AutomatGlitch.visibility == 0f){
                AutomatGlitch.visibility = 1f;
            } else {

            }
        }

        if (IsEnabled == true) {
            AutomatPoswiata.visibility = 1f;
            if (licznik%podzielna_poswiata == 0){
                if (AutomatPoswiata.visibility == 0.6f) {
                    AutomatPoswiata.visibility = 1f;
                    AutomatPoswiata.R=0f;
                    AutomatPoswiata.G=colour;
                    AutomatPoswiata.B=1f;
                } else {
                    AutomatPoswiata.visibility = 0.6f;
                    AutomatPoswiata.R=0f;
                    AutomatPoswiata.G=colourr;
                    AutomatPoswiata.B=1f;
                }
            }
        }
        licznik++;
    }
}
