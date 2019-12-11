package edu.sjsu.cs151.controller;

import java.io.*;
import java.net.*;
import java.util.*;
import java.util.concurrent.*;

import edu.sjsu.cs151.view.*;
import edu.sjsu.cs151.model.*;
import edu.sjsu.cs151.controller.*;
import edu.sjsu.cs151.game.*;

public class Server extends Thread{
	
	private static ServerSocket listener;
	
	public Server() {	}
	
	public void run()
	{
		listener = null;
		try
		{			
			//Random unaffiliated port
			listener = new ServerSocket(4387);			
			System.out.println("Server is running");
			ExecutorService gameInstances = Executors.newFixedThreadPool(10);
			while(true)
			{
				//Wait for first player, repeat for P2
				Socket s = listener.accept();
				System.out.println(s);
				Player player1 = new Player(s, 1);
				System.out.println(player1);
				System.out.println("Player 1 connected");
				System.out.println("Player 1 has joined");
				
				Player player2 = new Player(listener.accept(), 2);
				System.out.println(player2.getSocket());
				System.out.println(player2);
				System.out.println("Player 2 connected");
				System.out.println("Player 2 has joined");
				gameInstances.execute(new Game(player1, player2));
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try 
			{
				listener.close();
			}
			catch(Exception e)
			{ }
		}
	}
	
	
	
	public void shutdown()
	{
		//for (int i = 0; i < players.size(); i++)
		{
			//players.get(i).serverClose();
		}
		System.exit(0);
	}
	
/*	class ServerManager extends Thread
	{
		Server handledServer;
		public ServerManager(Server handledServer)
		{
			this.handledServer = handledServer;
		}
		
		public void run()
		{
			Scanner inputReader = new Scanner(System.in);
			while(true) 
		    {
		        if (inputReader.hasNext())
		        {
		            String input = inputReader.next();
		            if (input.toLowerCase().equals("quit"))
		            {
		            	handledServer.shutdown();
		            	break;
		            }
		        }
		    }
			inputReader.close();
		}
	}*/
	
	
	public static void main(String args[])
	{
		Server server = new Server();
		server.start();
	}
}
