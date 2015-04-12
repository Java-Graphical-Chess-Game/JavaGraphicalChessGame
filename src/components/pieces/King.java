package components.pieces;

import game.GameState;
import java.awt.Color;
import java.io.File;
import java.util.ArrayList;
import components.Board;
import components.Square;
import checker.moveSystem.*;


public class King extends Piece {
	

	private boolean moved = false; //TODO 
	private boolean castled = false; //TODO
	
	public King(Color c) {
		super(c);
		String filename = (color.equals(Color.BLACK))? "bking.png":"wking.png";
		imagePath = "icons" + File.separator + filename;
		generalmove = new GeneralMove(new AllDirection(), new SingleStepDisplacement());
	}


	public GameState isInDanger(Board board){

		GameState gs = GameState.NONE;

		Direction directions [] = {
				new StraightDirection(),
				new DiagonalDirection(),
				new AllDirection(),
				new LShapedDirection(),
				new PawnDirection()
		};

		Displacement displacements [] = {
				new SingleStepDisplacement(),
				new MultipleStepDisplacement()
		};

		GeneralMove gm;

		ArrayList <Square> threatSquares = new ArrayList<Square>();
		ArrayList <Square> temp = new ArrayList<Square>();
		
		for(Direction d : directions)
			for(Displacement dis : displacements){
				gm = new GeneralMove(d, dis);
				temp = askForSquares(board, gm, temp, false); // Attackers are too lazy to attack the king
												 			  // So the king will attack them instead
				for(Square tmp : temp){
					if(tmp.getPiece() != null
							&& tmp.getPiece().getColor()!=this.getColor()
							&& tmp.getPiece().getGeneralMove().equals(gm))
						threatSquares.add(tmp);
				}
			}
		if(threatSquares.isEmpty()) return gs;

		if(getColor() == "Black")
			gs = GameState.CHECK_BLACK;
		else
			gs = GameState.CHECK_WHITE;



		threatSquares.clear();
		return gs;
	}

}
