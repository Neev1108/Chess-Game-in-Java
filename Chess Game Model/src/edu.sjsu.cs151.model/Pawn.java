package Model;

import Model.Piece.PieceType;
import Model.Game;
public class Pawn extends Piece {
	Game game;

	PieceType type = PieceType.Pawn;
	Player player;

	/**
	 * The constructor for a Pawn.
	 * 
	 * @param x      the Pawn's X location
	 * @param y      the Pawn's Y location
	 * @param player the Pawn's associated player
	 */
	public Pawn(boolean white) {
		super(white);
	}

	/**
	 * A function that gets the Piece type.
	 * 
	 * @return an enum indicating the Piece type
	 */
	public PieceType getType() {
		return type;
	}

	/**
	 * A function that determines whether the pawn is moving two steps or one step
	 * or captures diagonally.
	 * 
	 * @param start the initial box of the board
	 * @param end   the final box of the board
	 * @return a boolean indicating whether the path is valid
	 */
	public boolean isValidMove(Board board, Tile start, Tile end) {
		// checks if it is the player's first turn, and if there are no units along the
		// path
		// if so, it will let the pawn move two spaces forward
		
		// if (pawnCanMoveTwo(board, start, end))
			//return true;

		// checks if pawn is moving on a diagonal, if it is moving only one space, and
		// if there is an enemy in that space
		if (pawnCanCapture(board, start, end))
			return true;

		// checks if pawn is moving one space forward, does not let it move forward
		// unless space is empty
		if (pawnCanMoveForward(board, start, end))
			return true;

		else {
			return false;
		}
	}

	/**
	 * A function that determines whether the pawn is moving two steps.
	 * 
	 * @param start the initial box of the board
	 * @param end   the final box of the board
	 * @return a boolean indicating whether the path is valid
	 */
	
	/*
	protected boolean pawnCanMoveTwo(Board board, Tile start, Tile end) {
		// we can't move the piece to a Spot that
		// has a piece of the same color
		if (end.getPiece().isWhite() == this.isWhite()) {
			return false;
		}

		int abs_Y_diff = Math.abs(end.getY() - start.getY());

		if ((abs_Y_diff == 2) && (this.game.doTurn == 1 || this.player.game.turn == 2)
				&& (board.getTile(end.getX(), end.getY()) == null)) {
			return true;
		}

		else
			return false;
	}

*/
	/**
	 * A function that determines whether the pawn captures diagonally.
	 * 
	 * @param start the initial box of the board
	 * @param end   the final box of the board
	 * @return a boolean indicating whether the path is valid
	 */
	protected boolean pawnCanCapture(Board board, Tile start, Tile end) {

		// we can't move the piece to a Spot that
		// has a piece of the same color
		if (end.getPiece().isWhite() == this.isWhite()) {
			return false;
		}
		int abs_X_diff = Math.abs(end.getX() - start.getX());
		int abs_Y_diff = Math.abs(end.getY() - start.getY());
		int Y_diff = end.getY() - start.getY();

		if ((abs_X_diff == abs_Y_diff) && (abs_Y_diff == 1)) {
			if ((board.getTile(end.getX(), end.getY()) != null && Y_diff < 0))
				return true;

			if ((board.getTile(end.getX(), end.getY()) != null && Y_diff > 0))
				return true;
		}

		return false;

	}

	/**
	 * A function that determines whether the pawn is moving one step.
	 * 
	 * @param start the initial box of the board
	 * @param end   the final box of the board
	 * @return a boolean indicating whether the path is valid
	 */
	protected boolean pawnCanMoveForward(Board board, Tile start, Tile end) {
		if (end.getPiece().isWhite() == this.isWhite()) {
			return false;
		}
		int abs_Y_diff = Math.abs(end.getY() - start.getY());
		int Y_diff = end.getY() - start.getY();

		if (((Y_diff < 0 && abs_Y_diff == 1) || (Y_diff > 0 && abs_Y_diff == 1))
				&& ((board.getTile(end.getX(), end.getY()) == null && start.getX() == end.getX()))) {
			return true;
		}

		return false;
	}

}
	

