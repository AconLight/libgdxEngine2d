package com.redartedgames.libgdxengine2d.objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.redartedgames.libgdxengine2d.assets.Biurko;
import com.redartedgames.libgdxengine2d.main.GameObject;


public class Connection2 extends GameObject{
    public Wajha wajha;
    public Biurko biurko;
    private int x1;
    private int y1;
    private int x2;
    private int y2;
    private boolean isActive;

    public Connection2(Wajha wajha, Biurko biurko){
        super(0,0,null,false);
        this.wajha = wajha;
        this.biurko = biurko;
        x1 = wajha.x;
        y1 = wajha.y;
        x2 = (int)biurko.getMovement().getPosition().x;
        y2 = (int)biurko.getMovement().getPosition().y;
        isActive  =false;
    }

    public void changeStatus(){
        if(isActive) {
            isActive = false;
        }
        else {
            isActive = true;
        }
    }

    public void setInactive(){
        isActive=false;
    }

    private void drawInactive(ShapeRenderer shape){
        shape.setAutoShapeType(true);
        Gdx.gl20.glLineWidth(20);
        shape.setColor(Color.GRAY);
        shape.rectLine(x1+1,y1+1,x2+1,y2+1,10);
        shape.setAutoShapeType(false);
    }

    private void drawActive(ShapeRenderer shape){
        shape.setAutoShapeType(true);
        Gdx.gl20.glLineWidth(20);
        shape.setColor(Color.GOLD);
        shape.rectLine(x1+1,y1+1,x2+1,y2+1,10);
        shape.setAutoShapeType(false);
    }

    public void render(ShapeRenderer batch, int priority, float dx, float dy, float visibility){
        super.render(batch, priority, dx, dy, visibility);
        if(isActive) drawActive(batch);
        else drawInactive(batch);
    }
}
