package com.redartedgames.libgdxengine2d;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.redartedgames.libgdxengine2d.hexs.HexMatrix;

public class HexTest extends ApplicationAdapter {
	
	HexMatrix hexMatrix;
	ShapeRenderer batch;
	
	
	@Override
	public void create () {
		batch = new ShapeRenderer();
		hexMatrix = new HexMatrix(25, 8, 20);
		hexMatrix.initialize();
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin(ShapeType.Filled);
		batch.setColor(0, 1, 0, 1);
		hexMatrix.render(batch);
		batch.end();
	}
	
	@Override
	public void dispose () {
		
	}
}
