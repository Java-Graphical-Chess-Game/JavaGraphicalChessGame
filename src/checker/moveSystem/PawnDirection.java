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
		if(p.getColor().equals(Color.WHITE)){
			tmp = board.getSquare(start.getX(), start.getY()+1);
			if(tmp.getPiece() == null) p.addPossibleSquare(tmp);
			else if (tmp.getPiece().getColor() != start.getPiece().getColor())
				p.addPossibleSquare(tmp);
			if(!p.hasMoved() && !p.doubleStepped()){
				tmp = board.getSquare(start.getX(), start.getY()+2);
				if(tmp.getPiece() == null) p.addPossibleSquare(tmp);
				else if (tmp.getPiece().getColor() != start.getPiece().getColor())
					p.addPossibleSquare(tmp);
			}
			tmp = board.getSquare(start.getX()+1, start.getY()+1);
			if(tmp.getPiece() != null) p.addPossibleSquare(tmp);
			
			tmp = board.getSquare(start.getX()-1, start.getY()+1);
			if(tmp.getPiece() != null) p.addPossibleSquare(tmp);
			
		}
		else if(p.getColor().equals(Color.BLACK)){
			tmp = board.getSquare(start.getX(), start.getY()-1);
			if(tmp.getPiece() == null) p.addPossibleSquare(tmp);
			else if (tmp.getPiece().getColor() != start.getPiece().getColor())
				p.addPossibleSquare(tmp);
			if(!p.hasMoved() && !p.doubleStepped()){
				tmp = board.getSquare(start.getX(), start.getY()-2);
				if(tmp.getPiece() == null) p.addPossibleSquare(tmp);
				else if (tmp.getPiece().getColor() != start.getPiece().getColor())
					p.addPossibleSquare(tmp);
			}
			tmp = board.getSquare(start.getX()+1, start.getY()-1);
			if(tmp.getPiece() != null) p.addPossibleSquare(tmp);
			
			tmp = board.getSquare(start.getX()-1, start.getY()-1);
			if(tmp.getPiece() != null) p.addPossibleSquare(tmp);
			
		}
	}

}
