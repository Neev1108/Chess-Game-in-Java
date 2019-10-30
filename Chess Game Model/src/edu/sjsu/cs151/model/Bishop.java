package edu.sjsu.cs151.model;
/**
 * Created by Sehajmeet on 10/27/2019
 */
public class Bishop extends Piece {
	PieceType type;

	public Bishop(boolean white) {
		super(white);
		type = PieceType.Bishop;
	}

	/**
	 * A function that gets the Piece type.
	 * 
	 * @return an integer indicating the Piece type
	 */
	public PieceType getType() {
		return type;
	}

	/**
	 * A function that determines whether the Bishop moves in the right path.
	 * 
	 * @param board the board of the game
	 * @param start the initial location of the piece
	 * @param end the end location of the piece
	 * @return a boolean indicating whether the move is valid
	 */
	public boolean isValidMove(Board board, Tile start, Tile end) {
		int x_diff = Math.abs(end.getX() - start.getX());
		int y_diff = Math.abs(end.getY() - start.getY());

		return x_diff == y_diff;
	}
	
	



	

}

