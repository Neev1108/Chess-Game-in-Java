package edu.sjsu.cs151.game;
import java.util.Scanner;

import edu.sjsu.cs151.model.*;
public class ChessGame {
	
	public static void main(String args[]) {
		System.out.println("For this assignment we are simulating a chess game in console.");
		Game game = new Game();
		game.printBoard();
		
		
		Scanner scan = new Scanner(System.in);
		Player currentPlayer = game.getPlayer1();
		while ((game.getEvent() != GameEvent.WhiteWin) && (game.getEvent() != GameEvent.BlackWin))
		{
			System.out.println(currentPlayer.getColor() + " team is making their move.");
			/*
				pseudocode
				if (currentPlayer.King.inCheck == true)
				{
					System.out.println(currentPlayer.getName() + ", your king is in check.")
				}
				display warning if currentPlayer's king is in check
			 */

			System.out.println("Please input the row of the current location of the piece you wish to move:");
			int row = scan.nextInt();
			System.out.println("Please input the column of the current location of the piece you wish to move:");
			int col = scan.nextInt();

			//if this spot is empty, will throw NullPointerException. I'm open to ideas on how to fix it.
			Tile currentTile = game.board.getTile(row, col);

			Piece currentPiece = currentTile.getPiece();
			System.out.println("You have selected " + currentPiece.getPieceColor() + " " + currentPiece.getPieceType() + ".");

			System.out.println("Please input the row of the desired destination:");
			row = scan.nextInt();
			System.out.println("Please input the column of the desired destination:");
			col = scan.nextInt();
			Tile targetTile = game.board.getTile(row, col);
			Moves currentMove = new Moves(currentPlayer, currentTile, targetTile);
			boolean validMove = game.startTurn(currentMove, currentPlayer);
			if (validMove != true)
			{
				System.out.println("Move failed, please try again");
				continue;
			}
			else
			{
				System.out.println("Move successful");
				/*
					pseudocode
					if (pieceWasCaptured == true)
						System.out.println(capturedPiece + " has been captured.");
				 */
				//lines 57-63 are purely for my own use and can be removed for the submitted version
				System.out.println("Is game over?");
				boolean end = scan.nextBoolean();
				if (end == true)
				{
					System.out.println("Game complete");
					break;
				}
				if (game.getEvent() == GameEvent.WhiteWin || game.getEvent() == GameEvent.BlackWin)
				{
					System.out.println("Game complete");
					break;
				}
				else {
					System.out.println("Turn complete, next player will begin their turn.");
					if (currentPlayer.equals(game.getPlayer1())) {
						currentPlayer = game.getPlayer2();
					} else
						currentPlayer = game.getPlayer1();
				}
			}

		}





		scan.close();
	}

}



/*
	Changelog:

	edited Main method heavily (obviously)
	added accessor methods for the variables of Game so that I can actually use them
*/



/*
	Notes:
	The whole moving process is hella buggy. Pieces can land on allied spots, pieces can pass through others,
		pawns can't move, players can control both teams, knights can't move.

	King move might(?) be broken? Its hard to tell if its broken in that it doesn't allow king to move, or if its working
		properly in that king can't step on other pieces. Until other pieces are movable, it'll be hard to test that.

	It looks

	Player class ought to have a toString method, maybe displaying the player name (or P1/P2/whatever)

	King should have some sort of flag to know whether its in check.

	I would like it if Line 34 of this class ("you have selected ___") could display the selected piece's color
		and type/rank/whatever. Definitely not crucial, but I think it will be useful.

	Line 37 will throw NullPointerException if the selected spot is empty. I'm open to ideas on how to fix it.

 */
