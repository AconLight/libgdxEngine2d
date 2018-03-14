package com.redartedgames.libgdxengine2d.formation;

import java.util.ArrayList;

import com.badlogic.gdx.math.Vector2;

public interface FormationGenerator {

	public abstract ArrayList<Vector2> generate(int n);
}
