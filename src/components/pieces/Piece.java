package components.pieces;


import java.awt.Color;
import java.util.ArrayList;

import components.Square;

public abstract class Piece {

	protected Color color;
	protected ArrayList<Square> possibleSquares;
	protected Square square;
	protected String imagePath = "";
	
	public Piece(Color c){
		this.color = c;
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
	public String getImagePath(){ return imagePath; }
	
	public void addPossibleSquare(Square s){ possibleSquares.add(s); }
}
