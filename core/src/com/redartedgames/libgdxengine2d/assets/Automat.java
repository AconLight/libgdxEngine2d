package com.redartedgames.libgdxengine2d.assets;

import com.badlogic.gdx.Game;
import com.redartedgames.libgdxengine2d.main.GameObject;
import com.redartedgames.libgdxengine2d.main.Hitbox;
import com.redartedgames.libgdxengine2d.main.SpriteObject;
import com.redartedgames.libgdxengine2d.objects.Guard;
import com.redartedgames.libgdxengine2d.sound.MySound;
import com.redartedgames.libgdxengine2d.sound.SoundGlitch;
import com.redartedgames.libgdxengine2d.utilities.HitText;
import com.redartedgames.libgdxengine2d.utilities.RandomizeRandomTextToAutomat;


import java.util.ArrayList;
import java.util.Random;



public class Automat extends GameObject {

    SpriteObject Automatsprite;
    SpriteObject AutomatPoswiata;
    SpriteObject AutomatGlitch;
    SpriteObject AutomatGlitch2;
    boolean IsEnabled=false;
    HitText tekst;
    RandomizeRandomTextToAutomat rnd;
    String stringi;
    private float x;
    private float y;
    private GameObject parent;
    private ArrayList<Guard> guardList;
    public ArrayList<Guard> triggeredGuards;
    private int iter;

    public Automat(float x, float y, int alfa, GameObject parent, boolean isAttached){
        super(x, y, parent, isAttached);

        this.x = x;
        this.y = y;
        this.parent = parent;
        Hitbox AutomatHitbox;
        rnd = new RandomizeRandomTextToAutomat();
        stringi = rnd.getRandomTekst();
        iter = 0;
        guardList = new ArrayList<>();
        triggeredGuards = new ArrayList<>();

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

                AutomatGlitch2 = new SpriteObject(0,0,this,true);
                addSprite(AutomatGlitch2);
                AutomatGlitch2.addTexture("graphic/automat/automatGlitch2.png");
                AutomatGlitch2.visibility = 0f;

                //tekst = rnd.migoconcyTekst(x,y,this,5,0);
                //addSprite(tekst);

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

                AutomatGlitch2 = new SpriteObject(0,0,this,true);
                addSprite(AutomatGlitch2);
                AutomatGlitch2.addTexture("graphic/automat/automatGlitch2.png");
                AutomatGlitch2.alfa = 270;
                AutomatGlitch2.visibility = 0f;
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

                AutomatGlitch2 = new SpriteObject(0,0,this,true);
                addSprite(AutomatGlitch2);
                AutomatGlitch2.addTexture("graphic/automat/automatGlitch2.png");
                AutomatGlitch2.alfa = 180;
                AutomatGlitch2.visibility = 0f;
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

                AutomatGlitch2 = new SpriteObject(0,0,this,true);
                addSprite(AutomatGlitch2);
                AutomatGlitch2.addTexture("graphic/automat/automatGlitch2.png");
                AutomatGlitch2.alfa = 90;
                AutomatGlitch2.visibility = 0f;
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

                AutomatGlitch2 = new SpriteObject(0,0,this,true);
                addSprite(AutomatGlitch2);
                AutomatGlitch2.addTexture("graphic/automat/automatGlitch2.png");
                AutomatGlitch2.visibility = 0f;
                break;
        }

    }

    public void setIsEnabled(boolean set){
        IsEnabled=set;
    }

    private float licznik=0;

    public void onoff(boolean set){
        float zamiana;
        if (set == true) zamiana=1;
        else zamiana=0;
        SoundGlitch snd = new SoundGlitch();
        snd.play(1);
        AutomatGlitch2.visibility=zamiana;
        setIsEnabled(set);
    }

    public boolean isTriggered = false;

    public void trigger(){
        if (isTriggered==true) {
            iter=100;
            isTriggered=false;
            float guard_x;
            float guard_y;
            double distance;
            for (int i = 0; i < guardList.size(); i++) {
                guard_x = guardList.get(i).getMovement().getPosition().x;
                guard_y = guardList.get(i).getMovement().getPosition().y;
                distance = Math.sqrt(((x - guard_x) * (x - guard_x)) + ((y - guard_y) * (y - guard_y)));
                if (distance <= 200) {
                    //guardList.get(i).trigger();
                    onoff(true);
                    triggeredGuards.add(guardList.get(i));
                }
            }
        }
        if (iter==1){
            //guard untrigger, turn off automat
            onoff(false);
            for (int i=0;i<triggeredGuards.size();i++){
                 //triggeredGuards.get(i).untrigger();
                triggeredGuards.remove(i);
            }
        }
        if (iter>1) iter--;
    }

    public void update(float delta){
        super.update(delta);

        trigger();

        Random generator = new Random();
        int podzielna = generator.nextInt(150)+5;

        Random generrator = new Random();
        int podzielna_poswiata = generrator.nextInt(25)+5;

        Random generrrator = new Random();
        float colour = generrrator.nextFloat();

        Random generrrrator = new Random();
        float colourr = generrrrator.nextFloat();

        Random generrrrrator = new Random();
        int miganie = generrrrrator.nextInt(2500)+1;

        Random generrrrrrator = new Random();
        int poddzielna = generrrrrrator.nextInt(1000)+1;

        Random randTimeGen = new Random();
        int randTimeEnd = randTimeGen.nextInt(2)+1;

        if (AutomatGlitch.visibility == 1f) AutomatGlitch.visibility = 0f;
        if (licznik%podzielna == 0){
            if (AutomatGlitch.visibility == 0f){

                AutomatGlitch.visibility = 1f;
            } else {
                //????? kurwwa...
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

        if (licznik%poddzielna==0){
            if (AutomatGlitch2.visibility==1f) AutomatGlitch2.visibility=0f;
        }

        if (licznik%miganie==0){
            //tekst.endTime=(float)randTimeEnd;
            tekst = rnd.migoconcyTekst(x,y,parent,(float)randTimeEnd,1);
            //tekst.visibility=1;
            addSprite(tekst);
        }
        licznik++;
    }
}
