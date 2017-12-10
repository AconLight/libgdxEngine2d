package com.redartedgames.libgdxengine2d.intro;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector2;
import com.redartedgames.libgdxengine2d.assets.Biurko;
import com.redartedgames.libgdxengine2d.assets.GuardAnimation;
import com.redartedgames.libgdxengine2d.main.GameScreen;
import com.redartedgames.libgdxengine2d.main.SpriteObject;
import com.redartedgames.libgdxengine2d.main.World;
import com.redartedgames.libgdxengine2d.objects.Guard;

public class IntroWorld extends World{
	float time;
	SpriteObject made, red;
	Biurko b,b2;
	Guard g;
	public IntroWorld(OrthographicCamera cam, GameScreen gameScreen) {
		super(cam, gameScreen);
		time = 0;
		made = new SpriteObject(0, 0, null, false);
		made.addTexture("graphic/intro/madewithjava.png");
		red = new SpriteObject(0, 0, null, false);
		red.addTexture("graphic/intro/red.png");
		addSpriteObject(made).visibility = 0;
		addSpriteObject(red).visibility = 0;
		addGameObject(b = new Biurko(0, 0, 0, null, false, null));
		addGameObject(b2 = new Biurko(600, 0, 0, null, false, null));
		addGameObject(g = new Guard(400, 0, null, false, 0));
		b.collidableObjects.add(g);
		g.collidableObjects.add(b);
		g.collidableObjects.add(b2);
		
	}
	int i = 0;
	public void update(float delta) {
		super.update(delta);
		time += delta/2;
		
			
		
		if (time > 2 && time <= 3) {
			red.visibility = (time-2)*(time-2);
			
		}
		if (time > 3 && time <= 5) {
			red.visibility = 1f;
		}
		
		if (time > 5 && time <= 6) {
			red.visibility = 1 - (time-5)*(time-5);
		}
		if (time > 6 && time <= 7) {
			red.visibility = 0f;
			made.visibility = (time-6)*(time-6);
		}
		if (time > 7) {
			made.visibility = 1;
		}
		
		if (time > 8 && time <= 9 && i < 20) { 
			i++;
			time = 7.8f;
			gameScreen.screenShaker.shakePosition(10);
			gameScreen.screenShaker.shakeAlfa(10);
			gameScreen.screenShaker.shakeDeep(10);
		}
	}

}
