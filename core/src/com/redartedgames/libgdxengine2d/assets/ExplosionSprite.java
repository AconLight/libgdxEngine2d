package com.redartedgames.libgdxengine2d.assets;

import com.redartedgames.libgdxengine2d.gameobject.GameObject;
import com.redartedgames.libgdxengine2d.gameobject.SpriteObject;

public class ExplosionSprite extends SpriteObject {
    public ExplosionSprite(float x, float y, GameObject parent, boolean isAttached) {
        super(x, y, parent, isAttached);
        for(int i = 0; i < 14;i++){
            addTexture("graphic/explosion/e"+ i +".png");
        }
        isOnce = true;
        setFrameTime(0.05f);
    }

    @Override
    public void updateLast(float delta, float vx, float vy) {
        super.updateLast(delta, vx, vy);
    }
}
