package test;

import java.awt.Color;
import java.util.ArrayList;

public abstract class Piece {

	protected Color color;
	protected ArrayList<Square> possibleSquares;
	
	public Color getColor(){ return color; }
	
	public void addPossibleSquares(Square s){ possibleSquares.add(s); }
	
}
