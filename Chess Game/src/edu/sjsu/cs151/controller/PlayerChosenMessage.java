package edu.sjsu.cs151.controller;

/**
 * 
 * @author Sehajmeet
 *
 */
public class PlayerChosenMessage implements Message {

	String color;
	boolean firstTurn;
/**
 * 
 * @param color
 * @param firstTurn
 */
public PlayerChosenMessage(String color, boolean firstTurn) {
	this.color = color;
	this.firstTurn = firstTurn;
}

/**
 * 
 * @return
 */
public String getColor() {
	return color;
}

/**
 * 
 * @return
 */
public boolean isFirstTurn() {
	return firstTurn;
}




}
