import java.awt.Color;

import components.Board;
import components.Player;


public class Game {

	private Player bPlayer;
	private Player wPlayer;
	private Board board;
	
	
	public Game(){
		this.board = new Board();
		bPlayer = new Player(Color.BLACK, board);
		wPlayer = new Player(Color.WHITE, board);
	}
	
	
	public Player getWPlayer(){ return wPlayer; }
	public Player getBPlayer(){ return bPlayer; }
	
	
	public void run(){
		
	}
	
}

