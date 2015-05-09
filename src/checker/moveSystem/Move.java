package checker.moveSystem;

import java.io.Serializable;

import components.Square;
import components.pieces.Piece;

public class Move implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Square start, end;
    private Piece current;
	private Piece victim;
 public Piece getCurrentPiece(){
	 return this.current;
 }
	
	public Move(Square start, Square end){
		if (start.equals(end))
			return;
		 this.start=start;
		 this.end=end;
		 this.current=start.getPiece();
			
	}
	
	public Piece getVictim(){ return victim; }
	public void setVictim(Piece victim) { this.victim = victim; };
	
	
	/**
	 * @return the start square
	 */
	public Square getStart() {
		return start;
	}

	/**
	 * @return the end square
	 */
	public Square getEnd() {
		return end;
	}

	public void reverse() {
		this.start.setPiece(this.end.deletePiece());
		this.start.getPiece().setSquare(start);
		if(this.victim != null){
			this.end.setPiece(victim);
			victim.setSquare(this.end);
		}
		
	}

}
