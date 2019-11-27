package edu.sjsu.cs151.model;

/**
 * Created by Sehaj on 10/26/2019
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

	public Piece(boolean isWhite, PieceType type, Tile currentTile) {
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
		this.currentTile = currentTile;
	}

	// enums for type and color
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

	public boolean isWhite() {
		return this.isWhite;
	}

	// getter methods for each
	public PieceType getPieceType() {
		return type;
	}

	public PieceColor getPieceColor() {
		return color;
	}

	public abstract boolean isValidMove(Tile origin, Tile destination);
	
	public void move(Tile origin, Tile destination)
	{
		destination.setPiece(origin.getPiece());
		origin.setPiece(null);
		destination.setIsOccupied(true);
		origin.setIsOccupied(false);
		this.setHasMoved(true);
	}
	

//	public abstract boolean isValidMove(Board board, Tile currentPos, Tile endPos);

	public boolean pieceDied() {
		this.PieceAlive = false;
		return this.PieceAlive;
	}
	
	
	public String getColorString()
	{
		return colorString;
	}
	
	public boolean getHasMoved()
	{
		return hasMoved;
	}
	
	public void setHasMoved(boolean b)
	{
		hasMoved = b;
	}
	
	public Tile getCurrentTile()
	{
		return currentTile;
	}
	
	public void setCurrentTile(Tile newTile)
	{
		currentTile = newTile;
	}
}
