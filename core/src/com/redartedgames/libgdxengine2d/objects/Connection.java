package com.redartedgames.libgdxengine2d.objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.redartedgames.libgdxengine2d.assets.Biurko;
import com.redartedgames.libgdxengine2d.main.GameObject;

public class Connection extends GameObject{
    private Biurko startingPosition;
    private Biurko finishPosition;
    private Boolean isActive;
    //private SpriteBatch batch;
    //private ShapeRenderer shape;
    private int x1,y1,x2,y2;

    public Connection(Biurko startingPosition, Biurko finishPosition){
        super(0,0,startingPosition,true);
        //batch = new SpriteBatch();
        //shape = new ShapeRenderer();
        isActive = false;
        this.startingPosition = startingPosition;
        this.finishPosition = finishPosition;
        x1 = (int)startingPosition.getMovement().getPosition().x;
        y1 = (int)startingPosition.getMovement().getPosition().y;
        x2 = (int)finishPosition.getMovement().getPosition().x;
        y2 = (int)finishPosition.getMovement().getPosition().y;
    }

    public void changeStatus(){
        if(isActive) isActive = false;
        else isActive = true;
    }

    private void drawInactive(ShapeRenderer shape){
        shape.setAutoShapeType(true);
        Gdx.gl20.glLineWidth(20);
        //shape.setColor(183,177,20,1);
        shape.setColor(Color.GRAY);
        shape.rectLine(x1+1,y1+1,x2+1,y2+1,10);
        shape.setAutoShapeType(false);
    }

    private void drawActive(ShapeRenderer shape){
        shape.setAutoShapeType(true);
        Gdx.gl20.glLineWidth(20);
        //shape.setColor(72,72,72,1);
        shape.setColor(Color.GOLD);
        shape.rectLine(x1+1,y1+1,x2+1,y2+1,10);
        shape.setAutoShapeType(false);
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public Biurko getStartingPosition() {
        return startingPosition;
    }

    public Biurko getFinishPosition() {
        return finishPosition;
    }

    public void render(ShapeRenderer batch, int priority, float dx, float dy, float visibility){
        super.render(batch, priority, dx, dy, visibility);
        if(isActive) drawActive(batch);
        else drawInactive(batch);
    }
}
