package checker;

import java.util.ArrayList;

import components.Board;
import components.Square;

public class Motion {
	public static ArrayList<Square> fetchUpSquares(Square start, Board board){
		ArrayList<Square> ss = new ArrayList<Square>();
		int startX=start.getX();
		int startY=start.getY();
		int tmpY = startY - 1;
		Square s;
		String currentColor = start.getPiece().getColor();
		for(;tmpY >= 0;tmpY--){
			s = board.getSquare(startX, tmpY);
			if(s.getPiece() != null){
				
				if(s.getPiece().getColor() == currentColor)
					break;
				else{
					ss.add(s);
					break;
				} 
			}
			else{
				ss.add(s);
			}
		}
		return ss;
	}


	public static ArrayList<Square> fetchDownSquares(Square start, Board board){
		ArrayList<Square> ss = new ArrayList<Square>();
		int startX=start.getX();
		int startY=start.getY();
		int tmpY = startY + 1;
		Square s;
		String currentColor = start.getPiece().getColor();
		for(;tmpY < 8;tmpY++){
			s = board.getSquare(startX, tmpY);
			if(s.getPiece() != null){
				
				if(s.getPiece().getColor() == currentColor)
						break;
				else{
					ss.add(s);
					break;
				} 
			}
			else{
				ss.add(s);
			}
		}
		return ss;
	}


	public static ArrayList<Square> fetchLeftSquares(Square start, Board board){
		ArrayList<Square> ss = new ArrayList<Square>();
		int startX=start.getX();
		int startY=start.getY();
		int tmpX = startX - 1;
		Square s;
		String currentColor = start.getPiece().getColor();
		for(;tmpX >= 0;tmpX--){
			s = board.getSquare(tmpX, startY);
			if(s.getPiece() != null){
				
				if(s.getPiece().getColor() == currentColor)
					break;
				else{
					ss.add(s);
					break;
				} 
			}
			else{
				ss.add(s);
			}
		}
		return ss;
	}



	public static ArrayList<Square> fetchRightSquares(Square start, Board board){
		ArrayList<Square> ss = new ArrayList<Square>();
		int startX=start.getX();
		int startY=start.getY();
		int tmpX = startX + 1;
		Square s;
		String currentColor = start.getPiece().getColor();
		for(;tmpX <8;tmpX++){
			s = board.getSquare(tmpX, startY);
			if(s.getPiece() != null){
				
				if(s.getPiece().getColor() == currentColor)
					break;
				else{
					ss.add(s);
					break;
				} 
			}
			else{
				ss.add(s);
			}
		}
		return ss;
	}


	public static ArrayList<Square> fetchUpLeftSquares(Square start, Board board){
		ArrayList<Square> ss = new ArrayList<Square>();
		int startX=start.getX();
		int startY=start.getY();
		int tmpX = startX - 1, tmpY = startY - 1;
		Square s;
		String currentColor = start.getPiece().getColor();
		for(;tmpX >= 0 && tmpY >= 0;tmpX--, tmpY--){
			s = board.getSquare(tmpX, tmpY);
			if(s.getPiece() != null){
				
				if(s.getPiece().getColor() == currentColor)
					break;
				else{
					ss.add(s);
					break;
				} 
			}
			else{
				ss.add(s);
			}
		}
		return ss;
	}




	public static ArrayList<Square> fetchUpRightSquares(Square start, Board board){
		ArrayList<Square> ss = new ArrayList<Square>();
		int startX=start.getX();
		int startY=start.getY();
		int tmpX = startX + 1, tmpY = startY - 1;
		Square s;
		String currentColor = start.getPiece().getColor();
		for(;tmpX < 8 && tmpY >= 0;tmpX++, tmpY--){
			s = board.getSquare(tmpX, tmpY);
			if(s.getPiece() != null){
				
				if(s.getPiece().getColor() == currentColor)
					break;
				else{
					ss.add(s);
					break;
				} 
			}
			else{
				ss.add(s);
			}
		}
		return ss;
	}




	public static ArrayList<Square> fetchDownLeftSquares(Square start, Board board){
		ArrayList<Square> ss = new ArrayList<Square>();
		int startX=start.getX();
		int startY=start.getY();
		int tmpX = startX - 1, tmpY = startY + 1;
		Square s;
		String currentColor = start.getPiece().getColor();
		for(;tmpX >= 0 && tmpY < 8;tmpX--, tmpY++){
			s = board.getSquare(tmpX, tmpY);
			if(s.getPiece() != null){
				
				if(s.getPiece().getColor() == currentColor)
					break;
				else{
					ss.add(s);
					break;
				} 
			}
			else{
				ss.add(s);
			}
		}
		return ss;
	}


	public static ArrayList<Square> fetchDownRightSquares(Square start, Board board){
		ArrayList<Square> ss = new ArrayList<Square>();
		int startX=start.getX();
		int startY=start.getY();
		int tmpX = startX + 1, tmpY = startY + 1;
		Square s;
		String currentColor = start.getPiece().getColor();
		for(;tmpX < 8 && tmpY < 8;tmpX++, tmpY++){
			s = board.getSquare(tmpX, tmpY);
			if(s.getPiece() != null){
				
				if(s.getPiece().getColor() == currentColor)
					break;
				else{
					ss.add(s);
					break;
				} 
			}
			else{
				ss.add(s);
			}
		}
		return ss;
	}

}
