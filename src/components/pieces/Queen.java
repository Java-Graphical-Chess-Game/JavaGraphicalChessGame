package components.pieces;

import java.awt.Color;
import java.io.File;

public class Queen extends Piece {

	public Queen(Color c) {
		super(c);
		String filename = (color.equals(Color.BLACK))? "bqueen.png":"wqueen.png";
		imagePath = "icons" + File.separator + filename;
	}

}
