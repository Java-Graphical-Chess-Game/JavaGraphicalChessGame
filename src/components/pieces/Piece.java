package components.pieces;


import java.awt.Color;
import java.util.ArrayList;

import checker.SpecialMoveGenerator;
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
		askForSquares(board, generalmove, true);
	}

	public void askForSquares(Board board, GeneralMove gm, boolean graphicalWork){
		askForSquares(board, generalmove, possibleSquares, graphicalWork);
	}
	
	public ArrayList<Square> askForSquares(Board board, GeneralMove gm, ArrayList<Square> list, boolean graphicalWork){
		resetSquares(); // reset possible squares for this piece.
		list = gm.getDirection().generateValidSquares(square, board);
		ArrayList<Square> squaresToRemove = new ArrayList<Square>();

		for(Square s: list)
			if(!gm.getDisplacement().isValidMove(new Move(square, s)))
				squaresToRemove.add(s);

		list.removeAll(squaresToRemove);

		SpecialMoveGenerator smg = board.getGame().getSMG();
		if(board.getGame().getGameState().contains("Check") && !smg.isSet()){
			
			smg.alter(list, this);
		}

		if(graphicalWork){
			possibleSquares = list;
			highlightSquares();
		}
		return list;
	}

	public GeneralMove getGeneralMove(){ return generalmove; }

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



	public void nullifySquare() {
		square = Square.INEXISTANT;

	}

}
