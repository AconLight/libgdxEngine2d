package com.redartedgames.libgdxengine2d.main;

import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.redartedgames.libgdxengine2d.gameWorld.GameWorld;

public class InputHandler implements InputProcessor{

	GameWorld world;
	public InputHandler(GameWorld world) {
		this.world = world;
	}
	@Override
	public boolean keyDown(int keycode) {
		switch (keycode) {
		case  Keys.ESCAPE: {
			Gdx.app.exit();
			break;
		}
		
		case  Keys.DOWN: {
			world.camVel.y -= 200;
			break;
		}
		case  Keys.UP: {
			world.camVel.y += 200;
			break;
		}
		case  Keys.RIGHT: {
			world.camVel.x += 200;
			break;
		}
		case  Keys.LEFT: {
			world.camVel.x -= 200;
			break;
		}
		}
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		switch (keycode) {
		case  Keys.ESCAPE: {
			Gdx.app.exit();
			break;
		}
		
		case  Keys.DOWN: {
			world.camVel.y += 200;
			break;
		}
		case  Keys.UP: {
			world.camVel.y -= 200;
			break;
		}
		case  Keys.RIGHT: {
			world.camVel.x -= 200;
			break;
		}
		case  Keys.LEFT: {
			world.camVel.x += 200;
			break;
		}
		}
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		// TODO Auto-generated method stub
		return false;
	}

}
