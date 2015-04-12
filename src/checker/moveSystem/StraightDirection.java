package checker.moveSystem;

import java.awt.Color;
import java.util.ArrayList;

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
    public ArrayList<Square> generateValidSquares(Square start, Board board) {
		ArrayList<Square> ss = new ArrayList<Square>();
        ss.addAll(Motion.fetchUpSquares(start, board));
        ss.addAll(Motion.fetchDownSquares(start, board));
        ss.addAll(Motion.fetchLeftSquares(start, board));
        ss.addAll(Motion.fetchRightSquares(start, board));
        return ss;
    }
	
	
	@Override
	public boolean equals(Object obj) {
		return obj instanceof StraightDirection;
	}

}