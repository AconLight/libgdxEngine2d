package com.redartedgames.libgdxengine2d.generation;

import java.util.ArrayList;

import com.redartedgames.libgdxengine2d.objects.Kafelek;
import com.redartedgames.libgdxengine2d.objects.Kafelek.KafelekType;

public class KafelekWorld {
	public ArrayList<ArrayList<Kafelek>> kafelki;
	public ArrayList<Kafelek> origins;
	public ArrayList<Kafelek> paths;
	
	
	public KafelekWorld(int width) {
		kafelki = new ArrayList<ArrayList<Kafelek>>();
		origins = new ArrayList<Kafelek>();
		generate(width);
		generateOrigins(width, 0, 25);
		for (Kafelek k : origins) {
			generateSquares(k.x, k.y, 20);
		}
		for (Kafelek k : origins) {
			generateSquares(k.x, k.y, 15);
		}
		for (Kafelek k : origins) {
			generateSquares(k.x, k.y, 10);
		}
		for (Kafelek k : origins) {
			generateSquares(k.x, k.y, 5);
		}
		
	}
	
	public void generateSquares(int x, int y, int width) {
		for (int i = x-width+1; i < x + width; i++) {
			for (int j = y-width+1; j < y+width; j++) {
				if (i >= 0 && i < kafelki.size())
					if (j >= 0 && j < kafelki.get(i).size())
						kafelki.get(i).get(j).type = KafelekType.covered;
			}
		}
		
		for (int j = y-width; j < y+width+1; j++) {
			int i = x + width;
			//if (i >= 0 && i < kafelki.size())
				//if (j >= 0 && j < kafelki.get(i).size())
			kafelki.get(x + width).get(j).type = KafelekType.path;
			
			i = x - width;
			//if (i >= 0 && i < kafelki.size())
				//if (j >= 0 && j < kafelki.get(i).size())
			kafelki.get(x - width).get(j).type = KafelekType.path;
		}
		
		for (int j = x-width; j < x+width; j++) {
			int i = y + width;
			//if (i >= 0 && i < kafelki.size())
				//if (j >= 0 && j < kafelki.get(i).size())
			kafelki.get(j).get(y+width).type = KafelekType.path;
			
			i = y - width;
			//if (j >= 0 && j < kafelki.size())
				//if (i >= 0 && i < kafelki.get(i).size())
			kafelki.get(j).get(y-width).type = KafelekType.path;
		}
		
	}
	public void myCover(int x, int y) {
		
	}

	public void cover(int x, int y) {
		if (kafelki.get(x).get(y).type == KafelekType.normal) {
			//kafelki.get(x).get(y).type = KafelekType.covered;
		}
	}
	
	public boolean generatePath(Kafelek origin, int number, int r) {
		int myX = origin.x;
		int myY = origin.y;
		int tempX = 1, tempY = 0;
		float alfa = 0;
		/*
		//generowanie pozycji pocz¹tkowej do tworzenia sciezki
		for(int i = 1; i < r; i++) {
			tempX = (int) (Math.cos(alfa)*i);
			tempY = (int) (Math.sin(alfa)*i);
			//TODO
			//nie obsluguje przypadku natrafienia na rozga³êzienie
			// rozwi¹zanie: dodaæ KafelekType.covered
			while(kafelki.get(tempX+myX).get(tempY+myY).type == KafelekType.path && alfa < Math.PI*2) {
				alfa += 0.1f;
			}
		}
		*/
		//rysowanie sciezki
		float radius = r;
		float prealfa = alfa;
		alfa = 0;
		boolean ret = true;
		int firstX = 0;
		int firstY = 0;
		while (alfa < Math.PI*2) {
		//przeskok alfa do nastêpnego kafelka
			
			while(tempX == (int) (Math.cos(alfa+prealfa)*radius) && tempY == (int) (Math.sin(alfa+prealfa)*radius) && alfa < Math.PI*2) {
				alfa += 0.1f;
				for(int i = 1; i < radius; i++) {
					if (kafelki.get(myX+(int) (Math.cos(alfa+prealfa)*i)).get(myY+(int) (Math.sin(alfa+prealfa)*i)).type == KafelekType.normal) {
						kafelki.get(myX+(int) (Math.cos(alfa+prealfa)*i)).get(myY+(int) (Math.sin(alfa+prealfa)*i)).type = KafelekType.covered;
					}
				}
			}
			tempX = (int) (Math.cos(alfa+prealfa)*radius);
			tempY = (int) (Math.sin(alfa+prealfa)*radius);
			if (firstX == 0 && firstY == 0) {
				firstX = tempX;
				firstY = tempY;
			}
			if(kafelki.get(tempX+myX).get(tempY+myY).type != KafelekType.path && kafelki.get(tempX+myX).get(tempY+myY).type != KafelekType.covered) {
				kafelki.get(tempX+myX).get(tempY+myY).type = KafelekType.path;
			}
			else {
				if (tempX != firstX && tempY != firstY) {
					ret = false;
				}
			}
		}
		cover((int) (Math.cos(prealfa)*(radius-3)), (int) (Math.sin(prealfa)*(radius-3)));
		return ret;
		
	}
			
	
	public void generateOrigins(int width, int randomness, int delta) {
		for(int i = delta; i < width; i+=delta) {
			for(int j = delta; j < width; j+=delta) {
				kafelki.get(i).get(j).type = KafelekType.origin;
				origins.add(kafelki.get(i).get(j));
			}
		}
	}
	public void generate(int width) {
		for(int i = 0; i < width; i++) {
			kafelki.add(new ArrayList<Kafelek>());
			for(int j = 0; j < width; j++) {
				kafelki.get(i).add(new Kafelek(j, i, null, false, KafelekType.normal));
			}
		}
	}
}
