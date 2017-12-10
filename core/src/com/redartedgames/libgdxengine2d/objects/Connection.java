package com.redartedgames.libgdxengine2d.objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.redartedgames.libgdxengine2d.assets.Biurko;
import com.redartedgames.libgdxengine2d.main.GameObject;

public class Connection extends GameObject{
    private Biurko startingPosition;
    private Biurko finishPosition;
    private Boolean isActive;
    private SpriteBatch batch;
    private ShapeRenderer shape;

    public Connection(Biurko startingPosition, Biurko finishPosition){
        super(0,0,null,false);
        batch = new SpriteBatch();
        shape = new ShapeRenderer();
        isActive = false;
        this.startingPosition = startingPosition;
        this.finishPosition = finishPosition;
        drawInactive();
    }

    public void changeStatus(){
        if(isActive) isActive = false;
        else isActive = true;
    }

    private void drawActive(){
        //batch.draw(rect,1,1,1,1);
        Gdx.gl20.glLineWidth(10);
        shape.begin(ShapeRenderer.ShapeType.Line);
        shape.setColor(183,177,20,1);
        shape.line(startingPosition.getMovement().getPosition().x+400,startingPosition.getMovement().getPosition().y+400,
                    finishPosition.getMovement().getPosition().x+400,finishPosition.getMovement().getPosition().y+400);
        shape.end();
    }

    private void drawInactive(){
        Gdx.gl20.glLineWidth(10);
        shape.begin(ShapeRenderer.ShapeType.Line);
        shape.setColor(72,72,72,1);
        shape.line(startingPosition.getMovement().getPosition().x+400,startingPosition.getMovement().getPosition().y+400,
                finishPosition.getMovement().getPosition().x+400,finishPosition.getMovement().getPosition().y+400);
        shape.end();
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
        if(isActive) drawActive();
        else drawInactive();
    }
}
