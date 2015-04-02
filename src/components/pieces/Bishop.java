package components.pieces;

import java.awt.Color;
import java.io.File;

public class Bishop extends Piece {

	public Bishop(Color c) {
		super(c);
		String filename = (color.equals(Color.BLACK))? "bbishop.png":"wbishop.png";
		imagePath = "icons" + File.separator + filename;
	}

}
