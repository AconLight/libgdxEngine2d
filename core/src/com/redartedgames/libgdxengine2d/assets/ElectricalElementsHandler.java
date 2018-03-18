package com.redartedgames.libgdxengine2d.assets;

import com.badlogic.gdx.math.Vector2;
import com.redartedgames.libgdxengine2d.gameobject.GameObject;
import com.redartedgames.libgdxengine2d.player.Player;

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
                elements.add(new ElectricalElement(v.x-1920,v.y-1080,null,false,random.nextInt(7)));
                elements.get(elements.size()-1).collidableObjects.addAll(player1.getHitboxes());
                elements.get(elements.size()-1).collidableObjects.addAll(player2.getHitboxes());
            }
            if(random.nextInt(bound)==0) {
                elements.add(new ElectricalElement(1920-v.x,v.y-1080,null,false,random.nextInt(7)));
                elements.get(elements.size()-1).collidableObjects.addAll(player1.getHitboxes());
                elements.get(elements.size()-1).collidableObjects.addAll(player2.getHitboxes());
            }
            if(random.nextInt(bound)==0) {
                elements.add(new ElectricalElement(v.x-1920,-v.y+1080,null,false,random.nextInt(7)));
                elements.get(elements.size()-1).collidableObjects.addAll(player1.getHitboxes());
                elements.get(elements.size()-1).collidableObjects.addAll(player2.getHitboxes());
            }
            if(random.nextInt(bound)==0) {
                elements.add(new ElectricalElement(-v.x+1920,-v.y+1080,null,false,random.nextInt(7)));
                elements.get(elements.size()-1).collidableObjects.addAll(player1.getHitboxes());
                elements.get(elements.size()-1).collidableObjects.addAll(player2.getHitboxes());
            }
        }
    }

    private void read() {
    	String s[] = new String[500];
    	int j = 0;
    			s[j] = "36" ; j++; 
    			s[j] = "120" ; j++; 
    			s[j] = "118" ; j++; 
    			s[j] = "70" ; j++; 
    			s[j] = "146" ; j++; 
    			s[j] = "122" ; j++; 
    			s[j] = "201" ; j++; 
    			s[j] = "122" ; j++; 
    			s[j] = "242" ; j++; 
    			s[j] = "124" ; j++; 
    			s[j] = "238" ; j++; 
    			s[j] = "174" ; j++; 
    			s[j] = "90" ; j++; 
    			s[j] = "266" ; j++; 
    			s[j] = "196" ; j++; 
    			s[j] = "279" ; j++; 
    			s[j] = "249" ; j++; 
    			s[j] = "278" ; j++; 
    			s[j] = "362" ; j++; 
    			s[j] = "278" ; j++; 
    			s[j] = "306" ; j++; 
    			s[j] = "278" ; j++; 
    			s[j] = "415" ; j++; 
    			s[j] = "279" ; j++; 
    			s[j] = "348" ; j++; 
    			s[j] = "420" ; j++; 
    			s[j] = "348" ; j++; 
    			s[j] = "486" ; j++; 
    			s[j] = "136" ; j++; 
    			s[j] = "550" ; j++; 
    			s[j] = "116" ; j++; 
    			s[j] = "878" ; j++; 
    			s[j] = "790" ; j++; 
    			s[j] = "123" ; j++; 
    			s[j] = "884" ; j++; 
    			s[j] = "70" ; j++; 
    			s[j] = "1114" ; j++; 
    			s[j] = "82" ; j++; 
    			s[j] = "884" ; j++; 
    			s[j] = "348" ; j++; 
    			s[j] = "1020" ; j++; 
    			s[j] = "110" ; j++; 
    			s[j] = "885" ; j++; 
    			s[j] = "225" ; j++; 
    			s[j] = "575" ; j++; 
    			s[j] = "225" ; j++; 
    			s[j] = "520" ; j++; 
    			s[j] = "122" ; j++; 
    			s[j] = "885" ; j++; 
    			s[j] = "956" ; j++; 
    			s[j] = "590" ; j++; 
    			s[j] = "526" ; j++; 
    			s[j] = "590" ; j++; 
    			s[j] = "588" ; j++; 
    			s[j] = "657" ; j++; 
    			s[j] = "582" ; j++; 
    			s[j] = "482" ; j++; 
    			s[j] = "618" ; j++; 
    			s[j] = "350" ; j++; 
    			s[j] = "768" ; j++; 
    			s[j] = "708" ; j++; 
    			s[j] = "640" ; j++; 
    			s[j] = "642" ; j++; 
    			s[j] = "640" ; j++; 
    			s[j] = "546" ; j++; 
    			s[j] = "840" ; j++; 
    			s[j] = "483" ; j++; 
    			s[j] = "825" ; j++; 
    			s[j] = "546"; j++; 
    			s[j] = "898" ; j++; 
    			s[j] = "600" ; j++; 
    			s[j] = "956" ; j++; 
    			s[j] = "550" ; j++; 
    			s[j] = "950" ; j++; 
    			s[j] = "350" ; j++; 
    			s[j] = "875" ; j++; 
    			s[j] = "183" ; j++; 
    			s[j] = "880" ; j++; 
    			s[j] = "184" ; j++; 
    			s[j] = "1005" ; j++; 
    			s[j] = "330" ; j++; 
    			s[j] = "957" ; j++; 
    			s[j] = "1236" ; j++; 
    			s[j] = "147" ; j++; 
    			s[j] = "1167" ; j++; 
    			s[j] = "202" ; j++; 
    			s[j] = "1220" ; j++; 
    			s[j] = "236" ; j++; 
    			s[j] = "1320" ; j++; 
    			s[j] = "270" ; j++; 
    			s[j] = "1154" ; j++; 
    			s[j] = "290" ; j++; 
    			s[j] = "1086" ; j++; 
    			s[j] = "261" ; j++; 
    			s[j] = "1314" ; j++; 
    			s[j] = "318" ; j++; 
    			s[j] = "1221" ; j++; 
    			s[j] = "444" ; j++; 
    			s[j] = "1300" ; j++; 
    			s[j] = "512" ; j++; 
    			s[j] = "1220" ; j++; 
    			s[j] = "537" ; j++; 
    			s[j] = "1302" ; j++; 
    			s[j] = "666" ; j++; 
    			s[j] = "1262" ; j++; 
    			s[j] = "704" ; j++; 
    			s[j] = "1125" ; j++; 
    			s[j] = "747" ; j++; 
    			s[j] = "1065" ; j++; 
    			s[j] = "747" ; j++; 
    			s[j] = "1006" ; j++; 
    			s[j] = "747" ; j++; 
    			s[j] = "885" ; j++; 
    			s[j] = "844" ; j++; 
    			s[j] = "1262" ; j++; 
    			s[j] = "915" ; j++; 
    			s[j] = "1330" ; j++; 
    			s[j] = "956" ; j++; 
    			s[j] = "1200" ; j++; 
    			s[j] = "956" ; j++; 
    			s[j] = "1126" ; j++; 
    			s[j] = "954" ; j++; 
    			s[j] = "1056" ; j++; 
    			s[j] = "954" ; j++; 
    			s[j] = "884" ; j++; 
    			s[j] = "902" ; j++; 
    			s[j] = "1020" ; j++; 
    			s[j] = "1010" ; j++; 
    			s[j] = "1287" ; j++; 
    			s[j] = "1006" ; j++; 
    			s[j] = "1234" ; j++; 
    			s[j] = "1005" ; j++; 
    			s[j] = "1408" ; j++; 
    			s[j] = "914" ; j++; 
    			s[j] = "1450" ; j++; 
    			s[j] = "150" ; j++; 
    			s[j] = "1450" ; j++; 
    			s[j] = "213" ; j++; 
    			s[j] = "1581" ; j++; 
    			s[j] = "189" ; j++; 
    			s[j] = "1587" ; j++; 
    			s[j] = "126" ; j++; 
    			s[j] = "1789" ; j++; 
    			s[j] = "189" ; j++; 
    			s[j] = "1789" ; j++; 
    			s[j] = "122" ; j++; 
    			s[j] = "1800" ; j++; 
    			s[j] = "69" ; j++; 
    			s[j] = "1800" ; j++; 
    			s[j] = "250" ; j++; 
    			s[j] = "1800" ; j++; 
    			s[j] = "315" ; j++; 
    			s[j] = "1500" ; j++; 
    			s[j] = "450" ; j++; 
    			s[j] = "1466" ; j++; 
    			s[j] = "510" ; j++; 
    			s[j] = "1641" ; j++; 
    			s[j] = "590" ; j++; 
    			s[j] = "1770" ; j++; 
    			s[j] = "592" ; j++; 
    			s[j] = "1458" ; j++; 
    			s[j] = "672" ; j++; 
    			s[j] = "1810" ; j++; 
    			s[j] = "645" ; j++; 
    			s[j] = "1814" ; j++; 
    			s[j] = "693" ; j++; 
    			s[j] = "1720" ; j++; 
    			s[j] = "774" ; j++; 
    			s[j] = "1684" ; j++; 
    			s[j] = "866" ; j++; 
    			s[j] = "1720" ; j++; 
    			s[j] = "906" ; j++; 
    			s[j] = "1460" ; j++; 
    			s[j] = "956" ; j++; 
    			s[j] = "1600" ; j++; 
    			s[j] = "1010" ; j++; 
    			s[j] = "885" ; j++; 
    			s[j] = "1150" ; j++; 
    			s[j] = "885" ; j++; 
    			s[j] = "1100" ; j++; 
    			s[j] = "1500" ; j++; 
    			s[j] = "267" ; j++; 
    			s[j] = "1450" ; j++; 
    			s[j] = "360" ; j++; 
    			s[j] = "760" ; j++; 
    			s[j] = "1325";
    	
       
            int x,y;
            //BufferedReader br = new BufferedReader(new FileReader("dane.txt"));
            for (int i = 0; i < 186; i++) {
                x = Integer.parseInt(s[i]);
                y = Integer.parseInt(s[++i]);
                punkty.add(new Vector2(x,y));
            }
        
    }
}
