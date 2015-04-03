package components.pieces;

import java.awt.Color;
import java.io.File;

import checker.GeneralMove;
import checker.moveSystem.MultipleStepDisplacement;
import checker.moveSystem.StraightDirection;

public class Rook extends Piece {

	public Rook(Color c) {
		super(c);
		String filename = (color.equals(Color.BLACK))? "brook.png":"wrook.png";
		imagePath = "icons" + File.separator + filename;
		generalmove = new GeneralMove(new StraightDirection(), new MultipleStepDisplacement());
	}

}
