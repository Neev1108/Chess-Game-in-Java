package edu.sjsu.cs151.model;
/**
 * Created by Sehajmeet on 10/26/2019
 */
public class Pawn extends Piece {
	
	PieceType type = PieceType.Pawn;

	/**
	 * The constructor for a Pawn.
	 */
	
	public Pawn(boolean isWhite) {
		super(isWhite, PieceType.Pawn);
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
	public boolean isValidMove(Tile origin, Tile destination) {
				
		int diffRow = origin.getRow() - destination.getRow();
		int diffCol = origin.getCol() - destination.getCol();
		System.out.println(origin.getRow() + " " + destination.getRow() + " " + diffRow);
		System.out.println(origin.getCol() + " " + destination.getCol() + " " + diffCol);
		diffRow = Math.abs(diffRow);
		diffCol = Math.abs(diffCol);
		
		System.out.println("hasMoved = " + this.getHasMoved());
		//outside any eligible move range
		if (diffCol > 1)
		{
			System.out.println("That is too far for a pawn to move in X.");
			return false;
		}
		if ((this.getHasMoved() == true) && (diffRow == 2))
		{
			System.out.println("This pawn has already moved and can now only move one space forward at a time.");
			return false;
		}
		if (diffRow != 1 && diffRow != 2)
		{
			System.out.println("That is too far for a pawn to move in Y.");
			return false;
		}
		
		//pawn is trying to capture
		if (diffCol != 0)
		{
			boolean destOcc = destination.getIsOccupied();
			//no piece in destination, can't capture
			if (destOcc == false)
			{
				System.out.println("You can't capture an empty space.");
				return false;
			}
			//destination contains an ally
			if (destination.getPiece().getPieceColor().equals(this.getPieceColor()))
			{
				System.out.println("You can't capture your allies.");
				return false;
			}
			return true;
		}
		
		if (destination.getIsOccupied() == true)
		{
			System.out.println("Pawns cannot interact with pieces directly ahead.");
			return false;
		}
		
		return true;
	}
}
	

