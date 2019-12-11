package edu.sjsu.cs151.controller;

import edu.sjsu.cs151.model.*;
import edu.sjsu.cs151.view.*;



public class EndGameValve implements Valve {

	Model model;
	View view;
	Controller controller;
	
	public EndGameValve(Controller c)
	{
		controller = c;
	}
	
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
			
			if (controller.getServer() != null)
			{
				controller.getServer().shutdown();
			}
			else
			{
				System.exit(0);
			}
			return ValveResponses.FINISH;
		}
	}

}
