package com.redartedgames.libgdxengine2d.intro;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.redartedgames.libgdxengine2d.gameobject.SpriteObject;
import com.redartedgames.libgdxengine2d.scene.Screen;
import com.redartedgames.libgdxengine2d.scene.World;

public class IntroWorld extends World{
	float time;
	float speed = 2;
	SpriteObject made, red, title;
	public IntroWorld(OrthographicCamera cam, Screen gameScreen) {
		super(cam, gameScreen);
		time = 0;
		made = new SpriteObject(0, 0, null, false);
		made.addTexture("graphic/intro/madewithjava.png");
		red = new SpriteObject(0, 0, null, false);
		red.addTexture("graphic/intro/red.png");
		title = new SpriteObject(0,0,null,false);
		title.addTexture("graphic/intro/newTitle.png");
		addSpriteObject(made).visibility = 0;
		addSpriteObject(red).visibility = 0;
		addSpriteObject(title).visibility = 0;
		
	}
	int i = 0;
	public void update(float delta) {
		super.update(delta);
		time += delta*speed;
		
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
		if (time > 7 && time <= 8) {
			made.visibility = 1;
		}
		
		if (time > 8 && time <= 9) {
			made.visibility = 1 - (time-8)*(time-8);
		}
		if (time > 11 && time <= 12) {
			made.visibility = 0;
			title.visibility = (time-11)*(time-11);
		}
		
		if(time > 13 && time <= 14){
			title.visibility = 1 - (time-13)*(time-13);
		}
		if(time > 14) {
			title.visibility = 0;
			changeScreen();
		}
		
	}

	public void changeScreen(){
		gameScreen.window.game.presentationNext();
	}
	
}
