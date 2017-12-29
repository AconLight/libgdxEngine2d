package com.redartedgames.libgdxengine2d.hexs;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class HexShapeRenderer {

	public static void drawHex(ShapeRenderer batch, float x, float y, float a) {
		float s = (float) Math.sqrt(3);
		float[] verts = {x-a, y,
				x-a/2f, y + a*s/2f, 
				x+a/2f, y + a*s/2f,
				x+a, y, 
				x+a/2f, y - a*s/2f, 
				x-a/2f, y - a*s/2f
				};
		//batch.polygon(verts);
		//hehe polygon nie dzia³a z wype³nieniem, wiêc poni¿ej gunwokod z 6 trójk¹tami
		for(int i = 0; i < 6; i++) {
			batch.triangle(verts[2*i], verts[2*i+1], verts[(2*i+2)%12], verts[(2*i+3)%12], x, y);
		}
	}
}
