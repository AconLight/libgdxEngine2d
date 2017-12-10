package com.redartedgames.libgdxengine2d.utilities;

import com.redartedgames.libgdxengine2d.main.GameObject;
import com.redartedgames.libgdxengine2d.assets.Automat;

import java.util.ArrayList;
import java.util.Random;


public class RandomizeRandomTextToAutomat {

    public ArrayList<String> teksty;
    private String wynik;
    private HitText texxxt;

    public RandomizeRandomTextToAutomat(){
        teksty = new ArrayList<>();
        teksty.add("NullPointerException");
        teksty.add("dupa do not refer to any variable");
        teksty.add("Out of range");
        teksty.add("Syntax error");
        teksty.add("segmantation fault");
        teksty.add("; Missing");
        //teksty.add("");
    }

    public String getRandomTekst (){
        Random generator = new Random();
        int var = generator.nextInt(6);
        return teksty.get(var);
    }

    public HitText migoconcyTekst (float x, float y, GameObject parent, float endTime, float visibility){
        Random generator  = new Random();
        int type = generator.nextInt(6);
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
            case 4:
                texxxt = new HitText(x+50,y+60,parent,true,-1,teksty.get(4),visibility,endTime);
                break;
            case 5:
                texxxt = new HitText(x-140,y+60,parent,true,-1,teksty.get(5),visibility,endTime);
                break;
            default:
                texxxt = new HitText(x-120,y+120,parent,true,-1,teksty.get(0),visibility,endTime);
                break;
        }

        return texxxt;//HitTekst
    }
}
