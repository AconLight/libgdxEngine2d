package com.redartedgames.libgdxengine2d.assets;

import com.redartedgames.libgdxengine2d.gameobject.GameObject;
import com.redartedgames.libgdxengine2d.gameobject.SpriteObject;

public class ChargeSprite extends SpriteObject {
    public ChargeSprite(float x, float y, GameObject parent, boolean isAttached) {
        super(x, y, parent, isAttached);
        for(int i = 0; i < 7;i++){
            addTexture("graphic/charge/Charge_animation/Charge_animation_"+i+".png");
        }
        setFrameTime(0.05f);
    }
}
