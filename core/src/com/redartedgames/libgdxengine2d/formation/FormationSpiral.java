package com.redartedgames.libgdxengine2d.formation;

import com.badlogic.gdx.math.Vector2;

import java.util.ArrayList;

public class FormationSpiral implements FormationGenerator {
    @Override
    public ArrayList<Vector2> generate(int n) {
        ArrayList<Vector2> positions = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            positions.add(new Vector2((float)(i*50*Math.cos(2*Math.PI*i/n)), (float)(i*50*Math.sin(2*Math.PI*i/n))));
        }
        return positions;
    }
}
