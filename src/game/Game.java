package game;

import gui.ChessFrame;
import gui.GraphicalBoard;
import java.awt.Color;
import javax.swing.SwingUtilities;
import checker.GameStateChecker;
import checker.SpecialMoveGenerator;
import components.Board;
import components.Player;


public class Game {

	private Player bPlayer;
	private Player wPlayer;
	private Board board;
	private GraphicalBoard guiBoard;
	private ChessFrame chessFrame;
	private GameState gamestate;
	private boolean isWhiteTurn = true;
	private GameStateChecker checker;
	private SpecialMoveGenerator smg;
	
	private Runnable r;
	
	public Game(){
		this.board = new Board(this);
		bPlayer = new Player(Color.BLACK, board);
		wPlayer = new Player(Color.WHITE, board);
		guiBoard = new GraphicalBoard(board);
		chessFrame = new ChessFrame(guiBoard);
		gamestate = GameState.NONE;
		init();
		chessFrame.updateStatus();
		checker = new GameStateChecker(this);
		smg = new SpecialMoveGenerator(board);
	}
	
	public String getTurnColor(){
		if(isWhiteTurn) return "White";
		else return "Black";
	}
	
	public void switchTurn() {
		if(isWhiteTurn) isWhiteTurn = false;
		else isWhiteTurn = true;
	}		
	
	public void init(){
		bPlayer.getSet().placePieces();
		wPlayer.getSet().placePieces();
	}
	
	
	public Player getWPlayer(){ return wPlayer; }
	public Player getBPlayer(){ return bPlayer; }
	public String getGameState(){ return gamestate.toString(); }
	
	public void run(){

		r = new Runnable() {

				@Override
				public void run() {	
					
					guiBoard.redraw();
					
				}
			};
			SwingUtilities.invokeLater(r);
	
		// wait for user input
		// process input
		// check state
		// switch turn
		// repeat
	}
	
	public void end(){
		board = null;
		bPlayer = wPlayer = null;
		chessFrame.dispose();
		try {
			finalize();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		
	}
	
	public Board getBoard(){ return board; }
	
	private void setGameState(GameState gs){ gamestate = gs;}


	public void updateGameState() {
		Player currentTeam = isWhiteTurn? wPlayer:bPlayer;
		GameState gs = requestGameState(currentTeam);
		
		
		
		setGameState(gs);
		chessFrame.updateStatus();
		
	}
	
	public GameState requestGameState(Player team){
		return checker.checkGameState(team);
	}

	public SpecialMoveGenerator getSMG() { return smg; }
	
}























