package com.redartedgames.libgdxengine2d.player;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.redartedgames.libgdxengine2d.assets.HitboxPlayer;
import com.redartedgames.libgdxengine2d.assets.PlayerSprite;
import com.redartedgames.libgdxengine2d.formation.Formation;
import com.redartedgames.libgdxengine2d.formation.MyFormationGenerator;
import com.redartedgames.libgdxengine2d.gameobject.GameObject;
import com.redartedgames.libgdxengine2d.lightnings.Charge;
import com.redartedgames.libgdxengine2d.lightnings.Lightning;
import com.redartedgames.libgdxengine2d.smartphones.SmartphoneBlue;
import com.redartedgames.libgdxengine2d.smartphones.SmartphoneRed;
import com.redartedgames.libgdxengine2d.smartphones.SmartphoneYellow;

public class Player extends GameObject{
	
	public int skill = 0;
	public HitboxPlayer hitboxPlayer;
	Formation formation;
	PlayerSprite sprite;
	public static final int playerV = 1500;
	public static final float playerDrag = 0.9f;
	public ArrayList<SmartphoneRed> smartphonesRed;
	public ArrayList<SmartphoneYellow> smartphonesYellow;
	public ArrayList<SmartphoneBlue> smartphonesBlue;
	public SmartphoneRed sr1, sr2;
	public SmartphoneYellow sy1;
	public SmartphoneBlue sb1, sb2;
	private Vector2 direction;
	ArrayList<GameObject> smartphones;
	private LifeBelt belt;
	public float life;
	
	public Player(float x, float y, GameObject parent, boolean isAttached) {
		super(x, y, parent, isAttached);
		life = 70;
		belt = new LifeBelt(0, 100, this, true);
		belt.pointsOfLife = life;
		
		hitboxPlayer = new HitboxPlayer(0, 0, 50, this, true);
		direction = new Vector2();
		smartphones = new ArrayList<>();
		smartphonesRed = new ArrayList<>();
		smartphonesYellow = new ArrayList<>();
		smartphonesBlue = new ArrayList<>();
		sr1 = new SmartphoneRed(0, 0, this);
		sr2 = new SmartphoneRed(0, 0, this);
		sb1 = new SmartphoneBlue(0, 0, this);
		sb2 = new SmartphoneBlue(0, 0, this);
		sy1 = new SmartphoneYellow(0, 0, this);
		smartphones.add(sb1);
		smartphones.add(sr1);
		smartphones.add(sr2);
		smartphones.add(sy1);
		smartphones.add(sb2);
		
		smartphonesRed.add(sr1);
		smartphonesRed.add(sr2);
		
		smartphonesBlue.add(sb1);
		smartphonesBlue.add(sb2);
		
		smartphonesYellow.add(sy1);

		
		
		sy1.addRed(sr1);
		sy1.addRed(sr2);
		
		collidableObjects.add(this); // just to asure that collide is performed
		

		formation = new Formation(0, 0, smartphones, this, true, new MyFormationGenerator());
		
		gameObjects.addAll(smartphones);
		gameObjects.add(formation);
		
		sprite = new PlayerSprite(0, 0, this, true);
		gameObjects.add(sprite);
		gameObjects.add(belt);
	}
	
	public void updateLast(float delta, float vx, float vy) {
		belt.pointsOfLife = life;
		movement.setG(new Vector2((direction.x + movement.getG().x*29)/30, (direction.y + movement.getG().y*29)/30));
		movement.setVelocity(new Vector2(movement.getVelocity().x*playerDrag, movement.getVelocity().y*playerDrag));
		movement.addG(new Vector2 (0, 100));
		for(GameObject obj: gameObjects) {

			obj.translationAlfa = (float) (Math.toRadians(movement.getG().angle()) + Math.PI/2);
		}
		movement.addG(new Vector2 (0, -100));
		sprite.alfa = (float) (movement.getG().angle() - 90);
	}

	@Override
	public void update(float delta) {
		super.update(delta);
	}

	public void collide(GameObject obj) {
		if (obj == this) {
			formation.collide(obj);
			for(GameObject obj1 :gameObjects) {
				obj1.collide(obj);
			}
		}
		else {
			super.collide(obj);
			hitboxPlayer.collide(obj);
			for(GameObject obj1 :smartphones) {
				//obj1.collide(obj);
			}
		}
		//Gdx.app.log("end", "");
	}
	
	public ArrayList<GameObject> getHitboxes() {
		ArrayList<GameObject> h = new ArrayList<>();
		for(SmartphoneRed s: smartphonesRed) {
			for(Lightning l: s.lightnings ) {
				for(Charge c: l.charges ) {
					h.add(c.chargeSprite.hitboxCharge);
				}
			}
		}
		Gdx.app.log("end", "" + h.size());
		return h;
	}
	
	public void moveVel(int x, int y) {
		if (Math.abs(x) > 0 && Math.abs(y) > 0) {
			direction.add(new Vector2(x/1.47f, y/1.47f));
		}
		else {
			direction.add(new Vector2(x, y));
		}
		
	}
	
	public void startSkill(int i) {
		if (skill == 0) {
			for(SmartphoneRed s: smartphonesRed) {
				s.startSkill(i);
			}
		}
		if (skill == 1) {
			for(SmartphoneBlue s: smartphonesBlue) {
				s.startSkill(i);
			}
		}
		if (skill == 2) {
			for(SmartphoneYellow s: smartphonesYellow) {
				s.startSkill(i);
			}
		}
		skill ++;
		if (skill > 2) skill = 0;
	}

}
