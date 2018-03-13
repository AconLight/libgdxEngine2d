package com.redartedgames.libgdxengine2d.myhexs;

import java.util.Random;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.redartedgames.libgdxengine2d.hexs.Hex;

public class MyHex extends Hex{

	private float r, g, b;
	
	public MyHex(int x, int y, int a) {
		super(x, y, a);
		Random rand = new Random();
		r = rand.nextInt(256)/256f;
		g = rand.nextInt(256)/256f;
		b = rand.nextInt(256)/256f;
	}
	
	public void render(ShapeRenderer batch) {
		batch.setColor(r, g, b, 1);
		super.render(batch);
	}
	
	
}
