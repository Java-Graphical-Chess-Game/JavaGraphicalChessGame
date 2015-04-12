package components.pieces;

import java.awt.Color;
import java.io.File;

import checker.moveSystem.GeneralMove;
import checker.moveSystem.MultipleStepDisplacement;
import checker.moveSystem.StraightDirection;

public class Rook extends Piece {

	private boolean moved = false;
	private boolean castled = false;
	
	public Rook(Color c) {
		super(c);
		String filename = (color.equals(Color.BLACK))? "brook.png":"wrook.png";
		imagePath = "icons" + File.separator + filename;
		generalmove = new GeneralMove(new StraightDirection(), new MultipleStepDisplacement());
	}

}
