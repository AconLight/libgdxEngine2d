package com.redartedgames.libgdxengine2d.hexs;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

/** Zaimplementowana macierz szeœciok¹tów foremnych. 
 * Pozwala na: za³adowanie hexów, przesuwanie hexów, do³adowywanie i zwalnianie wynikaj¹ce z przesuwania kamery.
 * Logika generowania pojedyczych hexów znajduje siê w HexGenerator i klasach pochodnych
 * TODO przesuwanie ca³ej macierzy i do³adowywanie hexów
 * @author AconLight */
public class HexMatrix {
	
	/** tablica hexów do wyœwietlania na ekranie **/
	private Hex[][] hexs;
	
	/** wymiary tablicy hexów **/
	private int width, height;
	
	/** d³ugoœæ boku hexa **/
	private int a;
	
	/** generator hexów - zawiera logikê ³adowania hexów **/
	private HexGenerator hexGenerator;
	
	/** konstruktor **/
	public HexMatrix(int width, int height, int a) {
		this.width = width;
		this.height = height;
		this.a = a;
		hexGenerator = new HexGenerator();
	}
	
	/** aby zmieniæ logikê ³adowania siê hexów, trzeba ustawiæ inny generator **/
	public void setHexGenerator(HexGenerator hexGenerator) {
		this.hexGenerator = hexGenerator;
	}
	
	/** po odpaleniu konstruktora i ewentualnym ustawieniu generatora, trzeba odpaliæ inicjalizacjê **/
	public void initialize() {
		hexs = hexGenerator.initialize(width, height, a);
		hexGenerator.connectHexs(hexs, width, height);
	}
	
	/** odpala render na ka¿dym z hexów w macierzy **/
	public void render(ShapeRenderer batch) {
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				hexs[x][y].render(batch);
			}
		}
	}
	
	/** odpala render na ka¿dym z hexów w macierzy **/
	public void render(SpriteBatch batch) {
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				hexs[x][y].render(batch);
			}
		}
	}
	
}
