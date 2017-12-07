package com.redartedgames.libgdxengine2d.intro;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.redartedgames.libgdxengine2d.main.SpriteObject;
import com.redartedgames.libgdxengine2d.main.World;

public class IntroWorld extends World{
	float time;
	SpriteObject made, red;
	public IntroWorld(OrthographicCamera cam) {
		super(cam);
		time = 0;
		made = new SpriteObject(0, 0, null, false);
		made.addTexture("graphic/intro/madewithjava.png");
		red = new SpriteObject(0, 0, null, false);
		red.addTexture("graphic/intro/red.png");
		addSpriteObject(made).visibility = 0;
		addSpriteObject(red).visibility = 0;
	}
	
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
	}

}
