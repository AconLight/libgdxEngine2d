package com.redartedgames.libgdxengine2d.gameWorld;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.redartedgames.libgdxengine2d.generation.KafelekWorld;
import com.redartedgames.libgdxengine2d.main.GameScreen;
import com.redartedgames.libgdxengine2d.main.World;
import com.redartedgames.libgdxengine2d.objects.Kafelek;

public class GameWorld extends World{

	KafelekWorld kafelekWorld;
	
	public GameWorld(OrthographicCamera cam, GameScreen gameScreen) {
		super(cam, gameScreen);
		kafelekWorld = new KafelekWorld(10);
		// TODO Auto-generated constructor stub
		for (ArrayList<Kafelek> k : kafelekWorld.kafelki) {
			gameObjects.addAll(k);
		}
	}

}
