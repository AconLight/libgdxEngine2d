package com.redartedgames.libgdxengine2d.sound;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;

public class MySound {
	
	static SoundEffect g;
	public static Sound s1;
	public static Sound s2;
	public static Sound s3;
	public static Sound s4;
    public static Sound s5;
    public static Sound s6;
	public static ArrayList<Sound> sounds;
	
	
	public MySound(){
		sounds = new ArrayList<>();
	    s1 = Gdx.audio.newSound(Gdx.files.internal("audio/soundEffects/jjjiiiicha.mp3"));
		s2 = Gdx.audio.newSound(Gdx.files.internal("audio/soundEffects/aua.mp3"));
		s3 = Gdx.audio.newSound(Gdx.files.internal("audio/soundEffects/kaszel.mp3"));
		s4 = Gdx.audio.newSound(Gdx.files.internal("audio/soundEffects/walen.mp3"));
		s5 = Gdx.audio.newSound(Gdx.files.internal("audio/soundEffects/walen2.mp3"));
		s6 = Gdx.audio.newSound(Gdx.files.internal("audio/soundEffects/walen3.mp3"));
		sounds.add(s1);
        sounds.add(s2);
        sounds.add(s3);
        sounds.add(s4);
        sounds.add(s5);
        sounds.add(s6);
	}
}
