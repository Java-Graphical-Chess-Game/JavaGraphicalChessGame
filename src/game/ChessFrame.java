package game;

import gui.GraphicalBoard;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.JToolBar;

public class ChessFrame extends JFrame {

	private static final long serialVersionUID = 591882616190547773L;

	
	public ChessFrame() throws HeadlessException {}

	public ChessFrame(GraphicsConfiguration gc, GraphicalBoard guiBoard) {
		super(gc);
		setTitle("Chess Game");
		setSize(450, 450);
		setVisible(true);
		setResizable(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		guiBoard.setSize(guiBoard.getPreferredSize());
		//c.squares[0][0].iconPath = "/home/zshulu/Chess/bbishop.png";
		guiBoard.paintComponent(getGraphics());
		
		JPanel tools = new JPanel();
		JPanel constraint = guiBoard.getConstraintPanel();
		JToolBar toolbar = new JToolBar();
		toolbar.setFloatable(false);
		add(toolbar, BorderLayout.PAGE_START);
		
		Action newGame = new AbstractAction("New Game") {
			private static final long serialVersionUID = 1L;
			@Override
			public void actionPerformed(ActionEvent arg0) {
				//TODO
			}
		};
		toolbar.add(newGame);
		toolbar.add(new JButton("Save"));
		toolbar.add(new JButton("Load"));
		toolbar.addSeparator();
		toolbar.add(new JButton("Abandon Ship"));
		tools.add(toolbar);
		add(tools, BorderLayout.NORTH);
		add(constraint, BorderLayout.CENTER);
		
		setMinimumSize(new Dimension(450, 450));
		
		JPanel statusBar = new JPanel();
		JTextPane tp = new JTextPane();
		tp.setText("Welcome to Chess");
		statusBar.setSize(new Dimension(getWidth(), 230));
		statusBar.add(tp);
		
		add(statusBar, BorderLayout.SOUTH);
		
		pack();
		
	}

	public ChessFrame(String title) throws HeadlessException {
		super(title);
	}

	public ChessFrame(String title, GraphicsConfiguration gc) {
		super(title, gc);
	}

}
