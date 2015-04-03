package gui;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JPanel;

import checker.moveSystem.Move;

import components.Board;
import components.Square;

public class GraphicalBoard  extends JPanel implements MouseListener{

	private static final long serialVersionUID = 4708082910655534101L;

	private Board board;
	private boolean existsSelectedSquare = false;
	private Square selectedSquare = Square.INEXISTANT;

	public GraphicalBoard(Board board){
		super(new GridLayout(10, 10));
		this.board = board;
		setPreferredSize(getPreferredSize());
		addMouseListener(this);
	}

	public boolean hasSelectedSquare(){ return existsSelectedSquare; }

	@Override
	public void paintComponent(Graphics g) {
		draw(g);
	}

	private void draw(Graphics g){
		Square s;
		for(int i=0; i<8; i++){
			for(int j=0; j<8; j++){
				s = board.getSquare(i, j);
				s.setGraphicalX(i*Square.SQUARE_SIZE);
				s.setGraphicalY(j*Square.SQUARE_SIZE);
				s.draw(g);
			}
		}
	}

	public void redraw(){
		paintComponent(this.getGraphics());
	}


	@Override
	public void mouseClicked(MouseEvent e) {
		Square selected = board.getSquare
				(e.getX()/Square.SQUARE_SIZE,
						e.getY()/Square.SQUARE_SIZE);

		if(existsSelectedSquare){ // was waiting for move of selected piece
			if(selected.isHighlighted()){ // is a valid move
				Move m;
				if((m = new Move(selectedSquare, selected))!=null)
					selectedSquare.getPiece().executeMove(m, board);
			}
			board.resetSquares();
			existsSelectedSquare = false;
			selectedSquare = Square.INEXISTANT;
			redraw();
			return;
		}

		if(selected.getPiece() == null) return; //no piece here
		redraw();
		if(!selected.isSelected()){
			selected.setSelected();
			existsSelectedSquare = true;
			selectedSquare = selected;
			selected.getPiece().askForSquares(board);
		}
		else{
			board.resetSquares();
			existsSelectedSquare = false;
			selectedSquare = Square.INEXISTANT;
		}
		redraw();
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {}

	@Override
	public void mouseExited(MouseEvent arg0) {}

	@Override
	public void mousePressed(MouseEvent arg0) {}

	@Override
	public void mouseReleased(MouseEvent arg0) {}


	@Override
	public Dimension getPreferredSize() {
		Dimension d = super.getPreferredSize();
		Dimension prefSize = null;
		Component c = this.getParent();
		if(c == null)
			prefSize = new Dimension(
					(int)d.getWidth(), (int)d.getHeight()
					);

		else if(c.getWidth() > d.getWidth() && c.getHeight() > d.getHeight())
			prefSize = c.getSize();
		else
			prefSize = d;

		int w = (int)prefSize.getWidth();
		int h = (int)prefSize.getHeight();

		int s = (w>h? h:w);
		Square.SQUARE_SIZE = s/8;
		return new Dimension(s, s);

	}

	public JPanel getConstraintPanel() {
		JPanel containsChessBoard = new JPanel(new GridBagLayout());
		//containsChessBoard.setBorder(new CompoundBorder(new EmptyBorder(10,10,10,10),
		//	new LineBorder(Color.BLACK)));
		containsChessBoard.setOpaque(false);
		containsChessBoard.add(this);
		containsChessBoard.setSize(containsChessBoard.getPreferredSize());

		return containsChessBoard;
	}

}
