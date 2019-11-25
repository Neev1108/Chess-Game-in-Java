package edu.sjsu.cs151.model;
/**
 * 
 * Created by Neeval Kumar on 10/27/2019
 *
 */
public class Player {
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
	}
}
