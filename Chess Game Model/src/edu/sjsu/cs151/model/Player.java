package edu.sjsu.cs151.model;
/**
 * 
 * Created by Neeval Kumar on 10/27/2019
 *
 */
public class Player {
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
}
}
