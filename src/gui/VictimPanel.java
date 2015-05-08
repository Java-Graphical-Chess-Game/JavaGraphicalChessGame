package gui;


import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.io.Serializable;
import java.util.Vector;
import javax.swing.JPanel;
import components.pieces.Piece;

public class VictimPanel extends JPanel implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Vector<Piece> vP;
	private Vector<Image> images;
	
	public VictimPanel(){
		vP = new Vector<Piece>();
		images = new Vector<Image>();
		setPreferredSize(getPreferredSize());
		setBounds(getVisibleRect());
		setBackground(Color.white);
		setVisible(true);


	}

	public Dimension getPreferredSize(){

		int width = Toolkit.getDefaultToolkit().getImage("icons" + File.separator + "bking.png").getWidth(null);

		Component c= this.getParent();
		if(c == null)
			return new Dimension(
					2 * width + 10, (int)getHeight()
					);

		else{
			int h= c.getHeight();
			return new Dimension(2 * width + 10, h);
		}
	}

	public void addVictim(Piece p){
		vP.add(p);
		images.add(Toolkit.getDefaultToolkit().getImage(p.getImagePath()));
	}
	
	public void removeLastPiece(){
		vP.remove(vP.size() - 1);
		images.remove(images.size() - 1);
		redraw();
	}

	@Override
	public void paintComponent(Graphics g) {
		draw(g);
	}
	
	public void redraw(){
		paintComponent(this.getGraphics());
	}

	public void draw(Graphics g){

		if(g == null) g = this.getGraphics();
		Graphics2D g2 = (Graphics2D) g;
		Component c;
		
		g2.clearRect(0, 0, getWidth(), getHeight());
		int i = 0, j = 0;
		int pad = 10; // padding
		
		for(Image img : images){
			c=this.getParent();
			
			if((100 + i + img.getHeight(null)) >= c.getHeight()){
				i = 0;
				j += img.getWidth(null);
			}
			g2.drawImage(img, pad + j, i, null);

			i += img.getHeight(null) + pad;	
		}
	}

}