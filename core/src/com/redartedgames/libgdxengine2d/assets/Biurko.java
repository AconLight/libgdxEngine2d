package com.redartedgames.libgdxengine2d.assets;

import com.badlogic.gdx.Gdx;
import com.redartedgames.libgdxengine2d.main.GameObject;
import com.redartedgames.libgdxengine2d.main.Hitbox;
import com.redartedgames.libgdxengine2d.main.SpriteObject;
import com.redartedgames.libgdxengine2d.objects.Connection;

import java.util.ArrayList;
import java.util.Random;

public class Biurko extends GameObject {
    public SpriteObject biurkoSprite;
    SpriteObject biurko_poswiata;

	private float time=0;
	private float licznik=0;
    public ArrayList<Connection> connections;

    public Biurko (float x, float y, int alfa, GameObject parent,boolean isAttached){
		super(x, y, parent,isAttached);
		Hitbox biurkoHitbox;
		connections = new ArrayList<Connection>();
        //SpriteObject poswiata = new SpriteObject(0,0,null,false);
		switch(alfa){
		case 0:
		biurkoHitbox = new Hitbox(x, y, 200, 100, Hitbox.kinematic);
		setHitbox(biurkoHitbox);
		biurkoSprite = new SpriteObject(0,0,this,true);
		addSprite(biurkoSprite);
		biurkoSprite.addTexture("graphic/biurko/biurko0.png");
		biurko_poswiata = new SpriteObject(0,0,this,true);
		addSprite(biurko_poswiata);
		biurko_poswiata.addTexture("graphic/biurko/biurko_poswiata.png");
		break;
		case 90:
			biurkoHitbox = new Hitbox(x, y, 100, 200, Hitbox.kinematic);
			setHitbox(biurkoHitbox);
			biurkoSprite = new SpriteObject(0,0,this,true);
			addSprite(biurkoSprite);
			biurkoSprite.addTexture("graphic/biurko/biurko90.png");
            biurko_poswiata = new SpriteObject(0,0,this,true);
            addSprite(biurko_poswiata);
            biurko_poswiata.addTexture("graphic/biurko/biurko_poswiata.png");
            biurko_poswiata.alfa=270;
		break;
		case 180:
			biurkoHitbox = new Hitbox(x, y, 200, 100, Hitbox.kinematic);
			setHitbox(biurkoHitbox);
			biurkoSprite = new SpriteObject(0,0,this,true);
			addSprite(biurkoSprite);
			biurkoSprite.addTexture("graphic/biurko/biurko180.png");
            biurko_poswiata = new SpriteObject(0,0,this,true);
            addSprite(biurko_poswiata);
            biurko_poswiata.addTexture("graphic/biurko/biurko_poswiata.png");
            biurko_poswiata.alfa=180;
		break;
		case 270:
			biurkoHitbox = new Hitbox(x, y, 200, 100, Hitbox.kinematic);
			setHitbox(biurkoHitbox);
			biurkoSprite = new SpriteObject(0,0,this,true);
			addSprite(biurkoSprite);
			biurkoSprite.addTexture("graphic/biurko/biurko270.png");
            biurko_poswiata = new SpriteObject(0,0,this,true);
            addSprite(biurko_poswiata);
            biurko_poswiata.addTexture("graphic/biurko/biurko_poswiata.png");
            biurko_poswiata.alfa=90;
		break;
		default:
			biurkoHitbox = new Hitbox(x, y, 200, 100, Hitbox.kinematic);
			setHitbox(biurkoHitbox);
			biurkoSprite = new SpriteObject(0,0,this,true);
			addSprite(biurkoSprite);
			biurkoSprite.addTexture("graphic/biurko/biurko0.png");
            biurko_poswiata = new SpriteObject(0,0,this,true);
            addSprite(biurko_poswiata);
            biurko_poswiata.addTexture("graphic/biurko/biurko_poswiata.png");
		break;
		}
	}

	public void addConnecton(Biurko target){
    	connections.add(new Connection(this,target));
	}

	public void changeConnectionStatus(Biurko target){
    	for(Connection c : connections) {
			if (c.getFinishPosition() == target) ;
				c.changeStatus();
    	}
	}

	public void update(float delta){
        super.update(delta);
        time += delta/2;

        Random generattor = new Random();
        int podzielna = generattor.nextInt(17)+7;

        Random generatttor = new Random();
        float coulor = generatttor.nextFloat();

        Random generattttor = new Random();
        float coulorr = generattttor.nextFloat();

        Random generatttttor = new Random();
        float coulorrr = generatttttor.nextFloat();

        if (licznik%podzielna==0) {
            if (biurko_poswiata.visibility == 0.75f) {
                biurko_poswiata.visibility = 1f;
                biurko_poswiata.R=0;
                biurko_poswiata.G=coulorr;
                biurko_poswiata.B=coulorrr;
            }
            else {
                biurko_poswiata.visibility = 0.75f;
                biurko_poswiata.R=0;
                biurko_poswiata.G=coulorr;
                biurko_poswiata.B=coulorrr;
            }
        }
        //if (time>endTime) biurkoSprite.visibility=0f;
        licznik++;
    }
	public void collide(GameObject obj) {
		super.collide(obj);
		Gdx.app.log("biurko", "hb: " + hitbox.rectangle.x + ", " + hitbox.rectangle.y);
	}
}
