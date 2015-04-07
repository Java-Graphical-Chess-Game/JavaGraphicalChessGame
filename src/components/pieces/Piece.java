package components.pieces;


import java.awt.Color;
import java.util.ArrayList;

import checker.moveSystem.GeneralMove;
import checker.moveSystem.Move;
import components.Board;
import components.Square;

public abstract class Piece {

	protected Color color;
	protected ArrayList<Square> possibleSquares;
	protected Square square;
	protected String imagePath = "";
	protected GeneralMove generalmove;
	protected Piece victim;
	
	public Piece(Color c){
		this.color = c;
		possibleSquares = new ArrayList<Square>();
	}
	
	
	
	public void askForSquares(Board board){
		resetSquares(); // reset colors
		generalmove.getDirection().generateValidSquares(square, board);
		ArrayList<Square> squaresToRemove = new ArrayList<Square>();
		
		for(Square s: possibleSquares)
			if(!generalmove.getDisplacement().isValidMove(new Move(square, s)))
				squaresToRemove.add(s);
		
		
		for(Square i : squaresToRemove)
			possibleSquares.remove(i);
		highlightSquares();
	}
	public void resetSquares(){possibleSquares.clear();}
	
	private void highlightSquares(){
		for(Square s : possibleSquares){
			s.setHighlighted();
		}
	}
	
	public String getColor(){ 
		if(color == Color.BLACK)
			return "Black";
		else if(color == Color.WHITE)
			return "White";
		else
			return "";
	}
	
	public Square getSquare(){ return square; }
	
	public void setSquare(Square square) {
		this.square = square;
	}
	
	public String getImagePath(){ return imagePath; }
	
	public void addPossibleSquare(Square s){ possibleSquares.add(s); }

	
	
	public void executeMove(Move move, Board board) {
		square = move.getEnd();
		board.executeMove(move);
		
	}



	public void setVictim(Piece victim) { this.victim = victim; }

}
