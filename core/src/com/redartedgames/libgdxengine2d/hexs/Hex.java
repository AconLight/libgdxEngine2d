package com.redartedgames.libgdxengine2d.hexs;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

/** Zaimplementowany szeœciok¹t foremny. 
 * Docelowo mo¿e byæ u¿yty do organizacji obiektów na siatce szeœciok¹tów w 2D. 
 * Domyœlna klasa zarz¹dzaj¹ca - HexMatrix
 * Klasy pochodne bêd¹ mog³y mieæ inne funkcje render
 * @author AconLight */
public class Hex {
	
	/** pozycje w tablicy[x][y] Hexów klasy zarz¹dzaj¹cej **/
	public int x, y;
	
	/** d³ugoœæ boku szeœciok¹ta **/
	private int a;
	
	/** pozycja do wyœwietlania na ekranie(x, y) **/
	private float realX, realY;
	
	/** referencja do s¹siedniego hexa **/
	public Hex leftUp, leftDown, up, down, rightUp, rightDown;
	
	public Hex(int x, int y, int a) {
		this.a = a;
		set(x, y);
	}
	
	public void set(int x, int y) {
		this.x = x;
		this.y = y;
		realX = x*a*2;
		realY = (float) (y*a*2 + x%2*Math.sqrt(3)/2*a); // co drugi hex na osi X musi byæ przesuniêty do góry
	}
	
	
	public void render(ShapeRenderer batch) {
		HexShapeRenderer.drawHex(batch, realX, realY, a);
	}
	
	public void render(SpriteBatch batch) {
		
	}

}
