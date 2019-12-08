package edu.sjsu.cs151.controller;

import edu.sjsu.cs151.model.Model;
import edu.sjsu.cs151.model.Moves;
import edu.sjsu.cs151.model.Player;
import edu.sjsu.cs151.model.Tile;
import edu.sjsu.cs151.view.View;

/**
 * This class handles Valve response to move Message received from View
 */
public class MoveValve implements Valve {
	View view;
	Model model;

	/**
	 * Constructor for the class
	 * 
	 * @param model The model
	 * @param view  The View
	 */
	public MoveValve(Model model, View view) {
		this.model = model;
		this.view = view;
	}

	/**
	 * ValveResponse execute method checks class types of incoming Messages and only
	 * executes them if they are a MoveMessage.
	 * 
	 * @param message from queue
	 */
	public ValveResponses execute(Message message) {
		if (message.getClass() != MoveMessage.class)
			return ValveResponses.MISS;
		int currentPosition = ((MoveMessage) message).getCurrentPosition();
		int endPosition = ((MoveMessage) message).getEndPosition();

		// positions here are single coordinates from 0-63. Position/8 into an int will
		// return row, position%8 will return column
		int currentRow = currentPosition / 8;
		int currentCol = currentPosition % 8;
		int endRow = endPosition / 8;
		int endCol = endPosition % 8;

		Tile currentTile = model.getTile(currentRow, currentCol);
		Tile endTile = model.getTile(endRow, endCol);
		Player currentPlayer = model.getDoTurn();
		Moves move = new Moves(currentPlayer, currentTile, endTile);

		boolean isSuccessful = model.startTurn(move);

		// If start turn is successful then make move on view or dont move
		if (isSuccessful == true) {
			view.canmovePiece(isSuccessful);
			if (currentPlayer.getColor() != "White")
				view.setGameInfo("Move successful. White player move.");
			else
				view.setGameInfo("Move sucessful. Black Player move.");
		} else {
			view.canmovePiece(false);
			view.setGameInfo(model.getGameInfo());
		}

		view.printGameInfo();
		return ValveResponses.EXECUTED;

	}

}
