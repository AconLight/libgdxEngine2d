package com.redartedgames.libgdxengine2d.assets;

import com.badlogic.gdx.graphics.Texture;
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
        hit = new Hitbox(x,y,txt.getWidth(),txt.getHeight(), Hitbox.BehaviorMode.kinematic);

        switch (type) {
            case 0: //dioda LED
                //hitboxy
                break;
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            case 6: //LCD
                break;
        }
    }
}
