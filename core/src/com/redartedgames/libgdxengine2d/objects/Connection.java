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
        if(isActive) {
            isActive = false;
            for(Connection c : finishPosition.connections)
                if(c.finishPosition==this.startingPosition) c.isActive=false;
        }
        else {
                isActive = true;
                for(Connection c : finishPosition.connections)
                    if(c.finishPosition==this.startingPosition) c.isActive=true;
        }
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
  //Jebane kurwa gówno jebaæ to dwa dni robory i nawet najprostrzeych rzeczy nie
  	//mo¿na implementowac poprost kurwicy dostajê wszyscy coœ robi¹ a ja 
  	//siedzê na d jakims gównemi nie wiem jak to nawet ugry¿æ ca³a praca jak 
  	//krew w piach i nawet w Guitar Hero nie mo¿na by³o zagrac a chocia¿
  	//to chcia³em na otarcie ³ez ale kurwa nie.
}
