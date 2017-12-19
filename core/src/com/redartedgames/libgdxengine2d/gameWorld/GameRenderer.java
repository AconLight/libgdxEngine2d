package com.redartedgames.libgdxengine2d.gameWorld;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.redartedgames.libgdxengine2d.main.GameObject;
import com.redartedgames.libgdxengine2d.main.GameScreen;

import java.util.ArrayList;

public class GameRenderer {
    private int chunkSize = 500;
    private int height, width;
    private OrthographicCamera cam;
    private GameScreen gameScreen;
    private ArrayList<ArrayList<ArrayList<ArrayList<GameObject>>>> all;
    private ArrayList<ArrayList<ArrayList<GameObject>>> xdyd;
    private ArrayList<ArrayList<ArrayList<GameObject>>> xdyu;
    private ArrayList<ArrayList<ArrayList<GameObject>>> xuyd;
    private ArrayList<ArrayList<ArrayList<GameObject>>> xuyu;

    public GameRenderer(OrthographicCamera cam, GameScreen gameScreen, int height, int width){
        this.cam = cam;
        this.gameScreen = gameScreen;
        this.height = height;
        this.width = width;
        all = new ArrayList<ArrayList<ArrayList<ArrayList<GameObject>>>>();
        xdyd = new ArrayList<ArrayList<ArrayList<GameObject>>>();
        xdyu = new ArrayList<ArrayList<ArrayList<GameObject>>>();
        xuyd = new ArrayList<ArrayList<ArrayList<GameObject>>>();
        xuyu = new ArrayList<ArrayList<ArrayList<GameObject>>>();
        all.add(xdyd);
        all.add(xdyu);
        all.add(xuyd);
        all.add(xuyu);
    }

    public GameObject addGameObject(GameObject obj){
        expandList(obj);
        if(obj.getMovement().getPosition().x>=0){
            if(obj.getMovement().getPosition().y>=0)
                xdyd.get(chunkPositionX(obj)).get(chunkPositionY(obj)).add(obj);
            else
                xdyu.get(chunkPositionX(obj)).get(chunkPositionY(obj)).add(obj);
        }
        else {
            if(obj.getMovement().getPosition().y>=0)
                xuyd.get(chunkPositionX(obj)).get(chunkPositionY(obj)).add(obj);
            else
                xuyu.get(chunkPositionX(obj)).get(chunkPositionY(obj)).add(obj);
        }
        return obj;
    }

    private int chunkPositionX(GameObject obj){
        return (int)(Math.abs(obj.getMovement().getPosition().x))/chunkSize;
    }

    private int chunkPositionY(GameObject obj){
        return (int)(Math.abs(obj.getMovement().getPosition().y))/chunkSize;
    }

    private void expandList(GameObject obj){
        if(obj.getMovement().getPosition().x>=0){
            if(obj.getMovement().getPosition().y>=0)
                expandSingleList(xdyd,obj);
            else
                expandSingleList(xdyu,obj);
        }
        else {
            if(obj.getMovement().getPosition().y>=0)
                expandSingleList(xuyd,obj);
            else
                expandSingleList(xuyu,obj);
        }
    }

    private void expandSingleList(ArrayList<ArrayList<ArrayList<GameObject>>> direction, GameObject obj){
        for(int i=direction.size(); i <= chunkPositionX(obj)+100; i++) {
            direction.add(new ArrayList<ArrayList<GameObject>>());
            for (int j = direction.size(); j <= chunkPositionY(obj)+100; j++)
                direction.get(i).add(new ArrayList<GameObject>());
        }
    }

    public GameObject updateIndividual(GameObject obj, float desiredX, float desiredY){
        if(obj.getMovement().getPosition().x>=0){
            if(obj.getMovement().getPosition().y>=0)
                xdyd.get(chunkPositionX(obj)).get(chunkPositionY(obj)).remove(obj);
            else
                xdyu.get(chunkPositionX(obj)).get(chunkPositionY(obj)).remove(obj);
        }
        else {
            if(obj.getMovement().getPosition().y>=0)
                xuyd.get(chunkPositionX(obj)).get(chunkPositionY(obj)).remove(obj);
            else
                xuyu.get(chunkPositionX(obj)).get(chunkPositionY(obj)).remove(obj);
        }
        obj.getMovement().setPosition(new Vector2(desiredX,desiredY));
        addGameObject(obj);
        return obj;
    }

    public void render(SpriteBatch batch, float visibility){
        //cam.update();
        //batch.setProjectionMatrix(cam.combined);

        for(int i=0; i<=(Math.abs((width)/chunkSize)+1); i++)
            for(int j=0; j<=(Math.abs((height)/chunkSize)+1); j++)
                for(GameObject obj : xdyd.get(i+(int)(Math.abs(cam.position.x-width/2)/chunkSize)).get(j+(int)(Math.abs(cam.position.y-height/2)/chunkSize)))
                    obj.render(batch, 1, 0, 0, visibility);
        /*
        for(int i=0; i<=(Math.abs((width)/chunkSize)); i++)
            for(int j=0; j<=(Math.abs((height)/chunkSize)); j++)
                for(GameObject obj : xdyd.get(i+(int)(cam.position.x/chunkSize)).get(j+(int)cam.position.y/chunkSize))
                    obj.render(batch, 1, 0, 0, visibility);
        */

        for(int i=0; i<=(Math.abs((width)/chunkSize)); i++)
            for(int j=0; j<=(Math.abs((height)/chunkSize)); j++)
                for(GameObject obj : xdyu.get(i+(int)(cam.position.x/chunkSize)).get(j+(int)(cam.position.y/chunkSize)))
                    obj.render(batch, 1, 0, 0, visibility);

        for(int i=0; i<=(Math.abs((width)/chunkSize)); i++)
            for(int j=0; j<=(Math.abs((height)/chunkSize)); j++)
                for(GameObject obj : xuyd.get(i+(int)(cam.position.x/chunkSize)).get(j+(int)(cam.position.y/chunkSize)))
                    obj.render(batch, 1, 0, 0, visibility);

        for(int i=0; i<=(Math.abs((width)/chunkSize)); i++)
            for(int j=0; j<=(Math.abs((height)/chunkSize)); j++)
                for(GameObject obj : xuyu.get(i+(int)(cam.position.x/chunkSize)+2).get(j+(int)(cam.position.y/chunkSize)))
                    obj.render(batch, 1, 0, 0, visibility);
    }
}
