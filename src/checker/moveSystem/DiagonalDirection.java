package checker.moveSystem;

import java.awt.Color;
import java.util.ArrayList;

import checker.Motion;

import components.Board;
import components.Square;

public class DiagonalDirection extends Direction {

	@Override
	public boolean isValidMove(Move m, Color c) {
		int xStart = m.getStart().getX();
		int xEnd = m.getEnd().getY();
		int yStart = m.getStart().getX();
		int yEnd = m.getEnd().getY();
		return Math.abs(xStart - xEnd )== Math.abs(yStart - yEnd);
	
	}

	@Override
	public ArrayList<Square> generateValidSquares(Square start, Board board) {
		ArrayList<Square> ss = new ArrayList<Square>();
		ss.addAll(Motion.fetchUpLeftSquares(start, board));
		ss.addAll(Motion.fetchDownLeftSquares(start, board));
		ss.addAll(Motion.fetchUpRightSquares(start, board));
		ss.addAll(Motion.fetchDownRightSquares(start, board));
		return ss;
	}
	
	@Override
	public boolean equals(Object obj) {
		return obj instanceof DiagonalDirection;
	}

}
