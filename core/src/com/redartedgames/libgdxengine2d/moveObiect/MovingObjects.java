package com.redartedgames.libgdxengine2d.moveObiect;

import com.badlogic.gdx.Gdx;
import com.redartedgames.libgdxengine2d.physics.CollisionHandle;

public class MovingObjects {


    public static CollisionHandle animationUpAndDown(float timeOfMoving) {
        //-t(t-d)*k
        CollisionHandle finalPositionOfObject = new CollisionHandle();
        float timeOfFullAnimacion=50.0f;
        float movingMulitilplier=1.0f;

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
        float timeOfFullAnimacion=10.0f; //d
        float movingMulitilplier=8.0f; //k

        if (timeOfMoving>=timeOfFullAnimacion) {
            finalPositionOfObject.disY=0;
            finalPositionOfObject.disX=0;
        } else {
            finalPositionOfObject.disY = timeOfMoving*timeOfMoving;
            finalPositionOfObject.disX = Math.abs(-timeOfMoving * (timeOfMoving - timeOfFullAnimacion) * movingMulitilplier);
        }

        /*Gdx.app.log("czas:",Float.toString(timeOfMoving));
        Gdx.app.log("X:", Float.toString(finalPositionOfObject.disX));
        Gdx.app.log("Y:",Float.toString(finalPositionOfObject.disY));*/

        return finalPositionOfObject;
    }
}
