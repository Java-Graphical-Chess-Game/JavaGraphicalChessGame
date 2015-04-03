package components.pieces;

import java.awt.Color;
import java.io.File;

import components.Board;

import checker.GeneralMove;
import checker.moveSystem.DoubleStepDisplacement;
import checker.moveSystem.Move;
import checker.moveSystem.PawnDirection;
import checker.moveSystem.SingleStepDisplacement;

public class Pawn extends Piece {

	private boolean moved = false;
	private boolean doubleStepped = false;
	
	public Pawn(Color c) {
		super(c);
		String filename = (color.equals(Color.BLACK))? "bpawn.png":"wpawn.png";
		imagePath = "icons" + File.separator + filename;
		generalmove = new GeneralMove(new PawnDirection(), new DoubleStepDisplacement());
	}

	public void setMoved(){ 
		moved = true;
		generalmove = new GeneralMove(new PawnDirection(), new SingleStepDisplacement());
	}
	public void setDoubleStepped(){ 
		doubleStepped = true;
		generalmove = new GeneralMove(new PawnDirection(), new SingleStepDisplacement());
	}
	
	public boolean hasMoved(){ return moved; }
	public boolean doubleStepped(){ return doubleStepped; }
	
	@Override
	public void executeMove(Move move, Board board) {
		super.executeMove(move, board);
		setMoved();
		if(generalmove.getDisplacement().isValidMove(move)) doubleStepped = true;
	}
	
}
