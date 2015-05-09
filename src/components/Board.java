package components;

import java.io.Serializable;
import java.util.ArrayList;

import game.Game;
import gui.GraphicalBoard;
import components.pieces.Pawn;
import components.pieces.Piece;
import checker.moveSystem.Move;

public class Board implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected Square squares [][] = new Square[8][8];
	private GraphicalBoard guiBoard = new GraphicalBoard(this);
	private Game game;

	public Board(Game game){
		this.game = game;
		for(int i=0; i<8; i++)
			for(int j=0; j<8; j++)
				squares[i][j] = new Square(i*Square.SQUARE_SIZE, j*Square.SQUARE_SIZE, i, j);
	}

	public ArrayList<Square> getSquares(){
		ArrayList<Square> x = new ArrayList<Square>();
		for(Square ss []: squares)
			for(Square s : ss)
				x.add(s);
		return x; 
	}
	public Game getGame(){ return game; }
	public GraphicalBoard getGraphicalBoard(){ return guiBoard; }
	public Square getSquare(int x, int y){
		try{
			return squares[x][y];
		}catch(ArrayIndexOutOfBoundsException e){
			return Square.INEXISTANT;
		}
	}

	public String getCurrentColor() {
		return game.getTurnColor();
	}

	public void resetSquares() {
		for(Square ss[] : squares)
			for(Square s : ss)
				s.setColor();

	}

	public void executeMove(Move move) {
		if(move == null) return;
		Piece moved = move.getStart().deletePiece();
		if(move.getEnd().getPiece() != null)
		{
			Piece victim= move.getEnd().deletePiece();
			Player current=game.getCurrentPlayer();
			current.addToTaken(victim);
			moved.setVictim(victim);
			move.setVictim(victim);
			game.requestAddTaken(victim);
		}
		move.getEnd().insertPiece(moved);
		game.pushUndo(move);
		game.switchTurn();
		game.updateGameState();

	}


	public boolean attemptMove(Move move) {

		if(move == null) return false;
		
		Piece moved = move.getStart().deletePiece();
		Piece attacked = null;
		if(move.getEnd().getPiece() != null){
			attacked = move.getEnd().getPiece();
			moved.setVictim(attacked);
		}
		move.getEnd().insertPiece(moved);

		Player current;
		if(game.getTurnColor() == "White") current = game.getWPlayer();
		else current = game.getBPlayer();

		boolean willSolve;

		if(game.requestGameState(current).toString().contains("Check")) willSolve = false;
		else willSolve = true;

		move.getStart().insertPiece(move.getEnd().deletePiece());
		if(attacked != null) move.getEnd().insertPiece(attacked);

		return willSolve;
	}

}








