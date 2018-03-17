package com.redartedgames.libgdxengine2d.moveObiect;

import com.badlogic.gdx.Gdx;
import com.redartedgames.libgdxengine2d.physics.CollisionHandle;

public class MovingObjects {
    private static float disx=0;
    private static float disy=0;

    public static CollisionHandle animationUpAndDown(float timeOfMoving) {
        //-t(t-d)*k
        CollisionHandle finalPositionOfObject = new CollisionHandle();
        float timeOfFullAnimacion=15.0f;
        float movingMulitilplier=5.0f;

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
        float movingMulitilplier=2.0f; //k
        if (timeOfMoving>timeOfFullAnimacion && timeOfMoving<1.5*timeOfFullAnimacion) {
            finalPositionOfObject.disY= disy-Math.abs(-timeOfMoving * (timeOfMoving - timeOfFullAnimacion) * movingMulitilplier);
            finalPositionOfObject.disX=0;
        } else if (timeOfMoving>=1.5*timeOfFullAnimacion) {
            finalPositionOfObject.disX=0;
            finalPositionOfObject.disY=0;
        } else {
                disy = timeOfMoving * timeOfMoving;
                disx = Math.abs(-timeOfMoving * (timeOfMoving - timeOfFullAnimacion) * movingMulitilplier);
                finalPositionOfObject.disX=disx;
                finalPositionOfObject.disY=disy;
            }


        /*Gdx.app.log("czas:",Float.toString(timeOfMoving));
        Gdx.app.log("X:", Float.toString(finalPositionOfObject.disX));
        Gdx.app.log("Y:",Float.toString(finalPositionOfObject.disY));*/

        return finalPositionOfObject;
    }

    public static CollisionHandle animationTangens(float timeOfMoving) {
        CollisionHandle finalPositionOfObject = new CollisionHandle();

        float timeOfFullAnimacion=10.5f; //d
        float movingMulitilplier=10.1f; //k

        if (timeOfMoving>timeOfFullAnimacion && timeOfMoving<1.1*timeOfFullAnimacion) {
            finalPositionOfObject.disY=disy-Math.abs(-timeOfMoving * (timeOfMoving - timeOfFullAnimacion) * movingMulitilplier);
            finalPositionOfObject.disX=0;
        } else if (timeOfMoving>=1.1*timeOfFullAnimacion) {
            finalPositionOfObject.disX=0;
            finalPositionOfObject.disY=0;
        } else {
            disy = timeOfMoving*movingMulitilplier;
            disx = (float)Math.sin((double)timeOfMoving)*movingMulitilplier*2;
            finalPositionOfObject.disX=disx;
            finalPositionOfObject.disY=disy;
        }
        return finalPositionOfObject;
    }
}
