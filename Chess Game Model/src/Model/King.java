package Model;

public class King extends Piece {
	
	public King(PieceColor color) {
		super(PieceType.King, color, "King");
	}
	
	public Moves[] AcceptableMoves() {
		return new Moves[] { //think of the moves as plotting a point on a graph where the graph is limited to a domain and range of one.
				
				// All diagonal moves
				new Moves(1,1), // northeast direction diagonally
				new Moves(1,-1), // south east direction diagonal
				new Moves(-1,1), // south west direction diagonal
				new Moves(-1,-1), //north west direction
				
				//Horizontal and Vertical Moves
				new Moves(1,0),//move right
				new Moves(-1,0), //move left 
				new Moves(0,-1), //move down
				new Moves(0,1)}; // move up
	}	
	
	
	}
	
