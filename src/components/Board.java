package components;

import java.awt.Color;

public class Board {
	
	private Square squares [][] = new Square[8][8];
	
	
	public Square getSquare(int x, int y){
		return squares[x][y];
	}

	public Color getCurrentColor() {
		// TODO Let the board know who's playing (which color)
		return null;
	}

}
