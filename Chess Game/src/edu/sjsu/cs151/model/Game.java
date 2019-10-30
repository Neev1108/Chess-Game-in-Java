package edu.sjsu.cs151.model;


/**
 * Created by Neeval on 10/27/2019
 */
	public class Game {
		
		public Board board;
		/** Represents the players.
		*/
		Player player1 = new Player("white" , true);
		Player player2 = new Player("black", false);
		Player doTurn;
		GameEvent event;
		
		public Player getPlayer1()
		{
			return player1;
		}

		public Player getPlayer2()
		{
			return player2;
		}

		public Player getDoTurn()
		{
			return doTurn;
		}

		public GameEvent getEvent()
		{
			return event;
		}

		public Game() {
			this.board = Board.getInstance();
			if (player1.firstTurn == true) {
				this.doTurn = player1;
			}
			else
				this.doTurn = player2;
			
		}

		public void printBoard() {
			Tile[][] b = board.getArray();
			for (int i = 0; i < 8; i++ ) {
				for (int j= 0; j < 8; j++) {
					
					if (b[i][j].getPiece() == null) {
						System.out.print("-   ");
						if (j == 7) {
							System.out.println();
						}
					}
					else {
						
					System.out.print(b[i][j].getPiece() + " ");}
					if (j == 7) {
						System.out.println();
					}
				}
			
			}
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
	

	

