package com.redartedgames.libgdxengine2d.intro;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.redartedgames.libgdxengine2d.main.GameScreen;
import com.redartedgames.libgdxengine2d.main.SpriteObject;
import com.redartedgames.libgdxengine2d.main.World;

public class IntroWorld extends World{
	float time;
	SpriteObject made, red, title;
	public IntroWorld(OrthographicCamera cam, GameScreen gameScreen) {
		super(cam, gameScreen);
		time = 0;
		made = new SpriteObject(0, 0, null, false);
		made.addTexture("graphic/intro/madewithjava.png");
		red = new SpriteObject(0, 0, null, false);
		red.addTexture("graphic/intro/red.png");
		title = new SpriteObject(0, 0, null, false);
		title.addTexture("graphic/intro/title.png");
		addSpriteObject(title).visibility = 0;
		addSpriteObject(made).visibility = 0;
		addSpriteObject(red).visibility = 0;
		
	}
	int i = 0;
	public void update(float delta) {
		super.update(delta);
		time += delta/2;
		
		if (time > 8 && time <= 10 && i < 20) { 
			i++;
			time = 9.8f;
			gameScreen.screenShaker.shakePosition(10);
			gameScreen.screenShaker.shakeAlfa(10);
			gameScreen.screenShaker.shakeDeep(10);
		}
		if (time > 9) {
			title.visibility = 1f;
		}
		else if (time > 8 && time <= 9) {
			made.visibility = 0f;
			title.visibility = (time-8)*(time-8);
		}
		else if (time > 7 && time <= 8) {
			made.visibility = 1 - (time-7)*(time-7);
		}
		else if (time > 7) {
			made.visibility = 1f;
		}
		else if (time > 6 && time <= 7) {
			red.visibility = 0f;
			made.visibility = (time-6)*(time-6);
		}
		else if (time > 5 && time <= 6) {
			red.visibility = 1 - (time-5)*(time-5);
		}
		else if (time > 3 && time <= 5) {
			red.visibility = 1f;
		}
		else if (time > 2 && time <= 3) {
			red.visibility = (time-2)*(time-2);
		}
		
		
		
		
		
		
		
		
	
		
		
	}

}
