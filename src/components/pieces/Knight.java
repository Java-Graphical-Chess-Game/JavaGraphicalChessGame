package components.pieces;

import java.awt.Color;
import java.io.File;

import checker.moveSystem.GeneralMove;
import checker.moveSystem.LShapedDirection;
import checker.moveSystem.MultipleStepDisplacement;

public class Knight extends Piece {

	public Knight(Color c) {
		super(c);
		String filename = (color.equals(Color.BLACK))? "bknight.png":"wknight.png";
		imagePath = "icons" + File.separator + filename;
		generalmove = new GeneralMove(new LShapedDirection(), new MultipleStepDisplacement());
	}

}
