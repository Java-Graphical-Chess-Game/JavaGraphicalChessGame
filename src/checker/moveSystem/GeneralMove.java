package checker.moveSystem;

import java.awt.Color;
import java.io.Serializable;

public class GeneralMove implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Displacement displacement;
	private Direction direction;
	
	public GeneralMove(Direction direction, Displacement displacement){
		
		this.direction=direction;
		this.displacement=displacement;
	}

	public boolean isValidMove(Move m, Color c){
		return displacement.isValidMove(m) && direction.isValidMove(m, c);
	}

	public Displacement getDisplacement() { return displacement; }
	public Direction getDirection() { return direction; }
	
	
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof GeneralMove))
			return false;
		GeneralMove tmp = (GeneralMove)obj;
		
		return tmp.direction.equals(direction) && tmp.displacement.equals(displacement);
	}
	
}