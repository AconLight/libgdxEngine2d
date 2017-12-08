package com.redartedgames.libgdxengine2d.main;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.utils.viewport.Viewport;

public class GameScreen {
	private Viewport viewport;
	protected OrthographicCamera cam;
	protected World world;
	private SpriteBatch batch;
	private ShapeRenderer shapeBatch;
	private float visibility;
	
	public GameScreen(Viewport viewport, float visibility, int width, int height) {
		this.viewport = viewport;
		batch = new SpriteBatch();
		shapeBatch = new ShapeRenderer();
		cam = new OrthographicCamera(width, height);
		batch.setProjectionMatrix(cam.combined);
		viewport.setCamera(cam);
		viewport.apply();
		this.visibility = visibility;
	}
	
	public void setWorld(World world) {
		this.world = world;
	}
	
	public void update(float delta) {
		world.update(delta);
	}
	
	public void render() {
		Gdx.app.log("GameScreen", "render");
		batch.begin();
		world.render(batch, visibility);
		batch.end();
		shapeBatch.begin(ShapeType.Filled);
		world.render(shapeBatch, visibility);
		shapeBatch.end();
	}
	
	public OrthographicCamera getCam() {
		return cam;
	}
}
