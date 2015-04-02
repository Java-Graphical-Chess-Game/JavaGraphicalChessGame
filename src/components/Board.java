package components;

import game.Game;
import gui.GraphicalBoard;

import java.awt.Color;

public class Board {
	
	protected Square squares [][] = new Square[8][8];
	private GraphicalBoard guiBoard = new GraphicalBoard(this);
	private Game game;
	
	public Board(Game game){
		this.game = game;
		for(int i=0; i<8; i++)
			for(int j=0; j<8; j++)
				squares[i][j] = new Square(i*Square.SQUARE_SIZE, j*Square.SQUARE_SIZE, i, j);
	}
	
	public Game getGame(){ return game; }
	public GraphicalBoard getGraphicalBoard(){ return guiBoard; }
	public Square getSquare(int x, int y){
		try{
			return squares[x][y];
		}catch(ArrayIndexOutOfBoundsException e){
			return Square.INEXISTANT;
		}
	}

	public Color getCurrentColor() {
		// TODO Let the board know who's playing (which color)
		return null;
	}

}
