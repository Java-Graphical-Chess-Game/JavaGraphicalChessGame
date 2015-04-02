package components.pieces;

import java.awt.Color;
import java.io.File;

public class Rook extends Piece {

	public Rook(Color c) {
		super(c);
		String filename = (color.equals(Color.BLACK))? "brook.png":"wrook.png";
		imagePath = "icons" + File.separator + filename;
	}

}
