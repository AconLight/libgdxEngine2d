package com.redartedgames.libgdxengine2d.assetexample;

import java.util.ArrayList;

import com.badlogic.gdx.math.Vector2;
import com.redartedgames.libgdxengine2d.assets.BoardHolder;
import com.redartedgames.libgdxengine2d.assets.TeslaTower;
import com.redartedgames.libgdxengine2d.formation.Formation;
import com.redartedgames.libgdxengine2d.formation.MyFormationGenerator;
import com.redartedgames.libgdxengine2d.gameobject.GameObject;
import com.redartedgames.libgdxengine2d.player.Player;
import com.redartedgames.libgdxengine2d.smartphones.SmartphoneBlue;
import com.redartedgames.libgdxengine2d.smartphones.SmartphoneRed;
import com.redartedgames.libgdxengine2d.smartphones.SmartphoneYellow;

public class AssetExampleLoader {
	
	public static Player player1, player2;
	public static TeslaTower tesla;
	public static ArrayList<GameObject> getObjects() {
		ArrayList<GameObject> gameObjects = new ArrayList<>();
		gameObjects.add(new BoardHolder(0,0,null,false));
		tesla = new TeslaTower(-400,-300);
		player1 = new Player(-200, -200, null, false);
		player2 = new Player(200, -200, null, false);

		gameObjects.add(player1);
		gameObjects.add(player2);
		gameObjects.add(tesla);
		

		return gameObjects;
	}
}
