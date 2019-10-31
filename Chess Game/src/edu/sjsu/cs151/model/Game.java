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

			 boolean isCollision = checkCollisions(move, player, PieceMoved);
			 if (isCollision == true)
			 {
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
		


		 public boolean isOccupied(Tile tile)
		 {
		 	if (tile.getPiece() != null)
			{
				return true;
			}
		 	return false;
		 }

		 // returns false if there are NOT any collisions
		 public boolean checkCollisions(Moves move, Player player, Piece pieceMoved)
		 {
		 	Piece.PieceType type = pieceMoved.getPieceType();

		 	//Knights can jump over other pieces, so only need to check for allies in the destination
		 	if (type.equals(Piece.PieceType.Knight))
			{
				if (pieceMoved.getPieceColor().equals(move.getDestinationPiece().getPieceColor()))
				{
					System.out.println("That spot is occupied by an ally. You cannot move there.");
					return true;
				}
				return false;
			}
		 	
		 	
		 	int changeX = move.getEndPos().getX() - move.getCurrentPos().getX();
		 	int changeY = move.getEndPos().getY() - move.getCurrentPos().getY();
		 	//If x coordinate did not change
			if (changeX == 0)
			{
				if (changeY > 0)
				{
					//piece moved in increasing Y
					for (int i = 1; i <= changeY; i++)
					{
						boolean occupied = isOccupied(board.getTile(move.getCurrentPos().getX(), (move.getCurrentPos().getY() + i)));
						if (occupied == true)
						{
							System.out.println("A different piece prevents you from reaching your destination. Please select another destination.");
							return true;
						}
					}
				}
				else //piece moved in decreasing Y
				{
					for (int i = -1; i >= changeY; i--)
					{
						boolean occupied = isOccupied(board.getTile(move.getCurrentPos().getX(), (move.getCurrentPos().getY() + i)));
						if (occupied == true)
						{
							System.out.println("A different piece prevents you from reaching your destination. Please select another destination.");
							return true;
						}
					}
				}
			}

			//if Y coordinate did not change
			else if (changeY == 0)
			{
				if (changeX > 0)
				{
					//piece moved in increasing X
					for (int i = 1; i <= changeX; i++)
					{
						boolean occupied = isOccupied(board.getTile((move.getCurrentPos().getX() + i), move.getCurrentPos().getY()));
						if (occupied == true)
						{
							System.out.println("A different piece prevents you from reaching your destination. Please select another destination.");
							return true;
						}
					}
				}
				
				else
				{
					//piece moved in decreasing X
					for (int i = -1; i >= changeX; i--)
					{
						boolean occupied = isOccupied(board.getTile((move.getCurrentPos().getX() + i), move.getCurrentPos().getY()));
						if (occupied == true)
						{
							System.out.println("A different piece prevents you from reaching your destination. Please select another destination.");
							return true;
						}
					}
				}
				
			}
			
			
			//If the piece moved diagonally
			if (Math.abs(changeX) == Math.abs(changeY))
			{
				//both x and y increase
				for (int i = 1; i <= changeX; i++)
				{
					boolean occupied = isOccupied(board.getTile((move.getCurrentPos().getX() + i), (move.getCurrentPos().getY() + i)));
					if (occupied == true)
					{
						System.out.println("A different piece prevents you from reaching your destination. Please select another destination.");
						return true;
					}
				}
				
				//both x and y decrease
				for (int i = -1; i >= changeX; i--)
				{
					boolean occupied = isOccupied(board.getTile((move.getCurrentPos().getX() + i), (move.getCurrentPos().getY() + i)));
					if (occupied == true)
					{
						System.out.println("A different piece prevents you from reaching your destination. Please select another destination.");
						return true;
					}
				}
				
				
				//x decreases while y increases
				for (int i = 1; i <= changeY; i++)
				{
					boolean occupied = isOccupied(board.getTile((move.getCurrentPos().getX() - i), (move.getCurrentPos().getY() + i)));
					if (occupied == true)
					{
						System.out.println("A different piece prevents you from reaching your destination. Please select another destination.");
						return true;
					}
				}
				
				//y decreases while x increases
				for (int i = 1; i <= changeX; i++)
				{
					boolean occupied = isOccupied(board.getTile((move.getCurrentPos().getX() + i), (move.getCurrentPos().getY() - i)));
					if (occupied == true)
					{
						System.out.println("A different piece prevents you from reaching your destination. Please select another destination.");
						return true;
					}
				}
			}
			
			
			
		 	return false;
		 }




	}
	

	

