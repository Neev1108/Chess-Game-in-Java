package Package;

public class Knight extends Piece { 
	
	public Knight(Piece.PieceColor color){
		super(PieceType.Knight, color, "Knight");
	}


	public Moves[] AcceptableMove(){
	return new Moves[] {
			
	//Following represents the L - direction a knight can make, combinations are 4^2 - 4 subtracting the duplicates. So there are 12 different combinations	
	new Moves(2, 1), 
	new Moves(1, 2),
	new Moves(2, -1),
	new Moves(-1, 2),
    new Moves(2, -1), 
    new Moves(-1, 2),
    new Moves(-2, 1), 
    new Moves(1, -2),
    new Moves(-2, -1), 
    new Moves(-1, -2),
    new Moves(-2, -1), 
    new Moves(-1, -2)};

}
	
}
