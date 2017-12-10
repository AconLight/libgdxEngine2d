package com.redartedgames.libgdxengine2d.utilities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.redartedgames.libgdxengine2d.main.GameObject;
import com.redartedgames.libgdxengine2d.main.SpriteObject;

public class Text extends SpriteObject{

    protected String txt;
    protected BitmapFont font;
    protected float x;
    protected float y;
    protected float visibility;


    public Text(float x, float y, GameObject parent, boolean isAttached, int size, String tekst, float visibility){
        super(x,y,parent,isAttached);
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
            case 3:
                font = new BitmapFont(Gdx.files.internal("fonts/best_font.fnt"),false);
                break;
            case -1:
                font = new BitmapFont(Gdx.files.internal("fonts/font_extraSmall.fnt"),false);
                break;
            default:
                break;
        }

    }

    public void render(SpriteBatch batch, int priority, float dx, float dy, float visibility) {
        batch.setColor(1, 1, 1, 0);
        font.setColor(new Color(1, 1, 1, visibility*this.visibility));
        font.draw(batch, txt, x, y);
        batch.setColor(1, 1, 1, visibility);
    }
}
