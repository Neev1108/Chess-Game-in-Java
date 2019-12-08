package edu.sjsu.cs151.model;

/**
 * This is the abstract piece class which contain the methods
 * that are common to all the chess pieces.
 * 
 * Created by Sehajmeet on 10/26/2019
 */
public abstract class Piece {

	// Piece needs to hold type, color and name
	private PieceType type;
	private PieceColor color;
	private String colorString;
	private boolean isWhite = false;
	private boolean PieceAlive = true;
	private boolean hasMoved = false;
	private Tile currentTile;

	public Piece(boolean isWhite, PieceType type) {
		this.isWhite = isWhite;
		if (isWhite == true) {
			color = PieceColor.White;
			colorString = "White";
		} 
		else
		{
			color = PieceColor.Black;
			colorString = "Black";
		}
		this.type = type;
	}

	/**
	 * Enum for pieceColor
	 */
	public enum PieceColor {
		White {
			@Override
			public String toString() {
				return "w";
			}
		},

		Black {
			@Override
			public String toString() {
				return "b";
			}
		}
	}
	
	/**
	 * Enum for pieceType
	 */
	public enum PieceType {
		King {
			@Override
			public String toString() {
				return "K";
			}
		},
		Queen {
			@Override
			public String toString() {
				return "Q";
			}
		},
		Rook {
			@Override
			public String toString() {
				return "R";
			}
		},
		Knight {
			@Override
			public String toString() {
				return "C"; //C for Cavalier/Chevalier
			}
		},
		Bishop {
			@Override
			public String toString() {
				return "B";
			}
		},
		Pawn {
			@Override
			public String toString() {
				return "P";
			}
		}

	}

	/**
	 * This method return true if a piece is white else returns false
	 * @return The boolean value after checking the color of the piece
	 */
	public boolean isWhite() {
		return this.isWhite;
	}

	/**
	 * Getter method for the piece type
	 * @return The type of the piece
	 */
	public PieceType getPieceType() {
		return type;
	}

	/**
	 * Getter method for the color of the piece
	 * @return The color of the piece
	 */
	public PieceColor getPieceColor() {
		return color;
	}

	/**
	 * Abstract method to check the validity of the move.
	 * @param origin The initial tile 
	 * @param destination The final tile
	 * @return The boolean value after determining the validity of the piece
	 */
	public abstract boolean isValidMove(Tile origin, Tile destination);
	
	public void move(Tile origin, Tile destination)
	{
		destination.setPiece(origin.getPiece());
		origin.setPiece(null);
		destination.setIsOccupied(true);
		origin.setIsOccupied(false);
		this.setHasMoved(true);
	}
	

	/**
	 * This method return the boolean value if a piece has died.
	 * @return true if the piece has died else false
	 */
	public boolean pieceDied() {
		this.PieceAlive = false;
		return this.PieceAlive;
	}
	
	/**
	 * This method the 
	 * @return The color of the String
	 */
	public String getColorString()
	{
		return colorString;
	}
	
	/**
	 * Getter method for the hasMoved field
	 * @return A boolean value
	 */
	public boolean getHasMoved()
	{
		return hasMoved;
	}
	
	/**
	 * Setter method for the hasMoved field
	 * @param b A boolean value
	 */
	public void setHasMoved(boolean b)
	{
		hasMoved = b;
	}
	
	/**
	 * Getter method for the current tile
	 * @return The current tile
	 */
	public Tile getCurrentTile()
	{
		return currentTile;
	}
	
	/**
	 * Setter method for the current tile
	 * @param newTile The new tile that needs to be added
	 */
	public void setCurrentTile(Tile newTile)
	{
		currentTile = newTile;
	}
}
