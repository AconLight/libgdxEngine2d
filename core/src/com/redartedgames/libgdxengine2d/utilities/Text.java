package com.redartedgames.libgdxengine2d.utilities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.redartedgames.libgdxengine2d.main.GameObject;
import com.redartedgames.libgdxengine2d.main.SpriteObject;

public class Text extends SpriteObject{

    private String txt;
    private BitmapFont font;
    private float x;
    private float y;
    private float visibility;

    public Text(float x, float y, GameObject parent, boolean isAtt, int size, String tekst, float visibility){
        super(x,y,parent,isAtt);
        this.txt = tekst;
        this.x = x;
        this.y = y;
        this.visibility = visibility;
        switch(size) {
            case 0:
                font = new BitmapFont(Gdx.files.internal("fonts/font_small.fnt"),false);
                break;
            case 1:
                font = new BitmapFont(Gdx.files.internal("fonts/font_medium.fnt"),false);
                break;
            case 2:
                font = new BitmapFont(Gdx.files.internal("fonts/font_big.fnt"),false);
                break;
            default:
                break;
        }

    }

    public void render(SpriteBatch batch, int priority, float dx, float dy, float visibility) {
        font.setColor(Color.BLACK);
        font.draw(batch, txt,x,y);
    }
}
