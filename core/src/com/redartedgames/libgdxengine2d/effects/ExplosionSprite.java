package com.redartedgames.libgdxengine2d.effects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.redartedgames.libgdxengine2d.gameobject.GameObject;
import com.redartedgames.libgdxengine2d.gameobject.SpriteObject;
import com.redartedgames.libgdxengine2d.sound.MySound;

import java.util.Random;

public class ExplosionSprite extends SpriteObject {

    protected float power;

    public ExplosionSprite(float x, float y, GameObject parent, boolean isAttached, int size) {
        super(x, y, parent, isAttached);
        Random random = new Random();
        power = random.nextInt(17)+4;
        for(int i = 0; i < 14;i++){
            addTexture("graphic/explosion/e"+ i +".png");
        }
        scale(size);
        isOnce = true;
        setFrameTime(0.05f);
    }

    private void scale(int size) {
        this.sclX = size/power;
        this.sclY = size/power;
    }

    @Override
    public void updateLast(float delta, float vx, float vy) {
        super.updateLast(delta, vx, vy);
    }
}
