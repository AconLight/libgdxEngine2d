package com.redartedgames.libgdxengine2d.assets;

import com.badlogic.gdx.math.Vector2;
import com.redartedgames.libgdxengine2d.gameobject.GameObject;
import com.redartedgames.libgdxengine2d.player.Player;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Random;

public class ElectricalElementsHandler {

    private Random random;
    private ArrayList<Vector2> punkty;

    public ArrayList<GameObject> elements;

    public ElectricalElementsHandler(Player player1, Player player2) {
        random = new Random();
        elements = new ArrayList<>();
        punkty = new ArrayList<>();
        read();
        addElements(player1, player2);
    }

    private void addElements(Player player1, Player player2) {
        int bound = 5;
        for(Vector2 v : punkty) {
            if(random.nextInt(bound)==0) {
                elements.add(new ElectricalElement(v.x-1920,v.y-1080,null,false,random.nextInt(6)));
                elements.get(elements.size()-1).collidableObjects.addAll(player1.getHitboxes());
                elements.get(elements.size()-1).collidableObjects.addAll(player2.getHitboxes());
            }
            if(random.nextInt(bound)==0) {
                elements.add(new ElectricalElement(1920-v.x,v.y-1080,null,false,random.nextInt(6)));
                elements.get(elements.size()-1).collidableObjects.addAll(player1.getHitboxes());
                elements.get(elements.size()-1).collidableObjects.addAll(player2.getHitboxes());
            }
            if(random.nextInt(bound)==0) {
                elements.add(new ElectricalElement(v.x-1920,-v.y+1080,null,false,random.nextInt(6)));
                elements.get(elements.size()-1).collidableObjects.addAll(player1.getHitboxes());
                elements.get(elements.size()-1).collidableObjects.addAll(player2.getHitboxes());
            }
            if(random.nextInt(bound)==0) {
                elements.add(new ElectricalElement(-v.x+1920,-v.y+1080,null,false,random.nextInt(6)));
                elements.get(elements.size()-1).collidableObjects.addAll(player1.getHitboxes());
                elements.get(elements.size()-1).collidableObjects.addAll(player2.getHitboxes());
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
