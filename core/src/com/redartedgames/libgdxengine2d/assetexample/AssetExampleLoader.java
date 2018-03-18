package com.redartedgames.libgdxengine2d.assetexample;

import java.util.ArrayList;

import com.redartedgames.libgdxengine2d.assets.BoardHolder;
import com.redartedgames.libgdxengine2d.assets.ElectricalElement;
import com.redartedgames.libgdxengine2d.assets.ElectricalElementsHandler;
import com.redartedgames.libgdxengine2d.assets.TeslaTower;
import com.redartedgames.libgdxengine2d.gameobject.GameObject;
import com.redartedgames.libgdxengine2d.player.Player;

public class AssetExampleLoader {
	
	public static Player player1, player2;

	public static ArrayList<GameObject> getObjects() {
		ArrayList<GameObject> gameObjects = new ArrayList<>();
		gameObjects.add(new BoardHolder(0,0,null,false));
		player1 = new Player(-200, -200, null, false, 0, null);
		player2 = new Player(200, -200, null, false, 1, null);
		player1.collidableObjects.addAll(player2.getHitboxes());
		player2.collidableObjects.addAll(player1.getHitboxes());

		gameObjects.add(player1);
		gameObjects.add(player2);
		ElectricalElementsHandler eh = new ElectricalElementsHandler(player1,player2);
		for(GameObject go : eh.elements) {
			gameObjects.add(go);
		}


		return gameObjects;
	}
}
