package com.redartedgames.libgdxengine2d.moveObiect;

import com.redartedgames.libgdxengine2d.physics.CollisionHandle;

public class MovingObjects {
    private static float timeOfFullAnimacion;
    private static float movingMulitilplier;

    public static CollisionHandle animationPosition(float timeOfMoving) {
        CollisionHandle finalPositionOfObject = new CollisionHandle();
        timeOfFullAnimacion=5.0f;
        movingMulitilplier=1.0f;

        finalPositionOfObject.disX=0;
        if (timeOfMoving>timeOfFullAnimacion) {
            finalPositionOfObject.disY=0;
        } else {
            finalPositionOfObject.disY = Math.abs(-timeOfMoving * (timeOfMoving - timeOfFullAnimacion) * movingMulitilplier);
        }


        return finalPositionOfObject;



    }
}
