package gui;

import game.Game;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.io.File;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JToolBar;

import checker.moveSystem.Move;
import components.pieces.Piece;

public class ChessFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 773148790671349216L;
	private Action newGame, saveGame, loadGame, abandonGame, undo;
	private VictimPanel vp;
	private GraphicalBoard guiBoard;
	
	private Game game; JLabel tp;
	
	public ChessFrame() throws HeadlessException {}

	public ChessFrame(GraphicalBoard guiBoard) {
		this.guiBoard = guiBoard;
		setTitle("Chess Game");
		setSize(600, 600);
		setVisible(true);
		setResizable(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		vp = new VictimPanel();
		//vp.redraw();
		
		
		add(vp, BorderLayout.EAST);
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
				game.save();
			}
			
		};
		
		loadGame 		= new AbstractAction("Load Game"){
			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent e) {
				game.load();
			}
			
		};
		
		abandonGame 		= new AbstractAction("Resign"){
			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent e) {
				//JOptionPane.showMessageDialog(null, this, "Do you want to keep my ass for the night?", JFrame.EXIT_ON_CLOSE);
				//JOptionPane.showConfirmDialog(null, this, "Do you want to keep my ass for the night?", JFrame.EXIT_ON_CLOSE);
				int x = JOptionPane.showConfirmDialog(null, "Do you want to resign?", "Resign?", JOptionPane.YES_NO_OPTION);
				
				switch (x) {
				case JOptionPane.YES_OPTION:
					System.exit(0);
					break;
				case JOptionPane.NO_OPTION:
					// ok...
					break;
				default:
					// doesn't do shit
					break;
				}
			}
			
		};
		
		undo 		= new AbstractAction("Undo"){
			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent e) {
				Move m = game.popUndo();
				m.reverse();
				if(m.getVictim() != null){
					vp.removeLastPiece();
				}
				game.switchTurn();
				updateStatus();
				ChessFrame.this.game.requestVPRedraw();
				ChessFrame.this.guiBoard.redraw();
				game.updateGameState();
				if(game.isUndoEmpty())
					undo.setEnabled(false);
			}
			
		};
		
				
		newGame 	    .setEnabled(true);
		saveGame 	    .setEnabled(true);
		loadGame 	    .setEnabled(true);
		abandonGame     .setEnabled(true);
		undo     		.setEnabled(false);
		
		JButton newButton 	  = new JButton(newGame);
		JButton saveButton 	  = new JButton(saveGame);
		JButton loadButton 	  = new JButton(loadGame);
		JButton abandonButton = new JButton(abandonGame);
		JButton undoButton    = new JButton(undo);
		
		toolbar.add(newButton);
		toolbar.add(saveButton);
		toolbar.add(loadButton);
		toolbar.addSeparator();
		toolbar.add(abandonButton);
		toolbar.addSeparator();
		toolbar.add(undoButton);
		tools.add(toolbar);
		add(tools, BorderLayout.NORTH);
		add(constraint, BorderLayout.CENTER);
		
		setMinimumSize(new Dimension(600, 600));
		
		JPanel statusBar = new JPanel();
		tp = new JLabel("Welcome To Chess");
		statusBar.setSize(new Dimension(getWidth(), 230));
		statusBar.add(tp);
		
		add(statusBar, BorderLayout.SOUTH);
		
		this.setIconImage(Toolkit.getDefaultToolkit()
				.getImage("icons" + File.separator + "wking.png"));
		
		pack();
		
	}
	
	public void updateStatus(){
		String status = game.getTurnColor() + "'s Turn";
		if(game.getGameState() != "None")
			status += "   ---   " + game.getGameState();
		tp.setText(status);
	}
	
	public void setUndoEnable(boolean enable){
		undo.setEnabled(enable);
	}
	public void setRedoEnable(boolean enable){
		//redo.setEnabled(enable);
	}
	public boolean getUndoState(){
		return undo.isEnabled();
	}
	public boolean getRedoState(){
		return false;
		//return redo.isEnabled();
	}
	
	public void requestAddVictim(Piece p){
		vp.addVictim(p);
	}

	public VictimPanel getVP() {
		return vp;
	}
	

}
