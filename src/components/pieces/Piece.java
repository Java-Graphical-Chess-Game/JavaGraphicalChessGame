package components.pieces;


import java.awt.Color;
import java.util.ArrayList;

import components.Square;

public abstract class Piece {

	protected Color color;
	protected ArrayList<Square> possibleSquares;
	
	public String getColor(){ 
		if(color == Color.BLACK)
			return "Black";
		else if(color == Color.WHITE)
			return "White";
		else
			return "";
	}
	
	public void addPossibleSquare(Square s){ possibleSquares.add(s); }
}
