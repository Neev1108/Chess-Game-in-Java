package edu.sjsu.cs151.controller;

/**
 * This class represents the color selected by the user in the View.
 * @author Sehajmeet
 *
 */
public class PlayerChosenMessage implements Message {

	String color;
	/**
	 * The constructor for the class
	 * @param color The color of the player 
	 * @param firstTurn boolean value to determine the first turn
	 */
	public PlayerChosenMessage(String color) {
		this.color = color;
	}
	
	/**
	 * Getter method to get the color of the player
	 * @return the color of the player
	 */
	public String getColor() {
		return color;
	}

}
