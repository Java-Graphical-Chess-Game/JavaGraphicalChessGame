package components;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.Rectangle2D;
import java.awt.Toolkit;

import components.pieces.Piece;


public class Square {

	public static int SQUARE_SIZE = 10;

	private Color color;
	private int x, y, indexX, indexY;
	private boolean selected = false;
	private String iconPath;
	private Piece piece;
	
	public void setHilighted(){
		color = new Color(248, 242, 114);
		selected = true;
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
		if(!(indexX%2 == 0 ^ indexY%2 == 0))
			color = Color.BLACK;
		else color = Color.WHITE;
		selected = false;
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
		
		if(iconPath != null){
			Image i = Toolkit.getDefaultToolkit().getImage(iconPath);
			
			
//			i = i.getScaledInstance((int)(SQUARE_SIZE*0.8)+1, (int)(SQUARE_SIZE*0.8)+1, Image.SCALE_SMOOTH);
			
			
			
			g2.drawImage(i, x+SQUARE_SIZE/2 - i.getWidth(null)/2,
					y+SQUARE_SIZE/2 - i.getHeight(null)/2, null);
			
			
//			g.drawImage(i, x+SQUARE_SIZE/2 - i.getWidth(null)/2,
//					y+SQUARE_SIZE/2 - i.getHeight(null)/2, null);
		
		}
	}

}