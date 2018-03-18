package com.redartedgames.libgdxengine2d.gameWorld;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
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
import com.redartedgames.libgdxengine2d.scene.ScreenShaker;
import com.redartedgames.libgdxengine2d.scene.World;
import com.redartedgames.libgdxengine2d.smartphones.PowerMedia;
import com.redartedgames.libgdxengine2d.smartphones.SmartphoneRed;

public class GameWorld extends World{

	public static Player player1, player2;
	//public static TeslaTower tesla;
	boolean isReady;
	SpriteObject o;
	public static Music soundTrack = Gdx.audio.newMusic(Gdx.files.internal("audio/soundtrack/sound.mp3"));
	
	public void restart() {
		player1.movement.setPosition(new Vector2(-300, -200));
		player2.movement.setPosition(new Vector2(300, -200));
		player1.life = 100;
		player2.life = 100;
		gameObjects.remove(o);
		gameObjects.remove(player1);
		gameObjects.remove(player2);
		gameObjects.add(player1);
		gameObjects.add(player2);
		isReady = true;

	}
	
	void load() {
		gameObjects.clear();
		isReady = true;
		gameObjects.add(new BoardHolder(0,0,null,false));
		player1 = new Player(-300, -200, null, false, 0, gameScreen);
		player2 = new Player(300, -200, null, false, 1, gameScreen);

		player1.collidableObjects.addAll(player2.getHitboxes());
		player2.collidableObjects.addAll(player1.getHitboxes());
		gameObjects.add(player1);
		gameObjects.add(player2);
		gameScreen.screenShaker = new ScreenShaker(new Vector3(0.92f, 0.92f, 0.92f), 500, 20);
		gameScreen.updateCam();
        soundTrack.setLooping(true);
        //soundTrack.play();
		
	}
    public GameWorld(OrthographicCamera cam, Screen gameScreen) {
		super(cam, gameScreen);
		//gameObjects.addAll(AssetExampleLoader.getObjects());
		load();
		


		ElectricalElementsHandler eh = new ElectricalElementsHandler(player1,player2);
		for(GameObject go : eh.elements) {
			gameObjects.add(go);
		}

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
				player2.life = 0;
				//gameScreen.zoom = 1;
				o = new SpriteObject(0, 0, null, false);
				o.addTexture("graphic/splashscreen/blueWins.png").sclX = 1.57f;
				o.sclY = 1.57f;
				addGameObject(o);
				gameObjects.remove(player1);
				gameObjects.remove(player2);
				isReady = false;
			}
			else if (player2.life <= 0) {
				Gdx.app.log("cleared ",  "" );
				//gameScreen.zoom = 1;
				player1.life = 0;
				o = new SpriteObject(0, 0, null, false);
					o.addTexture("graphic/splashscreen/redWins.png").sclX = 1.57f;
					o.sclY = 1.57f;
					addGameObject(o);
					gameObjects.remove(player1);
					gameObjects.remove(player2);
				isReady = false;
			}
			
		}

	}

}
