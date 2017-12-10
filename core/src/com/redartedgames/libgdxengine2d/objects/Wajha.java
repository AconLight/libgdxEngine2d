package com.redartedgames.libgdxengine2d.objects;

import com.redartedgames.libgdxengine2d.assets.Biurko;

import java.util.ArrayList;
import java.util.Random;

public class Wajha {
    public int x;
    public int y;
    public ArrayList<Biurko> biurka;
    public ArrayList<Connection2> polaczenia;

    public Wajha(int x, int y, ArrayList<Biurko> wszystkieBiurka){
        this.x=x;
        this.y=y;
        biurka = new ArrayList<Biurko>();
        polaczenia = new ArrayList<Connection2>();
        for(Biurko b : wszystkieBiurka){
            if(Math.abs(b.getMovement().getPosition().x-x)<2000 &&
                    Math.abs(b.getMovement().getPosition().y-y)<2000){
                biurka.add(b);
            }
        }
        for(Biurko b : biurka){
            polaczenia.add(new Connection2(this,b));
        }
    }

    public void press(){ polaczenia.size();
        for(Connection2 c : polaczenia){
            c.setInactive();
            int bound = polaczenia.size()/3;
            if(bound < 3) bound = 3;
            if(new Random().nextInt(bound)==0)
                c.changeStatus();
        }
    }
}
