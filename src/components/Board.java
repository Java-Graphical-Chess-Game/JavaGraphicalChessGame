package components;

import game.Game;
import gui.GraphicalBoard;

import java.awt.Color;

import components.pieces.Piece;

import checker.moveSystem.Move;

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

	public void resetSquares() {
		for(Square ss[] : squares)
			for(Square s : ss)
				s.setColor();
		
	}

	public void executeMove(Move move) {
		if(move == null) return;
		Piece moved = move.getStart().getPiece();
		move.getStart().deletePiece();
		if(move.getEnd() != null)
			moved.setVictim(move.getEnd().deletePiece());
		move.getEnd().insertPiece(moved);
	}

	
	// for debugging
	public void redraw(){
		guiBoard.redraw();
	}
	
}
