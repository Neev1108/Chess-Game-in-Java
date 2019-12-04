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
	
	
	
	
	/**
	 * Controller constructor. 
	 * @param model
	 * @param view
	 * @param queue
	 */

	public Controller(Model model, View view,BlockingQueue<Message> queue) {
		valves.add(new NewGameValve());
    	valves.add(new MoveValve(model, view));
    	valves.add(new EndGameValve());
		this.model = model;
		this.view = view;
		this.queue = queue;
	}
	
	
	public View getView() {
		return view;
	}


	public Model getModel() {
		return model;
	}


	public void mainLoop() throws Exception{
		System.out.println("I am running");
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
	
	public void updateMessageQueue(BlockingQueue<Message> queue){
		this.queue = queue;
	}
	
	public void printMessageQueue(BlockingQueue<Message> queue)
	{
		try {
			System.out.println(queue.take());
			
		}
		catch (InterruptedException e){
			
		}
	}
	
	
}
