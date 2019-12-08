package edu.sjsu.cs151.model;

/**
 * This class is used to creates the tiles for the ChessBoard.
 * 
 * @author Sehajmeet
 *
 */
public class Tile {
	private Piece piece; // the piece that occupies the tile
	private int row;	// row and col coordinates of the tile
	private int col;   // row and col coordinates of the tile
	private boolean isOccupied;

	/**
	 * Constructor to initialize coordinates and piece
	 * 
	 * @param row   The horizontal coordinate of the tile
	 * @param col   The vertical coordinate of the tile
	 * @param piece The chess piece
	 */
	public Tile(int row,int col, Piece piece) {
		this.piece = piece;
		this.row = row;
		this.col = col;
		if (piece == null) {
			isOccupied = false;
		} else {
			isOccupied = true;
		}
	}

	// getter and setter methods for our instance fields

	/**
	 * This is the getter method for the piece.
	 * 
	 * @return A piece
	 */
	public Piece getPiece() {
		return this.piece;
	}

	/**
	 * This method replaces the piece on the tile by the new piece.
	 * 
	 * @param piece The moved piece
	 */
	public void setPiece(Piece piece) { // replaces the piece on the tile by the new piece
		this.piece = piece;
	}

	/**
	 * The getter method to get the horizontal coordinate of the tile.
	 * 
	 * @return The the horizontal coordinate of the tile
	 */
	public int getRow() {
		return this.row;
	}

	/**
	 * The setter method to set the horizontal coordinate of the tile.
	 * 
	 * @param row the horizontal coordinate of the tile
	 */
	public void setX(int row) {
		this.row = row;
	}

	/**
	 * The getter method to get the vertical coordinate of the tile.
	 * 
	 * @return The the vertical coordinate of the tile
	 */
	public int getCol() {
		return this.col;
	}

	/**
	 * The setter method to set the vertical coordinate of the tile
	 * 
	 * @param col the horizontal coordinate of the tile
	 */

	public void setCol(int col) {
		this.col = col;
	}

	/**
	 * This method checks if a tile is already occupied or not.
	 * 
	 * @return The boolean value after determining the tile
	 */
	public boolean getIsOccupied() {
		return isOccupied;
	}

	/**
	 * This method tells the piece if a tile is occupied or not and that it cannot
	 * be moved
	 * 
	 * @param b The boolean value after determining the emptiness of the tile.
	 */
	public void setIsOccupied(boolean b) {
		isOccupied = b;
	}
}