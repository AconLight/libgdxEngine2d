package com.redartedgames.libgdxengine2d.lightnings;

import com.badlogic.gdx.graphics.Texture;
import com.redartedgames.libgdxengine2d.gameobject.GameObject;

import java.util.ArrayList;

public class Lightning extends GameObject{

    private float startX;
    private float startY;
    private float endX;
    private float endY;
    private float chargeSize;
    private boolean wasStarted;
    private boolean wasStopped;
    private int animationCounter;
    private int amount;
    private int animationSpeed; //in frames
    private float distance;
    public ArrayList<Charge> charges;

    public Lightning(float startX, float startY, float endX, float endY, GameObject parent, boolean isAttached) {
        super(0,0,parent, isAttached);

        this.startX = startX;
        this.startY = startY;
        this.endX = endX;
        this.endY = endY;
        animationSpeed = 20;
        charges = new ArrayList<>();
        chargeSize = calculateSize();
        animationCounter = 0;
        amount = calculateAmount();
        distance = calculateDistance();
        addCharges();
        for(Charge c : charges) {
            gameObjects.add(c);
            c.setInvisible();
        }
        wasStopped = false;
        wasStarted = true;

        start();
        //Gdx.graphics.getDeltaTime();
    }

    private float calculateDistance() {
        return (float)(Math.sqrt(Math.pow((startX-endX),2)+Math.pow((startY-endY),2)));
    }

    private int calculateAmount() {
        Texture texture = new Texture("graphic/charge/charge.png");
        float f = calculateDistance()/texture.getHeight();
        if(f != (int)f) f+=1;
        return (int)f;
    }

    private float calculateSize() {
        return (int)calculateDistance()/calculateAmount();
    }

    private void render() {
        for(Charge c : charges) {
            addGameObject(c);
        }
    }

    private void addCharges() {
        for(int i = 0; i < amount; i++) {
            float x = startX + (endX-startX)*(amount*2-(i*2+1))/(amount*2);//((((startX-endX)/(float)(2.0*amount))*i*2+1));
            float y = startY + (startY-endY)*(amount*2-(i*2+1))/(amount*2);//((((startY-endY)/(float)(2.0*amount))*i*2+1));
            charges.add(new Charge(x,y,chargeSize,this,true));
        }
    }

    private void start() {
        if(!wasStarted && !wasStopped) {
            wasStarted = true;
            animationCounter = 0;
        }
    }

    private void stop() {
        if(wasStarted && !wasStopped) {
            wasStopped = true;
            wasStarted = false;
            animationCounter = 0;
        }
    }

    @Override
    public void update(float delta) {
        super.update(delta);
        if(wasStarted && !wasStopped) {
            if(animationCounter%animationSpeed == 0 && animationCounter/animationSpeed != amount/2) {
                charges.get(animationCounter/animationSpeed).setVisible();
                charges.get(amount-animationCounter/animationSpeed-1).setVisible();

            }
            animationCounter++;
            if(animationCounter/animationSpeed == amount/2) {
                stop();
            }
        }
    }
}
