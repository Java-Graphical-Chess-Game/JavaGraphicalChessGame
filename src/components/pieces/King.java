package components.pieces;

import java.awt.Color;
import java.io.File;


public class King extends Piece {

	public King(Color c) {
		super(c);
		String filename = (color.equals(Color.BLACK))? "bking.png":"wking.png";
		imagePath = "icons" + File.separator + filename;
	}

}
