package edu.sjsu.cs151.controller;

public class PlayerChosenMessageValve implements Valve {

	public ValveResponses execute(Message message) {
		if(message.getClass() != PlayerChosenMessage.class) {
			return ValveResponses.MISS;
		}
		
		//needs to set the players for the game class. I put some setplayer methods in there
		
		return ValveResponses.EXECUTED;
	}
}
