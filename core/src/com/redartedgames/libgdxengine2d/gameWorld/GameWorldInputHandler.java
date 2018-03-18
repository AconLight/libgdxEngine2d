package com.redartedgames.libgdxengine2d.gameWorld;

import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.redartedgames.libgdxengine2d.assetexample.AssetExampleLoader;
import com.redartedgames.libgdxengine2d.player.Player;

public class GameWorldInputHandler implements InputProcessor{

	GameWorld world;
	

	public GameWorldInputHandler(GameWorld world) {
		this.world = world;
	}
	@Override
	public boolean keyDown(int keycode) {
		switch (keycode) {
		case  Keys.ESCAPE: {
			Gdx.app.exit();
			break;
		}
		case  Keys.W: {
			world.player1.moveVel(0, Player.playerV);
			break;
		}
		case  Keys.S: {
			world.player1.moveVel(0, -Player.playerV);
			break;
		}
		case  Keys.D: {
			world.player1.moveVel(Player.playerV, 0);
			break;
		}
		case  Keys.A: {
			world.player1.moveVel(-Player.playerV, 0);
			break;
		}
		case  Keys.R: {
			world.player1.startSkill(0);
			break;
		}
		case  Keys.T: {
			world.player1.startSkill(1);
			break;
		}
		case  Keys.Y: {
			world.player1.startSkill(2);
			break;
		}
		case  Keys.UP: {
			world.player2.moveVel(0, Player.playerV);
			break;
		}
		case  Keys.DOWN: {
			world.player2.moveVel(0, -Player.playerV);
			break;
		}
		case  Keys.RIGHT: {
			world.player2.moveVel(Player.playerV, 0);
			break;
		}
		case  Keys.LEFT: {
			world.player2.moveVel(-Player.playerV, 0);
			break;
		}
		case  Keys.I: {
			world.player2.startSkill(0);
			break;
		}
		case  Keys.O: {
			world.player2.startSkill(1);
			break;
		}
		case  Keys.P: {
			world.player2.startSkill(2);
			break;
		}
		case  Keys.ENTER: {
			world.restart();
			break;
		}
		case  Keys.SPACE: {

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
		case  Keys.W: {
			world.player1.moveVel(0, -Player.playerV);
			break;
		}
		case  Keys.S: {
			world.player1.moveVel(0, Player.playerV);
			break;
		}
		case  Keys.D: {
			world.player1.moveVel(-Player.playerV, 0);
			break;
		}
		case  Keys.A: {
			world.player1.moveVel(Player.playerV, 0);
			break;
		}
		case  Keys.UP: {
			world.player2.moveVel(0, -Player.playerV);
			break;
		}
		case  Keys.DOWN: {
			world.player2.moveVel(0, Player.playerV);
			break;
		}
		case  Keys.RIGHT: {
			world.player2.moveVel(-Player.playerV, 0);
			break;
		}
		case  Keys.LEFT: {
			world.player2.moveVel(Player.playerV, 0);
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
