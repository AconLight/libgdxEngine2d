package com.redartedgames.libgdxengine2d.assets;

import com.redartedgames.libgdxengine2d.effects.ExplosionSprite;
import com.redartedgames.libgdxengine2d.gameobject.GameObject;
import com.redartedgames.libgdxengine2d.gameobject.SpriteObject;

public class ElectricalElement extends GameObject {
    private SpriteObject spriteObject;
    private SpriteObject spriteObjectExplosion;
    private int size;

    public ElectricalElement(float x, float y, GameObject parent, boolean isAttached, int type) {
        super(x, y, parent, isAttached);
        spriteObject = new ElecrticalElementSprite(0,0,this,true,type);
        addSprite(spriteObject);
        setSize();
        spriteObjectExplosion = new ExplosionSprite(0,0,this,true,size);
        spriteObject.visibility = 1;
        spriteObject.isVisible = true;
        spriteObjectExplosion.visibility = 0;
        spriteObjectExplosion.isVisible = false;
        switch (type) {
            case 0: //dioda LED
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
        spriteObject.visibility = 0;
        spriteObject.isVisible = false;
        addSprite(spriteObjectExplosion);
        spriteObjectExplosion.visibility = 1;
        spriteObjectExplosion.isVisible = true;
    }
}
