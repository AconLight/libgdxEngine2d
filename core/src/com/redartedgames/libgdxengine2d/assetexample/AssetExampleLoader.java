package com.redartedgames.libgdxengine2d.assetexample;

import java.util.ArrayList;

import com.badlogic.gdx.math.Vector2;
import com.redartedgames.libgdxengine2d.gameobject.GameObject;

public class AssetExampleLoader {
	
	
	public static ArrayList<GameObject> getObjects() {
		ArrayList<GameObject> gameObjects = new ArrayList<>();
		AssetExample e1 = new AssetExample(-180, -180);
		AssetExample e2 = new AssetExample(180, 180);
		e1.movement.setVelocity(new Vector2(40, 40));
		e2.movement.setVelocity(new Vector2(-30, -30));
		e1.addCollidable(e2.head.hitbox1);
		e2.addCollidable(e1.head.hitbox1);
		gameObjects.add(e1);
		gameObjects.add(e2);
		return gameObjects;
	}
}
