package game;

import gui.ChessFrame;
import gui.GraphicalBoard;
import gui.VictimPanel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.JOptionPane;

public class SaveLoadLibrary {

	
	public static void save(Game g) throws IOException{
		File savedFile = new File(
				//System.getProperty("user.home") + 
				//File.separator + 
				//"Chess_Saved_Games" + 
				//File.separator + 
				"savedGame.bla"
				);
		savedFile.createNewFile();
		
		ObjectOutputStream oos = new ObjectOutputStream(
				new FileOutputStream(savedFile));
		
		oos.writeObject(g);
		
		oos.close();
	}
	
	public static Game load() throws FileNotFoundException, IOException, ClassNotFoundException{
		File loadedFile = new File(
				//System.getProperty("user.home") + 
				//File.separator + 
				//"Chess_Saved_Games" + 
				//File.separator + 
				"savedGame.bla"
				);
		if(!loadedFile.exists()){
			JOptionPane.showMessageDialog(null, "No Saved Game Found.", "Load Error", 
					JOptionPane.OK_OPTION);
			return null;
		}
			
		ObjectInputStream ois = new ObjectInputStream(
				new FileInputStream(loadedFile));
		
		Game g;
		
		g = (Game)ois.readObject();
		GraphicalBoard guiBoard = new GraphicalBoard(g.getBoard());
		VictimPanel vp = new VictimPanel();
		g.setFrame(new ChessFrame(guiBoard));
		g.getFrame().setVP(vp);
		g.updateGameState();
		
		ois.close();
		
		return g;
		
	}
}