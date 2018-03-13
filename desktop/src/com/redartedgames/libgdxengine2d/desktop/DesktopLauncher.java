package com.redartedgames.libgdxengine2d.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.redartedgames.libgdxengine2d.LibgdxEngine2dGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = 1920;
		config.height = 1080;
		//config.fullscreen = true;
		new LwjglApplication(new LibgdxEngine2dGame(), config);
	}
}
