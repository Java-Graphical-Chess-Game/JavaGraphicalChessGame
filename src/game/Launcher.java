package game;

import javax.swing.SwingUtilities;

public class Launcher {

	public static void main(String[] args) {

		Runnable r = new Runnable() {

			@Override
			public void run() {	

				new Game().run();

			}
		};
		SwingUtilities.invokeLater(r);
	}

}