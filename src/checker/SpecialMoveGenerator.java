package checker;

import java.io.Serializable;
import java.util.ArrayList;

import checker.moveSystem.Move;
import components.Board;
import components.Square;
import components.pieces.Piece;

public class SpecialMoveGenerator implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Board board;
	private ArrayList<Square> tmp;
	private boolean isSet;

	public SpecialMoveGenerator( Board b) {
		this.board = b;
		tmp = new ArrayList<Square>();
		isSet = false;
	}

	public void alter(ArrayList<Square> possibleSquares, Piece piece){
		
		if(tmp.isEmpty() && !isSet){
			tmp.addAll(possibleSquares);
			isSet = true;
		}

		ArrayList<Square> toRemove = new ArrayList<Square>();
		for(Square s : tmp){
			if(!attemptMoveTo(s, piece)){
				toRemove.add(s);
			}
		}
		tmp.removeAll(toRemove);
		possibleSquares.clear();
		possibleSquares.addAll(tmp);

		isSet = false;
		tmp.clear();

	}

	public boolean isSet(){ return isSet; }
	public void set(){ isSet = true; System.out.println("SET");}
	public void unset(){ isSet = false; System.out.println("UNSET");}

	private boolean attemptMoveTo(Square s, Piece piece) {
		return board.attemptMove(new Move(piece.getSquare(), s));
	}


}

























