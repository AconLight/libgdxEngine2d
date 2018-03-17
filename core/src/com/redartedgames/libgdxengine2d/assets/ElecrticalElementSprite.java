package com.redartedgames.libgdxengine2d.assets;

import com.redartedgames.libgdxengine2d.gameobject.GameObject;
import com.redartedgames.libgdxengine2d.gameobject.SpriteObject;

public class ElecrticalElementSprite extends SpriteObject{

    public ElecrticalElementSprite(float x, float y, GameObject parent, boolean isAttached, int type) {
        super(x, y, parent, isAttached);
        addTexture("graphic/ukladyElektryczne/u" + type +".png");
    }


}