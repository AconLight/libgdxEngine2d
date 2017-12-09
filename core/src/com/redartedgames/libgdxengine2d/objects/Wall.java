package com.redartedgames.libgdxengine2d.objects;

import com.badlogic.gdx.math.Vector2;
import com.redartedgames.libgdxengine2d.main.GameObject;

import java.util.ArrayList;

public class Wall extends GameObject{

	private ArrayList<Vector2> positions;
	private WallElement we1, we2, we3, we4; // poszczególne kawalki kafelka 50x50
	private WallElement pom;
	private int rotation;
	public Wall(float x, float y, GameObject parent, boolean isAttached/*args*/, int wallType, int rotation) {
		super(x, y, parent, isAttached);

		positions = new ArrayList<Vector2>();
		positions.add(new Vector2(-25,25));
		positions.add(new Vector2(25,25));
		positions.add(new Vector2(25,-25));
		positions.add(new Vector2(-25,-25));

		this.rotation = rotation;

		we1 = solveWallElement(wallType,1);
		we2 = solveWallElement(wallType,2);
		we3 = solveWallElement(wallType,3);
		we4 = solveWallElement(wallType,4);

		addGameObject(we1);
		addGameObject(we2);
		addGameObject(we3);
		addGameObject(we4);
	}

	private WallElement solveWallElement(int wallType, int position) {

		switch (position) {
			default:
			case 1:
				switch (wallType) {
					default:
					case 1: case 2: case 3: case 4: case 5: case 7:
						pom = newWallElement(1,2,0);
					break;
					case 6: case 8:
						pom =  newWallElement(1,3,0);
					break;
				}
				break;
			case 2:
				switch (wallType) {
					default:
					case 1: case 2:
						pom =  newWallElement(2,2,180);
					break;
					case 3: case 4: case 8:
						pom =  newWallElement(2,4,0);
					break;
					case 6:
						pom =  newWallElement(2,3,90);
						break;
					case 5:	case 7:
						pom =  newWallElement(2,3,90);
					break;
				}
				break;
			case 4:
				switch (wallType) {
					default:
					case 1: case 3: case 5:
						pom =  newWallElement(4,1,270);
					break;
					case 2: case 4: case 7:
						pom =  newWallElement(4,2,0);
					break;
					case 6:
						pom =  newWallElement(4,3,270);
					break;
					case 8:
						pom =  newWallElement(4,3,270);
					break;
				}
				break;
			case 3:
				switch (wallType) {
					default:
					case 1:
						pom =  newWallElement(3,1,180);
					break;
					case 2:
						pom =  newWallElement(3,2,180);
						break;
					case 3: case 5:
						pom =  newWallElement(3,2,270);
						break;
					case 4: case 8:
						pom =  newWallElement(3,4,0);
					break;
					case 6: case 7:
						pom =  newWallElement(3,3,180);
					break;
				}
				break;
		}
		return pom;
	}

	private WallElement newWallElement(int position, int wt, int rot){
		return new WallElement(positions.get((position+rotation%89-1)%4).x,positions.get((position+rotation%89-1)%4).y, this, wt, rot + rotation);
	}
}
