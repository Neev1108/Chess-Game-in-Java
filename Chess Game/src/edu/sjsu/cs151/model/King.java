package edu.sjsu.cs151.model;

import edu.sjsu.cs151.model.Piece.PieceType;

/**
 * Created by Sehajmeet on 10/26/2019
 */	

public class King extends Piece {

	PieceType type;
	boolean isInCheck = false;
	
	
	public King(boolean isWhite) {
		super(isWhite, PieceType.King);
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
    public boolean isValidMove(Tile start, Tile end) 
    {
    	int diffRow = start.getRow() - end.getRow();
    	diffRow = Math.abs(diffRow);
    	int diffCol = start.getCol() - end.getCol();
    	diffCol = Math.abs(diffCol);
    	
    	//King can only move 1 square in any direction (unless Castling)
    	if ((diffRow > 1 || diffCol > 1) && (this.getHasMoved() == true))
    	{
    		System.out.println("This King cannot move that far right now.");
    		return false;
    	}
    	
    	
    	
    	//check for allies
    	if (end.getIsOccupied() == true)
    	{
    		if (end.getPiece().getColorString().compareTo(start.getPiece().getColorString()) == 0)
    		{
    			System.out.println("That tile is already held by an ally");
    			return false;
    		}
    	}
    	
    	return true;
    } 
  
    public boolean getIsInCheck()
    {
    	return isInCheck;
    }
 
    public void setIsInCheck(boolean b)
    {
    	isInCheck = b;
    }

}