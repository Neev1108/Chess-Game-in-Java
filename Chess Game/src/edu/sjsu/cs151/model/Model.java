package edu.sjsu.cs151.model;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.BlockingQueue;

import edu.sjsu.cs151.controller.Message;
import edu.sjsu.cs151.controller.PlayerChosenMessage;

/**
 * This is the Model class for our Chess game.
 * Created by Neeval on 10/27/2019
 */
public class Model {
	
	private Board board;
	/** Represents the players.
	*/
	Player player1 = new Player("White" , true);
	Player player2 = new Player("Black", false);
	Player doTurn;
	GameEvent event;
	BlockingQueue<Message> queue;
	String message;
	
	/**
	 * Method to get the Player1
	 * @return player
	 */
	public Player getPlayer1()
	{
		return player1;
	}
	
	/**
	 * Method to set the Player2 using the Message from the controller
	 * @param message PlayerChosen message from the controller
	 */
	public void setPlayer1(PlayerChosenMessage message) {
		this.player1 = new Player(message.getColor(), message.isFirstTurn());
	}
	
	/**
	 * Method to get the Player
	 * @return player
	 */
	public Player getPlayer2()
	{
		return player2;
	}


	/**
	 * Method to set the Player2 using the Message from the controller
	 * @param message PlayerChosen message from the controller
	 */
	public void setPlayer2(PlayerChosenMessage message) {
		this.player2 = new Player(message.getColor(), message.isFirstTurn());
	}
	
	
	/**
	 * Method for making the players to complete their turn
	 * @return The player that needs to do the turn
	 */
	public Player getDoTurn()
	{
		return doTurn;
	}

	/**
	 * Method to get the current state of the game. 
	 * @return GameEvent
	 */
	public GameEvent getEvent()
	{
		return event;
	}
	
	
	
	/**
	 * Constructor for the Model
	 */
	public Model() {
		this.board = Board.getInstance();
		// Checking if the color of the first moving player is white.
		if (player1.getColor().equals("White")) {
			this.doTurn = player1;
		}
		else
			this.doTurn = player2;
	}

	/**
	 * Method to print the board with all the pieces
	 * on the board.
	 */
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
					
