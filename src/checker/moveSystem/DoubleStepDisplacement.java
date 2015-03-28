package checker.moveSystem;

public class DoubleStepDisplacement implements Displacement {

	@Override
	public boolean isValidMove(Move m) {
		return Math.abs(m.getEnd().getX()-m.getStart().getX()) == 2
				|| m.getEnd().getY()-m.getStart().getY() == 2;

	}

}
