package game;

import java.io.Serializable;


public class Launcher implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {

		new Game().run();

	}

}