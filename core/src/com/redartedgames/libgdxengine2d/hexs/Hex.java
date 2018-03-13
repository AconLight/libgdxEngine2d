package com.redartedgames.libgdxengine2d.hexs;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

/** Zaimplementowany sze�ciok�t foremny. 
 * Docelowo mo�e by� u�yty do organizacji obiekt�w na siatce sze�ciok�t�w w 2D. 
 * Domy�lna klasa zarz�dzaj�ca - HexMatrix
 * Klasy pochodne b�d� mog�y mie� inne funkcje render
 * @author AconLight */
public class Hex {
	
	/** pozycje w tablicy[x][y] Hex�w klasy zarz�dzaj�cej **/
	public int x, y;
	
	/** d�ugo�� boku sze�ciok�ta **/
	private int a;
	
	/** pozycja do wy�wietlania na ekranie(x, y) **/
	private float realX, realY;
	
	/** referencja do s�siedniego hexa **/
	public Hex leftUp, leftDown, up, down, rightUp, rightDown;
	
	public Hex(int x, int y, int a) {
		this.a = a;
		set(x, y);
	}
	
	public void set(int x, int y) {
		this.x = x;
		this.y = y;
		realX = x*a*2;
		realY = (float) (y*a*2 + x%2*Math.sqrt(3)/2*a); // co drugi hex na osi X musi by� przesuni�ty do g�ry
	}
	
	
	public void render(ShapeRenderer batch) {
		HexShapeRenderer.drawHex(batch, realX, realY, a);
	}
	
	public void render(SpriteBatch batch) {
		
	}

}
