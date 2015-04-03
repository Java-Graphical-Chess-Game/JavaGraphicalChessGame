package components.pieces;

import java.awt.Color;
import java.io.File;

import checker.GeneralMove;
import checker.moveSystem.AllDirection;
import checker.moveSystem.SingleStepDisplacement;


public class King extends Piece {

	public King(Color c) {
		super(c);
		String filename = (color.equals(Color.BLACK))? "bking.png":"wking.png";
		imagePath = "icons" + File.separator + filename;
		generalmove = new GeneralMove(new AllDirection(), new SingleStepDisplacement());
	}

}
