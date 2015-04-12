package checker.moveSystem;

import java.awt.Color;
import java.util.ArrayList;

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
	public ArrayList<Square> generateValidSquares(Square start, Board board) {
		ArrayList<Square> ss = new ArrayList<Square>();
		ss.addAll(checkAndAdd(start, 1, 2, board));
		ss.addAll(checkAndAdd(start, -1, 2, board));
		ss.addAll(checkAndAdd(start, 1, -2, board));
		ss.addAll(checkAndAdd(start, -1, -2, board));
		ss.addAll(checkAndAdd(start, 2, 1, board));
		ss.addAll(checkAndAdd(start, -2, 1, board));
		ss.addAll(checkAndAdd(start, 2, -1, board));
		ss.addAll(checkAndAdd(start, -2, -1, board));
		return ss;
	}
	
	private ArrayList<Square> checkAndAdd(Square start, int dx, int dy, Board board){
		ArrayList<Square> ss = new ArrayList<Square>();
		Square tmp = board.getSquare(start.getX() + dx, start.getY() + dy);
		if(tmp.equals(Square.INEXISTANT)) return ss;
		if(tmp.getPiece() == null)
			ss.add(tmp);
		else if(tmp.getPiece().getColor() != start.getPiece().getColor())
			ss.add(tmp);
		return ss;
	}
	
	
	@Override
	public boolean equals(Object obj) {
		return obj instanceof LShapedDirection;
	}
	
}
