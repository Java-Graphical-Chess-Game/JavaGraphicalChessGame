import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JPanel;

import components.Square;


public class ChessBoardTest extends JPanel implements MouseListener{
	Square squares[][] = new Square[8][8];

	private static final long serialVersionUID = 7613925947436064730L;
	
	public ChessBoardTest(){
		super(new GridLayout(10, 10));
		for(int i=0; i<8; i++)
			for(int j=0; j<8; j++)
				squares[i][j] = new Square(i*Square.SQUARE_SIZE, j*Square.SQUARE_SIZE, i, j);
		//int prefSize = 8 * Square.SQUARE_SIZE;
		setPreferredSize(getPreferredSize());
		
		addMouseListener(this);
	}

	@Override
	protected void paintComponent(Graphics g) {
		draw(g);
	}
	
	private void draw(Graphics g){
		Square s;
		for(int i=0; i<8; i++){
			for(int j=0; j<8; j++){
				s = squares[i][j];
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
		Square selected = squares
			[e.getX()/Square.SQUARE_SIZE]
			[e.getY()/Square.SQUARE_SIZE];
		if(!selected.isSelected()) selected.setSelected();
		else selected.setColor();
		redraw();
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
	}

	@Override
	public void mousePressed(MouseEvent e) {

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
	}
	
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
		System.out.println(s);
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
