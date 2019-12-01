package edu.sjsu.cs151.game;

import edu.sjsu.cs151.view.*;
import edu.sjsu.cs151.model.*;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.locks.ReentrantLock;

import edu.sjsu.cs151.controller.*;

public class Game {

	private static BlockingQueue<Message> queue = new LinkedBlockingQueue<Message>();
	private static View view;
	private static Model model;
	
	  /**
     * Controller Constructor
     * @param View, Model, and BlockingQueue 
	 * @return 
     */
    public void Controller(BlockingQueue<Message> queue, Model model, View view) {
    	Game.queue = queue;
    	Game.model = model;
    	Game.view = view;
    }
    

	public static void main(String [] args){
		ReentrantLock lock = new ReentrantLock();
		view = View.init(queue, lock);
		model = new Model();
		
		Thread viewThread = new Thread(view);
		Thread modelThread = new Thread(model);
		Controller game = new Controller(model, view, queue);
		
		
		//these will start the game in the console AND the view thread, working on making it thread safe right now
		viewThread.start();
		modelThread.start();
		//game.updateMessageQueue(view.getQueue());
		/*
		try {
			game.mainLoop();
		} catch (Exception e) {
			e.printStackTrace();
		}
		//view.dispose();
		queue.clear();
		*/	
	}
	
	
	public static Model getModel() {
        return model;
    }

    /**
     * Getter for view
     * @return view
     */
    public static View getView() {
        return view;
    }
}


