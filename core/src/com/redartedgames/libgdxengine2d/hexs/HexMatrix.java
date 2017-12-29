package com.redartedgames.libgdxengine2d.hexs;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

/** Zaimplementowana macierz sze�ciok�t�w foremnych. 
 * Pozwala na: za�adowanie hex�w, przesuwanie hex�w, do�adowywanie i zwalnianie wynikaj�ce z przesuwania kamery.
 * Logika generowania pojedyczych hex�w znajduje si� w HexGenerator i klasach pochodnych
 * TODO przesuwanie ca�ej macierzy i do�adowywanie hex�w
 * @author AconLight */
public class HexMatrix {
	
	/** tablica hex�w do wy�wietlania na ekranie **/
	private Hex[][] hexs;
	
	/** wymiary tablicy hex�w **/
	private int width, height;
	
	/** d�ugo�� boku hexa **/
	private int a;
	
	/** generator hex�w - zawiera logik� �adowania hex�w **/
	private HexGenerator hexGenerator;
	
	/** konstruktor **/
	public HexMatrix(int width, int height, int a) {
		this.width = width;
		this.height = height;
		this.a = a;
		hexGenerator = new HexGenerator();
	}
	
	/** aby zmieni� logik� �adowania si� hex�w, trzeba ustawi� inny generator **/
	public void setHexGenerator(HexGenerator hexGenerator) {
		this.hexGenerator = hexGenerator;
	}
	
	/** po odpaleniu konstruktora i ewentualnym ustawieniu generatora, trzeba odpali� inicjalizacj� **/
	public void initialize() {
		hexs = hexGenerator.initialize(width, height, a);
		hexGenerator.connectHexs(hexs, width, height);
	}
	
	/** odpala render na ka�dym z hex�w w macierzy **/
	public void render(ShapeRenderer batch) {
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				hexs[x][y].render(batch);
			}
		}
	}
	
	/** odpala render na ka�dym z hex�w w macierzy **/
	public void render(SpriteBatch batch) {
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				hexs[x][y].render(batch);
			}
		}
	}
	
}
