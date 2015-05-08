package checker;

import java.io.Serializable;
import java.util.HashMap;

import components.Board;
import components.Square;
import components.pieces.Piece;

public class Memento implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static Board board;
	private static HashMap<Piece, Square> piecesPositions = new HashMap<Piece, Square>();
	
	public static void setMemento(Board b){
		board = b;
		setState();
	}
	
	private static void setState(){
		for(Square s : board.getSquares())
			piecesPositions.put(s.getPiece().clone(), s);
	}
	
	public Board retrieveState(){
		for(Piece p : piecesPositions.keySet()){
			//board.
		}
		return null;
	}
	
}
