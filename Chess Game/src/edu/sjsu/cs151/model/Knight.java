
package edu.sjsu.cs151.model;
/**
 * Created by Sehajmeet on 10/26/2019
 */

public class Knight extends Piece {
	PieceType type;
	
	
	public Knight(boolean white) {
		super(white, PieceType.Knight);
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
	public boolean isValidMove(Board board, Tile first, Tile last) {
		if (last.getPiece().isWhite() == this.isWhite()) {
			return false;
		}

		int x_diff = Math.abs(last.getX() - first.getX());
		int y_diff = Math.abs(last.getY() - first.getY());

		if ((x_diff == 1 && y_diff == 2) || (x_diff == 2 && y_diff == 1)) {
			return true;
		}

		return false;
	}

	
}

