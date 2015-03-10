import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.Rectangle2D;
import java.awt.Toolkit;


public class Square {

	private Color color;
	private int x, y;
	public static int SQUARE_SIZE = 10;
	private boolean selected = false;
	public String iconPath;
	
	public void setHL(){
		color = new Color(248, 242, 114);
		selected = true;
	}
	
	public boolean isSelected(){ return selected; }
	
	public Square(int x, int y){
		this.x = x;
		this.y = y;
		setColor();
	}
	
	protected void setX(int x){ this.x = x; }
	protected void setY(int y){ this.y = y; }
	
	public void setSize(int s){
		SQUARE_SIZE = s;
	}
	
	protected void setColor(){
		if(!((x/SQUARE_SIZE)%2 == 0 ^ (y/SQUARE_SIZE)%2 == 0))
			color = Color.darkGray;
		else color = Color.white;
		selected = false;
	}
	
	public Color getColor(){ return color; }
	public int getX(){ return x; }
	public int getY(){ return y; }

	
	public void draw(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		Rectangle2D r = new Rectangle2D.Double(x, y, SQUARE_SIZE, SQUARE_SIZE);
		g2.setColor(this.color);
		g2.fill(r);
		
		if(iconPath != null){
			Image i = Toolkit.getDefaultToolkit().getImage(iconPath);
			
			System.out.println("Image Height: "+i.getHeight(null));
			System.out.println("Image Width: "+i.getWidth(null));
			
//			i = i.getScaledInstance((int)(SQUARE_SIZE*0.8)+1, (int)(SQUARE_SIZE*0.8)+1, Image.SCALE_SMOOTH);
			
			System.out.println("Image Height: "+i.getHeight(null));
			System.out.println("Image Width: "+i.getWidth(null));
			
			
			g2.drawImage(i, x+SQUARE_SIZE/2 - i.getWidth(null)/2,
					y+SQUARE_SIZE/2 - i.getHeight(null)/2, null);
			
			
//			g.drawImage(i, x+SQUARE_SIZE/2 - i.getWidth(null)/2,
//					y+SQUARE_SIZE/2 - i.getHeight(null)/2, null);
		
		}
	}
}