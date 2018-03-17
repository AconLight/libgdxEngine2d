package com.redartedgames.libgdxengine2d.lightnings;

import com.badlogic.gdx.graphics.Texture;
import com.redartedgames.libgdxengine2d.gameobject.GameObject;
import com.redartedgames.libgdxengine2d.smartphones.PowerMedia;

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
    private ArrayList<Charge> charges;

    public Lightning(PowerMedia first, PowerMedia second, GameObject parent, boolean isAttached) {
        super(0,0,parent, isAttached);

        this.startX = first.movement.getPosition().x;
        this.startY = first.movement.getPosition().y;
        this.endX = second.movement.getPosition().x;
        this.endY = second.movement.getPosition().y;
        animationSpeed = 3;
        charges = new ArrayList<>();
        chargeSize = calculateSize();
        animationCounter = 0;
        amount = calculateAmount();
        wasStopped = false;
        wasStarted = false;
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

    private void addCharges() {
        for(int i = 0; i < amount; i++) {
            float x = startX + (endX-startX)*(amount*2-(i*2+1))/(amount*2);//((((startX-endX)/(float)(2.0*amount))*i*2+1));
            float y = startY + (endY-startY)*(amount*2-(i*2+1))/(amount*2);//((((startY-endY)/(float)(2.0*amount))*i*2+1));
            charges.add(new Charge(x,y,chargeSize,this,true,0,animationSpeed,this,false));
            charges.get(i).setInvisible();
            addGameObject(charges.get(i));
        }
    }

    public void start() {
        addCharges();
        if(!wasStarted) {
            wasStopped = false;
            wasStarted = true;
            animationCounter = 0;
        }
    }

    public void stop() {
        if(wasStarted && !wasStopped) {
            wasStopped = true;
            wasStarted = false;
            animationCounter = 0;
        }
        charges.clear();
        gameObjects.clear();
    }

    @Override
    public void update(float delta) {
        super.update(delta);
        if(wasStarted && !wasStopped) {
            if(amount%2==1 && animationCounter/animationSpeed==amount/2) {
                charges.get(amount/2).setVisible();
                charges.get(amount/2).start();
            }
            else if(animationCounter%animationSpeed == 0 && animationCounter/animationSpeed < amount/2) {
                charges.get(animationCounter/animationSpeed).setVisible();
                charges.get(animationCounter/animationSpeed).start();
                charges.get(amount-animationCounter/animationSpeed-1).setVisible();
                charges.get(amount-animationCounter/animationSpeed-1).start();
            }
            animationCounter++;
        }
    }

    public float getStartX() {
        return startX;
    }

    public float getStartY() {
        return startY;
    }

    public float getEndX() {
        return endX;
    }

    public float getEndY() {
        return endY;
    }
}
