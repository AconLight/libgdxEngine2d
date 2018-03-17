package com.redartedgames.libgdxengine2d.player;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.redartedgames.libgdxengine2d.gameobject.GameObject;
import com.redartedgames.libgdxengine2d.gameobject.SpriteObject;

import java.lang.reflect.GenericDeclaration;

public class LifeBelt extends SpriteObject{

    private float x;
    private float y;
    //private GameObject parent;
    private float pointsOfLife=10;
    public LifeBelt(float x, float y, GameObject parent, boolean isAttached) {
        super(x, y, parent, isAttached);
        this.x = x;
        this.y = y;
        //this.parent=parent;
    }

    public void render(ShapeRenderer batch, int priority, float dx, float dy,float visibility) {
        batch.rect(x, y, 600, 50, Color.RED, Color.RED, Color.RED, Color.RED);
        batch.rect(x+600,y,-6*pointsOfLife,50,Color.BLUE,Color.BLUE,Color.BLUE,Color.BLUE);
    }

    public void updateLast(float delta, float vx, float vy) {
        //pointsOfLife=Player.urLife;
        pointsOfLife=((Player)parent).urLife;
        Gdx.app.log("KURWAAAAAAAAAAAAAA",Float.toString(pointsOfLife));
        //super.updateLast(delta,vx,vy);
    }



}
