package com.redartedgames.libgdxengine2d.assets;

import com.badlogic.gdx.math.Vector2;
import com.redartedgames.libgdxengine2d.gameobject.GameObject;
import com.redartedgames.libgdxengine2d.gameobject.SpriteObject;
import com.redartedgames.libgdxengine2d.physics.Hitbox;

public class TeslaTowerSprite extends SpriteObject {

    private Hitbox hitboxxxx;

    public TeslaTowerSprite(float x, float y, GameObject parent, boolean isAttached) {
        super(x, y, parent, isAttached);
        for(int i = 0; i < 8;i++){
            addTexture("graphic/tesla_animacja/Tesla_animacja_"+i+".png");
        }
        setIsPingpong(true);
        visibility=1;
        hitboxxxx = new Hitbox(x,y,95, Hitbox.BehaviorMode.kinematic);

    }

    @Override
    public void updateLast(float delta, float vx, float vy) {
        super.updateLast(delta,vx,vy);
        hitboxxxx.update(parent.movement.getPosition().x,parent.movement.getPosition().y);
    }

    public void collide(GameObject obj) {
        c = hitboxxxx.checkCol(obj.getHitbox());
        if (c.isTrue)
            parent.movement.addCollisionAcc(new Vector2(c.disX, c.disY));


    }
}
