package checker.moveSystem;

import java.awt.Color;

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
	public void generateValidSquares(Square start, Board board) {
		Pawn p = (Pawn)start.getPiece();
		Square tmp;
		if(p.getColor() == "White"){
			tmp = board.getSquare(start.getX(), start.getY()+1);
			if(tmp.getPiece() == null) p.addPossibleSquare(tmp);
			if(!p.hasMoved() && !p.doubleStepped()){
				tmp = board.getSquare(start.getX(), start.getY()+2);
				if(tmp.getPiece() == null) p.addPossibleSquare(tmp);
			}
			
			// Attacking
			tmp = board.getSquare(start.getX()+1, start.getY()+1);
			if(tmp.getPiece() != null && tmp.getPiece().getColor() == "Black") p.addPossibleSquare(tmp);
			
			tmp = board.getSquare(start.getX()-1, start.getY()+1);
			if(tmp.getPiece() != null && tmp.getPiece().getColor() == "Black") p.addPossibleSquare(tmp);
			
			// En-Passant TODO FIX, Wrong
			tmp = board.getSquare(start.getX() - 1, start.getY());
			if(tmp.getPiece() != null && tmp.getPiece().getColor() == "Black")
				p.addPossibleSquare(board.getSquare(start.getX()-1, start.getY()+1));
			
			tmp = board.getSquare(start.getX() + 1, start.getY());
			if(tmp.getPiece() != null && tmp.getPiece().getColor() == "Black")
				p.addPossibleSquare(board.getSquare(start.getX()+1, start.getY()+1));
		}
		else if(p.getColor() == "Black"){
			tmp = board.getSquare(start.getX(), start.getY()-1);
			if(tmp.getPiece() == null) p.addPossibleSquare(tmp);
			if(!p.hasMoved() && !p.doubleStepped()){
				tmp = board.getSquare(start.getX(), start.getY()-2);
				if(tmp.getPiece() == null) p.addPossibleSquare(tmp);
			}
			
			// Attacking
			tmp = board.getSquare(start.getX()+1, start.getY()-1);
			if(tmp.getPiece() != null && tmp.getPiece().getColor() == "White") p.addPossibleSquare(tmp);
			
			tmp = board.getSquare(start.getX()-1, start.getY()-1);
			if(tmp.getPiece() != null && tmp.getPiece().getColor() == "White") p.addPossibleSquare(tmp);
			
			// En passant TODO FIX, Wrong
			tmp = board.getSquare(start.getX() - 1, start.getY());
			if(tmp.getPiece() != null && tmp.getPiece().getColor() == "White"){
				p.addPossibleSquare(board.getSquare(start.getX()-1, start.getY()-1));
			}
			
			tmp = board.getSquare(start.getX() + 1, start.getY());
			if(tmp.getPiece() != null && tmp.getPiece().getColor() == "White"){
				p.addPossibleSquare(board.getSquare(start.getX()+1, start.getY()-1));
			}
		}
	}

}
