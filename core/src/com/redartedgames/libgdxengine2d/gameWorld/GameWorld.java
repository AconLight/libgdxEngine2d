package com.redartedgames.libgdxengine2d.gameWorld;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.redartedgames.libgdxengine2d.assetexample.AssetExampleLoader;
import com.redartedgames.libgdxengine2d.assets.ElectricalElement;
import com.redartedgames.libgdxengine2d.assets.ElectricalElementsHandler;
import com.redartedgames.libgdxengine2d.effects.Explosion;
import com.redartedgames.libgdxengine2d.gameobject.GameObject;
import com.redartedgames.libgdxengine2d.lightnings.Charge;
import com.redartedgames.libgdxengine2d.lightnings.Lightning;
import com.redartedgames.libgdxengine2d.scene.Screen;
import com.redartedgames.libgdxengine2d.scene.World;
import com.redartedgames.libgdxengine2d.smartphones.PowerMedia;
import com.redartedgames.libgdxengine2d.smartphones.SmartphoneRed;

public class GameWorld extends World{
	private int counter;
	ElectricalElement e;

    public GameWorld(OrthographicCamera cam, Screen gameScreen) {
		super(cam, gameScreen);
		gameObjects.addAll(AssetExampleLoader.getObjects());
		/*Charge c1 = new Charge(-200,350,100,null,false);
		Charge c2 = new Charge(200,350,100,null,false);
		Charge c3 = new Charge(-450,-350,100,null,false);
		Charge c4 = new Charge(450,-350,100,null,false);
		gameObjects.add(c1);
		gameObjects.add(c2);
		gameObjects.add(c3);
		gameObjects.add(c4);*/
		counter = 0;



        PowerMedia p1 = new PowerMedia(450,150,null,false);
        PowerMedia p2 = new PowerMedia(-450,0,null,false);
		addGameObject(p1);
		addGameObject(p2);

		e = new ElectricalElement(0,0,null,false,4);
		addGameObject(e);



		//gameObjects.addAll(AssetExampleLoader.getObjects());
	}
	
	public void update(float delta) {
		super.update(delta);
		counter++;
		if(counter == 1000) e.explode();
			/*

		if(counter == 100) {
		    lightning2.start();
        }
        if(counter == 200) {
		    lightning2.stop();
		    counter = 0;
        }*/

	}

}
