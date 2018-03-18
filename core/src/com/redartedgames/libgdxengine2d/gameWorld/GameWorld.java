package com.redartedgames.libgdxengine2d.gameWorld;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.redartedgames.libgdxengine2d.assetexample.AssetExampleLoader;
import com.redartedgames.libgdxengine2d.assets.BoardHolder;
import com.redartedgames.libgdxengine2d.assets.ElectricalElement;
import com.redartedgames.libgdxengine2d.assets.ElectricalElementsHandler;
import com.redartedgames.libgdxengine2d.assets.TeslaTower;
import com.redartedgames.libgdxengine2d.effects.Explosion;
import com.redartedgames.libgdxengine2d.gameobject.GameObject;
import com.redartedgames.libgdxengine2d.gameobject.SpriteObject;
import com.redartedgames.libgdxengine2d.lightnings.Charge;
import com.redartedgames.libgdxengine2d.lightnings.Lightning;
import com.redartedgames.libgdxengine2d.player.Player;
import com.redartedgames.libgdxengine2d.scene.Screen;
import com.redartedgames.libgdxengine2d.scene.World;
import com.redartedgames.libgdxengine2d.smartphones.PowerMedia;
import com.redartedgames.libgdxengine2d.smartphones.SmartphoneRed;

public class GameWorld extends World{

	public static Player player1, player2;
	public static TeslaTower tesla;
	boolean isReady;
	
	private void load() {
		isReady = true;
		gameObjects.add(new BoardHolder(0,0,null,false));
		tesla = new TeslaTower(-400,-300);
		player1 = new Player(-200, -200, null, false, 0, gameScreen);
		player2 = new Player(200, -200, null, false, 1, gameScreen);
		player1.collidableObjects.addAll(player2.getHitboxes());
		player2.collidableObjects.addAll(player1.getHitboxes());

		gameObjects.add(player1);
		gameObjects.add(player2);
		gameObjects.add(tesla);
		ElectricalElementsHandler eh = new ElectricalElementsHandler(player1,player2);
		for(GameObject go : eh.elements) {
			gameObjects.add(go);
		}

        ElectricalElement EE = new ElectricalElement(100,100,null,false,0);
        gameObjects.add(EE);
	}
    public GameWorld(OrthographicCamera cam, Screen gameScreen) {
		super(cam, gameScreen);
		//gameObjects.addAll(AssetExampleLoader.getObjects());
		load();

	}
	
	public void update(float delta) {
		super.update(delta);
		
		
		float x2 = player1.movement.getPosition().x;
		float y2 = player1.movement.getPosition().y;
		float x =player2.movement.getPosition().x;
		float y = player2.movement.getPosition().y;
		
		float d = x*x + y*y;
		float d2 = x2*x2 + y2*y2;
		d = (float) Math.sqrt(d);
		d2 = (float) Math.sqrt(d2);
		if (d < d2) d = d2;
		
		float a = 1 + d/700;
		if (a < 1) a = 1; 
		if (a > 2.1f) a = 2.1f;
		gameScreen.zoom = a;
		
		if (isReady) {
			Gdx.app.log("life ",  "" + player2.life);
			if (player1.life <= 0) {
				Gdx.app.log("cleared ",  "" );
				gameObjects.clear();
				gameScreen.zoom = 1;
				addSpriteObject(new SpriteObject(0, 0, null, false)).
					addTexture("graphic/splashscreen/redWins.png");
				isReady = false;
			}
			else if (player2.life <= 0) {
				gameObjects.clear();
				Gdx.app.log("cleared ",  "" );
				gameScreen.zoom = 1;
				addSpriteObject(new SpriteObject(0, 0, null, false)).
					addTexture("graphic/splashscreen/blueWins.png");
				isReady = false;
			}
			
		}

	}

}
