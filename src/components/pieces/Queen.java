package components.pieces;

import java.awt.Color;
import java.io.File;

import checker.moveSystem.GeneralMove;
import checker.moveSystem.AllDirection;
import checker.moveSystem.MultipleStepDisplacement;

public class Queen extends Piece {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Queen(Color c) {
		super(c);
		String filename = (color.equals(Color.BLACK))? "bqueen.png":"wqueen.png";
		imagePath = "icons" + File.separator + filename;
		generalmove = new GeneralMove(new AllDirection(), new MultipleStepDisplacement());
	}

}
