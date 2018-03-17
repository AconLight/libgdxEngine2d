package com.redartedgames.libgdxengine2d.formation;

import com.badlogic.gdx.math.Vector2;

import java.util.ArrayList;

public class FormationShield implements FormationGenerator {
    @Override
    public ArrayList<Vector2> generate(int n) {
        ArrayList<Vector2> positions = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            float temp = (-n/2);
            positions.add(new Vector2((float)((temp+i)*100), (float)(-(((-(temp+i)*(temp+i))+4)*25))));
        }
        return positions;
    }
}
