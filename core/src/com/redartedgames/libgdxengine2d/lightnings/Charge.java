package com.redartedgames.libgdxengine2d.lightnings;

import com.badlogic.gdx.graphics.Texture;
import com.redartedgames.libgdxengine2d.gameobject.GameObject;
import com.redartedgames.libgdxengine2d.gameobject.SpriteObject;

public class Charge extends GameObject {

    private float x;
    private float y;
    private float size;
    private SpriteObject chargeSprite;

    public Charge(float x, float y, float size, GameObject parent, boolean isAttached) {
        super(x,y,parent,isAttached);
        this.x = x;
        this.y = y;
        this.size = size;
        chargeSprite = new SpriteObject(0,0,this,true);
        addSprite(chargeSprite);
        Texture texture = new Texture("graphic/charge/charge.png");
        scale(chargeSprite,texture);
        chargeSprite.addTexture(texture);
        chargeSprite.visibility = 1;
    }

    private void scale(SpriteObject s, Texture t) {
        float scale = t.getHeight()/size;
        s.sclX = scale;
        s.sclY = scale;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public float getSize() {
        return size;
    }

    @Override
    public void update(float delta) {
        super.update(delta);
    }
}
