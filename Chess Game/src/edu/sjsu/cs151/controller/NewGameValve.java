package edu.sjsu.cs151.controller;

public class NewGameValve implements Valve{

	/**
	 * ValveResponse execute method checks class types of incoming Messages and only
	 * executes them if they are a NewGameMessage.
	 * 
	 * @param message from queue
	 */
	public ValveResponses execute(Message message) {
		if(message.getClass() != NewGameMessage.class) {
			return ValveResponses.MISS;
		}
		
		return ValveResponses.EXECUTED;
	}

}
