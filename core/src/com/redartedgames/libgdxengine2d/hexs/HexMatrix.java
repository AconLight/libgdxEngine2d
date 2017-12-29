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
	public Hex[][] hexs;
	
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
	
	/** przesuwa macierz o dany x i dany y oraz uzupe³nia brakuj¹ce hexy za pomoc¹ hexGenerator **/
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
	
	/** odpala render na ka¿dym z hexów w macierzy **/
	public void render(ShapeRenderer batch) {
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				if (hexs[x][y] != null)
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
