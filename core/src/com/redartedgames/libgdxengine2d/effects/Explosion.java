package com.redartedgames.libgdxengine2d.effects;

import com.badlogic.gdx.graphics.Texture;
import com.redartedgames.libgdxengine2d.gameobject.GameObject;
import com.redartedgames.libgdxengine2d.gameobject.SpriteObject;

public class Explosion extends GameObject{

    private SpriteObject spriteObject;

    public Explosion(float x, float y, GameObject parent, boolean isAttached, int size) {
        super(x, y, parent, isAttached);
        spriteObject = new ExplosionSprite(0,0,this,true);
        addSprite(spriteObject);
        //scale(size);
        spriteObject.visibility = 1;
        spriteObject.isVisible = true;
    }

    private void scale(int size) {
        Texture texture = new Texture("graphic/explosion/e1.png");
        float change = size/texture.getHeight();
        spriteObject.sclX = change;
        spriteObject.sclY = change;
    }
}
