package edu.sjsu.cs151.controller;

import edu.sjsu.cs151.model.Model;
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
		
		//model.getGame().startTurn(move, player)
		
		/*
		 * if start turn is successful then make move on view or dont move
		if (isSucessful == true)
			view.Move(currentPosition, endPosition);
		else
			view.dontMove(s, e);
			*/
		return ValveResponses.EXECUTED;
		
		
	}

}
