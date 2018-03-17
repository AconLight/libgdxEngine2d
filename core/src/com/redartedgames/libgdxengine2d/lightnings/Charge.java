package com.redartedgames.libgdxengine2d.lightnings;

import com.badlogic.gdx.graphics.Texture;
import com.redartedgames.libgdxengine2d.gameobject.GameObject;
import com.redartedgames.libgdxengine2d.gameobject.SpriteObject;

import java.awt.geom.AffineTransform;
import java.util.ArrayList;
import java.util.Random;

public class Charge extends GameObject {

    private float x;
    private float y;
    private float size;
    private int level;
    private boolean wasStarted;
    private boolean wasStopped;
    private boolean isAbove;
    private int animationCounter;
    private int animationSpeed;
    private SpriteObject chargeSprite;
    private ArrayList<Charge> childCharges;
    private Random random = new Random();
    private Lightning lightning;

    public Charge(float x, float y, float size, GameObject parent, boolean isAttached) {
        super(x,y,parent,isAttached);
        this.x = x;
        this.y = y;
        this.size = size;
        wasStarted = false;
        wasStopped = false;
        animationCounter = 0;
        chargeSprite = new SpriteObject(0,0,this,true);
        addSprite(chargeSprite);
        Texture texture = new Texture("graphic/charge/charge.png");
        scale(chargeSprite,texture);
        chargeSprite.addTexture(texture);
    }

    public Charge(float x, float y, float size, GameObject parent, boolean isAttached, int level, int speed, Lightning lightning, boolean isAbove) {
        super(x,y,parent,isAttached);
        this.x = x;
        this.y = y;
        this.size = size;
        this.level = level;
        wasStarted = false;
        wasStopped = false;
        this.isAbove = isAbove;
        this.lightning = lightning;
        animationCounter = 0;
        animationSpeed = speed+1;
        chargeSprite = new SpriteObject(0,0,this,true);
        addSprite(chargeSprite);
        Texture texture = new Texture("graphic/charge/charge.png");
        scale(chargeSprite,texture);
        chargeSprite.addTexture(texture);
        chargeSprite.visibility = 1;
        childCharges = new ArrayList<>();
        if(level < 2) {
            addChildren();
        }
    }

    public void start() {
        if(!wasStarted && !wasStopped) {
            wasStarted = true;
            animationCounter = 1;
        }
    }

    public void stop() {
        if(wasStarted && !wasStopped) {
            wasStopped = true;
            wasStarted = false;
            animationCounter = 0;
        }
    }

    private float countChildX(int i, int bound) {
        int diff = 40;
        float angle = (float) Math.toDegrees(Math.atan2(lightning.getEndX() - lightning.getStartX(), lightning.getEndY() - lightning.getStartY()));
        if(angle < 0){
            angle += 360;
        }
        double[] pt = {size/3*2, 0};
        AffineTransform.getRotateInstance(Math.toRadians(-angle-diff*i+diff*(bound-1)/2), 0, 0)
                .transform(pt, 0, pt, 0, 1);
        return (float)pt[0];
    }

    private float countChildY(int i, int bound) {
        int diff = 40;
        float angle = (float) Math.toDegrees(Math.atan2(lightning.getEndX() - lightning.getStartX(), lightning.getEndY() - lightning.getStartY()));
        if(angle < 0){
            angle += 360;
        }
        double[] pt = {size/3*2, 0};
        AffineTransform.getRotateInstance(Math.toRadians(-angle-diff*i+diff*(bound-1)/2), 0, 0)
                .transform(pt, 0, pt, 0, 1);
        return (float)pt[1];
    }

    private void addChildren() {
        int bound = random.nextInt(3)+1;
        for(int i = 0; i < bound; i++) {
            if(level==0) {
                childCharges.add(new Charge(countChildX(i, bound), countChildY(i, bound), size / 2, this, true, level + 1, animationSpeed, lightning, false));
                childCharges.get(i*2).setInvisible();
                addGameObject(childCharges.get(i*2));
                childCharges.add(new Charge(-countChildX(i, bound), -countChildY(i, bound), size / 2, this, true, level + 1, animationSpeed, lightning,true));
                childCharges.get(i*2+1).setInvisible();
                addGameObject(childCharges.get(i*2+1));
            }
            else if(!isAbove) {
                childCharges.add(new Charge(countChildX(i, bound), countChildY(i, bound), size / 2, this, true, level + 1, animationSpeed, lightning, false));
                childCharges.get(i).setInvisible();
                addGameObject(childCharges.get(i));
            }
            else if(isAbove) {
                childCharges.add(new Charge(-countChildX(i, bound), -countChildY(i, bound), size / 2, this, true, level + 1, animationSpeed, lightning,true));
                childCharges.get(i).setInvisible();
                addGameObject(childCharges.get(i));
            }
        }
    }

    private void scale(SpriteObject s, Texture t) {
        float scale = size/t.getHeight();
        s.sclX = scale;
        s.sclY = scale;
    }

    protected void setInvisible() {
        chargeSprite.visibility = 0;
    }

    protected void setVisible() {
        chargeSprite.visibility = 1;
    }

    @Override
    public void update(float delta) {
        super.update(delta);
        if(wasStarted && !wasStopped) {
            if(animationCounter%animationSpeed == 0) {
                for(Charge c : childCharges) {
                    c.setVisible();
                    c.start();
                }
                stop();
            }
            animationCounter++;
        }
    }
}
