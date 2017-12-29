package com.redartedgames.libgdxengine2d;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.redartedgames.libgdxengine2d.hexs.HexMatrix;
import com.redartedgames.libgdxengine2d.myhexs.MyHexGenerator;

public class HexTest extends ApplicationAdapter {
	
	HexMatrix hexMatrix;
	MyHexGenerator myHexGenerator;
	ShapeRenderer batch;
	OrthographicCamera cam;
	
	@Override
	public void create () {
		cam = new OrthographicCamera(1920/2, 1080/2);
		//cam.translate(1920/4, 1080/4);
		//cam.update();
		
		batch = new ShapeRenderer();
		batch.setProjectionMatrix(cam.combined);
		
		hexMatrix = new HexMatrix(15, 8, 10);
		myHexGenerator = new MyHexGenerator();
		hexMatrix.setHexGenerator(myHexGenerator);
		hexMatrix.initialize();
	}
	boolean t = true;
	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		batch.begin(ShapeType.Filled);
		batch.setColor(0, 1, 0, 1);
		hexMatrix.render(batch);
		batch.end();
		
		if (Gdx.input.isKeyJustPressed(Keys.RIGHT)) {
			hexMatrix.moveMatrix(2, 0);
		}
		if (Gdx.input.isKeyJustPressed(Keys.LEFT)) {
			hexMatrix.moveMatrix(-2, 0);
		}
		if (Gdx.input.isKeyJustPressed(Keys.UP)) {
			hexMatrix.moveMatrix(0, 2);
		}
		if (Gdx.input.isKeyJustPressed(Keys.DOWN)) {
			hexMatrix.moveMatrix(0, -2);
		}
		
	}
	
	@Override
	public void dispose () {
		
	}
}
