package edu.sjsu.cs151.controller;

import edu.sjsu.cs151.model.Game;
import edu.sjsu.cs151.view.View;

public class PlayerChosenMessageValve implements Valve {

	public ValveResponses execute(Message message) {
		if(message.getClass() != PlayerChosenMessage.class) {
			return ValveResponses.MISS;
		}
		
		//needs to set the players for the game class. I put some setplayer methods in there
		
		return ValveResponses.EXECUTED;
	}
}
