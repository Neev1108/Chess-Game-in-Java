package edu.sjsu.cs151.controller;

public class EndGameValve implements Valve {

	@Override
	public ValveResponses execute(Message message) {
		{
			if(message.getClass() != EndGameMessage.class)
				return ValveResponses.MISS;
			return ValveResponses.FINISH; }
	}

}
