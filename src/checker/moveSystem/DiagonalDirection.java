package checker.moveSystem;

import java.awt.Color;

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
	public void generateValidSquares(Square start, Board board) {
		Motion.fetchUpLeftSquares(start, board);
		Motion.fetchDownLeftSquares(start, board);
		Motion.fetchUpRightSquares(start, board);
		Motion.fetchUpRightSquares(start, board);
		
	}

}
