package com.redartedgames.libgdxengine2d.sound;

import java.util.ArrayList;
import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;


public class SoundGlitch {

	public ArrayList<Sound> list;
	public Sound glitch0;
	public Sound glitch1;
	public Sound glitch2;
	public Sound glitch3;
	
	public SoundGlitch(){
		list = new ArrayList<Sound>();
		glitch0 = MySound.glitch0;
		glitch1 = MySound.glitch1;
		glitch2 = MySound.glitch2;
		glitch3 = MySound.glitch3;
		
		list.add(glitch0);
		list.add(glitch1);
		list.add(glitch2);
		list.add(glitch3);
	}
	

	public void play(float vol){
		
		list.get(new Random().nextInt(4)).play(vol);
	}
	
}
