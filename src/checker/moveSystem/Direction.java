package checker.moveSystem;

import java.awt.Color;

import components.Board;
import components.Square;

public abstract class Direction {

	public abstract boolean isValidMove(Move m, Color c);
	public abstract void generateValidSquares(Square start, Board board);
}
