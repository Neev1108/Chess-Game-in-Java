package edu.sjsu.cs151.controller;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.BlockingQueue;

import edu.sjsu.cs151.view.*;
import edu.sjsu.cs151.model.*;

/**
 * The main Controller class that handles the 
 * game management through the commands and messages generated 
 * in the Model and the View. 
 *
 */
public class Controller {
	private BlockingQueue<Message> queue;
	private View view;
	private Model model;
	private List<Valve> valves = new LinkedList<Valve>();
	private Server server;
	
	
	
	/**
	 * Controller constructor. 
	 * @param model The model component of our game 
	 * @param view The GUI component of our game
	 * @param queue The queue to contain the messages
	 */

/*	public Controller(Model model, View view,BlockingQueue<Message> queue) {
		valves.add(new NewGameValve());
    	valves.add(new MoveValve(model, view));
    	valves.add(new EndGameValve(this));
		this.model = model;
		this.view = view;
		this.queue = queue;
	}*/
	
	
	public Controller(Model model, View view,BlockingQueue<Message> queue, Server server) {
		valves.add(new NewGameValve());
    	valves.add(new MoveValve(model, view));
    	valves.add(new EndGameValve(this));
		this.model = model;
		this.view = view;
		this.queue = queue;
		this.server = server;
	}

	 /**
     * Getter for view
     * @return view
     */
	public View getView() {
		return view;
	}

	 /**
     * Getter for model
     * @return model
     */
	public Model getModel() {
		return model;
	}
	
	public Server getServer()
	{
		return server;
	}


	public void mainLoop() throws Exception{
		ValveResponses response = ValveResponses.EXECUTED;
		Message message = null;
		while (response != ValveResponses.FINISH) {
			try {
				message = queue.take();		
			}
			catch (InterruptedException e) {
				e.printStackTrace();
			}
			for (Valve valve: valves) {
				response = valve.execute(message);
				
				if(response != ValveResponses.MISS)
					break;
			}
		}
		
		
		
	}
	/**
	 * Method that updates the message into the queue
	 * @param queue The BlockingQueue containing the messages
	 */
	public void updateMessageQueue(BlockingQueue<Message> queue){
		this.queue = queue;
	}

	/**
	 * Method that prints the messages or throws an exception
	 * @param queue The BlockingQueue containing the messages
	 */
	public void printMessageQueue(BlockingQueue<Message> queue)
	{
		try {
			System.out.println(queue.take());
			
		}
		catch (InterruptedException e){
			
		}
	}
	
	
}
