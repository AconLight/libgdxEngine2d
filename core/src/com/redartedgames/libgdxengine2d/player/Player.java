package com.redartedgames.libgdxengine2d.player;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.redartedgames.libgdxengine2d.assets.HitboxPlayer;
import com.redartedgames.libgdxengine2d.assets.PlayerSprite;
import com.redartedgames.libgdxengine2d.formation.Formation;
import com.redartedgames.libgdxengine2d.formation.MyFormationGenerator;
import com.redartedgames.libgdxengine2d.gameWorld.GameScreen;
import com.redartedgames.libgdxengine2d.gameobject.GameObject;
import com.redartedgames.libgdxengine2d.lightnings.Charge;
import com.redartedgames.libgdxengine2d.lightnings.Lightning;
import com.redartedgames.libgdxengine2d.scene.Screen;
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
	public ArrayList<SmartphoneRed> smartphonesYellow;
	public ArrayList<SmartphoneRed> smartphonesBlue;
	public ArrayList<SmartphoneRed> current;
	public SmartphoneRed sr1, sr2;
	public SmartphoneRed sy1;
	public SmartphoneRed sb1, sb2;
	private Vector2 direction;
	ArrayList<GameObject> smartphones;
	private LifeBelt belt;
	public float life;
	float t1 = 0, t2 = 0, t3 = 0; 
	public Screen scr;
	
	public Player(float x, float y, GameObject parent, boolean isAttached, int type, Screen gameScreen) {
		super(x, y, parent, isAttached);
		this.scr = gameScreen;
		life = 100;
		t1 = 0; t2 = 0; t3 = 0;
		belt = new LifeBelt(0, 100, this, true);
		belt.pointsOfLife = life;
		
		hitboxPlayer = new HitboxPlayer(0, 0, 50, this, true);
		direction = new Vector2();
		smartphones = new ArrayList<>();
		smartphonesRed = new ArrayList<>();
		smartphonesYellow = new ArrayList<>();
		smartphonesBlue = new ArrayList<>();
		sr1 = new SmartphoneRed(0, 0, this, 0);
		sb1 = new SmartphoneRed(0, 0, this, 1);
		sy1 = new SmartphoneRed(0, 0, this, 2);
		sb2 = new SmartphoneRed(0, 0, this, 1);
		sr2 = new SmartphoneRed(0, 0, this, 0);
		smartphones.add(sr1);
		smartphones.add(sb1);
		smartphones.add(sy1);
		smartphones.add(sb2);
		smartphones.add(sr2);
		
		smartphonesRed.add(sr1);
		smartphonesRed.add(sr2);
		
		smartphonesBlue.add(sb1);
		smartphonesBlue.add(sb2);
		
		smartphonesYellow.add(sy1);

		
		
		collidableObjects.add(this); // just to asure that collide is performed
		

		formation = new Formation(0, 0, smartphones, this, true, new MyFormationGenerator());
		
		gameObjects.addAll(smartphones);
		gameObjects.add(formation);
		
		sprite = new PlayerSprite(0, 0, this, true, type);
		gameObjects.add(sprite);
		gameObjects.add(belt);
	}
	
	public void updateLast(float delta, float vx, float vy) {
		super.updateLast(delta, vx, vy);
		if (movement.getPosition().x > 1920)
			movement.getPosition().x = 1920;
			
		if (movement.getPosition().y > 1080)
			movement.getPosition().y = 1080;
		
		if (movement.getPosition().x < -1920)
			movement.getPosition().x = -1920;
			
		if (movement.getPosition().y < -1080)
			movement.getPosition().y = -1080;
		
		t1 += delta;
		t2 += delta;
		t3 += delta;
		belt.pointsOfLife = life;
		movement.setG(new Vector2((direction.x + movement.getG().x*29)/30, (direction.y + movement.getG().y*29)/30));
		movement.setVelocity(new Vector2(movement.getVelocity().x*playerDrag, movement.getVelocity().y*playerDrag));
		movement.addG(new Vector2 (0, 100));
		for(GameObject obj: gameObjects) {

			obj.translationAlfa = (float) (Math.toRadians(movement.getG().angle()) + Math.PI/2);
		}
		//translationAlfa = (float) (Math.toRadians(movement.getG().angle()) + Math.PI/2);;
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
		for(SmartphoneRed s: smartphonesBlue) {
			for(Lightning l: s.lightnings ) {
				for(Charge c: l.charges ) {
					h.add(c.chargeSprite.hitboxCharge);
				}
			}
		}
		for(SmartphoneRed s: smartphonesYellow) {
			for(Lightning l: s.lightnings ) {
				for(Charge c: l.charges ) {
					h.add(c.chargeSprite.hitboxCharge);
				}
			}
		}
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
			if(i == 0) {
				if (t1 > 4) {
					current = smartphonesRed;
					t1 = 0;
				}
				else {return;}
			}
			if(i == 1) {
				if (t2 > 4) {
					current = smartphonesYellow;
					t2 = 0;
				}else {return;}
			}
			if(i == 2) {
				if (t3 > 4) {
					current = smartphonesBlue;
					t3 = 0;
				}else {return;}
			}
		}
		if (skill == 1) {
			for(SmartphoneRed s: current) {
				s.startSkill1(i);
			}
		}
		if (skill == 2) {
			for(SmartphoneRed s: current) {
				s.startSkill2(i);
			}
		}
		skill ++;
		if (skill > 2) {
			skill = 0;
		}
	}
	
	public void render(SpriteBatch batch, int priority, float dx, float dy, float visibility) {
		if (life > 0) {
		realPosition.set(movement.getPosition().x, movement.getPosition().y);
		for(int i=0; i<gameObjects.size();i++)
			if (isAttached) gameObjects.get(i).render(batch, priority, dx + getTranslatedX(), dy + getTranslatedY(), visibility);
			else gameObjects.get(i).render(batch, priority, getTranslatedX(), getTranslatedY(), visibility);
		}
	}
	
	public void render(ShapeRenderer batch, int priority, float dx, float dy, float visibility) {
		if (life > 0) {
		for(int i=0; i<gameObjects.size();i++)
			if (isAttached) gameObjects.get(i).render(batch, priority, dx + movement.getPosition().x, dy + movement.getPosition().y, visibility);
			else gameObjects.get(i).render(batch, priority, movement.getPosition().x, movement.getPosition().y, visibility);
		}
	}

}
