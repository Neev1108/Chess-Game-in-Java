package Model;
	

public class King extends Piece {

	PieceType type;
	
	
	public King(boolean white) {
		super(white);
		type = PieceType.King;
	}

	/**
	 * A function that gets the Piece type.
	 * 
	 * @return an integer indicating the Piece type
	 */
	public PieceType getType() {
		return PieceType.King;
	}

	/**
	 * A function that determines whether the King moves in the right path.
	 * 
	 * @param board the board of the game
	 * @param start the initial location of the piece
	 * @param end the end location of the piece
	 * @return a boolean indicating whether the move is valid
	 */

	
	    @Override
	    public boolean isValidMove(Board board, Tile start, Tile end) 
	    { 
	        // we can't move the piece to a Box that  
	        // has a piece of the same color 
	        if (end.getPiece().isWhite() == this.isWhite()) { 
	            return false; 
	        } 
	  
	        int x = Math.abs(start.getX() - end.getX()); 
	        int y = Math.abs(start.getY() - end.getY()); 
	        if (x + y == 1) { 
	            // check if this move will not result in the king 
	            // being attacked if so return true 
	            return true; 
	        }
	        else
	        	return false;
	  
	    } 
	  

	 


	}	
	
	
	
	
