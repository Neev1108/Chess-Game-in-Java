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
	private OutputStreamWriter oSR1;
	private OutputStreamWriter oSR2;
	private BufferedWriter outputClient1;
	private BufferedWriter outputClient2;
	private InputStreamReader iSR1;
	private InputStreamReader iSR2;
	private BufferedReader inputClient1;
	private BufferedReader inputClient2;
	
	//ExecutorService gameInstances = Executors.newFixedThreadPool(10);

	public Server() {	}
	
	public void run()
	{
		listener = null;
		try
		{			
			//Random unaffiliated port
			listener = new ServerSocket(4387);			
			System.out.println("Server is running");
			while(true)
			{
				//Wait for first player, repeat for P2
				Socket firstPlayer = listener.accept();
				System.out.println(firstPlayer);
				Player player1 = new Player(firstPlayer, 1);
				System.out.println(player1);
				System.out.println("Player 1 connected");
				System.out.println("Player 1 has joined");
				oSR1 = new OutputStreamWriter(firstPlayer.getOutputStream());
				outputClient1 = new BufferedWriter(oSR1);
				iSR1 = new InputStreamReader(firstPlayer.getInputStream());
				inputClient1 = new BufferedReader(iSR1);
				
				
				Socket secondPlayer = listener.accept();
				Player player2 = new Player(secondPlayer, 2);
				System.out.println(player2.getSocket());
				System.out.println(player2);
				System.out.println("Player 2 connected");
				System.out.println("Player 2 has joined");
				oSR2 = new OutputStreamWriter(secondPlayer.getOutputStream());
				outputClient2 = new BufferedWriter(oSR2);
				iSR2 = new InputStreamReader(secondPlayer.getInputStream());
				inputClient2 = new BufferedReader(iSR2);
				
				//gameInstances.execute(new Game(player1, player2, this));
				Game g = new Game(player1, player2, this);
				g.start();
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
		System.out.println("shutting down");
		try {
		outputClient1.write("Server shutting down");
		outputClient2.write("Server shutting down");
		System.out.println("Messages sent");
		}
		catch (Exception e)
		{
			System.out.println("messages didn't send");
		}
		
		try {
		sleep(10000);
		}
		catch(Exception e){
			
		}
		System.exit(0);
	}
	
	
	public static void main(String args[])
	{
		Server server = new Server();
		server.start();
	}
}
