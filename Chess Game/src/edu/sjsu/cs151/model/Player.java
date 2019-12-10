package edu.sjsu.cs151.model;
/**
 * Created by Neeval Kumar on 10/27/2019
 *
 */

import java.io.*;
import java.net.*;
import java.util.*;

public class Player extends Thread{
	private String color;
	private boolean firstTurn = false;
	private Socket socket;
	private Player opponent;
	private BufferedReader br;
	private PrintWriter pw;
	
	
	/**
	 * Constructor for a Player.
	 * @param color The color of the player
	 * @param firstTurn The boolean value to determine the first turn
	 */
	public Player(String color, boolean firstTurn) {
		this.color = color;
		this.firstTurn = firstTurn;


	}
	
	
	
	public Player(Socket socket)
	{
		this.socket = socket;
	}
	

	/**
	 * Getter method to get the color of the player.
	 * @return The color of the player
	 */
	public String getColor() {
		return color;
	}

	/**
	 * Method that checks which player gets the first turn
	 * @return The boolean value after determining the first turn
	 */
	public boolean firstTurn() {
		return firstTurn = true;
	}
	
	/**
	 * The to string method that return 
	 * the color and the name of the player.
	 */
	public String toString()
	{
		return color + " Player";
	}
	
	public Player getOpponent()
	{
		return opponent;
	}
	
	public void setOpponent(Player p)
	{
		opponent = p;
	}
	
	public void serverClose()
	{
		pw.print("The server has closed. Terminating client.");
	}
	
}
