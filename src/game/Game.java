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
	@SuppressWarnings("unused")
	private ChessFrame chessFrame;
	
	public Game(){
		this.board = new Board(this);
		bPlayer = new Player(Color.BLACK, board);
		wPlayer = new Player(Color.WHITE, board);
		guiBoard = new GraphicalBoard(board);
		chessFrame = new ChessFrame(guiBoard);
		bPlayer.getSet().placePieces();
		wPlayer.getSet().placePieces();
	}
	
	
	public Player getWPlayer(){ return wPlayer; }
	public Player getBPlayer(){ return bPlayer; }
	
	
	public void run(){
		Runnable r = new Runnable() {

			@Override
			public void run() {	
				
				guiBoard.redraw();
				
			}
		};
		SwingUtilities.invokeLater(r);
	}
	
}

