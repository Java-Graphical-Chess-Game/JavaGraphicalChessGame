package gui;


import game.Game;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToolBar;

public class ChessFrame extends JFrame {

	private static final long serialVersionUID = 591882616190547773L;

	private Action newGame, saveGame, loadGame, abandonGame, undo, redo;
	private Game game; JLabel tp;
	
	public ChessFrame() throws HeadlessException {}

	public ChessFrame(GraphicalBoard guiBoard) {
		setTitle("Chess Game");
		setSize(500, 500);
		setVisible(true);
		setResizable(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		guiBoard.setSize(guiBoard.getPreferredSize());
		guiBoard.paintComponent(getGraphics());
		this.game = guiBoard.getBoard().getGame();
		JPanel constraint = guiBoard.getConstraintPanel();
		JPanel tools = new JPanel();
		JToolBar toolbar = new JToolBar();
		toolbar.setFloatable(false);
		add(toolbar, BorderLayout.PAGE_START);
		
		newGame 		= new AbstractAction("New Game"){
			private static final long serialVersionUID = 1L;
				
			@Override
			public void actionPerformed(ActionEvent e) {
				game.end();
				game = new Game();
				game.run();
			}
			
		};
		
		saveGame 		= new AbstractAction("Save Game"){
			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
			
		};
		
		loadGame 		= new AbstractAction("Load Game"){
			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent e) {
			}
			
		};
		
		abandonGame 		= new AbstractAction("Resign"){
			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent e) {
//				Dialog d = new Dialog(null, "Resign Game", null, null);
//				d.setLayout(getLayout());
//				JLabel j = new JLabel("Would you like to resign the current game?");
//				JButton yes = new JButton("Yes");
//				JButton no = new JButton("No");
//				d.add(j);
//				d.add(yes);
//				d.add(no);
//				d.setVisible(true);
			}
			
		};
		
		undo 		= new AbstractAction("Undo"){
			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent e) {
			}
			
		};
		
		redo 		= new AbstractAction("Redo"){
			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent e) {
			}
			
		};
				
		newGame 	    .setEnabled(true);
		saveGame 	    .setEnabled(false);
		loadGame 	    .setEnabled(true);
		abandonGame     .setEnabled(true);
		undo     		.setEnabled(false);
		redo 			.setEnabled(false);
		
		JButton newButton 	  = new JButton(newGame);
		JButton saveButton 	  = new JButton(saveGame);
		JButton loadButton 	  = new JButton(loadGame);
		JButton abandonButton = new JButton(abandonGame);
		JButton undoButton    = new JButton(undo);
		JButton redoButton    = new JButton(redo);
		
		toolbar.add(newButton);
		toolbar.add(saveButton);
		toolbar.add(loadButton);
		toolbar.addSeparator();
		toolbar.add(abandonButton);
		toolbar.addSeparator();
		toolbar.add(undoButton);
		toolbar.add(redoButton);
		tools.add(toolbar);
		add(tools, BorderLayout.NORTH);
		add(constraint, BorderLayout.CENTER);
		
		setMinimumSize(new Dimension(500, 500));
		
		JPanel statusBar = new JPanel();
		tp = new JLabel("Welcome To Chess");
		statusBar.setSize(new Dimension(getWidth(), 230));
		statusBar.add(tp);
		
		add(statusBar, BorderLayout.SOUTH);
		
		pack();
		
	}
	
	public void updateStatus(){
		String status = game.getTurnColor() + "'s Turn";
		if(game.getGameState() != "None")
			status += "   ---   " + game.getGameState();
		tp.setText(status);
	}

}
