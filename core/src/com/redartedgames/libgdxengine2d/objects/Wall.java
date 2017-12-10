package com.redartedgames.libgdxengine2d.objects;

import com.badlogic.gdx.math.Vector2;
import com.redartedgames.libgdxengine2d.generation.KafelekWorld;
import com.redartedgames.libgdxengine2d.main.GameObject;

import java.util.ArrayList;

public class Wall extends GameObject{

	private int changeX;
	private int changeY;
	private int defChangeY;
	public ArrayList<ArrayList<ArrayList<GameObject>>> plansza;
	private ArrayList<ArrayList<Boolean>> map;
	private ArrayList<Vector2> positions;
	private Boolean e1,e2,e3,e4;
	private WallElement we1, we2, we3, we4; // poszczególne kawalki kafelka 50x50
	private WallElement pom;
	private int rotation;
	public Wall(float x, float y, GameObject parent, boolean isAttached/*args*/,ArrayList<ArrayList<Boolean>> map, KafelekWorld kafelekWorld) {
		super(x, y, parent, isAttached);

		defChangeY = (int)y;
		changeX = (int)x;
		changeY = 0;

		e1 = false;
		e2 = false;
		e3 = false;
		e4 = false;

		map = new ArrayList<>();
		plansza = new ArrayList<>();
		positions = new ArrayList<>();
		positions.add(new Vector2(-25,25));
		positions.add(new Vector2(25,25));
		positions.add(new Vector2(25,-25));
		positions.add(new Vector2(-25,-25));

		this.rotation = rotation;

		//we1 = solveWallElement(wallType,1);
		//we2 = solveWallElement(wallType,2);
		//we3 = solveWallElement(wallType,3);
		//we4 = solveWallElement(wallType,4);

		mapMap(kafelekWorld);

		generate(map);
	}

	private void mapMap(KafelekWorld kafelekWorld){
		for(int i=0; i<kafelekWorld.kafelki.size(); i++) {
			map.add(new ArrayList<>());
			for (int j = 0; i < kafelekWorld.kafelki.get(i).size(); j++) {
				if (kafelekWorld.kafelki.get(1).get(1).type == Kafelek.KafelekType.path)
					map.get(i).add(new Boolean(true));
				else
					map.get(i).add(new Boolean(false));
			}
		}

	}

	private void generate(ArrayList<ArrayList<Boolean>> map){
		for(int i=0; i<map.size(); i++){
			changeY=0;
			plansza.add(new ArrayList<ArrayList<GameObject>>());
			for( int j=0; j<map.get(0).size(); j++){
				plansza.get(i).add(new ArrayList<GameObject>());
				boolean b0,b1,b2,b3,b4,b5,b6,b7,b8;
				b0=map.get(i).get(j).booleanValue();

				if(j==0) b2=true;
				else b2=map.get(i).get(j-1).booleanValue();

				if(j==map.get(0).size()-1) b6=true;
				else b6=map.get(i).get(j+1).booleanValue();

				if(i==0) b8=true;
				else b8=map.get(i-1).get(j).booleanValue();

				if(i==map.size()-1) b4=true;
				else b4=map.get(i+1).get(j).booleanValue();

				if(i==0 || j==0) b1=true;
				else b1=map.get(i-1).get(j-1).booleanValue();

				if(i==0 || j==map.get(0).size()-1) b7=true;
				else b7=map.get(i-1).get(j+1).booleanValue();

				if(i==map.size()-1 || j==map.get(0).size()-1) b5=true;
				else b5=map.get(i+1).get(j+1).booleanValue();

				if(i==map.size()-1 || j==0) b3=true;
				else b3=map.get(i+1).get(j-1).booleanValue();

				//addLD(b8,b0,b2,b1);
				//addLU(b7,b6,b0,b8);
				//addRD(b0,b4,b3,b2);
				//addRU(b6,b5,b4,b0);
				plansza.get(i).get(j).add(addLD(b8,b0,b2,b1,b0));
				plansza.get(i).get(j).add(addLU(b7,b6,b0,b8,b0));
				plansza.get(i).get(j).add(addRD(b0,b4,b3,b2,b0));
				plansza.get(i).get(j).add(addRU(b6,b5,b4,b0,b0));
				//plansza.get(i).get(j).add(newWallElement(100,100,0));
				changeY+=100;
			}
			changeX+=100;
		}
	}

	private WallElement addLD(boolean b1,boolean b2,boolean b3,boolean b4, boolean b0){
		if(b1&&!b2&&b3&&!b4) return newWallElement(4, 3, 90 + rotation);
		if(b1&&!b2&&!b3&&!b4) b4=true;
		if(!b1&&!b2&&b3&&!b4) b4=true;
		return addLogic(b1, b2, b3, b4, 4, we4,0,b0);
	}

	private WallElement addLU(boolean b1,boolean b2,boolean b3,boolean b4, boolean b0){
		if(!b1&&b2&&!b3&&b4) return newWallElement(1, 3, 180 + rotation);
		if(!b1&&b2&&!b3&&!b4) b1=true;
		if(!b1&&!b2&&!b3&&b4) b1=true;
		return addLogic(b1, b2, b3, b4, 1, we1,0,b0);
	}

	private WallElement addRD(boolean b1,boolean b2,boolean b3,boolean b4, boolean b0){
		if(!b1&&b2&&!b3&&!b4) b3=true;
		if(!b1&&!b2&&!b3&&b4) b3=true;
		return addLogic(b1, b2, b3, b4, 3, we3,0,b0);
	}

	private WallElement addRU(boolean b1,boolean b2,boolean b3,boolean b4, boolean b0){
		if(b1&&!b2&&!b3&&!b4) b2=true;
		if(!b1&&!b2&&b3&&!b4) b2=true;
		return addLogic(b1, b2, b3, b4, 2, we2,0,b0);
	}

	private WallElement addLogic(boolean b1, boolean b2, boolean b3, boolean b4, int p, WallElement we, int rotation, boolean b0){
		if(b0)we=newWallElement(p,4,0 + rotation);
		else {
			if (b1)
				if (b2)
					if (b3)
						if (b4) we = newWallElement(p, 4, 0 + rotation);
						else we = newWallElement(p, 3, 270 + rotation);
					else if (b4) we = newWallElement(p, 3, 180 + rotation);
					else we = newWallElement(p, 2, 270 + rotation);
				else if (b3)
					if (b4) we = newWallElement(p, 3, 90 + rotation);
					else we = newWallElement(p, 3, 270 + rotation);
				else if (b4) we = newWallElement(p, 2, 180 + rotation);
				else we = newWallElement(p, 1, 180 + rotation);
			else if (b2)
				if (b3)
					if (b4) we = newWallElement(p, 3, 0 + rotation);
					else we = newWallElement(p, 2, 0 + rotation);
				else if (b4) we = newWallElement(p, 3, 0 + rotation);
				else we = newWallElement(p, 1, 270 + rotation);
			else if (b3)
				if (b4) we = newWallElement(p, 2, 90 + rotation);
				else we = newWallElement(p, 1, 0 + rotation);
			else if (b4) we = newWallElement(p, 1, 90 + rotation);
			else we = newWallElement(p, 6, 0 + rotation);
		}
		return we;
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
		return new WallElement(positions.get((position+rotation%89-1)%4).x+changeX,positions.get((position+rotation%89-1)%4).y+changeY, this, wt, rot + rotation);
	}
}
