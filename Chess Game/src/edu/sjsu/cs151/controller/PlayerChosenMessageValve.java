package edu.sjsu.cs151.controller;

import edu.sjsu.cs151.model.ModelTester;
import edu.sjsu.cs151.view.View;

/**
 * This class implements the Valve interface and sends a message 
 * when a player is chosen.
 * @author Sehajmeet
 *
 */
public class PlayerChosenMessageValve implements Valve {
	View view;
	ModelTester model;
	
	/**
	 * Constructor for the class
	 * @param model The Model
	 * @param view The View
	 */
	public PlayerChosenMessageValve(ModelTester model, View view) {
		this.model = model;
		this.view = view;
	}

	/**
	 * ValveResponse execute method checks class types of incoming Messages and only
	 * executes them if they are a PlayerChosenMessage.
	 * 
	 * @param message from queue
	 */
	public ValveResponses execute(Message message) {
		
		if(message.getClass() != PlayerChosenMessage.class) {
			return ValveResponses.MISS;
		}
		
		
		
		return ValveResponses.EXECUTED;
	}
}
