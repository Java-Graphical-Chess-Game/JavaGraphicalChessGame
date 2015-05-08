package components.pieces;

import java.awt.Color;
import java.io.File;

import checker.moveSystem.GeneralMove;
import checker.moveSystem.DiagonalDirection;
import checker.moveSystem.MultipleStepDisplacement;

public class Bishop extends Piece {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Bishop(Color c) {
		super(c);
		String filename = (color.equals(Color.BLACK))? "bbishop.png":"wbishop.png";
		imagePath = "icons" + File.separator + filename;
		generalmove = new GeneralMove(new DiagonalDirection(), new MultipleStepDisplacement());
	}

}
