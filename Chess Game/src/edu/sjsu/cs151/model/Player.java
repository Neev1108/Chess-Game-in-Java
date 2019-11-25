package edu.sjsu.cs151.model;
/**
 * 
 * Created by Neeval Kumar on 10/27/2019
 *
 */
public class Player {
<<<<<<< HEAD
	public String color;
	public boolean firstTurn = false;

	public Player(String color, boolean firstTurn) {
		this.color = color;
		this.firstTurn = firstTurn;


	}

	public String getColor() {
		return color;
	}

	public boolean firstTurn() {
		return firstTurn = true;
=======
	private String color;	
	
	public Player(String color, boolean firstTurn) {
		this.color = color;
		
		
	}
	
	public String getColor() {
		return color;
	}
	
	
	public String toString()
	{
		return color + " Player";
>>>>>>> branch 'master' of https://github.com/SkylerHungerford/cs151-team8-chess
	}
}
