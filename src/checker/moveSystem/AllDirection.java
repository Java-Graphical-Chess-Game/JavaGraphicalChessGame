package checker.moveSystem;

import java.awt.Color;

import components.Board;
import components.Square;

public class AllDirection extends Direction {
	
	@Override
	public boolean isValidMove(Move m, Color c) {
		return new DiagonalDirection().isValidMove(m, c) && new StraightDirection().isValidMove(m, c);
	}

	@Override
	public void generateValidSquares(Square start, Board board) {
		new DiagonalDirection().generateValidSquares(start, board);
		new StraightDirection().generateValidSquares(start, board);
	}

}
 