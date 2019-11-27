package edu.sjsu.cs151.model;
/**
 * Created by Sehajmeet on 10/27/2019
 */
public class Bishop extends Piece {
	PieceType type;

	public Bishop(boolean isWhite, Tile currentTile) {
		super(isWhite, PieceType.Bishop, currentTile);
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
	public boolean isValidMove(Tile start, Tile end) {
		int x_diff = Math.abs(end.getRow() - start.getRow());
		int y_diff = Math.abs(end.getCol() - start.getCol());

		return x_diff == y_diff;
	}
	
	



	

}

