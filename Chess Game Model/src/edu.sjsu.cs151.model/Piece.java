package edu.sjsu.cs151.model;
/**
 * Created by Sehajmeet on 10/26/2019
 */
public abstract class Piece {

	//Piece needs to hold type, color and name
	private PieceType type;
	private PieceColor color;
	boolean white = false;
	boolean PieceAlive = true;
	
	
	public Piece(boolean white) {
		this.white = white;
	}
	
	
	//enums for type and color
	public enum PieceColor{
		White, Black
	}
	
	public enum PieceType{
		King, Queen, Rook, Knight, Bishop, Pawn
	}
	
	public boolean isWhite() {
		return this.white == true;
	}

	//getter methods for each
	public PieceType getPieceType() {
		return type;
	}
	
	
	public PieceColor getPieceColor() {
		return color;
	}
	
	public abstract boolean isValidMove(Board board, Tile currentPos, Tile endPos);
	
	public boolean pieceDied() {
		this.PieceAlive = false;
		return this.PieceAlive;
	}
}
