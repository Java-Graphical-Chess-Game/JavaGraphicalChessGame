package test;

public class Board {
	Square squares [][] = new Square[8][8];
	
	
	public Square getSquare(int x, int y){
		return squares[x][y];
	}
}
