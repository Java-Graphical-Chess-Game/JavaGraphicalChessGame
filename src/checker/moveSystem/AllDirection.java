package checker.moveSystem;

import java.awt.Color;
import java.util.ArrayList;

import components.Board;
import components.Square;

public class AllDirection extends Direction {
	
	@Override
	public boolean isValidMove(Move m, Color c) {
		return new DiagonalDirection().isValidMove(m, c) && new StraightDirection().isValidMove(m, c);
	}

	@Override
	public ArrayList<Square> generateValidSquares(Square start, Board board) {
		ArrayList<Square> ss = new ArrayList<Square>();
		ss.addAll(new DiagonalDirection().generateValidSquares(start, board));
		ss.addAll(new StraightDirection().generateValidSquares(start, board));
		return ss;
	}
	
	@Override
	public boolean equals(Object obj) {
		return obj instanceof AllDirection;
	}

}
 