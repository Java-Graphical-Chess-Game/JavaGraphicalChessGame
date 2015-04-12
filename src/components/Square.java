package components;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.Rectangle2D;
import java.awt.Toolkit;

import components.pieces.Piece;


public class Square {
	
	public final static Square INEXISTANT = new Square(-1, -1, -1, -1);
	public static int SQUARE_SIZE = 10;

	private Color color;
	private int x, y, indexX, indexY;
	private boolean selected = false;
	private boolean highlighted = false;
	protected Piece piece;
	
	public void setSelected(){
		color = new Color(248, 242, 114);
		selected = true;
	}
	
	public void setHighlighted(){
		//color = new Color(100, 137, 97);
		highlighted = true;
	}
	
	public boolean isSelected(){ return selected; }
	
	public Square(int x, int y, int indexX, int indexY){
		this.x = x;
		this.y = y;
		
		this.indexX = indexX;
		this.indexY = indexY;
		
		setColor();
	}
	
	public void setGraphicalX(int x){ this.x = x; }
	public void setGraphicalY(int y){ this.y = y; }
	
	public void setSize(int s){
		SQUARE_SIZE = s;
	}
	
	public void setColor(){
		if(indexX%2 == 0 ^ indexY%2 == 0)
			color = new Color(143, 4, 0);
		else color = new Color(204, 84, 0);
		selected = false;
		highlighted = false;
	}
	
	public Color getColor(){ return color; }
	
	public void setPiece(Piece piece) {
		this.piece = piece;
	}
	
	public Piece getPiece() { return piece; }

	public int getGraphicalX(){ return x; }
	public int getGraphicalY(){ return y; }
	
	public int getX(){ return indexX; }
	public int getY(){ return indexY; }
	
	
	public void draw(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		Rectangle2D r = new Rectangle2D.Double(x, y, SQUARE_SIZE, SQUARE_SIZE);
		g2.setColor(this.color);
		g2.fill(r);
		
		
		if(piece != null && piece.getImagePath() != ""){
			Image i = Toolkit.getDefaultToolkit().getImage(piece.getImagePath());
			
			
//			i = i.getScaledInstance((int)(SQUARE_SIZE*0.8)+1, (int)(SQUARE_SIZE*0.8)+1, Image.SCALE_SMOOTH);
			
			
			
			g2.drawImage(i, x+SQUARE_SIZE/2 - i.getWidth(null)/2,
					y+SQUARE_SIZE/2 - i.getHeight(null)/2, null);
			
			
//			g.drawImage(i, x+SQUARE_SIZE/2 - i.getWidth(null)/2,
//					y+SQUARE_SIZE/2 - i.getHeight(null)/2, null);
		
		}
		if(isHighlighted()){
			g2.setColor(new Color(100, 137, 97));
			g2.fillOval(x + SQUARE_SIZE/2 - 10, y+SQUARE_SIZE/2 - 10, 20, 20);
		}
	}

	public boolean isHighlighted() {
		return highlighted;
	}

	public Piece deletePiece() {
		Piece p = this.piece;
		this.piece = null;
		p.nullifySquare();
		return p;
	}

	protected void insertPiece(Piece moved) {
		this.piece = moved;
		piece.setSquare(this);
	}

	@Override
	public String toString() {
		return "("+indexX+", "+indexY+")";
	}
	
	
}