package Model;

public class Piece {
	//Uses immutable object pattern. We do not want the objects fields to be changed.
	//Piece needs to hold type, color and name
	private PieceType type;
	private PieceColor color;
	private String name;
	
	
	public Piece(PieceType type, PieceColor color, String name) {
		this.type = type;
		this.color = color;
		this.name = name;
	}
	
	//enums for type and color
	public enum PieceColor{
		White, Black
	}
	
	public enum PieceType{
		King, Queen, Rook, Knight, Bishop, Pawn
	}

	//getter methods for each
	public PieceType getPieceType() {
		return type;
	}
	
	public String getPieceName() {
		return name;
	}
	
	public PieceColor getPieceColor() {
		return color;
	}
}
