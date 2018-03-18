package com.redartedgames.libgdxengine2d.text;

import java.util.ArrayList;
import java.util.Random;

import com.redartedgames.libgdxengine2d.gameobject.GameObject;


public class RandomizeRandomText {

    public ArrayList<String> teksty;
    private String wynik;
    private HitText texxxt;

    public RandomizeRandomText(){
        teksty = new ArrayList<>();
        teksty.add("NullPointerException");
        teksty.add("Syntax error");
        teksty.add("Segmentation fault");
        teksty.add("; Missing");
    }

    public String getRandomTekst (){
        Random generator = new Random();
        int var = generator.nextInt(4);
        return teksty.get(var);
    }

    public HitText migoconcyTekst (float x, float y, GameObject parent, float endTime, float visibility){
        Random generator  = new Random();
        int type = generator.nextInt(4);
        switch (type){
            case 0:
                texxxt = new HitText(x-100,y+100,parent,true,-1,teksty.get(0),visibility,endTime);
                break;
            case 1:
                texxxt = new HitText(x-170,y-35,parent,true,-1,teksty.get(1),visibility,endTime);
                break;
            case 2:
                texxxt = new HitText(x+60,y,parent,true,-1,teksty.get(2),visibility,endTime);
                break;
            case 3:
                texxxt = new HitText(x-150,y-15,parent,true,-1,teksty.get(3),visibility,endTime);
                break;
            default:
                texxxt = new HitText(x-120,y+120,parent,true,-1,teksty.get(0),visibility,endTime);
                break;
        }

        return texxxt;//HitTekst
    }
}
