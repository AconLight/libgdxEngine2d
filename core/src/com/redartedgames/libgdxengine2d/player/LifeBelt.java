package com.redartedgames.libgdxengine2d.player;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.redartedgames.libgdxengine2d.gameobject.GameObject;
import com.redartedgames.libgdxengine2d.gameobject.SpriteObject;

public class LifeBelt extends SpriteObject{

	private float width = 150, height = 10;
    private float x;
    private float y;
    public float pointsOfLife=10;
    public LifeBelt(float x, float y, GameObject parent, boolean isAttached) {
        super(x, y, parent, isAttached);
        this.x = x;
        this.y = y;
    }

    public void render(ShapeRenderer batch, int priority, float dx, float dy,float visibility) {
    	float pointsOfLife2 = pointsOfLife;
    	if (pointsOfLife2 < 0) pointsOfLife2 = 0;
        batch.rect(dx + x-width/2, dy + y-height/2, width, height, Color.RED, Color.RED, Color.RED, Color.RED);
        batch.rect(dx + x+width/2, dy + y-height/2,-width/100*(100-pointsOfLife2),height,Color.BLUE,Color.BLUE,Color.BLUE,Color.BLUE);
    }

    public void updateLast(float delta, float vx, float vy) {
        //pointsOfLife=((Player)parent).urLife;
    }



}
