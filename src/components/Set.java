package components;

import java.awt.Color;
import java.util.HashMap;
import components.pieces.*;

public class Set {

	private Color color;
	private HashMap<Piece, Square> piecesPositions;
	private Board board;
	private King king;
	
	
	public Set(Color c, Board board) {
		this.color = c;
		this.board = board;
		if(c.equals(Color.BLACK))
				createBlackSet();
		else if(c.equals(Color.WHITE))
				createWhiteSet();
		else
			return;
	}
	
	public Color getColor(){ return color; }
	
	public Square getPositionOf(Piece p){
		return piecesPositions.get(p);
	}
	
	public King getKing(){
		return king;
	}
	
	private void createWhiteSet(){
		king = new King(Color.WHITE);
		piecesPositions = new HashMap<Piece, Square>();
		piecesPositions.put(          king,		 		board.getSquare(4, 0));    
		piecesPositions.put(new Queen(Color.WHITE), 	board.getSquare(3, 0));    
		piecesPositions.put(new Rook(Color.WHITE), 		board.getSquare(7, 0));    
		piecesPositions.put(new Knight(Color.WHITE), 	board.getSquare(6, 0));    
		piecesPositions.put(new Bishop(Color.WHITE), 	board.getSquare(5, 0));    
		piecesPositions.put(new Rook(Color.WHITE), 		board.getSquare(0, 0));    
		piecesPositions.put(new Knight(Color.WHITE), 	board.getSquare(1, 0));    
		piecesPositions.put(new Bishop(Color.WHITE), 	board.getSquare(2, 0));    
		piecesPositions.put(new Pawn(Color.WHITE), 	 	board.getSquare(7, 1));    
		piecesPositions.put(new Pawn(Color.WHITE), 		board.getSquare(6, 1));    
		piecesPositions.put(new Pawn(Color.WHITE), 		board.getSquare(5, 1));    
		piecesPositions.put(new Pawn(Color.WHITE), 		board.getSquare(4, 1));    
		piecesPositions.put(new Pawn(Color.WHITE), 		board.getSquare(3, 1));    
		piecesPositions.put(new Pawn(Color.WHITE), 		board.getSquare(2, 1));    
		piecesPositions.put(new Pawn(Color.WHITE), 		board.getSquare(1, 1));    
		piecesPositions.put(new Pawn(Color.WHITE), 		board.getSquare(0, 1));    
	}                                                                              
	                                                                               
	private void createBlackSet(){                                                 
		piecesPositions = new HashMap<Piece, Square>();   
		king = new King(Color.BLACK);
		piecesPositions.put(          king,		 		board.getSquare(4, 7));    
		piecesPositions.put(new Queen(Color.BLACK), 	board.getSquare(3, 7));    
		piecesPositions.put(new Rook(Color.BLACK), 		board.getSquare(7, 7));    
		piecesPositions.put(new Knight(Color.BLACK), 	board.getSquare(6, 7));    
		piecesPositions.put(new Bishop(Color.BLACK), 	board.getSquare(5, 7));    
		piecesPositions.put(new Rook(Color.BLACK), 		board.getSquare(0, 7));    
		piecesPositions.put(new Knight(Color.BLACK), 	board.getSquare(1, 7));    
		piecesPositions.put(new Bishop(Color.BLACK), 	board.getSquare(2, 7));    
		piecesPositions.put(new Pawn(Color.BLACK), 		board.getSquare(7, 6));    
		piecesPositions.put(new Pawn(Color.BLACK), 	 	board.getSquare(6, 6));    
		piecesPositions.put(new Pawn(Color.BLACK), 		board.getSquare(5, 6));    
		piecesPositions.put(new Pawn(Color.BLACK), 		board.getSquare(4, 6));    
		piecesPositions.put(new Pawn(Color.BLACK), 		board.getSquare(3, 6));    
		piecesPositions.put(new Pawn(Color.BLACK), 		board.getSquare(2, 6));    
		piecesPositions.put(new Pawn(Color.BLACK), 		board.getSquare(1, 6));    
		piecesPositions.put(new Pawn(Color.BLACK), 		board.getSquare(0, 6));    
	}

	
	public void placePieces() {
		int x, y;
		for(Piece p : piecesPositions.keySet()){
			x = piecesPositions.get(p).getX();
			y = piecesPositions.get(p).getY();
			board.squares[x][y].piece = p;
			p.setSquare(board.squares[x][y]);
		}

	}
	
}
