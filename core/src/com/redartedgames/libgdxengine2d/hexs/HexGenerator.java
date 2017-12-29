package com.redartedgames.libgdxengine2d.hexs;

/** Klasa podstawowa, w kt�rej trzymamy logik� generowania si� hex�w.
 * Klasy rozszerzaj�ce b�d� zawiera� fiku�ne funkcje generuj�ce odpowiednie hexy,
 * natomiast ta podstawowa klasa po prostu inicjalizycje ka�dego hexa jako Hex
 * TODO system do�adowywania hex�w w zwi�zku z przesuwaniem kamerki
 * @author AconLight */
public class HexGenerator {
	
	/** zwraca zainicjalizowane hexy **/
	public Hex[][] initialize(int width, int height, int a) {
		Hex[][] hexs = new Hex[width][height];
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				hexs[x][y] = new Hex(x, y, a);
			}
		}
		return hexs;
	}
	
	/** ustawienie po��cze� mi�dzy hexami
	 * to b�dzie szczeg�lnie przydatne przy generowaniu grafik hex�w i przy animacji **/
	public void connectHexs(Hex[][] hexs, int width, int height) {
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				if (y >= 1) {
					hexs[x][y].down = hexs[x][y-1];
					hexs[x][y-1].up = hexs[x][y];
					if (x >= 1) {
						hexs[x][y].leftDown = hexs[x-1][y-1];
						hexs[x-1][y-1].rightUp = hexs[x][y];
						hexs[x][y].leftUp = hexs[x-1][y];
						hexs[x-1][y].rightDown = hexs[x][y];
					}
				}
				else {
					if (x >= 1) {
						hexs[x][y].leftUp = hexs[x-1][y];
						hexs[x-1][y].rightDown = hexs[x][y];
					}
				}
			}
		}
	}
	
	//TODO
	public Hex[] generateVerticalLine() {
		return null;
	}
}
