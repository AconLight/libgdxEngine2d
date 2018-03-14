package com.redartedgames.libgdxengine2d.formation;

import java.util.ArrayList;

import com.badlogic.gdx.math.Vector2;

public class MyFormationGenerator implements FormationGenerator{

	@Override
	public ArrayList<Vector2> generate(int n) {
		ArrayList<Vector2> positions = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			positions.add(new Vector2((float)(60*Math.cos(2*Math.PI*i/n)), (float)(60*Math.sin(2*Math.PI*i/n))));
		}
		return positions;
	}

}
