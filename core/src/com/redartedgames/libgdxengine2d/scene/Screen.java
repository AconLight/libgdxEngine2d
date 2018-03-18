package com.redartedgames.libgdxengine2d.scene;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.viewport.Viewport;

public class Screen {
	private Viewport viewport;
	public OrthographicCamera cam;
	public World world;
	private SpriteBatch batch;
	private ShapeRenderer shapeBatch;
	public float visibility;
	public Vector2 camPosition;
	private Vector2 screenPosition;
	public ScreenShaker screenShaker;
	public Window window;
	public float zoom;
	
	public Screen(Viewport viewport, float visibility, float x, float y, int width, int height, Window window) {
		this.window = window;
		zoom = 1;
		this.viewport = viewport;
		screenShaker = new ScreenShaker(new Vector3(0.92f, 0.92f, 0.92f), 500, 20);
		screenPosition = new Vector2(x, y);
		camPosition = new Vector2(-x, -y);
		batch = new SpriteBatch();
		shapeBatch = new ShapeRenderer();
		cam = new OrthographicCamera(width, height);
		updateCam();
		viewport.setCamera(cam);
		viewport.apply();
		this.visibility = visibility;
	}
	
	public void updateCam() {
		cam.position.x = -screenPosition.x + camPosition.x - screenShaker.getPosition().x;
		cam.position.y = -screenPosition.y + camPosition.y - screenShaker.getPosition().y;
		cam.direction.set(0, 0, -1);
		cam.up.set(0, 1, 0);
		cam.rotate(screenShaker.getAlfaDeep().x);

		cam.zoom = zoom + (screenShaker.getAlfaDeep().y)/(Math.abs(screenShaker.getAlfaDeep().y)+1);

		cam.update();
		batch.setProjectionMatrix(cam.combined);
		shapeBatch.setProjectionMatrix(cam.combined);
	}
	
	public void setWorld(World world) {
		this.world = world;
	}
	
	public void update(float delta) {
		world.update(delta);
		screenShaker.update(delta);
		updateCam();
	}
	
	public void render() {
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
