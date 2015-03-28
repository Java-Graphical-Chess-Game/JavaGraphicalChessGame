package checker;

import components.Board;
import components.Square;

public class Motion {
	public static void fetchUpSquares(Square start, Board board){
		int startX=start.getX();
		int startY=start.getY();
		int tmpY = startY;
		Square s;
		String currentColor = start.getPiece().getColor();
		for(;tmpY >= 0;tmpY--){
			s = board.getSquare(startX, tmpY);
			if(s.getPiece() != null){
				if(s.getPiece().getColor().equals(currentColor))
					break;
				else{
					s.getPiece().addPossibleSquare(s);
					break;
				} 
			}
			else{
				s.getPiece().addPossibleSquare(s);
			}
		}

	}


	public static void fetchDownSquares(Square start, Board board){
		int startX=start.getX();
		int startY=start.getY();
		int tmpY = startY;
		Square s;
		String currentColor = start.getPiece().getColor();
		for(;tmpY < 8;tmpY++){
			s = board.getSquare(startX, tmpY);
			if(s.getPiece() != null){
				if(s.getPiece().getColor().equals(currentColor))
					break;
				else{
					s.getPiece().addPossibleSquare(s);
					break;
				} 
			}
			else{
				s.getPiece().addPossibleSquare(s);
			}
		}


	}


	public static void fetchLeftSquares(Square start, Board board){
		int startX=start.getX();
		int startY=start.getY();
		int tmpX = startX;
		Square s;
		String currentColor = start.getPiece().getColor();
		for(;tmpX >= 0;tmpX--){
			s = board.getSquare(tmpX, startY);
			if(s.getPiece() != null){
				if(s.getPiece().getColor().equals(currentColor))
					break;
				else{
					s.getPiece().addPossibleSquare(s);
					break;
				} 
			}
			else{
				s.getPiece().addPossibleSquare(s);
			}
		}


	}



	public static void fetchRightSquares(Square start, Board board){
		int startX=start.getX();
		int startY=start.getY();
		int tmpX = startX;
		Square s;
		String currentColor = start.getPiece().getColor();
		for(;tmpX <8;tmpX++){
			s = board.getSquare(tmpX, startY);
			if(s.getPiece() != null){
				if(s.getPiece().getColor().equals(currentColor))
					break;
				else{
					s.getPiece().addPossibleSquare(s);
					break;
				} 
			}
			else{
				s.getPiece().addPossibleSquare(s);
			}
		}


	}


	public static void fetchUpLeftSquares(Square start, Board board){
		int startX=start.getX();
		int startY=start.getY();
		int tmpX = startX, tmpY = startY;
		Square s;
		String currentColor = start.getPiece().getColor();
		for(;tmpX >= 0 && tmpY >= 0;tmpX--, tmpY--){
			s = board.getSquare(tmpX, tmpY);
			if(s.getPiece() != null){
				if(s.getPiece().getColor().equals(currentColor))
					break;
				else{
					s.getPiece().addPossibleSquare(s);
					break;
				} 
			}
			else{
				s.getPiece().addPossibleSquare(s);
			}
		}

	}




	public static void fetchUpRightSquares(Square start, Board board){
		int startX=start.getX();
		int startY=start.getY();
		int tmpX = startX, tmpY = startY;
		Square s;
		String currentColor = start.getPiece().getColor();
		for(;tmpX < 8 && tmpY >= 0;tmpX++, tmpY--){
			s = board.getSquare(tmpX, tmpY);
			if(s.getPiece() != null){
				if(s.getPiece().getColor().equals(currentColor))
					break;
				else{
					s.getPiece().addPossibleSquare(s);
					break;
				} 
			}
			else{
				s.getPiece().addPossibleSquare(s);
			}
		}

	}




	public static void fetchDownLeftSquares(Square start, Board board){
		int startX=start.getX();
		int startY=start.getY();
		int tmpX = startX, tmpY = startY;
		Square s;
		String currentColor = start.getPiece().getColor();
		for(;tmpX >= 0 && tmpY < 8;tmpX--, tmpY++){
			s = board.getSquare(tmpX, tmpY);
			if(s.getPiece() != null){
				if(s.getPiece().getColor().equals(currentColor))
					break;
				else{
					s.getPiece().addPossibleSquare(s);
					break;
				} 
			}
			else{
				s.getPiece().addPossibleSquare(s);
			}
		}

	}


	public static void fetchDownRightSquares(Square start, Board board){
		int startX=start.getX();
		int startY=start.getY();
		int tmpX = startX, tmpY = startY;
		Square s;
		String currentColor = start.getPiece().getColor();
		for(;tmpX < 8 && tmpY < 8;tmpX++, tmpY++){
			s = board.getSquare(tmpX, tmpY);
			if(s.getPiece() != null){
				if(s.getPiece().getColor().equals(currentColor))
					break;
				else{
					s.getPiece().addPossibleSquare(s);
					break;
				} 
			}
			else{
				s.getPiece().addPossibleSquare(s);
			}
		}

	}

}
