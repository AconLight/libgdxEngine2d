package com.redartedgames.libgdxengine2d.utilities;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.redartedgames.libgdxengine2d.main.GameObject;
import com.redartedgames.libgdxengine2d.main.SpriteObject;
import com.redartedgames.libgdxengine2d.utilities.Text;

import java.io.Console;

public class HitText extends Text{

    private float time=0;
    private float endTime;
    private float visibility;
    private int licznik=0;

    public  HitText(float x, float y, GameObject parent, boolean isAttached, int size, String tekst, float visibility, float endTime){
        super(x,y,parent,isAttached,size,tekst,visibility);
        this.endTime = endTime;
        this.visibility = visibility;
    }

    public void update (float delta) {
        super.update(delta);
        time += delta/2;

        if (licznik%7==0 && time<=endTime) {
            if (visibility == 0.5f) visibility = 1f;
            else visibility = 0.5f;
        }
        if (time>endTime) visibility=0f;
        licznik++;
    }

    public void render(SpriteBatch batch, int priority, float dx, float dy, float visibility){
        batch.setColor(1, 1, 1, 0);
            font.setColor(new Color(255, 0, 0, visibility * this.visibility));
            font.draw(batch, txt, x, y);
        batch.setColor(255, 1, 1, visibility);

    }
}
