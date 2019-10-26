package Model;

public class Pawn extends Piece {
	public Pawn(PieceColor color){
		super(PieceType.Pawn, color, "Pawn");
	}

	
	//
	public Moves[] AcceptableMoves(PieceColor color, boolean firstMove){
        if (color == PieceColor.Black){
            Moves[] moves = new Moves[4];
            
            //Move up
            moves[0] = new Moves(0,1);
            
            //Cut sideways if taking an enemy piece
            moves[1] = new Moves(1,1);
            moves[2] = new Moves(-1,1);
            
            //
            if (firstMove == true)
            	moves[3] = new Moves(0,2);
            
            return moves;
            } 
        
	    else {
           Moves[] moves = new Moves[4];
           moves[0] = new Moves(0,-1);
           moves[1] = new Moves(1,-1);
           moves[2] = new Moves(-1,-1);
        
           if (firstMove == true)
           	moves[3] = new Moves(0,-2);
           
           return moves;
	    }
}
	
}
