package checker.moveSystem;

import java.awt.Color;
import java.util.ArrayList;

import components.Board;
import components.Square;
import components.pieces.Pawn;

public class PawnDirection extends Direction {

	@Override
	public boolean isValidMove(Move m, Color c) {
		int dy = m.getEnd().getY() - m.getStart().getY();
		int dx = m.getEnd().getX() - m.getStart().getX();
		if(c.equals(Color.WHITE))
			return (dy > 0 && dx == 0)
					|| (dy == 1 && Math.abs(dx) == 1);
		else if(c.equals(Color.BLACK))
			return (dy < 0 && dx == 0)
					|| (dy == -1 && Math.abs(dx) == 1);
		else
			return false;
	}

	@Override
	public ArrayList<Square> generateValidSquares(Square start, Board board) {
		Pawn p;
		
		ArrayList<Square> ss = new ArrayList<Square>();
		
		if(start.getPiece() instanceof Pawn)
			p = (Pawn)start.getPiece();
		else{
			if(start.getPiece().getColor() == "White")
				ss.addAll(checkForAttackPossibility("White", start, board));
			else
				ss.addAll(checkForAttackPossibility("Black", start, board));
			return ss;
		}
		
		Square tmp;


		if(p.getColor() == "White"){
			tmp = board.getSquare(start.getX(), start.getY()+1);
			if(tmp.getPiece() == null) ss.add(tmp);
			if(!p.hasMoved() && !p.doubleStepped()){
				tmp = board.getSquare(start.getX(), start.getY()+2);
				if(tmp.getPiece() == null && board.getSquare(start.getX(), start.getY()+1).getPiece() == null) ss.add(tmp);
			}

			// En-Passant
			if(start.getY() == 4){
				tmp = board.getSquare(start.getX() - 1, start.getY());
				if(tmp.getPiece() != null && tmp.getPiece() instanceof Pawn && tmp.getPiece().getColor() == "Black"){
					Pawn x = (Pawn)tmp.getPiece();
					if(x.doubleStepped())
						ss.add(board.getSquare(start.getX()-1, start.getY()+1));
				}

				tmp = board.getSquare(start.getX() + 1, start.getY());
				if(tmp.getPiece() != null && tmp.getPiece() instanceof Pawn && tmp.getPiece().getColor() == "Black"){
					Pawn x = (Pawn)tmp.getPiece();
					if(x.doubleStepped())
						ss.add(board.getSquare(start.getX()+1, start.getY()+1));
				}
			}

			ss.addAll(checkForAttackPossibility("White", start, board));
		}
		else if(p.getColor() == "Black"){
			tmp = board.getSquare(start.getX(), start.getY()-1);
			if(tmp.getPiece() == null) ss.add(tmp);
			if(!p.hasMoved() && !p.doubleStepped()){
				tmp = board.getSquare(start.getX(), start.getY()-2);
				if(tmp.getPiece() == null && board.getSquare(start.getX(), start.getY()-1).getPiece() == null) ss.add(tmp);
			}


			// En-passant
			if(start.getY() == 3){
				tmp = board.getSquare(start.getX() - 1, start.getY());
				if(tmp.getPiece() != null && tmp.getPiece() instanceof Pawn && tmp.getPiece().getColor() == "White"){
					Pawn x = (Pawn)tmp.getPiece();
					if(x.doubleStepped())
						ss.add(board.getSquare(start.getX()-1, start.getY()-1));
				}

				tmp = board.getSquare(start.getX() + 1, start.getY());
				if(tmp.getPiece() != null && tmp.getPiece() instanceof Pawn && tmp.getPiece().getColor() == "White"){
					Pawn x = (Pawn)tmp.getPiece();
					if(x.doubleStepped())
						ss.add(board.getSquare(start.getX()+1, start.getY()-1));
				}
			}
			
			ss.addAll(checkForAttackPossibility("Black",  start, board));

		}
		return ss;
	}

	private ArrayList<Square> checkForAttackPossibility(String color, Square start, Board board){
		ArrayList<Square> ss = new ArrayList<Square>();
		// Attacking
		int i = (color == "Black")? -1: 1; 
		Square tmp = board.getSquare(start.getX()+1, start.getY()+i);
		if(tmp.getPiece() != null && tmp.getPiece().getColor() != color) ss.add(tmp);

		tmp = board.getSquare(start.getX()-1, start.getY()+i);
		if(tmp.getPiece() != null && tmp.getPiece().getColor() != color) ss.add(tmp);
		return ss;
	}


	@Override
	public boolean equals(Object obj) {
		return obj instanceof PawnDirection;
	}


}
