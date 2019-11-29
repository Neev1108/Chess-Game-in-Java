package edu.sjsu.cs151.controller;

import edu.sjsu.cs151.model.Game;
import edu.sjsu.cs151.model.Model;
import edu.sjsu.cs151.view.View;

public class NewGameValve implements Valve{
	
	public ValveResponses execute(Message message) {
		if(message.getClass() != NewGameMessage.class) {
			return ValveResponses.MISS;
		}
		//modelGame.start();
		//needs to create a thread for model which will start the moment the player color is chosen
		
		return ValveResponses.EXECUTED;
	}

}
