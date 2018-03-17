package com.redartedgames.libgdxengine2d.assets;

import com.redartedgames.libgdxengine2d.effects.ExplosionSprite;
import com.redartedgames.libgdxengine2d.gameobject.GameObject;
import com.redartedgames.libgdxengine2d.gameobject.SpriteObject;

import java.util.Random;

public class ElectricalElement extends GameObject {
    private SpriteObject spriteObject;
    private SpriteObject spriteObjectExplosion;
    private int size;
    private Random rng;
    private int type;
    private int counterBoom;
    private boolean hasExploded;

    public ElectricalElement(float x, float y, GameObject parent, boolean isAttached, int type) {
        super(x, y, parent, isAttached);
        this.type=type;
        rng = new Random();
        spriteObject = new ElecrticalElementSprite(0,0,this,true,type);
        addSprite(spriteObject);
        setSize();
        counterBoom = 0;
        spriteObjectExplosion = new ExplosionSprite(0,0,this,true,size);
        spriteObject.visibility = 1;
        spriteObject.isVisible = true;
        spriteObjectExplosion.visibility = 0;
        spriteObjectExplosion.isVisible = false;
        hasExploded = false;
        switch (type) {
            case 0: //dioda LED
                for (int i=0;i<500;i++) {
                    int wylosowanyNumerInt = rng.nextInt(3)+1;
                    switch (wylosowanyNumerInt){
                        case 1:
                            spriteObject.R=0;
                            spriteObject.G=0;
                            spriteObject.B=1;
                            break;
                        case 2:
                            spriteObject.R=0;
                            spriteObject.G=1;
                            spriteObject.B=0;
                            break;
                        case 3:
                            spriteObject.R=1;
                            spriteObject.G=0;
                            spriteObject.B=0;
                            break;
                    }
                }
                break;
            case 1: //kondensator
                //efekty
                break;
            case 2: //tranzystor
                break;
            case 3: //rezystor
                break;
            case 4: //Pentium P5
                break;
            case 5: //LM75
                break;
            case 6: //LCD
                break;
        }
    }

    private void setSize() {
        size = spriteObject.regionList.get(0).getRegionHeight();
        if(size < spriteObject.regionList.get(0).getRegionWidth()) size = spriteObject.regionList.get(0).getRegionWidth();
    }

    public int getSize() {
        return size;
    }

    public void explode() {
        hasExploded = true;
        spriteObject.visibility = 0;
        spriteObject.isVisible = false;
        addSprite(spriteObjectExplosion);
        spriteObjectExplosion.visibility = 1;
        spriteObjectExplosion.isVisible = true;
        counterBoom = 0;
    }

    public void update(float delta) {
        super.update(delta);
        float losujWolniej = rng.nextInt(100);
        if (type==0 && losujWolniej%5==0) {
            int wylosowanyNumerInt = rng.nextInt(3) + 1;
            switch (wylosowanyNumerInt) {
                case 1:
                    spriteObject.R = 0;
                    spriteObject.G = 0;
                    spriteObject.B = 1;
                    break;
                case 2:
                    spriteObject.R = 0;
                    spriteObject.G = 1;
                    spriteObject.B = 0;
                    break;
                case 3:
                    spriteObject.R = 1;
                    spriteObject.G = 0;
                    spriteObject.B = 0;
                    break;
            }
        }
        if(counterBoom == 200 && hasExploded) {
            spriteObject = new ElecrticalElementSprite(0,0,this,true,rng.nextInt(6));
            hasExploded = false;
        }
    }
}
