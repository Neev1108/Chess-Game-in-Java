package edu.sjsu.cs151.model;
/**
 * This class simulates our game in the console
 * @author Neeval, Skylar and Sehajmeet
 *
 */
public class ModelTester {
	/**
	 * Main method that simulates our game
	 * @param args
	 */
	public static void main(String args[]) {
		System.out.println("For this assignment we are simulating a chess game in console.");
		Model game = new Model();		
		game.playGame();
		
	}

	

}