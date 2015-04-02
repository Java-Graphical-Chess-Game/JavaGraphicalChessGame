package checker.moveSystem;

import java.awt.Color;

public class GenaralMove{
	private Displacement displacement;
	private Direction direction;
//constructor
	public GenaralMove(Direction direction, Displacement displacement){
		
		this.direction=direction;
		this.displacement=displacement;
	}

	public boolean isValidMove(Move m, Color c){
		return displacement.isValidMove(m) && direction.isValidMove(m, c);//chain of command design patterns
	}
}