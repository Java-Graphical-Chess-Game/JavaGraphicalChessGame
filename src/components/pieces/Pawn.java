package components.pieces;

import java.awt.Color;
import java.io.File;

public class Pawn extends Piece {

	private boolean moved = false;
	private boolean doubleStepped = false;
	
	public Pawn(Color c) {
		super(c);
		String filename = (color.equals(Color.BLACK))? "bpawn.png":"wpawn.png";
		imagePath = "icons" + File.separator + filename;
	}

	public void setMoved(){ moved = true; }
	public void setDoubleStepped(){ doubleStepped = true; }
	
	public boolean hasMoved(){ return moved; }
	public boolean doubleStepped(){ return doubleStepped; }
	
}
