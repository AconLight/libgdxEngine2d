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
	public Hex[][] hexs;
	
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
	
	/** przesuwa macierz o dany x i dany y oraz uzupe�nia brakuj�ce hexy za pomoc� hexGenerator **/
	public void moveMatrix(int x, int y) {
		Hex hex;
		//przesuwanie na osi X
		if (x > 0) {
			for(int xx = width-1; xx >= 0; xx--) {
				for(int yy = 0; yy < height; yy++) {
					if (xx+x < width) {
						hexs[xx+x][yy] = hexs[xx][yy];
						hexs[xx+x][yy].set(xx+x, yy);
					}
				}
			}
			for(int i = 0; i < x; i++) {
				hexGenerator.generateVerticalLine(hexs, width, height, i, a);
			}
		}
		else if(x < 0) {
			for(int xx = 0; xx < width; xx++) {
				for(int yy = 0; yy < height; yy++) {
					if (xx+x >= 0) {
						hexs[xx+x][yy] = hexs[xx][yy];
						hexs[xx+x][yy].set(xx+x, yy);
					}
				}
			}
			for(int i = 0; i > x; i--) {
				hexGenerator.generateVerticalLine(hexs, width, height, width+i-1, a);
			}
		}
		
		//przesuwanie na osi Y
		if (y > 0) {
			for(int yy = height-1; yy >= 0; yy--) {
				for(int xx = 0; xx < width; xx++) {
					if (yy+y < height) {
						hexs[xx][yy+y] = hexs[xx][yy];
						hexs[xx][yy+y].set(xx, yy+y);
					}
				}
			}
			for(int i = 0; i < y; i++) {
				hexGenerator.generateHorizontalLine(hexs, width, height, i, a);
			}
		}
		else if(y < 0) {
			for(int yy = 0; yy < height; yy++) {
				for(int xx = 0; xx < width; xx++) {
					if (yy+y >= 0) {
						hexs[xx][yy+y] = hexs[xx][yy];
						hexs[xx][yy+y].set(xx, yy+y);
					}
				}
			}
			for(int i = 0; i > y; i--) {
				hexGenerator.generateHorizontalLine(hexs, width, height, height+i-1, a);
			}
		}		
	}
	
	/** odpala render na ka�dym z hex�w w macierzy **/
	public void render(ShapeRenderer batch) {
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				if (hexs[x][y] != null)
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
