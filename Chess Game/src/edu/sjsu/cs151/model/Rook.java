package edu.sjsu.cs151.model;
/**
 * Created by Sehajmeet on 10/27/2019
 */

public class Rook extends Piece {
	PieceType type;
	public Rook(boolean white) {
		super(white, PieceType.Rook);
	}
	
	/**
	 * A function that determines whether the Rook moves in the right path.
	 * 
	 * @param board the board of the game
	 * @param start the initial location of the piece
	 * @param end the end location of the piece
	 * @return a boolean indicating whether the move is valid
	 */

	@Override
	public boolean isValidMove(Board board, Tile start, Tile end) {
		if ((end.getX() == start.getX()) || (end.getY() == start.getY()))
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



