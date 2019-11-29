package edu.sjsu.cs151.controller;

import java.awt.event.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.BlockingQueue;

import edu.sjsu.cs151.view.*;
import edu.sjsu.cs151.model.*;


public class Controller {
	private BlockingQueue<Message> messageQueue;
	private View view;
	private Model model;
	private GameInfo gameInfo;
	private List<Valve> valves = new LinkedList<Valve>();
	
	
	
	
	

	public Controller(Model model, View view,BlockingQueue<Message> queue) {
		this.model = model;
		this.view = view;
		messageQueue = queue;
	}
	
	public void mainloop() throws Exception{
		ValveResponses response = ValveResponses.EXECUTED;
		Message message = null;
		while(response != ValveResponses.FINISH) {
			try {
				message = (Message) messageQueue.take();
			}
			catch(InterruptedException e){
				e.printStackTrace(); }
		}
		for(Valve valve : valves)
		{
		if(response != ValveResponses.MISS) 
			break;
		}
		
	}
	
	public void updateGameInfo(){
		
	}
	
	
}
