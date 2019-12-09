package edu.sjsu.cs151.model;

/**
 * Created by Sehajmeet on 10/27/2019
 */
public class Queen extends Piece {

	PieceType type;

	/**
	 * Constructor for the class that calls the super constructor from the abstract
	 * class and gives the color to the piece and sets it's type.
	 * 
	 * @param isWhite Boolean value to set the color white.
	 */
	public Queen(boolean isWhite) {
		super(isWhite, PieceType.Queen);
	}

	/**
	 * A function that determines whether the Queen moves in the right path.
	 * 
	 * @param start the initial location of the piece
	 * @param end   the end location of the piece
	 * @return a boolean indicating whether the move is valid
	 */

	@Override
	public boolean isValidMove(Tile start, Tile end) {
		int x_diff = Math.abs(end.getRow() - start.getRow());
		int y_diff = Math.abs(end.getCol() - start.getCol());
		System.out.println("x diff: " + x_diff + "     y diff: " + y_diff);
		if ((x_diff == y_diff) || (end.getRow() == start.getRow()) || (end.getCol() == start.getCol()))
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
