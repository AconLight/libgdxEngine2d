package com.redartedgames.libgdxengine2d.intro;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector2;
import com.redartedgames.libgdxengine2d.assets.Biurko;
import com.redartedgames.libgdxengine2d.assets.GuardAnimation;
import com.redartedgames.libgdxengine2d.assets.Menu;
import com.redartedgames.libgdxengine2d.main.GameObject;
import com.redartedgames.libgdxengine2d.main.GameScreen;
import com.redartedgames.libgdxengine2d.main.SpriteObject;
import com.redartedgames.libgdxengine2d.main.World;
import com.redartedgames.libgdxengine2d.objects.Guard;

public class IntroWorld extends World{
	float time;
	SpriteObject made, red;
	Menu menu;
	Biurko b,b2;
	Guard g;
	public IntroWorld(OrthographicCamera cam, GameScreen gameScreen) {
		super(cam, gameScreen);
		time = 0;
		menu = new Menu(0, 0, null, false);
		made = new SpriteObject(0, 0, null, false);
		made.addTexture("graphic/intro/madewithjava.png");
		red = new SpriteObject(0, 0, null, false);
		red.addTexture("graphic/intro/red.png");
		addSpriteObject(made).visibility = 0;
		addSpriteObject(red).visibility = 0;
	//	addGameObject(b = new Biurko(0, 0, 0, null, false));
		//addGameObject(b2 = new Biurko(600, 0, 0, null, false));
	//	addGameObject(g = new Guard(400, 0, null, false));
		addGameObject(menu);
		menu.isOnMenu(false);
		//b.collidableObjects.add(g);
		//g.collidableObjects.add(b);
	//	g.collidableObjects.add(b2);
		
		//g = new SoundGlitch();
		
	}
	int i = 0;
	public void update(float delta) {
		super.update(delta);
		time += delta/2;
		
		if(menu.isMenuEnd())
			changeScreen();
		
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
		if(time > 8){
			made.visibility = 0;
			menu.setMenuVisi(1);
			menu.isOnMenu(true);
		}
		
		
		if (time > 3 && time <= 7 && i < 20) { 
			i++;
			//time = 7.8f;
			gameScreen.screenShaker.shakePosition(10);
			gameScreen.screenShaker.shakeAlfa(10);
			gameScreen.screenShaker.shakeDeep(10);
		}
	}

	public void changeScreen(){
		gameScreen.window.game.startGame();
	}
	
}
