package checker.moveSystem;

import java.awt.Color;

import components.Board;
import components.Square;

public class LShapedDirection extends Direction {

	@Override
	public boolean isValidMove(Move m ,Color c) {
		int xStart = m.getStart().getX();
		int xEnd = m.getEnd().getY();
		int yStart = m.getStart().getX();
		int yEnd = m.getEnd().getY();
	     int dx =Math.abs(xStart-xEnd);
	     int dy =Math.abs(yStart-yEnd);
	     return (dx == 2 && dy == 1)||(dx == 1 && dy == 2);
	}

	@Override
	public void generateValidSquares(Square start, Board board) {
		checkAndAdd(start, 1, 2, board);
		checkAndAdd(start, -1, 2, board);
		checkAndAdd(start, 1, -2, board);
		checkAndAdd(start, -1, -2, board);
		checkAndAdd(start, 2, 1, board);
		checkAndAdd(start, -2, 1, board);
		checkAndAdd(start, 2, -1, board);
		checkAndAdd(start, -2, -1, board);
	}
	
	private void checkAndAdd(Square start, int dx, int dy, Board board){
		Square tmp = board.getSquare(start.getX() + dx, start.getY() + dy);
		if(tmp.equals(Square.INEXISTANT)) return;
		if(tmp.getPiece() == null)
			start.getPiece().addPossibleSquare(tmp);
		else if(tmp.getPiece().getColor() != start.getPiece().getColor())
			start.getPiece().addPossibleSquare(tmp);
	}
	
}
