package com.redartedgames.libgdxengine2d.assets;

import com.redartedgames.libgdxengine2d.gameobject.GameObject;
import com.redartedgames.libgdxengine2d.gameobject.SpriteObject;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ChargeSprite extends SpriteObject {
    public ChargeSprite(float x, float y, GameObject parent, boolean isAttached) {
        super(x, y, parent, isAttached);
        Random random = new Random();
        int los = random.nextInt(7);
        for(int i = 0; i < 7;i++){
            addTexture("graphic/charge/Charge_animation/Charge_animation_"+(i+los)%7+".png");
        }
        setFrameTime(0.05f);
    }

    @Override
    public void updateLast(float delta, float vx, float vy) {
        super.updateLast(delta, vx, vy);
        System.out.println("hiiii");
    }
}
