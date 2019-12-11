package edu.sjsu.cs151.game;

import edu.sjsu.cs151.view.*;
import edu.sjsu.cs151.model.*;
import edu.sjsu.cs151.controller.*;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import javax.swing.JPanel;

/**
 * The main class of our which lets us play the actual game it combines the
 * three components of our game which are the model, view and controller.
 * 
 * @author Skyler, Neeval and Sehajmeet
 *
 */

public class Game extends Thread{

	/**
	 * The blocking queue that contains all the message of our game.
	 */
	private static BlockingQueue<Message> queue = new LinkedBlockingQueue<Message>();

	/**
	 * The view field that exports all the methods and fields in the View.
	 */
	private static View view;

	/**
	 * The model field that exports all the methods and fields in the Model.
	 */
	private static Model model;

	private Server server;
	
	public Game()
	{	}
	
	public Game(Player P1, Player P2, Server server)
	{
		this.server = server;
		run(P1, P2);
	}
	
	public void run(Player P1, Player P2) {
		view = new View(queue);
		model = new Model();

		Controller controller = new Controller(model, view, queue, server);

		try {
			controller.mainLoop();
		} catch (Exception e) {
			e.printStackTrace();
		}
		queue.clear();
	}
	
	/**
	 * Method get the model.
	 * 
	 * @return The model of our game
	 */
	public static Model getModel() {
		return model;
	}

	/**
	 * Getter for view
	 * 
	 * @return view
	 */
	public static View getView() {
		return view;
	}
	
/*	private void run2()
	{
		View v = getView();
		JPanel jp = v.getChessBoard();
		jp.setVisible(true);
	}*/
	
	
	
	/**
	 * The main method that lets us play the game combining the three components.
	 * @param args The String arguments
	 */
/*	public static void main(String[] args) {
		view = new View(queue);
		model = new Model();

		Controller controller = new Controller(model, view, queue);

		try {
			controller.mainLoop();
		} catch (Exception e) {
			e.printStackTrace();
		}

		queue.clear();
	}*/
}
