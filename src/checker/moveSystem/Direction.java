package checker.moveSystem;

import java.awt.Color;
import java.io.Serializable;
import java.util.ArrayList;

import components.Board;
import components.Square;

public abstract class Direction implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public abstract boolean isValidMove(Move m, Color c);
	public abstract ArrayList<Square> generateValidSquares(Square start, Board board);
	
}
