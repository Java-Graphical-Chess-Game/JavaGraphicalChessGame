package components;


import java.awt.Color;
import java.io.Serializable;
import java.util.Vector;
import components.pieces.Piece;

public class Player implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Set set;
	private Color color;
	private Vector<Piece> takenPieces;
	
	public Player(Color c, Board board){
		this.color = c;
		set = new Set(c, board);
		takenPieces = new Vector<Piece>();
	}
	
	public Color getColor() { return color; }
	public Set getSet() { return set; }
	
	public void addToTaken(Piece p){
		takenPieces.add(p);
	}
	
	public Vector<Piece> getTakenPieces(){ return takenPieces; }
	
}
