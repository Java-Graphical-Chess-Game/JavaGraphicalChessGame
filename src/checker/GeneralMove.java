package checker;

import java.awt.Color;

import checker.moveSystem.Direction;
import checker.moveSystem.Displacement;
import checker.moveSystem.Move;

public class GeneralMove {
	private Direction direction;
	private Displacement displacement;
	
	public Direction getDirection(){ return direction; }
	public Displacement getDisplacement(){ return displacement; }
	
	
	public GeneralMove(Direction d, Displacement ds){
		direction = d;
		displacement = ds;
	}
	
	public boolean isValidMove(Move m, Color c){
		return direction.isValidMove(m, c) && displacement.isValidMove(m);
	}
}
