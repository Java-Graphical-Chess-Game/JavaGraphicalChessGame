package checker.moveSystem;

public class SingleStepDisplacement implements Displacement {

	@Override
	public boolean isValidMove(Move m) {
		
		return Math.abs(m.getEnd().getX()-m.getStart().getX()) <= 1
					&& Math.abs(m.getEnd().getY()-m.getStart().getY()) <= 1;
		}

	@Override
	public boolean equals(Object obj) {
		return obj instanceof SingleStepDisplacement;
	}
	
}
