package com.redartedgames.libgdxengine2d.assets;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.math.Vector2;
import com.redartedgames.libgdxengine2d.effects.Explosion;
import com.redartedgames.libgdxengine2d.gameobject.GameObject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Random;

public class ElectricalElementsHandler {

    private Random random;
    private ArrayList<Vector2> punkty;

    public ArrayList<GameObject> elements;

    public ElectricalElementsHandler() {
        random = new Random();
        elements = new ArrayList<>();
        punkty = new ArrayList<>();
        read();
        addElements();
    }

    public void addElements() {
        for(Vector2 v : punkty) {
            if(random.nextInt(10)==0) {
                elements.add(new ElectricalElement(v.x-1920,v.y-1080,null,false,random.nextInt(6)));
            }
            if(random.nextInt(10)==0) {
                elements.add(new ElectricalElement(1920-v.x,v.y-1080,null,false,random.nextInt(6)));
            }
            if(random.nextInt(10)==0) {
                elements.add(new ElectricalElement(v.x-1920,-v.y+1080,null,false,random.nextInt(6)));
            }
            if(random.nextInt(10)==0) {
                elements.add(new ElectricalElement(-v.x+1920,-v.y+1080,null,false,random.nextInt(6)));
            }
        }
    }

    private void read() {
        try {
            int x,y;
            BufferedReader br = new BufferedReader(new FileReader("dane.txt"));
            for (int i = 0; i < 186/2; i++) {
                x = Integer.parseInt(br.readLine());
                y = Integer.parseInt(br.readLine());
                punkty.add(new Vector2(x,y));
            }
        } catch (Exception e) {
            System.out.println("Błąd w odczycie: " + e.toString());
        }
    }
}
