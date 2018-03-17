package com.redartedgames.libgdxengine2d.formation;

import com.badlogic.gdx.math.Vector2;

import java.util.ArrayList;

public class FormationNone implements FormationGenerator {
    @Override
    public ArrayList<Vector2> generate(int n) {
        ArrayList<Vector2> positions = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            positions.add(new Vector2((float)(0), (float)(0)));
        }
        return positions;
    }
}
