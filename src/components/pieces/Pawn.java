package components.pieces;

import java.awt.Color;
import java.io.File;

public class Pawn extends Piece {

	public Pawn(Color c) {
		super(c);
		String filename = (color.equals(Color.BLACK))? "bpawn.png":"wpawn.png";
		imagePath = "icons" + File.separator + filename;
	}

}
