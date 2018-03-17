package com.redartedgames.libgdxengine2d.assets;

import com.redartedgames.libgdxengine2d.gameobject.GameObject;
import com.redartedgames.libgdxengine2d.gameobject.SpriteObject;

public class BoardHolder extends SpriteObject {
    public BoardHolder(float x, float y, GameObject parent, boolean isAttached){
        super(x, y, parent, isAttached);
        addTexture("graphic/plansza/plansza_4xmonitor.png");

    }
}
