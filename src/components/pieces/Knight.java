package components.pieces;

import java.awt.Color;
import java.io.File;

public class Knight extends Piece {

	public Knight(Color c) {
		super(c);
		String filename = (color.equals(Color.BLACK))? "bknight.png":"wknight.png";
		imagePath = "icons" + File.separator + filename;
	}

}
