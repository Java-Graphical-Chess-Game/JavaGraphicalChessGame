package game;

import gui.ChessFrame;
import gui.GraphicalBoard;
import java.awt.Color;
import java.io.IOException;
import java.io.Serializable;
import java.util.Stack;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import checker.GameStateChecker;
import checker.SpecialMoveGenerator;
import checker.moveSystem.Move;
import components.Board;
import components.Player;
import components.pieces.Piece;


public class Game implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Player bPlayer;
	private Player wPlayer;
	private Board board;
	private transient GraphicalBoard guiBoard;
	private ChessFrame chessFrame;
	private GameState gamestate;
	private boolean isWhiteTurn = true;
	private GameStateChecker checker;
	private SpecialMoveGenerator smg;

	private transient Runnable r;

	private Stack<Move> undo, redo;

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
		undo = new Stack<Move>();
		redo = new Stack<Move>();
	}

	public String getTurnColor(){
		if(isWhiteTurn) return "White";
		else return "Black";
	}

	public Player getCurrentPlayer(){
		if(isWhiteTurn) return wPlayer;
		else return bPlayer;
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
				//chessFrame.getVP().redraw();
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

	public boolean isUndoEmpty(){
		return this.undo.isEmpty();
	}
	public boolean isRedoEmpty(){
		return this.redo.isEmpty();
	}
	public void pushUndo(Move m){
		undo.push(m);
	}
	public void pushRedo(Move m){
		redo.push(m);
	}
	public Move popUndo(){
		undo.lastElement().getCurrentPiece().recountMove();
		return undo.pop();

	}
	public Move popRedo(){
		return redo.pop();
	}

	public void requestUndoEnable(){
		if(!chessFrame.getUndoState())
			chessFrame.setUndoEnable(true);
	}
	public void requestRedoEnable(){
		if(!chessFrame.getRedoState())
			chessFrame.setRedoEnable(true);
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

	public void requestAddTaken(Piece p){ chessFrame.requestAddVictim(p); }

	public void requestVPRedraw() {
		this.chessFrame.getVP().redraw();
	}

	public void save(){
		try {
			SaveLoadLibrary.save(this);
			JOptionPane.showMessageDialog(null, "Game Saved.", "Save", JOptionPane.OK_OPTION);
		} catch (IOException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Could not save game.", "Save Error", JOptionPane.OK_OPTION);
		}
	}


	public void load(){

		try {
			Game g = SaveLoadLibrary.load();
			if(g == null) return;
			this.end();
			//g.run();
			JOptionPane.showMessageDialog(null, "Game Loaded.", "Load", JOptionPane.OK_OPTION);
		} catch (IOException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Could not load game.", "Load Error", JOptionPane.OK_OPTION);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void setFrame(ChessFrame cf) {
		this.chessFrame = cf;
	}
	public ChessFrame getFrame(){ return chessFrame; }

	public GraphicalBoard getGUIBoard() {
		return guiBoard;
	}

}
