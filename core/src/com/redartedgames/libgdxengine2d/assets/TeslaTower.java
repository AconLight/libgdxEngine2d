package com.redartedgames.libgdxengine2d.assets;

import com.redartedgames.libgdxengine2d.gameobject.GameObject;

public class TeslaTower extends GameObject{
    public TeslaTowerSprite teslaTowerSprite;
    public TeslaTower(float x, float y) {
        super(x, y, null, false);
        teslaTowerSprite = new TeslaTowerSprite(0,0,this,true);
        addSprite(teslaTowerSprite);
    }

    public void updateLast(float delta, float vx, float vy){
        super.updateLast(delta,vx,vy);
    }

    public void collide(GameObject obj){
        teslaTowerSprite.collide(obj);
    }

    public void addCollidable(GameObject obj) {
        collidableObjects.add(obj);
    }

    public void update(float delta) {
        super.update(delta);
    }
}
