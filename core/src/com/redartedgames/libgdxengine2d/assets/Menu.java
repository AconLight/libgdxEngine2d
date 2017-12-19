package com.redartedgames.libgdxengine2d.assets;

import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.redartedgames.libgdxengine2d.main.GameObject;
import com.redartedgames.libgdxengine2d.main.SpriteObject;
import com.redartedgames.libgdxengine2d.sound.MySound;
import com.redartedgames.libgdxengine2d.sound.SoundGlitch;

public class Menu extends GameObject{
		
	private SpriteObject menuGlitch, menu, zoom;
	private SoundGlitch g;
	private Random rand;
	private float delta, wdupe = 0; 
	boolean endMenu = false, ison = false;
	public Menu(float x, float y, GameObject parent, boolean isAttached){
		super(x, y, parent, isAttached);
		MySound.create();
		menu = new SpriteObject(0, 0, null, false);
		menuGlitch = new SpriteObject(0, 0, null, false);
		zoom = new SpriteObject(0, 0, null, false);
		g = new SoundGlitch();
		
		addSprite(menu);
		addSprite(menuGlitch);
		addSprite(zoom);
		
		menu.addTexture("graphic/menu/menu0.png");
		menuGlitch.addTexture("graphic/menu/menu1.png");
		menuGlitch.addTexture("graphic/menu/menu2.png");
		menuGlitch.addTexture("graphic/menu/menu3.png");
		menuGlitch.addTexture("graphic/menu/menu4.png");
		menuGlitch.addTexture("graphic/menu/menu5.png");
		menuGlitch.addTexture("graphic/menu/menu6.png");
		menuGlitch.addTexture("graphic/menu/menu7.png");
		menuGlitch.addTexture("graphic/menu/menu8.png");
		zoom.addTexture("graphic/menu/menu9.png");
		zoom.addTexture("graphic/menu/menu10.png");
		zoom.addTexture("graphic/menu/menu11.png");
		zoom.addTexture("graphic/menu/menu12.png");
		zoom.addTexture("graphic/menu/menu13.png");
		zoom.addTexture("graphic/menu/menu14.png");
		zoom.addTexture("graphic/menu/menu15.png");
		zoom.addTexture("graphic/menu/menu16.png");
		zoom.addTexture("graphic/menu/menu17.png");
		zoom.addTexture("graphic/menu/menu18.png");
		zoom.addTexture("graphic/menu/menu19.png");

		
		
		menu.isVisible = true;
		menu.visibility = 0;
		menuGlitch.isVisible = true;
		menuGlitch.visibility = 0;
		menuGlitch.setFrameTime(0.04f);
		zoom.isVisible = true;
		zoom.visibility = 0;
		zoom.setFrameTime(0.04f);
	}
	int dupa;
	boolean f = true, z = false;
	public void update(float delta){
		super.update(delta);
		delta = Gdx.graphics.getDeltaTime();
		wdupe += delta;
		
		if(ison){
		
		
		if(Gdx.input.isKeyPressed(Keys.SPACE) == true && z == false){
			z = true;
			zoom.visibility = 1;
			menuGlitch.visibility = 0;
			menu.visibility = 1;
			wdupe = 0;
		}

		if(z){
			if(wdupe >= 0.4){
				zoom.visibility = 0;
				endMenu = true;
				zoom.isVisible = false;
				menu.isVisible = false;
				menuGlitch.isVisible = false;
			}
			else
				zoom.updateFrames(delta);
		}
		else{
			if(f)
				dupa = new Random().nextInt(4)+3;
			
			if(wdupe >= dupa){
				menu.isVisible = false;
				menuGlitch.visibility = 1;
				g.play(1);
				menuGlitch.updateFrames(delta/2);
				f = false;
				if(wdupe >= (dupa + 0.25)){
					menu.isVisible = true;
					menuGlitch.visibility = 0;
					g.stop();
					wdupe = 0;
					f = true;
					

				}
			}
			else
				menu.updateFrames(delta/20);
		}
		
		}
	}
	
	public void setMenuVisi(float vis){
		menu.visibility = vis;
		//menuGlitch.visibility = vis;
	}
	public void setMenuGlitchVisi(float vis){
		menuGlitch.visibility = vis;
	}
	
	public boolean isMenuEnd(){
		return endMenu;
		
	}
	public void isOnMenu(boolean ison){
		this.ison = ison;
	}
}
