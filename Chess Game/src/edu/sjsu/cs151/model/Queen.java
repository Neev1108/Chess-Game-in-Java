package edu.sjsu.cs151.model;
/**
 * Created by Sehajmeet on 10/27/2019
 */
public class Queen extends Piece{

	PieceType type;
public Queen(boolean isWhite) {
	super(isWhite, PieceType.Queen);
}

/**
 * A function that determines whether the Queen moves in the right path.
 * 
 * @param board the board of the game
 * @param start the initial location of the piece
 * @param end the end location of the piece
 * @return a boolean indicating whether the move is valid
 */

@Override
public boolean isValidMove(Tile start, Tile end) {
	int x_diff = Math.abs(end.getRow() - start.getRow());
	int y_diff = Math.abs(end.getRow() - start.getRow());

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
