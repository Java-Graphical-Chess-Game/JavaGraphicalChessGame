package game;

public enum GameState {
	NONE,
	DRAW,
	CHECK_WHITE,
	CHECK_BLACK,
	CHECKMATE_WHITE,
	CHECKMATE_BLACK;
	
	public String toString(){
		switch (this) {
		case NONE:
			return "None";
		case DRAW:
			return "Draw";
		case CHECK_WHITE:
			return "Check On White";
		case CHECK_BLACK:
			return "Check On Black";
		case CHECKMATE_BLACK:
			return "CheckMate On Black";
		case CHECKMATE_WHITE:
			return "CheckMate On White";
		default:
			return "";
		}
	}
}
