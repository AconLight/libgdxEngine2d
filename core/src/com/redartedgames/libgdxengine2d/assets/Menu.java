package com.redartedgames.libgdxengine2d.assets;

import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.redartedgames.libgdxengine2d.main.GameObject;
import com.redartedgames.libgdxengine2d.main.SpriteObject;
import com.redartedgames.libgdxengine2d.sound.MySound;
import com.redartedgames.libgdxengine2d.sound.SoundGlitch;

public class Menu extends GameObject{
	
	private SpriteObject menuGlitch, menu;
	private SoundGlitch g;
	private Random rand;
	private float delta, wdupe = 0;
	
	public Menu(float x, float y, GameObject parent, boolean isAttached){
		super(x, y, parent, isAttached);
		MySound.create();
		menu = new SpriteObject(0, 0, null, false);
		menuGlitch = new SpriteObject(0, 0, null, false);
		g = new SoundGlitch();
		
		addSprite(menu);
		addSprite(menuGlitch);
		
		menu.addTexture("graphic/menu/menu0.png");
		menuGlitch.addTexture("graphic/menu/menu1.png");
		menuGlitch.addTexture("graphic/menu/menu2.png");
		menuGlitch.addTexture("graphic/menu/menu3.png");
		menuGlitch.addTexture("graphic/menu/menu4.png");
		menuGlitch.addTexture("graphic/menu/menu5.png");
		menuGlitch.addTexture("graphic/menu/menu6.png");
		menuGlitch.addTexture("graphic/menu/menu7.png");
		menuGlitch.addTexture("graphic/menu/menu8.png");
		
		
		menu.isVisible = true;
		menu.visibility = 0;
		menuGlitch.isVisible = true;
		menuGlitch.visibility = 0;
		menuGlitch.setFrameTime(0.04f);
		
		
	}
	int dupa;
	boolean f = true;
	public void update(float delta){
		super.update(delta);
		delta = Gdx.graphics.getDeltaTime();
		wdupe += delta;
		menuGlitch.updateFrames(delta/2);
		
		if(f)
			dupa = new Random().nextInt(4) + 5;
		
		if(wdupe >= dupa){
			menu.isVisible = false;
			menuGlitch.visibility = 1;
			g.play(1);
			f = false;
			if(wdupe>= (dupa + 0.25)){
				menu.isVisible = true;
				menuGlitch.visibility = 0;
				g.setVol(0);
				wdupe = 0;
				f = true;
			}
		}
		else
			menu.updateFrames(delta/20);
		
	}
	
	public void setMenuVisi(float vis){
		menu.visibility = vis;
	}
	public void setMenuGlitchVisi(float vis){
		menuGlitch.visibility = vis;
	}
}
