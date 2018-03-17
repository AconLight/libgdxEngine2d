package com.redartedgames.libgdxengine2d.assetexample;

import java.util.ArrayList;

import com.badlogic.gdx.math.Vector2;
import com.redartedgames.libgdxengine2d.formation.Formation;
import com.redartedgames.libgdxengine2d.formation.MyFormationGenerator;
import com.redartedgames.libgdxengine2d.gameobject.GameObject;
import com.redartedgames.libgdxengine2d.smartphones.SmartphoneBlue;
import com.redartedgames.libgdxengine2d.smartphones.SmartphoneRed;
import com.redartedgames.libgdxengine2d.smartphones.SmartphoneYellow;

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
		
		ArrayList<GameObject> objects = new ArrayList<>();
		
		objects.add(new SmartphoneBlue(-180, -180, null));
		objects.add(new SmartphoneRed(-180, -180, null));
		objects.add(new SmartphoneRed(-180, -180, null));
		objects.add(new SmartphoneBlue(-180, -180, null));
		objects.add(new SmartphoneYellow(-180, -180, null));
		
		((SmartphoneYellow)objects.get(4)).addRed((SmartphoneRed) objects.get(1));
		((SmartphoneYellow)objects.get(4)).addRed((SmartphoneRed) objects.get(2));
		
	
		

		Formation formation = new Formation(-200, -200, objects, null, new MyFormationGenerator());
		gameObjects.addAll(objects);
		gameObjects.add(formation);
		return gameObjects;
	}
}
