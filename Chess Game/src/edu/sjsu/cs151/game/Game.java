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
		view = View.init(queue);
		model = new Model();
	
		Controller game = new Controller(view,model,queue);
		game.mainLoop();
		view.dispose();
		queue.clear();
	}
	
	public void mainLoop() {
		
	}

}
