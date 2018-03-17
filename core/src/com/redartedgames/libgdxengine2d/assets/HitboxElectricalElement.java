package com.redartedgames.libgdxengine2d.assets;

import com.redartedgames.libgdxengine2d.gameobject.GameObject;
import com.redartedgames.libgdxengine2d.gameobject.SpriteObject;
import com.redartedgames.libgdxengine2d.physics.ColSpriteObject;
import com.redartedgames.libgdxengine2d.physics.Hitbox;
import com.redartedgames.libgdxengine2d.player.Player;

public class HitboxElectricalElement extends ColSpriteObject {
    public HitboxElectricalElement(float x, float y, int width, int height,GameObject parent, boolean isAttached) {
        super(x, y, parent, 0, isAttached);
        setHitbox(new Hitbox(parent.realPosition.x, parent.realPosition.y, width, height, Hitbox.BehaviorMode.dynamic));
    }

    @Override
    public void updateLast(float delta, float vx, float vy) {
        super.updateLast(delta, vx, vy);
        hitbox.update(parent.realPosition.x, parent.realPosition.y);
    }

    public void collide(GameObject obj) {
        //obj.hitbox.update(obj.parent.parent.realPosition.x, obj.parent.parent.realPosition.y);
        hitbox.update(parent.realPosition.x, parent.realPosition.y);
        c = hitbox.checkCol(obj.getHitbox());
        //Gdx.app.log("Player: " + parent.realPosition, "Obj: " +obj.parent.parent.realPosition);
        if (c.isTrue) {
            //Gdx.app.log("collqq", "hitboxCharge");
            ((ElectricalElement)parent).explode();
        }
        //parent.parent.movement.addCollisionAcc(new Vector2(c.disX, c.disY));

    }
}
