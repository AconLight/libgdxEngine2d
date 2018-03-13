package com.redartedgames.libgdxengine2d.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.redartedgames.libgdxengine2d.HexTest;

public class DesktopLauncherHexTest {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = 1920/2;
		config.height = 1080/2;
		config.fullscreen = false;//true;
		new LwjglApplication(new HexTest(), config);
	}
}
