package com.redartedgames.libgdxengine2d.assets;

import com.badlogic.gdx.Game;
import com.redartedgames.libgdxengine2d.effects.Explosion;
import com.redartedgames.libgdxengine2d.gameobject.GameObject;

import java.util.ArrayList;

public class ElectricalElementsHandler {
    private ArrayList<GameObject> elements;

    public ElectricalElementsHandler() {
        elements = new ArrayList<>();
    }

    public void destroy(ElectricalElement e) {
        elements.set(elements.indexOf(e),new Explosion(e.realPosition.x,e.realPosition.y,null,false,e.getSize()));
    }

    public ElectricalElement addElement(ElectricalElement e) {
        elements.add(e);
        return (ElectricalElement)elements.get(elements.size()-1);
    }
}
