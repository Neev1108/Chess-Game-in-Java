package Model;

public class Piece {
	private PieceType type;
	private PieceColor color;
	private String name;
	
	
	public Piece(PieceType type, PieceColor color, String name) {
		this.type = type;
		this.color = color;
		this.name = name;
	}
	
	public enum PieceColor{
		White, Black
	}
	
	public enum PieceType{
		King, Queen, Rook, Knight, Bishop, Pawn
	}

	
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
