package edu.sjsu.cs151.game;

import edu.sjsu.cs151.view.*;
import edu.sjsu.cs151.model.*;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
//import java.util.concurrent.locks.ReentrantLock;

import edu.sjsu.cs151.controller.*;

public class Game {

	private static BlockingQueue<Message> queue = new LinkedBlockingQueue<Message>();
	private static View view;
	private static Model model;
	

    

	public static void main(String [] args){
		view = new View(queue);
		model = new Model();
		Controller controller = new Controller(model, view, queue);
		
//		Thread viewThread = new Thread(view);
//		Thread modelThread = new Thread(model);
		
		
		//these will start the game in the console AND the view thread, working on making it thread safe right now
//		viewThread.start();
//		modelThread.start();
		
		
			try {
				controller.mainLoop();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		//view.dispose();
		queue.clear();	
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


