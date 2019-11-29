package edu.sjsu.cs151.controller;



public class PlayerChosenMessage implements Message {

	String color;
	boolean firstTurn;
	
public PlayerChosenMessage(String color, boolean firstTurn) {
	this.color = color;
	this.firstTurn = firstTurn;
}

public String getColor() {
	return color;
}


public boolean isFirstTurn() {
	return firstTurn;
}




}
