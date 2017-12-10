package com.redartedgames.libgdxengine2d.gameWorld;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.redartedgames.libgdxengine2d.assets.Biurko;
import com.redartedgames.libgdxengine2d.assets.GuardAnimation;
import com.redartedgames.libgdxengine2d.generation.KafelekWorld;
import com.redartedgames.libgdxengine2d.main.GameObject;
import com.redartedgames.libgdxengine2d.main.GameScreen;
import com.redartedgames.libgdxengine2d.main.World;
import com.redartedgames.libgdxengine2d.objects.Guard;
import com.redartedgames.libgdxengine2d.objects.Kafelek;

public class GameWorld extends World{

	Biurko b;
	Guard g;
	KafelekWorld kafelekWorld;
	
	public GameWorld(OrthographicCamera cam, GameScreen gameScreen) {
		super(cam, gameScreen);
		kafelekWorld = new KafelekWorld(200);
		for (ArrayList<Kafelek> k : kafelekWorld.kafelki) {
			gameObjects.addAll(k);
		}
		//addGameObject(b = new Biurko(0, 0, 0, null, false));
		//addGameObject(g = new Guard(400, 0, null, false));
		//b.collidableObjects.add(g);
		//g.collidableObjects.add(b);
	}
	
	public void update(float delta) {
		super.update(delta);
	}

}
