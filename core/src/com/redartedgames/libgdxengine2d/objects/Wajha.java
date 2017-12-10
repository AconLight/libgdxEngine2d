package com.redartedgames.libgdxengine2d.objects;

import com.redartedgames.libgdxengine2d.assets.Biurko;
import com.redartedgames.libgdxengine2d.main.GameObject;
import com.redartedgames.libgdxengine2d.main.SpriteObject;

import java.util.ArrayList;
import java.util.Random;

public class Wajha extends GameObject{
    public int x;
    public int y;
    public ArrayList<Biurko> biurka;
    public ArrayList<Connection2> polaczenia;
    private SpriteObject wajhaSprite;

    public Wajha(int x, int y, ArrayList<Biurko> wszystkieBiurka){
        super(0,0,null,false);
        this.x=x;
        this.y=y;
        wajhaSprite = new SpriteObject(x,y,this,true);
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
        addSprite(wajhaSprite);
        wajhaSprite.addTexture("graphic/press.png");
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