				System.out.print(b[i][j].getPiece().getPieceColor().toString()  + b[i][j].getPiece().getPieceType().toString() + " ");}
				if (j == 7) {
					System.out.println();
				}
			}
		
		}
	}
	
	
	/**
	 * Method to play the game	 
	 */
	public void playGame()
	{
		Scanner scan = new Scanner(System.in);
		Player currentPlayer = this.getPlayer1();
		while ((this.getEvent() != GameEvent.WhiteWin) && (this.getEvent() != GameEvent.BlackWin))
		{
			this.printBoard();
			System.out.println(currentPlayer.getColor() + " team is making their move.");
		/*	if (currentPlayer.getKing.getIsInCheck() == true)
				{
					System.out.println(currentPlayer.getName() + ", your king is in check.")
				}
				display warning if currentPlayer's king is in check
			 */

			System.out.println("Please input the row of the current location of the piece you wish to move:");
			int row = scan.nextInt();
			if (row < 0 || row > 7)
			{
				System.out.println("That is not a valid coordinate. Please try again.");
				continue;
			}
			
			
			System.out.println("Please input the column of the current location of the piece you wish to move:");
			int col = scan.nextInt();
			if (col < 0 || col > 7)
			{
				System.out.println("That is not a valid coordinate. Please try again.");
				continue;
			}
			
			
			
			Tile currentTile = this.board.getTile(row, col);
			if (currentTile.getIsOccupied() == false)
			{
				System.out.println("This tile is unoccupied. Please select a tile with a piece.");
				continue;
			}
			
			Piece currentPiece = currentTile.getPiece();
			if (currentPlayer.getColor().compareTo(currentPiece.getColorString()) != 0)
			{
				System.out.println("The piece you selected is your opponent's. Please select a " + currentPlayer.getColor() + " piece.");
				continue;
			}
			
			
			System.out.println("You have selected " + currentPiece.getPieceColor() + " " + currentPiece.getPieceType() + ".");

			
			System.out.println("Please input the row of the desired destination:");
			row = scan.nextInt();
			if (row < 0 || row > 7)
			{
				System.out.println("That is not a valid coordinate. Please try again.");
				continue;
			}
			
			System.out.println("Please input the column of the desired destination:");
			col = scan.nextInt();
			if (col < 0 || col > 7)
			{
				System.out.println("That is not a valid coordinate. Please try again.");
				continue;
			}
			
			
			Tile targetTile = this.board.getTile(row, col);
			Moves currentMove = new Moves(currentPlayer, currentTile, targetTile);
			boolean validMove = this.startTurn(currentMove);
			if (!validMove)
				continue;
			System.out.println("Move successful\n");
			
			
			if (this.getEvent() == GameEvent.WhiteWin || this.getEvent() == GameEvent.BlackWin)
			{
				System.out.println("Game complete");
				break;
			}
			else 
			{
				
				if (currentPlayer.equals(this.getPlayer1())) 
				{
					currentPlayer = this.getPlayer2();
				} 
				else
					currentPlayer = this.getPlayer1();
				System.out.println("Turn complete, " + currentPlayer.toString() + " will begin their turn.");

			}
		}
		scan.close();
	}
	

	/**
	 * Method to check if the player is making a valid move 
	 * and not moving the enemy pieces
	 * @param move
	 * @return The boolean value by checking the validity of the move.
	 */
	
	public boolean startTurn(Moves move){
		ArrayList<String> results = new ArrayList<String>();
		Player player = move.getPlayer();
		Piece PieceMoved = move.getPieceMoved();
		Piece EndPiece = move.getDestinationPiece();

		if (player.getColor().compareTo(PieceMoved.getColorString()) != 0)
			{
				results.add("The piece you selected is your opponent's. Please select a " + player.getColor() + " piece.");
				results.add("false");
				System.out.println("The piece you selected is your opponent's. Please select a " + player.getColor() + " piece.");
				String oppPiece = "The piece you selected is your opponent's. Please select a " + player.getColor() + " piece.";
				message = oppPiece;
				return false;
			}
		 
		 //Check if the move can be performed by the piece
		 if (!PieceMoved.isValidMove(move.getCurrentPos(), move.getEndPos())){
			 System.out.println("Error: the destination you have selected is outside this piece's valid movement range.\n Please select an alternate destination or piece.");
			 message = "Error: the destination you have selected is outside this piece's valid movement range.\n Please select an alternate destination or piece.";
			 return false;
		 }

		 //check for obstacles on the path
		 boolean isCollision = checkCollisions(move, player, PieceMoved);
		 if (isCollision == true)
		 {
		 	return false;
		 }
		 
		 //check if the destination contains an ally
		 
		 boolean containsAlly = checkDestinationForAlly(move, player, PieceMoved);
		 if (containsAlly == true)
		 {
			 return false;
		 }
		 
		 
		 //test if the move leaves allied king in check
	/*	 boolean testAllyKingCheck = false;
		 if (player.getColor().compareTo("White") == 0)
		 {
			 testAllyKingCheck = kingInCheck(board.getWhiteKing());
		 }
		 else
		 {
			 testAllyKingCheck = kingInCheck(board.getBlackKing());
		 }
		 if (testAllyKingCheck == true)
		 {
			 System.out.println("This move would leave your King in danger and thus cannot be performed");
			 return false;
		 }
*/ 
		 //Move is able to be performed; perform move
		 PieceMoved.move(move.getCurrentPos(), move.getEndPos());
		 
		 
		 if (EndPiece != null) {
			 EndPiece.pieceDied();
		 }
		 
		 move.getEndPos().setPiece(move.getPieceMoved());
		 move.getCurrentPos().setPiece(null);
		 
		 if(EndPiece instanceof King) {
			 if (player.getColor().equals("White")) {
				 event = GameEvent.WhiteWin;
			 }
			 else 
				 event = GameEvent.BlackWin;
			 
		 }
		 
		 System.out.println("Move successful\n");
			
			
		if (this.getEvent() == GameEvent.WhiteWin || this.getEvent() == GameEvent.BlackWin)
		{
			System.out.println("Game complete");
			return true;
		}
		else 
		{
			
			if (player.equals(this.getPlayer1())) 
			{
				player = this.getPlayer2();
			} 
			else
				player = this.getPlayer1();
			System.out.println("Turn complete, " + player.toString() + " will begin their turn.");

		}
		 
		 if(doTurn == player1) {
			 doTurn = player2;
		 }
		 else 
			 doTurn = player1;
		 
		 return true;
	 }
	

	/**
	 * Method to check if a tile is already occupied or not
	 * @param tile The tile value
	 * @return The boolean value to check if the tile is occupied or not
	 */
	 public boolean isOccupied(Tile tile)
	 {
	 	if (tile.getPiece() != null)
		{
			return true;
		}
	 	return false;
	 }

	 /**
	  * Method to check if the destination is occupied by a friendly piece or not
	  * @param move The valid move of the player
	  * @param player The Player making the move
	  * @param pieceMoved The piece moved by the player
	  * @return false if there is not an ally (either empty or enemy)
	  */
	 public boolean checkDestinationForAlly(Moves move, Player player, Piece pieceMoved)
	 {
		 if (move.getEndPos().getIsOccupied() == false)
		 {
			 return false;
		 }
		 if (pieceMoved.getColorString().compareTo(move.getDestinationPiece().getColorString()) == 0)
		 {
			 return true;
		 }
		 return false;
	 }
	 
	 /**
	  * Method to check if any collisions happened or not.
	  * @param player The Player making the move
	  * @param pieceMoved The piece moved by the player
	  * @return  false if there are NOT any collisions
	  */
	 // returns false if there are NOT any collisions
	 public boolean checkCollisions(Moves move, Player player, Piece pieceMoved)
	 {
	 	Piece.PieceType type = pieceMoved.getPieceType();
	 	boolean destOcc = move.getEndPos().getIsOccupied();
	 	//Knights can jump over other pieces, so only need to check for allies in the destination
	 	if (type.equals(Piece.PieceType.Knight) && destOcc == true)
		{
			if (pieceMoved.getPieceColor().equals(move.getDestinationPiece().getPieceColor()))
			{
				String allyOccupied = "That spot is occupied by an ally. You cannot move there.";
				System.out.println(allyOccupied);
				message = allyOccupied;
				return true;
			}
			return false;
		}
	 	
	 	
	 	int changeX = move.getEndPos().getRow() - move.getCurrentPos().getRow();
	 	int changeY = move.getEndPos().getCol() - move.getCurrentPos().getCol();
	 	//If x coordinate did not change
		if (changeX == 0)
		{
			if (changeY > 0)
			{
				//piece moved in increasing Y
				for (int i = 1; i < changeY; i++)
				{
					boolean occupied = isOccupied(board.getTile(move.getCurrentPos().getRow(), (move.getCurrentPos().getCol() + i)));
					if (occupied == true)
					{
						String isObstructed = "A different piece prevents you from reaching your destination. Please select another destination.";
						System.out.println(isObstructed);
						message = isObstructed;
						return true;
					}
				}
			}
			else //piece moved in decreasing Y
			{
				for (int i = -1; i > changeY; i--)
				{
					boolean occupied = isOccupied(board.getTile(move.getCurrentPos().getRow(), (move.getCurrentPos().getCol() + i)));
					if (occupied == true)
					{
						System.out.println("A different piece prevents you from reaching your destination. Please select another destination.");
						message = "A different piece prevents you from reaching your destination. Please select another destination.";
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
				for (int i = 1; i < changeX; i++)
				{
					boolean occupied = isOccupied(board.getTile((move.getCurrentPos().getRow() + i), move.getCurrentPos().getCol()));
					if (occupied == true)
					{
						System.out.println("A different piece prevents you from reaching your destination. Please select another destination.");
						message = "A different piece prevents you from reaching your destination. Please select another destination.";
						return true;
					}
				}
			}
			
			else
			{
				//piece moved in decreasing X
				for (int i = -1; i > changeX; i--)
				{
					boolean occupied = isOccupied(board.getTile((move.getCurrentPos().getRow() + i), move.getCurrentPos().getCol()));
					if (occupied == true)
					{
						System.out.println("A different piece prevents you from reaching your destination. Please select another destination.");
						message = "A different piece prevents you from reaching your destination. Please select another destination.";
						return true;
					}
				}
			}
			
		}
		
		
		//If the piece moved diagonally
		if (Math.abs(changeX) == Math.abs(changeY))
		{
			//both x and y increase
			for (int i = 1; i < changeX; i++)
			{
				boolean occupied = isOccupied(board.getTile((move.getCurrentPos().getRow() + i), (move.getCurrentPos().getCol() + i)));
				if (occupied == true)
				{
					System.out.println("A different piece prevents you from reaching your destination. Please select another destination.");
					message = "A different piece prevents you from reaching your destination. Please select another destination.";
					return true;
				}
			}
			
			//both x and y decrease
			for (int i = -1; i > changeX; i--)
			{
				boolean occupied = isOccupied(board.getTile((move.getCurrentPos().getRow() + i), (move.getCurrentPos().getCol() + i)));
				if (occupied == true)
				{
					System.out.println("A different piece prevents you from reaching your destination. Please select another destination.");
					message = "A different piece prevents you from reaching your destination. Please select another destination.";
					return true;
				}
			}
			
			
			//x decreases while y increases
			for (int i = 1; i < changeY; i++)
			{
				boolean occupied = isOccupied(board.getTile((move.getCurrentPos().getRow() - i), (move.getCurrentPos().getCol() + i)));
				if (occupied == true)
				{
					System.out.println("A different piece prevents you from reaching your destination. Please select another destination.");
					message = "A different piece prevents you from reaching your destination. Please select another destination.";
					return true;
				}
			}
			
			//y decreases while x increases
			for (int i = 1; i < changeX; i++)
			{
				boolean occupied = isOccupied(board.getTile((move.getCurrentPos().getRow() + i), (move.getCurrentPos().getCol() - i)));
				if (occupied == true)
				{
					System.out.println("A different piece prevents you from reaching your destination. Please select another destination.");
					message = "A different piece prevents you from reaching your destination. Please select another destination.";
					return true;
				}
			}
		}
		
		
		
	 	return false;
	 }



/*	 public boolean kingInCheck(King king) 
	 {
		 boolean result = false;
		 
		 Tile kingTile = king.getCurrentTile();
		 int checkRow = kingTile.getRow();
		 int checkCol = kingTile.getCol();
		 Tile checkTile = kingTile;
		 boolean checkForPiece = false;
		 Piece checkPiece = null;
		 
		 while (checkRow > -1)
		 {
			 checkTile = board.getTile(checkRow, checkCol);
			 checkForPiece = checkTile.getIsOccupied();
			 if (checkForPiece == true)
			 {
				 checkPiece = checkTile.getPiece();
				 
				 //if an enemy piece is found, test color
				 if (king.getColorString().compareTo(checkPiece.getColorString()) != 0)
				 {
					 //if the piece is an enemy, check if their range includes the King
					 if (checkPiece.isValidMove(checkTile, kingTile))
					 {
						 king.setIsInCheck(true);
						 return true;
					 }
				 }
			 }
			 checkRow = checkRow -1;
		 }
		 
		 checkRow = kingTile.getRow();
		 while (checkRow < 8)
		 {
			 checkTile = board.getTile(checkRow, checkCol);
			 checkForPiece = checkTile.getIsOccupied();
			 if (checkForPiece == true)
			 {
				 checkPiece = checkTile.getPiece();
				 
				 //if an enemy piece is found, test color
				 if (king.getColorString().compareTo(checkPiece.getColorString()) != 0)
				 {
					 //if the piece is an enemy, check if their range includes the King
					 if (checkPiece.isValidMove(checkTile, kingTile))
					 {
						 king.setIsInCheck(true);
						 return true;
					 }
				 }
			 }
			 checkRow = checkRow + 1;
		 }
		 
		 
		 while (checkCol > -1)
		 {
			 checkTile = board.getTile(checkRow, checkCol);
			 checkForPiece = checkTile.getIsOccupied();
			 if (checkForPiece == true)
			 {
				 checkPiece = checkTile.getPiece();
				 
				 //if an enemy piece is found, test color
				 if (king.getColorString().compareTo(checkPiece.getColorString()) != 0)
				 {
					 //if the piece is an enemy, check if their range includes the King
					 if (checkPiece.isValidMove(checkTile, kingTile))
					 {
						 king.setIsInCheck(true);
						 return true;
					 }
				 }
			 }
			 checkCol = checkCol -1;
		 }
		 
		 checkCol = kingTile.getCol();
		 while (checkRow < 8)
		 {
			 checkTile = board.getTile(checkRow, checkCol);
			 checkForPiece = checkTile.getIsOccupied();
			 if (checkForPiece == true)
			 {
				 checkPiece = checkTile.getPiece();
				 
				 //if an enemy piece is found, test color
				 if (king.getColorString().compareTo(checkPiece.getColorString()) != 0)
				 {
					 //if the piece is an enemy, check if their range includes the King
					 if (checkPiece.isValidMove(checkTile, kingTile))
					 {
						 king.setIsInCheck(true);
						 return true;
					 }
				 }
			 }
			 checkCol = checkCol + 1;
		 }
		 king.setIsInCheck(result);
		 return result;
	 }

*/



	 /**
	  * Method to get the tile
	  * @param row The x coordinate of the board
	  * @param col The Y coordinate of the board
	  * @return The correct tile 
	  */
	 public Tile getTile(int row, int col)
	 {
		 return board.getTile(row, col);
	 }
	 
	 /**
	  * Method to get the current state of the game
	  * @return The message about the current state of the game.
	  */
	 public String getGameInfo() {
		  return message;
		 
	 }
	
	 
}




