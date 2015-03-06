import java.awt.BorderLayout;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JToolBar;
import javax.swing.SwingUtilities;

public class TestingBoard{
	

	public static void main(String[] args) {
		
		Runnable r = new Runnable() {
			
			@Override
			public void run() {
				JFrame f = new JFrame();
				f.setTitle("Chess");
				f.setSize(600, 600);
				f.setVisible(true);
				f.setResizable(true);
				f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				ChessBoardTest c = new ChessBoardTest();
				
				c.squares[0][0].iconPath = "/home/zshulu/Chess/bbishop.png";
				c.paintComponent(f.getGraphics());
				
//				JToolBar toolbar = new JToolBar();
//				toolbar.setFloatable(false);
//				f.add(toolbar, BorderLayout.PAGE_START);
//				Action newGame = new AbstractAction("New Game") {
//					private static final long serialVersionUID = 1L;
//					@Override
//					public void actionPerformed(ActionEvent arg0) {
//						System.out.println("New was clicked");
//						
//					}
//				};
//				toolbar.add(newGame);
//				toolbar.add(new JButton("Save"));
//				toolbar.add(new JButton("Load"));
//				toolbar.addSeparator();
//				toolbar.add(new JButton("Abandon Ship"));
//				
				f.add(c, BorderLayout.SOUTH);
				f.pack();
				f.setMinimumSize(f.getSize());
				
			}
		};
		SwingUtilities.invokeLater(r);
		
	}
}
