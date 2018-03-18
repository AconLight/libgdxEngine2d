package com.redartedgames.libgdxengine2d.sound;

import java.util.ArrayList;
import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;


public class SoundEffect extends MySound{

	public SoundEffect(){
	    super();
    }

	
	public int soundNum = 0;

	public void play(float vol){
		soundNum = new Random().nextInt(6);
		MySound.sounds.get(soundNum).play(vol);
	}

	
}
