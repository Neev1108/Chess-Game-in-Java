package Model;


public class Tile {
	private tileColor color; //to hold the color of the tile
	private Piece piece; //the piece that occupies the tile

	public Tile(tileColor color) { //creates a constructor for a new tile with no piece
		this.color = color;
	}

	public Tile(tileColor color, Piece piece) { //creates a constructor for a new tile and that piece occupying that tile
		this.color = color;
		this.piece = piece;
	}

	public void setPiece(Piece piece) { //replaces the piece on the tile by the new piece
		this.piece = piece ;
	}

	public Piece getPiece() {
		return piece;
	}

	public enum tileColor{ //enum of what color tile can be
		White, Black
	}

}
