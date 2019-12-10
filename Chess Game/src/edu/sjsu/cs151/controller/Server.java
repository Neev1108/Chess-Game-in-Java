package edu.sjsu.cs151.controller;

import java.io.*;
import java.net.*;
import java.util.*;
import edu.sjsu.cs151.view.*;
import edu.sjsu.cs151.model.*;
import edu.sjsu.cs151.controller.*;
import edu.sjsu.cs151.game.*;

public class Server extends Thread{
	
	private static List<Game> gameInstances = null;
	private static List<Player> players;
	private static ServerSocket listener;
	
	
	public Server() {	}
	
	
	
	
	
	
	
	public void run()
	{
		gameInstances = new ArrayList<>();
		listener = null;
		try
		{
			listener = new ServerSocket(4387);
			System.out.println("Server is running");
			Player player1 = new Player(listener.accept());
			players.add(player1);
			System.out.println("Player 1 has joined");
			Player player2 = new Player(listener.accept());
			players.add(player2);
			System.out.println("Player 2 has joined");
			
			player1.setOpponent(player2);
			player2.setOpponent(player1);
			player1.start();
			player2.start();
		}
		catch (Exception e)
		{
			
		}
	}
	
	
	
	
	
	
	
	
	public static void main(String args[])
	{
		Server server = new Server();
		server.start();
	}
	
}
