package com.redartedgames.libgdxengine2d.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.redartedgames.libgdxengine2d.LibgdxEngine2dGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = 1280;
		config.height = 720+200;

		new LwjglApplication(new LibgdxEngine2dGame(), config);
	}
}
