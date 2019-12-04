package edu.sjsu.cs151.controller;

import edu.sjsu.cs151.model.ModelTester;
import edu.sjsu.cs151.view.View;

public class PlayerChosenMessageValve implements Valve {
	View view;
	ModelTester model;
	
	public PlayerChosenMessageValve(ModelTester model, View view) {
		this.model = model;
		this.view = view;
	}

	public ValveResponses execute(Message message) {
		
		if(message.getClass() != PlayerChosenMessage.class) {
			return ValveResponses.MISS;
		}
		
		//needs to set the players for the game class. I put some setplayer methods in there
		
		
		return ValveResponses.EXECUTED;
	}
}
