package edu.sjsu.cs151.controller;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.BlockingQueue;

import edu.sjsu.cs151.view.*;
import edu.sjsu.cs151.model.*;


public class Controller {
	private BlockingQueue<Message> queue;
	private View view;
	private Model model;
	private GameInfo gameInfo;
	private List<Valve> valves = new LinkedList<Valve>();
	
	
	
	
	

	public Controller(Model model, View view,BlockingQueue<Message> queue) {
		this.model = model;
		this.view = view;
		this.queue = queue;
	}
	
	
	public void mainLoop() throws Exception{
		ValveResponses response = ValveResponses.EXECUTED;
		Message message = null;
		System.out.println(queue);
		
	}
	
	public void updateMessageQueue(BlockingQueue<Message> queue){
		this.queue = queue;
	}
	
	public void updateGameInfo(){
		
	}
	
	
}
