package edu.sjsu.cs151.model;
/**
 * Created by Neeval Kumar on 10/27/2019
 */
public class Moves {
	
	public Tile currentPos;
	public Tile endPos;
	public Player player;
	public Piece pieceMoved;
	public Piece destinationPiece;

	/**
	 * Constructor of the Moves class.
	 * @param player The player making the move 
	 * @param currentPos The initial position of the piece
	 * @param endPos The final position of the piece
	 */
	public Moves(Player player, Tile currentPos, Tile endPos) 
	{
		this.player = player;
		this.currentPos = currentPos;
		this.endPos = endPos;
		pieceMoved = currentPos.getPiece();
		destinationPiece = endPos.getPiece();
	}
	
	/**
	 * This method returns the tile with the end position of the piece.
	 * @return The final position tile
	 */
	public Tile getEndPos() 
	{
		return endPos;
	}
	
	/**
	 * This method gets the player.
	 * @return The player
	 */
	public Player getPlayer() 
	{
		return player;
	}
	
	/**
	 * This method gets the piece that was moved.
	 * @return The moved piece
	 */
	public Piece getPieceMoved() 
	{
		return pieceMoved;
	}
	
	/**
	 * This method returns the tile with the initial position of the piece.
	 * @return The tile at the initial position
	 */
	public Tile getCurrentPos() 
	{
		return currentPos;
	}
	
	/**
	 * Method to get the piece at the final destination
	 * @return The destination piece
	 */
	public Piece getDestinationPiece() 
	{
		return destinationPiece;
	}
	
	
	
}

