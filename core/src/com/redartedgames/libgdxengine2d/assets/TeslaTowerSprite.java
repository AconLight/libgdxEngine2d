package com.redartedgames.libgdxengine2d.assets;

import com.redartedgames.libgdxengine2d.gameobject.GameObject;
import com.redartedgames.libgdxengine2d.gameobject.SpriteObject;

public class TeslaTowerSprite extends SpriteObject {
    public TeslaTowerSprite(float x, float y, GameObject parent, boolean isAttached) {
        super(x, y, parent, isAttached);
        for(int i = 0; i < 8;i++){
        addTexture("graphic/tesla_animacja/Tesla_animacja_"+i+".png");
        }
        setIsPingpong(true);
    }
}
