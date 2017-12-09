package com.redartedgames.libgdxengine2d.objects;

import com.badlogic.gdx.math.Vector2;
import com.redartedgames.libgdxengine2d.main.GameObject;

import java.util.ArrayList;

public class Wall extends GameObject{

	public ArrayList<ArrayList<ArrayList<GameObject>>> plansza;
	private ArrayList<Vector2> positions;
	private Boolean e1,e2,e3,e4;
	private WallElement we1, we2, we3, we4; // poszczególne kawalki kafelka 50x50
	private WallElement pom;
	private int rotation;
	public Wall(float x, float y, GameObject parent, boolean isAttached/*args*/,ArrayList<ArrayList<Boolean>> map) {
		super(x, y, parent, isAttached);

		e1 = false;
		e2 = false;
		e3 = false;
		e4 = false;

		plansza = new ArrayList<ArrayList<ArrayList<GameObject>>>();
		positions = new ArrayList<Vector2>();
		positions.add(new Vector2(-25,25));
		positions.add(new Vector2(25,25));
		positions.add(new Vector2(25,-25));
		positions.add(new Vector2(-25,-25));

		this.rotation = rotation;

		//we1 = solveWallElement(wallType,1);
		//we2 = solveWallElement(wallType,2);
		//we3 = solveWallElement(wallType,3);
		//we4 = solveWallElement(wallType,4);

		generate(map);
	}

	private void generate(ArrayList<ArrayList<Boolean>> map){
		int iter = 0;
		int iter2 = 0;
		for(int i=0; i<map.size(); i++){
			for( int j=0; j<map.get(0).size(); i++){
				boolean b0,b1,b2,b3,b4,b5,b6,b7,b8;
				b0=map.get(i).get(j).booleanValue();
				if(i==0) b2=true;
				else b2=map.get(i-1).get(j).booleanValue();
				if(i==map.size()-1) b6=true;
				else b6=map.get(i+1).get(j).booleanValue();
				if(j==0) b8=true;
				else b8=map.get(i).get(j-1).booleanValue();
				if(j==map.size()-1) b4=true;
				else b4=map.get(i).get(j+1).booleanValue();
				if(i==0 && j==0) b1=true;
				else b1=map.get(i-1).get(j-1).booleanValue();
				if(i==map.size()-1 && j==0) b7=true;
				else b7=map.get(i+1).get(j-1).booleanValue();
				if(i==0 && j==map.get(0).size()-1) b5=true;
				else b5=map.get(i-1).get(j+1).booleanValue();
				if(i==map.size()-1 && j==map.get(0).size()-1) b3=true;
				else b3=map.get(i+1).get(j+1).booleanValue();

				addLD(b8,b0,b2,b1);
				addLU(b7,b6,b0,b8);
				addRD(b0,b4,b3,b2);
				addRU(b6,b5,b4,b0);
				plansza.get(i).get(j).add(we1);
				plansza.get(i).get(j).add(we2);
				plansza.get(i).get(j).add(we3);
				plansza.get(i).get(j).add(we4);
			}
		}
	}

	private void addLD(boolean b1,boolean b2,boolean b3,boolean b4){
		addLogic(b1, b2, b3, b4, 4, e4);
	}

	private void addLU(boolean b1,boolean b2,boolean b3,boolean b4){
		addLogic(b1, b2, b3, b4, 1, e1);
	}

	private void addRD(boolean b1,boolean b2,boolean b3,boolean b4){
		addLogic(b1, b2, b3, b4, 3, e3);
	}

	private void addRU(boolean b1,boolean b2,boolean b3,boolean b4){
		addLogic(b1, b2, b3, b4, 2, e2);
	}

	void addLogic(boolean b1, boolean b2, boolean b3, boolean b4, int p, boolean e){
		if(b1)
			if(b2)
				if(b3)
					if(b4) we1=newWallElement(p,4,0);
					else we1=newWallElement(p,3,270);
				else if(b4) we1=newWallElement(p,3,180);
				else we1=newWallElement(p,2,270);
			else if(b3)
				if(b4) we1=newWallElement(p,3,90);
				else we1=newWallElement(p,5,0);
			else if(b4) we1=newWallElement(p,2,180);
			else we1=newWallElement(p,1,180);
		else if(b2)
				if(b3)
					if(b4) we1=newWallElement(p,3,0);
					else we1=newWallElement(p,2,0);
				else if(b4)	we1=newWallElement(p,1,90);
					else we1=newWallElement(p,1,270);
			else if(b3)
					if(b4) we1=newWallElement(p,2,90);
					else we1=newWallElement(p,1,0);
				else if(b4) we1=newWallElement(p,1,90);
					else e=true;
	}

	private WallElement solveWallElement(int wallType, int position) {

		switch (position) {
			default:
			case 1:
				switch (wallType) {
					default:
					case 1: case 2: case 3: case 4: case 5: case 7: case 9: case 10:
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
					case 3: case 4: case 8: case 10:
						pom =  newWallElement(2,4,0);
					break;
					case 6: case 9:
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
					case 2: case 4: case 7: case 9: case 10:
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
					case 4: case 8: case 9:
						pom =  newWallElement(3,4,0);
					break;
					case 6: case 7: case 10:
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
