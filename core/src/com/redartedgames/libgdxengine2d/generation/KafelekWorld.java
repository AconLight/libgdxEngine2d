package com.redartedgames.libgdxengine2d.generation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import com.redartedgames.libgdxengine2d.objects.Kafelek;
import com.redartedgames.libgdxengine2d.objects.Kafelek.KafelekType;

public class KafelekWorld {
	public ArrayList<ArrayList<Kafelek>> kafelki;
	public ArrayList<Kafelek> origins;
	public ArrayList<Kafelek> paths;
	private Random g;
	
	public KafelekWorld(int width) {
		g = new Random();
		kafelki = new ArrayList<ArrayList<Kafelek>>();
		origins = new ArrayList<Kafelek>();
		generate(width);
		generateOrigins(width, 0, 45);
		Collections.shuffle(origins);
		for (Kafelek k : origins) {
			generateSquares(k.x, k.y, 25);
		}
		for (Kafelek k : origins) {
			generateSquares(k.x, k.y, 10 + g.nextInt(4));
		}
		for (Kafelek k : origins) {
			generateSquares(k.x, k.y, 4 + g.nextInt(2));
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
		/////////////////////////////////
		//dol
		for (int i = -3; i < width*2+4 ; i++) {
			kafelki.get(x-width-1).get(y-width+i).type = KafelekType.path;
			kafelki.get(x-width-2).get(y-width+i).type = KafelekType.path;
			kafelki.get(x-width-3).get(y-width+i).type = KafelekType.path;
		}
		
		for (int j = y-width + 5 + g.nextInt(3); j < y+width;) {
			int a = g.nextInt(4) + 4;
			
			
			for (int i = 1; i < a-1; i++) {
				kafelki.get(x-width-1).get(j+i-5).type = KafelekType.covered;
				kafelki.get(x-width-2).get(j+i-5).type = KafelekType.covered;
				//kafelki.get(x-width-3).get(j+i-5).type = KafelekType.path;
			}
			int b = g.nextInt(a-1)+1;
			
			kafelki.get(x-width-1).get(j+b-5).type = KafelekType.covered;
			kafelki.get(x-width-2).get(j+b-5).type = KafelekType.covered;
			kafelki.get(x-width-3).get(j+b-5).type = KafelekType.covered;
			
			kafelki.get(x-width-1).get(j+b-6).type = KafelekType.covered;
			kafelki.get(x-width-2).get(j+b-6).type = KafelekType.covered;
			kafelki.get(x-width-3).get(j+b-6).type = KafelekType.covered;
			
			int c = g.nextInt(5);
			for (int i = 0; i < c+1; i++) {
				kafelki.get(x-width-1).get(j+i-5+a).type = KafelekType.path;
				kafelki.get(x-width-2).get(j+i-5+a).type = KafelekType.path;
				kafelki.get(x-width-3).get(j+i-5+a).type = KafelekType.path;
			}
			
			j += a + c+1;
		}
		
		////////////////////////////////
		//gora
		
		for (int i = -3; i < width*2+4 ; i++) {
			kafelki.get(x+width+1).get(y-width+i).type = KafelekType.path;
			kafelki.get(x+width+2).get(y-width+i).type = KafelekType.path;
			kafelki.get(x+width+3).get(y-width+i).type = KafelekType.path;
		}
		
		for (int j = y-width + 5 + g.nextInt(3); j < y+width;) {
			int a = g.nextInt(4) + 4;
			
			
			for (int i = 1; i < a-1; i++) {
				kafelki.get(x+width+1).get(j+i-5).type = KafelekType.covered;
				kafelki.get(x+width+2).get(j+i-5).type = KafelekType.covered;
				//kafelki.get(x-width-3).get(j+i-5).type = KafelekType.path;
			}
			int b = g.nextInt(a-1)+1;
			
			kafelki.get(x+width+1).get(j+b-5).type = KafelekType.covered;
			kafelki.get(x+width+2).get(j+b-5).type = KafelekType.covered;
			kafelki.get(x+width+3).get(j+b-5).type = KafelekType.covered;
			
			kafelki.get(x+width+1).get(j+b-6).type = KafelekType.covered;
			kafelki.get(x+width+2).get(j+b-6).type = KafelekType.covered;
			kafelki.get(x+width+3).get(j+b-6).type = KafelekType.covered;
			
			int c = g.nextInt(5);
			for (int i = 0; i < c+1; i++) {
				kafelki.get(x+width+1).get(j+i-5+a).type = KafelekType.path;
				kafelki.get(x+width+2).get(j+i-5+a).type = KafelekType.path;
				kafelki.get(x+width+3).get(j+i-5+a).type = KafelekType.path;
			}
			
			j += a + c+1;
		}
		
		
		
		//////////////////////////////////////////////
		//////////////////////////////
		///lewo prawo
		
		
/////////////////////////////////
//dol
for (int i = -3; i < width*2+4 ; i++) {
kafelki.get(y-width+i).get(x-width-1).type = KafelekType.path;
kafelki.get(y-width+i).get(x-width-2).type = KafelekType.path;
kafelki.get(y-width+i).get(x-width-3).type = KafelekType.path;
}

for (int j = y-width + 5 + g.nextInt(3); j < y+width;) {
int a = g.nextInt(4) + 4;


for (int i = 1; i < a-1; i++) {
kafelki.get(j+i-5).get(x-width-1).type = KafelekType.covered;
kafelki.get(j+i-5).get(x-width-2).type = KafelekType.covered;
//kafelki.get(x-width-3).get(j+i-5).type = KafelekType.path;
}
int b = g.nextInt(a-1)+1;

kafelki.get(j+b-5).get(x-width-1).type = KafelekType.covered;
kafelki.get(j+b-5).get(x-width-2).type = KafelekType.covered;
kafelki.get(j+b-5).get(x-width-3).type = KafelekType.covered;

kafelki.get(j+b-6).get(x-width-1).type = KafelekType.covered;
kafelki.get(j+b-6).get(x-width-2).type = KafelekType.covered;
kafelki.get(j+b-6).get(x-width-3).type = KafelekType.covered;

int c = g.nextInt(5);
for (int i = 0; i < c+1; i++) {
kafelki.get(j+i-5+a).get(x-width-1).type = KafelekType.path;
kafelki.get(j+i-5+a).get(x-width-2).type = KafelekType.path;
kafelki.get(j+i-5+a).get(x-width-3).type = KafelekType.path;
}

j += a + c+1;
}

////////////////////////////////
//gora
/*
for (int i = -3; i < width*2+4 ; i++) {
kafelki.get(x+width+1).get(y-width+i).type = KafelekType.path;
kafelki.get(x+width+2).get(y-width+i).type = KafelekType.path;
kafelki.get(x+width+3).get(y-width+i).type = KafelekType.path;
}

for (int j = y-width + 5 + g.nextInt(3); j < y+width;) {
int a = g.nextInt(4) + 4;


for (int i = 1; i < a-1; i++) {
kafelki.get(x+width+1).get(j+i-5).type = KafelekType.covered;
kafelki.get(x+width+2).get(j+i-5).type = KafelekType.covered;
//kafelki.get(x-width-3).get(j+i-5).type = KafelekType.path;
}
int b = g.nextInt(a-1)+1;

kafelki.get(x+width+1).get(j+b-5).type = KafelekType.covered;
kafelki.get(x+width+2).get(j+b-5).type = KafelekType.covered;
kafelki.get(x+width+3).get(j+b-5).type = KafelekType.covered;

kafelki.get(x+width+1).get(j+b-6).type = KafelekType.covered;
kafelki.get(x+width+2).get(j+b-6).type = KafelekType.covered;
kafelki.get(x+width+3).get(j+b-6).type = KafelekType.covered;

int c = g.nextInt(5);
for (int i = 0; i < c+1; i++) {
kafelki.get(x+width+1).get(j+i-5+a).type = KafelekType.path;
kafelki.get(x+width+2).get(j+i-5+a).type = KafelekType.path;
kafelki.get(x+width+3).get(j+i-5+a).type = KafelekType.path;
}

j += a + c+1;
}
	*/	
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
		for(int i = 30; i < width; i+=delta) {
			for(int j = 30; j < width; j+=delta) {
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
