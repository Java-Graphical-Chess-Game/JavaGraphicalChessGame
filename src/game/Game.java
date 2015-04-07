package game;
import gui.ChessFrame;
import gui.GraphicalBoard;

import java.awt.Color;

import javax.swing.SwingUtilities;

import components.Board;
import components.Player;


public class Game {

	private Player bPlayer;
	private Player wPlayer;
	private Board board;
	private GraphicalBoard guiBoard;
	private ChessFrame chessFrame;
	
	private Runnable r;
	
	public Game(){
		this.board = new Board(this);
		bPlayer = new Player(Color.BLACK, board);
		wPlayer = new Player(Color.WHITE, board);
		guiBoard = new GraphicalBoard(board);
		chessFrame = new ChessFrame(guiBoard);
		init();
	}
	
	
	public void init(){
		bPlayer.getSet().placePieces();
		wPlayer.getSet().placePieces();
	}
	
	
	public Player getWPlayer(){ return wPlayer; }
	public Player getBPlayer(){ return bPlayer; }
	
	
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
	
}

