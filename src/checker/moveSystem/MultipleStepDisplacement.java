package checker.moveSystem;

public class MultipleStepDisplacement implements Displacement {

	@Override
	public boolean isValidMove(Move m) {
		return true;
	}

	
	@Override
	public boolean equals(Object obj) {
		return obj instanceof MultipleStepDisplacement;
	}
}
