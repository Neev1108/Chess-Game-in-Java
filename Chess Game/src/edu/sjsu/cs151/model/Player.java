package edu.sjsu.cs151.model;
import java.net.*;
import java.util.*;
import java.io.*;


/**
 * Created by Neeval Kumar on 10/27/2019
 *
 */

public class Player extends Thread{
	private String color;
	private Player opponent;
	private Socket socket;
	private BufferedReader in;
	private PrintWriter out;
	private String input;
	
	
	/**
	 * Constructor for a Player.
	 * @param color The color of the player
	 */
	public Player(String color) {
		this.color = color;
		

	}	

	
	public Player(Socket s, int i)
	{
		this.socket = s;
		if (i == 1)
		{
			this.color = "White";
		}
		else
		{
			this.color = "Black";
		}
		try 
        {
        	in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        	out = new PrintWriter(socket.getOutputStream(), true);
        	out.println("Waiting for opponent...");
        } 
        catch (Exception e) 
        {
        }
	}
	
	
	public Socket getSocket()
	{
		return socket;
	}
	
	
	/**
	 * Getter method to get the color of the player.
	 * @return The color of the player
	 */
	public String getColor() {
		return color;
	}
	
	public void setColor(String s)
	{
		color = s;
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
	
    
    
}
