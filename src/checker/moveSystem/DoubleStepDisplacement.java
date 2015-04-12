package checker.moveSystem;

public class DoubleStepDisplacement implements Displacement {

	@Override
	public boolean isValidMove(Move m) {
		return Math.abs(m.getEnd().getX()-m.getStart().getX()) <= 2
				&& Math.abs(m.getEnd().getY()-m.getStart().getY()) <= 2;

	}

	
	@Override
	public boolean equals(Object obj) {
		return obj instanceof DoubleStepDisplacement;
	}
	
}
