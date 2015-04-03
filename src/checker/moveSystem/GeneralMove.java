package checker.moveSystem;

import java.awt.Color;

public class GeneralMove {
	private Direction direction;
	private Displacement displacement;
	
	public Direction getDirection(){ return direction; }
	public Displacement getDisplacement(){ return displacement; }
	
	
	public boolean isValidMove(Move m, Color c){
		return direction.isValidMove(m, c) && displacement.isValidMove(m);
	}
}
