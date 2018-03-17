package com.redartedgames.libgdxengine2d.assetexample;

import java.util.ArrayList;

import com.redartedgames.libgdxengine2d.assets.BoardHolder;
import com.redartedgames.libgdxengine2d.assets.TeslaTower;
import com.redartedgames.libgdxengine2d.gameobject.GameObject;
import com.redartedgames.libgdxengine2d.player.Player;

public class AssetExampleLoader {
	
	public static Player player1, player2;
	public static TeslaTower tesla;
	public static ArrayList<GameObject> getObjects() {
		ArrayList<GameObject> gameObjects = new ArrayList<>();
		gameObjects.add(new BoardHolder(0,0,null,false));
		tesla = new TeslaTower(-400,-300);
		player1 = new Player(-200, -200, null, false);
		player2 = new Player(200, -200, null, false);
		player1.collidableObjects.add(player2.hitboxPlayer);
		player2.collidableObjects.add(player1.hitboxPlayer);

		gameObjects.add(player1);
		gameObjects.add(player2);
		gameObjects.add(tesla);
		

		return gameObjects;
	}
}
