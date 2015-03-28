package checker.moveSystem;

import java.awt.Color;

import components.Board;
import components.Square;

public class PawnDirection extends Direction {

	@Override
	public boolean isValidMove(Move m, Color c) {
		int dy = m.getEnd().getY() - m.getStart().getY();
		int dx = m.getEnd().getX() - m.getStart().getX();
		if(c == Color.WHITE)
			return (dy < 0 && dx == 0)
						|| (dy == -1 && Math.abs(dx) == 1);
		else if(c == Color.BLACK)
			return (dy > 0 && dx == 0)
						|| (dy == 1 && Math.abs(dx) == 1);
		else
			return false;
	}

	@Override
	public void generateValidSquares(Square start, Board board) {
		// TODO
	}

}
