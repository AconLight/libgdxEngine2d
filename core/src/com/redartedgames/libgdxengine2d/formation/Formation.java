package com.redartedgames.libgdxengine2d.formation;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.math.Vector2;
import com.redartedgames.libgdxengine2d.assetexample.AssetExampleSpriteHead;
import com.redartedgames.libgdxengine2d.gameobject.GameObject;

public class Formation extends GameObject{
	float k = 100f;
	float drag = 0.8f;
	ArrayList<GameObject> objects;
	ArrayList<Vector2> positions;
	FormationGenerator generator;
	
	public Formation(float x, float y, ArrayList<GameObject> objects, GameObject parent, FormationGenerator generator) {
		super(x, y, parent, false);
		addSprite(new AssetExampleSpriteHead(0, 0, this, true));
		positions = generator.generate(objects.size());
		this.objects = objects;
		collidableObjects.add(this); // just to asure that collide is performed
	}
	
	public void updateLast(float delta, float vx, float vy) {
		super.updateLast(delta, vx, vy);

	}
	
	public void collide(GameObject obj) {
		Gdx.app.log("collide Formation", "");
		super.collide(obj);
		for (int i = 0; i < objects.size(); i++) {
			objects.get(i).movement.addCollisionAcc(new Vector2(k*(movement.getPosition().x + positions.get(i).x - objects.get(i).movement.getPosition().x), 
			k*(movement.getPosition().y + positions.get(i).y - objects.get(i).movement.getPosition().y)));
			objects.get(i).movement.setVelocity(new Vector2(objects.get(i).movement.getVelocity().x*drag,
					objects.get(i).movement.getVelocity().y*drag));
		}
		
		
		
	}

	
}
