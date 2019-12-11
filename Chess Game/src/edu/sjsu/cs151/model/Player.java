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
//	private boolean firstTurn = false;
	private Player opponent;
	private Socket socket;
	private BufferedReader in;
	private PrintWriter out;
	private String input;
	private String output;
	
	
	/**
	 * Constructor for a Player.
	 * @param color The color of the player
	 * @param firstTurn The boolean value to determine the first turn
	 */
	public Player(String color) {
		this.color = color;
		

	}	

	
	public Player(Socket s, int i)
	{
		this.socket = s;
		System.out.println("I exist");
		if (i == 1)
		{
			this.color = "White";
		}
		else
		{
			this.color = "Black";
		}
		System.out.println(this);
		try 
        {
        	in = new BufferedReader(new InputStreamReader(
	                socket.getInputStream()));
        	System.out.println(socket);
        	out = new PrintWriter(socket.getOutputStream(), true);
        	out.println("Welcome to the chess game! Waiting for opponent...");
        	System.out.println("still runnin");
        } 
        catch (IOException e) 
        {
            System.out.println("Player died: " + e);
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
	 * Method that checks which player gets the first turn
	 * @return The boolean value after determining the first turn
	 */
/*	public boolean firstTurn() {
		return firstTurn = true;
	}
	*/
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
	
	
	public void sendServerCLoseInfo()
    {
    	out.println("Chess server is closed, try another server...");
		out.println("SERVER CLOSE");
    }
	
	
	 /**
     * Informs the client that it is now their turn.
     */
    public void printPrompt()
    {
    	if(color.equals("Black"))
    		out.println("Black, your move");
    	else if (color.equals("White"))
    		out.println("White, your move");
    }
    
    
    
    
    
    
    /**
     * The run method of this thread. It handles communication within 
     * entire match. First it sends configuration messages to the client
     * (e.g. alliance setting and START message). The it processes messages
     * read from the client and communicate with opponent server thread 
     * managing the state of the game. It ends when QUIT message received 
     * or when error occurred.
     */
    public void run2() 
    {
        try 
        {
            // The thread is only started after everyone connects.
        	out.println(new String("ALLIANCE " + color));
        	out.println(new String("START "));
        	
            // Tell the first player that it is her turn.
            if (color.equals("White"))
            	printPrompt();
        	else
        		out.println("Opponent's move...");
            // Repeatedly get commands from the client and process them.
            while (true) 
            {
            	input = in.readLine();
            	if(input != null)
            	{
	            	if (input.startsWith("MOVE")) 
	                {
	            		opponent.out.println(input);
	            		opponent.printPrompt();
	            		out.println("Opponent's move...");
	                } 
	            	else
	            	{
	            		System.out.println(input);
		            	if (input.startsWith("QUIT")) 
		                {
		            		// notify second player that another has disconnected
		            		opponent.out.println("Opponent disconnected...");
		            		opponent.out.println("DISCON");
		            		return;
		                }
	            	}
            	}
            	else
            	{
            		System.out.println("null received");
            		return;
            	}
            }
        } 
        catch (IOException e)
        {
         	System.out.println("Exception! - cannot read from the input buffer");
        	e.printStackTrace(System.out);        
    	}
        catch(Exception e1)
        {
        	System.out.println("Error, Undefined server exception");
        }
        finally
        {
            try {socket.close();} catch (IOException e) {}
        }
    }
    
    
    
    
    public void run()
    {
    	 try {
    		 System.out.println("run method");
             setup();
            // processCommands();
         } catch (Exception e) {
             e.printStackTrace();
         } finally {
             if (opponent != null && opponent.out != null) {
                 opponent.out.println("OTHER_PLAYER_LEFT");
             }
             try {socket.close();} catch (IOException e) {}
         }
    }
    
    
    
    private void setup() throws IOException {
        Scanner scan = new Scanner(socket.getInputStream());
        out = new PrintWriter(socket.getOutputStream(), true);
        out.println("WELCOME");
        if (opponent == null) {
            //currentPlayer = this;
            out.println("MESSAGE Waiting for opponent to connect");
        } else {
            //opponent = currentPlayer;
            opponent.opponent = this;
            opponent.out.println("MESSAGE Your move");
        }
    }
    
    
}
