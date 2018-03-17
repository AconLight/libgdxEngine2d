package com.redartedgames.libgdxengine2d.lightnings;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.redartedgames.libgdxengine2d.gameobject.GameObject;
import com.redartedgames.libgdxengine2d.smartphones.PowerMedia;

import java.util.ArrayList;

public class Lightning extends GameObject{

    private float startX;
    private float startY;
    private PowerMedia first;
    private PowerMedia second;
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

        this.first = first;
        this.second = second;
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
        addCharges();
        stop();
        //Gdx.graphics.getDeltaTime();
    }

    private float calculateDistance() {
        return (float)(Math.sqrt(Math.pow((startX-endX),2)+Math.pow((startY-endY),2)));
    }

    private int calculateAmount() {
        Texture texture = new Texture("graphic/charge/charge.png");
        float f = calculateDistance()/5;///texture.getHeight();
        if(f != (int)f) f+=1;
        return (int)f;
    }

    private float calculateSize() {
        return (int)calculateDistance()/calculateAmount();
    }

    public PowerMedia getSecond() {
        return second;
    }

    private void addCharges() {
        for(int i = 0; i < amount; i++) {
            float x = startX + (endX-startX)*(amount*2-(i*2+1))/(amount*2);//((((startX-endX)/(float)(2.0*amount))*i*2+1));
            float y = startY + (endY-startY)*(amount*2-(i*2+1))/(amount*2);//((((startY-endY)/(float)(2.0*amount))*i*2+1));
            charges.add(new Charge(x,y,chargeSize,this,true,0,animationSpeed,this,false));
            charges.get(i).setInvisible();
            float f;
            if(i<amount/2) {
                f=(i*2.0f/amount);
            }
            else f=(amount/2.0f-(i-amount/2.0f))/(amount/2.0f);
            charges.get(i).rescale(1+(f)*2);
            addGameObject(charges.get(i));
        }
    }

    private void updateCharges() {
        for(int i = 0; i < amount; i++) {
            startX = first.realPosition.x;
            endX = second.realPosition.x;
            startY = first.realPosition.y;
            endY = second.realPosition.y;
            float x = startX + (endX-startX)*(amount*2-(i*2+1))/(amount*2);//((((startX-endX)/(float)(2.0*amount))*i*2+1));
            float y = startY + (endY-startY)*(amount*2-(i*2+1))/(amount*2);//((((startY-endY)/(float)(2.0*amount))*i*2+1));
            charges.get(i).getMovement().setPosition(new Vector2(x,y));
        }
    }

    public void start() {
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
    }

    @Override
    public void update(float delta) {
        super.update(delta);
        updateCharges();
        for(Charge c : charges) {
            c.update(delta);
        }
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
        if(wasStopped && !wasStarted) {
            for(Charge c : charges) {
                c.stop();
            }
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

    public PowerMedia getFirst() {
        return first;
    }
}
