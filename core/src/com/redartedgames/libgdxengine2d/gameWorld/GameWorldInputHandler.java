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
			AssetExampleLoader.player1.moveVel(0, Player.playerV);
			break;
		}
		case  Keys.S: {
			AssetExampleLoader.player1.moveVel(0, -Player.playerV);
			break;
		}
		case  Keys.D: {
			AssetExampleLoader.player1.moveVel(Player.playerV, 0);
			break;
		}
		case  Keys.A: {
			AssetExampleLoader.player1.moveVel(-Player.playerV, 0);
			break;
		}
		case  Keys.UP: {
			AssetExampleLoader.player2.moveVel(0, Player.playerV);
			break;
		}
		case  Keys.DOWN: {
			AssetExampleLoader.player2.moveVel(0, -Player.playerV);
			break;
		}
		case  Keys.RIGHT: {
			AssetExampleLoader.player2.moveVel(Player.playerV, 0);
			break;
		}
		case  Keys.LEFT: {
			AssetExampleLoader.player2.moveVel(-Player.playerV, 0);
			break;
		}
		case  Keys.SPACE: {
			AssetExampleLoader.player1.sr1.startSparkle();
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
			AssetExampleLoader.player1.moveVel(0, -Player.playerV);
			break;
		}
		case  Keys.S: {
			AssetExampleLoader.player1.moveVel(0, Player.playerV);
			break;
		}
		case  Keys.D: {
			AssetExampleLoader.player1.moveVel(-Player.playerV, 0);
			break;
		}
		case  Keys.A: {
			AssetExampleLoader.player1.moveVel(Player.playerV, 0);
			break;
		}
		case  Keys.UP: {
			AssetExampleLoader.player2.moveVel(0, -Player.playerV);
			break;
		}
		case  Keys.DOWN: {
			AssetExampleLoader.player2.moveVel(0, Player.playerV);
			break;
		}
		case  Keys.RIGHT: {
			AssetExampleLoader.player2.moveVel(-Player.playerV, 0);
			break;
		}
		case  Keys.LEFT: {
			AssetExampleLoader.player2.moveVel(Player.playerV, 0);
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
