package edu.sjsu.cs151.model;

/**
 * Created by Sehajmeet on 10/27/2019
 */

public class Rook extends Piece {
	PieceType type;

	/**
	 * Constructor for the class that calls the super constructor from the abstract
	 * class and gives the color to the piece and sets it's type.
	 * 
	 * @param isWhite Boolean value to set the color white.
	 */
	public Rook(boolean isWhite) {
		super(isWhite, PieceType.Rook);
	}

	/**
	 * A function that determines whether the Rook moves in the right path.
	 * 
	 * @param start the initial location of the piece
	 * @param end   the end location of the piece
	 * @return a boolean indicating whether the move is valid
	 */

	@Override
	public boolean isValidMove(Tile start, Tile end) {
		if ((end.getRow() == start.getRow()) || (end.getCol() == start.getCol()))
			return true;

		return false;
	}

	/**
	 * A function that gets the Piece type.
	 * 
	 * @return an integer indicating the Piece type
	 */
	public PieceType getType() {
		return type;
	}
}
