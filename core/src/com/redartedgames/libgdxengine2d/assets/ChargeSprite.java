package com.redartedgames.libgdxengine2d.assets;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.redartedgames.libgdxengine2d.gameobject.GameObject;
import com.redartedgames.libgdxengine2d.gameobject.SpriteObject;

import java.util.Random;

public class ChargeSprite extends SpriteObject {
	public HitboxCharge hitboxCharge;
    public ChargeSprite(float x, float y, GameObject parent, boolean isAttached) {
        super(x, y, parent, isAttached);
        Random random = new Random();
        hitboxCharge = new HitboxCharge(0, 0, 50, this, isAttached);
        addGameObject(hitboxCharge);
        int los = random.nextInt(7);
        for(int i = 0; i < 7;i++){
            addTexture("graphic/charge/Charge_animation/Charge_animation_"+(i+los)%7+".png");
        }
        setFrameTime(0.05f);
    }
    
    public void render(SpriteBatch batch, int priority, float dx, float dy, float visibility) {
    	hitboxCharge.hitbox.update(dx + movement.getPosition().x, dy + movement.getPosition().y);
    	super.render(batch, priority, dx, dy, visibility);
    }
    
    public void collide(GameObject obj) {
    	super.collide(obj);
    	hitboxCharge.collide(obj);
    }

    @Override
    public void updateLast(float delta, float vx, float vy) {
        super.updateLast(delta, vx, vy);
    }
}
