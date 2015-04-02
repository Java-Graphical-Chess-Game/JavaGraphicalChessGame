package checker.moveSystem;

import java.awt.Color;

import checker.Motion;

import components.Board;
import components.Square;

public class StraightDirection extends Direction {

	@Override
	public boolean isValidMove(Move m, Color c) {
		int xStart = m.getStart().getX();
		int xEnd = m.getEnd().getY();
		int yStart = m.getStart().getX();
		int yEnd = m.getEnd().getY();
		return xStart == xEnd && yStart == yEnd;
	}
	
	@Override
    public void generateValidSquares(Square start, Board board) {
        Motion.fetchUpSquares(start, board);
        Motion.fetchDownSquares(start, board);
        Motion.fetchLeftSquares(start, board);
        Motion.fetchRightSquares(start, board);
    }

}