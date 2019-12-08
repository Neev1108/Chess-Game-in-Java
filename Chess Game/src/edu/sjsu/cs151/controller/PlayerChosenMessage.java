package edu.sjsu.cs151.controller;

/**
 * This class represents the color selected by the user in the View.
 * @author Sehajmeet
 *
 */
public class PlayerChosenMessage implements Message {

	String color;
	boolean firstTurn;
/**
 * The constructor for the class
 * @param color The color of the player 
 * @param firstTurn boolean value to determine the first turn
 */
public PlayerChosenMessage(String color, boolean firstTurn) {
	this.color = color;
	this.firstTurn = firstTurn;
}

/**
 * Getter method to get the color of the player
 * @return the color of the player
 */
public String getColor() {
	return color;
}

/**
 * Getter method to determine if it is the player's first turn or not
 * @return boolean value to determine the first turn
 */
public boolean isFirstTurn() {
	return firstTurn;
}




}
