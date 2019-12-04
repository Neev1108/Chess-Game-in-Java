package edu.sjsu.cs151.game;

import edu.sjsu.cs151.view.*;
import edu.sjsu.cs151.model.*;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import edu.sjsu.cs151.controller.*;

public class Game {

	private static BlockingQueue<Message> queue = new LinkedBlockingQueue<Message>();
	private static View view;
	private static Model model;
	

    

	public static void main(String [] args){
		view = new View(queue);
		model = new Model();
		System.out.println("test1");

		Controller controller = new Controller(model, view, queue);
		
		System.out.println("test");
		try {
			controller.mainLoop();
			controller.printMessageQueue(queue);
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


