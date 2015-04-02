package test;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.Rectangle2D;
import java.awt.Toolkit;


public class Square {

	private Color color;
	private int x, y, indexX, indexY;
	public static int SQUARE_SIZE = 10;
	private boolean selected = false;
	public String iconPath;
	private Piece piece;
	
	
	public Piece getPiece(){
		return piece;
	}
	
	
	public void setHL(){
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

	protected void setX(int x){ this.x = x; }
	protected void setY(int y){ this.y = y; }

	public void setSize(int s){
		SQUARE_SIZE = s;
	}

	protected void setColor(){
		if(!((indexX)%2 == 0 ^ (indexY)%2 == 0))
			color = Color.darkGray;
		else color = Color.white;
		selected = false;
	}

	public Color getColor(){ return color; }
	public int getX(){ return indexX; }
	public int getY(){ return indexY; }
	public int getGraphicalX(){ return x; }
	public int getGraphicalY(){ return y; }

	@Override
	public boolean equals(Object o){
		if(o == null)
			return false;
		
		if(!(o instanceof Square))
			return false;
		
		Square s = (Square)o;
		if(this.indexX==s.indexX &&this.indexY==s.indexY)
			return true;
		return false;
		
	}

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