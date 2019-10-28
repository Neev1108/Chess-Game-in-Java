package Model;



	//import statements

	/**
	* @author      Neeval Kumar 
	* 
	*/

	/**
	Game class that will control the mechanisms of the game.
	*/
	public class Game {
		
		public Board board;
		/** Represents the players.
		*/
		Player player1;
		Player player2;
		Player doTurn;
		GameEvent event;
		
		
		public Game() {
			board = new Board();
			if (player1.firstTurn == true) {
				this.doTurn = player1;
			}
			else
				this.doTurn = player2;
			
		}

		 

		public boolean startTurn(Moves move, Player player){
			 Piece PieceMoved = move.getPieceMoved();
			 Piece EndPiece = move.getDestinationPiece();
			 
			 
			 if (!PieceMoved.isValidMove(board, move.getCurrentPos(), move.getEndPos())){
				 return false;
			 }
			 
			 
			 if (EndPiece != null) {
				 EndPiece.pieceDied();
			 }
			 
			 move.getEndPos().setPiece(move.getPieceMoved());
			 move.getCurrentPos().setPiece(null);
			 
			 if(EndPiece instanceof King) {
				 if (player.firstTurn()) {
					 event = GameEvent.WhiteWin;
				 }
				 else 
					 event = GameEvent.BlackWin;
				 
			 }
			 
			 if(doTurn == player1) {
				 doTurn = player2;
			 }
			 else 
				 doTurn = player1;
			 
			 return true;
			 
			 
		 }
		

	}
	

	

