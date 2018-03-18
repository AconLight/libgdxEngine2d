package com.redartedgames.libgdxengine2d.assets;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.redartedgames.libgdxengine2d.gameobject.GameObject;
import com.redartedgames.libgdxengine2d.gameobject.SpriteObject;
import com.redartedgames.libgdxengine2d.physics.Hitbox;

public class ElecrticalElementSprite extends SpriteObject{

    private Texture txt;
    private Hitbox hit;

    public ElecrticalElementSprite(float x, float y, GameObject parent, boolean isAttached, int type) {
        super(x, y, parent, isAttached);
        //addTexture("graphic/ukladyElektryczne/u" + type +".png");
        txt = new Texture("graphic/ukladyElektryczne/u" + type +".png");
        addTexture(txt);
        hit = new Hitbox(0,0,txt.getWidth(),txt.getHeight(), Hitbox.BehaviorMode.kinematic);
        setHitbox(hit);

    }
}
