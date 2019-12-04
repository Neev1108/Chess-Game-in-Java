package edu.sjsu.cs151.controller;

import edu.sjsu.cs151.model.Model;
import edu.sjsu.cs151.model.Moves;
import edu.sjsu.cs151.model.Player;
import edu.sjsu.cs151.model.Tile;
import edu.sjsu.cs151.view.View;

public class MoveValve implements Valve {
	View view;
	Model model;
	
	public MoveValve(Model model, View view) {
		this.model = model;
		this.view = view;
	}
	
	public ValveResponses execute(Message message) {
		if(message.getClass() != MoveMessage.class)
			return ValveResponses.MISS;
		int currentPosition = ((MoveMessage) message).getCurrentPosition();
		int endPosition = ((MoveMessage) message).getEndPosition();
		
		//positions here are single coordinates from 0-63. Position/8 into an int will return row, position%8 will return column
		int currentRow = currentPosition/8;
		int currentCol = currentPosition%8;
		int endRow = endPosition/8;
		int endCol = endPosition%8;
		
		Tile currentTile = model.getTile(currentRow, currentCol);
		Tile endTile = model.getTile(endRow, endCol);
		Player currentPlayer = model.getDoTurn();
		Moves move = new Moves (currentPlayer, currentTile, endTile);
		boolean isSuccessful = model.startTurn(move);
		
		System.out.println(isSuccessful);
		
		
		
		 // if start turn is successful then make move on view or dont move
		if (isSuccessful == true)
			view.canmovePiece(isSuccessful);
		else
			view.canmovePiece(false);

		return ValveResponses.EXECUTED;
		
		
	}

}
