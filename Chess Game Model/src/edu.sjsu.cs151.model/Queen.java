package Model;

public class Queen extends Piece{

	PieceType type;
public Queen(boolean white) {
	super(white);
	type = PieceType.Queen;
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
public boolean isValidMove(Board board, Tile start, Tile end) {
	int x_diff = Math.abs(end.getX() - start.getX());
	int y_diff = Math.abs(end.getX() - start.getX());

	if ((x_diff == y_diff) || (end.getX() == start.getX()) || (end.getY() == start.getY()))
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
