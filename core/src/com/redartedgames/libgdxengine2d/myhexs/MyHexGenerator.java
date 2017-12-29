package com.redartedgames.libgdxengine2d.myhexs;

import com.redartedgames.libgdxengine2d.hexs.Hex;
import com.redartedgames.libgdxengine2d.hexs.HexGenerator;

public class MyHexGenerator extends HexGenerator{

	public Hex[][] initialize(int width, int height, int a) {
		Hex[][] hexs = new MyHex[width][height];
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				hexs[x][y] = new MyHex(x, y, a);
			}
		}
		return hexs;
	}
	
	public void generateVerticalLine(Hex[][] hexs, int width, int height, int x, int a) {
		for (int y = 0; y < height; y++) {
			hexs[x][y] = new MyHex(x, y, a);
		}
	}
	
	public void generateHorizontalLine(Hex[][] hexs, int width, int height, int y, int a) {
		for (int x = 0; x < width; x++) {
			hexs[x][y] = new MyHex(x, y, a);
		}
	}
	
}
