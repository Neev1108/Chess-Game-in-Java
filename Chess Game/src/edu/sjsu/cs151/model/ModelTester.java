package edu.sjsu.cs151.model;

public class ModelTester implements Runnable{
	
	public void run() {
		System.out.println("For this assignment we are simulating a chess game in console.");
		Model game = new Model();		
		game.playGame();
		
	}

	

}