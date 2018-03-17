package com.redartedgames.libgdxengine2d.effects;

import com.redartedgames.libgdxengine2d.gameobject.GameObject;
import com.redartedgames.libgdxengine2d.gameobject.SpriteObject;

public class ExplosionSprite extends SpriteObject {

    public ExplosionSprite(float x, float y, GameObject parent, boolean isAttached, int size) {
        super(x, y, parent, isAttached);
        for(int i = 0; i < 14;i++){
            addTexture("graphic/explosion/e"+ i +".png");
        }
        scale(size);
        isOnce = true;
        setFrameTime(0.25f);
    }

    private void scale(int size) {
        this.sclX = size/25.0f;
        this.sclY = size/25.0f;
    }

    @Override
    public void updateLast(float delta, float vx, float vy) {
        super.updateLast(delta, vx, vy);
    }
}
