package edu.sjsu.cs151.model;

public class Model implements Runnable{
	
	public void run() {
		System.out.println("For this assignment we are simulating a chess game in console.");
		Game game = new Game();		
		game.playGame();
		
	}

	

}




/*
	Notes:
	The movement process still has major issues, especially for certain piece types.
	
	Do not attempt to select an empty tile; the program will crash.
	
	King being in check is not properly implemented yet.
 */
