package com.redartedgames.libgdxengine2d.sound;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;

public class MySound {
	
	static SoundGlitch g;
	public static Sound glitch0;
	public static Sound glitch1;
	public static Sound glitch2;
	public static Sound glitch3;
	public static ArrayList<Sound> glitches;
	
	
	public static void create(){
		glitch0 = Gdx.audio.newSound(Gdx.files.internal("audio/glitch0.mp3"));
		glitch1 = Gdx.audio.newSound(Gdx.files.internal("audio/glitch1.mp3"));
		glitch2 = Gdx.audio.newSound(Gdx.files.internal("audio/glitch2.mp3"));
		glitch3 = Gdx.audio.newSound(Gdx.files.internal("audio/glitch3.mp3"));
	}
}
