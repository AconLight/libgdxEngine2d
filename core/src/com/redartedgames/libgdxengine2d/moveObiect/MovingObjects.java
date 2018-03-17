package com.redartedgames.libgdxengine2d.moveObiect;

import com.badlogic.gdx.Gdx;
import com.redartedgames.libgdxengine2d.physics.CollisionHandle;

public class MovingObjects {
    private static float timeOfFullAnimacion;
    private static float movingMulitilplier;

    public static CollisionHandle animationUpAndDown(float timeOfMoving) {
        //-t(t-d)*k
        CollisionHandle finalPositionOfObject = new CollisionHandle();
        timeOfFullAnimacion=5.0f;
        movingMulitilplier=1.0f;

        finalPositionOfObject.disX=0;
        if (timeOfMoving>=timeOfFullAnimacion) {
            finalPositionOfObject.disY=0;
        } else {
            finalPositionOfObject.disY = Math.abs(-timeOfMoving * (timeOfMoving - timeOfFullAnimacion) * movingMulitilplier);
        }

        return finalPositionOfObject;

    }

    public static CollisionHandle animationCurve(float timeOfMoving) {
        CollisionHandle finalPositionOfObject = new CollisionHandle();
        //t(t-d)*k
        timeOfFullAnimacion=5.0f; //d
        movingMulitilplier=1.0f; //k

        if (timeOfMoving>=timeOfFullAnimacion) {
            finalPositionOfObject.disY=0;
            finalPositionOfObject.disX=0;
        } else {
            finalPositionOfObject.disX = timeOfMoving;
            finalPositionOfObject.disY = Math.abs(-timeOfMoving * (timeOfMoving - timeOfFullAnimacion) * movingMulitilplier);
        }

        /*Gdx.app.log("czas:",Float.toString(timeOfMoving));
        Gdx.app.log("X:", Float.toString(finalPositionOfObject.disX));
        Gdx.app.log("Y:",Float.toString(finalPositionOfObject.disY));*/

        return finalPositionOfObject;
    }
}
