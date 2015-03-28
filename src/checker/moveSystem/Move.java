package checker.moveSystem;

import components.Square;

public class Move {
	private Square start, end;

	
	public Move(Square start, Square end){
		if (start.equals(end))
			return;
		 this.start=start;
		 this.end=end;
			
	}
	
	
	/**
	 * @return the start
	 */
	public Square getStart() {
		return start;
	}

	/**
	 * @return the end
	 */
	public Square getEnd() {
		return end;
	}
	
}
