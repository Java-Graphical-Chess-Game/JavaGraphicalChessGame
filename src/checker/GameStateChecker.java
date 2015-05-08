package checker;

import java.io.Serializable;

import components.Player;

import game.Game;
import game.GameState;

public class GameStateChecker implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Game game;
	
	public GameStateChecker(Game game){ this.game = game; }

	public GameState checkGameState(Player currentTeam) {
		GameState gs = currentTeam.getSet().getKing().isInDanger(game.getBoard());
		return gs;
	}
	
	
}
