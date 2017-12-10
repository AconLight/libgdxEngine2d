package com.redartedgames.libgdxengine2d.gameWorld;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.redartedgames.libgdxengine2d.assets.Biurko;
import com.redartedgames.libgdxengine2d.assets.GuardAnimation;
import com.redartedgames.libgdxengine2d.generation.KafelekWorld;
import com.redartedgames.libgdxengine2d.main.GameObject;
import com.redartedgames.libgdxengine2d.main.GameScreen;
import com.redartedgames.libgdxengine2d.main.World;
import com.redartedgames.libgdxengine2d.objects.Guard;
import com.redartedgames.libgdxengine2d.objects.Kafelek;
import com.redartedgames.libgdxengine2d.objects.Wall;

import javax.swing.plaf.ViewportUI;

public class GameWorld extends World{

	ArrayList<Biurko> biurka;

	Biurko b;
	Guard g;
	KafelekWorld kafelekWorld;
	Wall wall;
	public Vector2 camVel;
	
	public GameWorld(OrthographicCamera cam, GameScreen gameScreen) {
		super(cam, gameScreen);
		camVel = new Vector2(0, 0);
		biurka = new ArrayList<Biurko>();
		gameScreen.camPosition.x = 1000;
		gameScreen.camPosition.y = 1000;
		kafelekWorld = new KafelekWorld(80);
		wall = new Wall(0, 0, null, false, null, kafelekWorld);
		
		for (int i = 0; i < wall.plansza.size(); i++) {
			for (int j = 0; j < wall.plansza.get(i).size(); j++) {
				for (int l = 0; l < wall.plansza.get(i).get(j).size(); l++) {
					addGameObject(wall.plansza.get(i).get(j).get(l));
				}
			}
		}
		
		for (int i = 0; i < kafelekWorld.biurka.size(); i++) {
			Biurko btest = new Biurko(kafelekWorld.biurka.get(i).x*100, kafelekWorld.biurka.get(i).y*100, kafelekWorld.biurka.get(i).alfa_biurko, null, false, kafelekWorld.biurka.get(i).guard);
			for(Biurko b : biurka){
				if(Math.abs(b.getMovement().getPosition().x-btest.getMovement().getPosition().x)<1000 &&
						Math.abs(b.getMovement().getPosition().y-btest.getMovement().getPosition().y)<1000){
					b.addConnecton(btest);
					btest.addConnecton(b);
				}
			}
			biurka.add(btest);
			addGameObject(biurka.get(biurka.size()-1));
		}
		for (int i = 0; i < kafelekWorld.origins.size(); i++) {
			addGameObject(new Biurko(kafelekWorld.origins.get(i).x*100, kafelekWorld.origins.get(i).y*100, 180, null, false, null));
		}
		//addGameObject(b = new Biurko(0, 0, 0, null, false));
		//addGameObject(g = new Guard(400, 0, null, false));
		//b.collidableObjects.add(g);
		//g.collidableObjects.add(b);
	}
	
	public void update(float delta) {
		super.update(delta);
		gameScreen.camPosition.x += camVel.x*delta;
		gameScreen.camPosition.y += camVel.y*delta;
	}

}
