package edu.sjsu.cs151.controller;

public class EndGameValve implements Valve {

	/**
	 * ValveResponse execute method checks class types of incoming Messages and only
	 * executes them if they are a EndGameMessage.
	 * 
	 * @param message from queue
	 */
	public ValveResponses execute(Message message) {
		{
			if (message.getClass() != EndGameMessage.class)
				return ValveResponses.MISS;
			return ValveResponses.FINISH;
		}
	}

}
