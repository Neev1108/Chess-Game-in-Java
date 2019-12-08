
package edu.sjsu.cs151.model;
/**
 * Created by Sehajmeet on 10/26/2019
 */

public class Knight extends Piece {
	PieceType type;
	
	/**
	 * Constructor of the Knight class
	 * @param isWhite boolean value to check if 
	 * the knight piece is white or not
	 */
	public Knight(boolean isWhite) {
		super(isWhite, PieceType.Knight);
	}

	/**
	 * A function that gets the Piece type.
	 * 
	 * @return an integer indicating the Piece type
	 */
	public PieceType getType() {
		return PieceType.Knight;
	}

	/**
	 * A function that determines whether the Knight is moving in an "L" path.
	 * 
	 * @param first the initial location of the piece
	 * @param last  the ends location of the piece
	 * @return a boolean indicating whether the move is valid
	 */

	@Override
	public boolean isValidMove(Tile origin, Tile destination) {
		
		if (destination.getIsOccupied() == true)
		{
			if (destination.getPiece().isWhite() == this.isWhite()) {
				return false;
			}
		}

		int x_diff = Math.abs(destination.getRow() - origin.getRow());
		int y_diff = Math.abs(destination.getCol() - origin.getCol());

		if ((x_diff == 1 && y_diff == 2) || (x_diff == 2 && y_diff == 1)) {
			return true;
		}

		return false;
	}

	
}

