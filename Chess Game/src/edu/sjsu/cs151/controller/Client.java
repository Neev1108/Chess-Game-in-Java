package edu.sjsu.cs151.controller;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.io.*;
import java.net.*;
import java.util.*;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import edu.sjsu.cs151.view.*;
import edu.sjsu.cs151.model.Player;

public class Client extends Thread {
	
	private Socket socket;
	private BufferedReader in;
	private Scanner inMk2;
	private BufferedWriter out;
	private String incomingMessage;
	private Player myID;
	
	public Client()
	{
		establishConnection();
		runClient();
	}
		
	public void establishConnection()
	{
		while(true)
		{
			String input = JOptionPane.showInputDialog("Please enter the IP address of the server.\nIf the server is on this computer, please use local IP address 127.0.0.1");
			//127.0.0.1 is the local ip address
			if (input == null)
			{
				System.exit(0);
			}
			try
	        {
		        // Make connection and initialize streams
		        socket = new Socket(input, 4387);
		        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		        inMk2 = new Scanner(socket.getInputStream());
		        out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
				System.out.println("Connection successful");
		        break;
	        }
	        catch(IOException e)
	        {
	        	System.out.println("Failed to connect to the server");
	        	e.printStackTrace(System.out);
	        	if(socket != null)
	        		try {socket.close();} catch (IOException e1) {}
	        	JOptionPane.showMessageDialog(null, "No server found at IP address " + input, "No server found at IP address " + input, JOptionPane.ERROR_MESSAGE);
	        	System.exit(1);
	        }
			
			
		}
	}
	
	public void runClient2()
	{
		while(true) {
			try {
				sleep(10000);
				System.out.println("yeeeeeeeeeeeeeeet");
			}
			catch (Exception e)
			{
				System.out.println("I broked " + e.getClass());
			}
		}
	}
	
	public void runClient()
	{
		try
		{
	        while (true) 
	        {
	        	System.out.println("Entered runClient");
	        	receiveMessage();
	        	if (incomingMessage == null)
	        	{
	        		continue;
	        	}
	        	if(incomingMessage != null)
	        	{
		        	if(incomingMessage.startsWith("ALLIANCE"))
			    	{
		        		if(incomingMessage.charAt(9)== 'B')
		        		{
		        			
		        		}
			              	//gameAlliance = Alliance.BLACK;
		        		else if (incomingMessage.charAt(9)== 'W')
		        		{
		        			
		        		}
			              	//gameAlliance = Alliance.WHITE;
			    	}
		        	else if(incomingMessage.startsWith("START"))
		        	{
		        		//gameModel.setNetworkGameStartFlag();
		        	}
		        	else if (incomingMessage.startsWith("MOVE")) 
		            {
		            	//moveToExecute = transformToMove(readMessage);
		            	//gameModel.executeMove(moveToExecute);
		            	//if(gameModel.isGameOver())
		            		//break;
		            } 
		        	else if(incomingMessage.startsWith("DISCON"))
		        	{
		        		break;
		        	}
		        	if (incomingMessage.equals("Server shutting down"))
		             {
		        		serverClose();
		             }
		        	else
		        	{
		        		//gameView.setMessageText(readMessage);
		        	}
	        	}
	        }
	        sendMessage("QUIT");
		}
        finally {
        	try {socket.close();} catch (IOException e1) {}
        }
	}
	
	public void receiveMessage()
	{
		 try 
		 {
			 System.out.println("Entered receiveMessage()");
			 //if (inMk2.hasNext())
			 incomingMessage = in.readLine();
         } 
		 catch (SocketException se)
		 {
			 serverClose();
		 }
		 catch(Exception e1)
		 {
			System.out.println("failure, proceed to wait");
		
			try{
				sleep(5000);
			}
			catch(Exception e)
			{
				
			}
        	System.out.println("Exception! - cannot read from the input buffer");
        	e1.printStackTrace(System.out);
		 }
	}
	public void sendMessage(String message)
	{
		try
		{
			out.write(message);
		}
		catch(Exception e)
		{
			System.out.println("Exception! - cannot write to the server");
        	e.printStackTrace(System.out);
		}
	}
	
	public void serverClose()
	{
		JOptionPane.showMessageDialog(null,"The server has shut down. We apologize for any inconvenience.", 
				"Server Shutdown", JOptionPane.INFORMATION_MESSAGE);
		System.exit(1);

	}
	
	
	/**
	 * This method prints prompt for user to ask if he wants to play and
	 * returns true if yes, false otherwise.
	 * @return true if user wants to play, false otherwise.
	 */
    private boolean wantsToPlayAgain() 
    {
        int response = JOptionPane.showConfirmDialog(/*gameView.getMainFrame()*/ null,
            "Want to play again?",
            "",
            JOptionPane.YES_NO_OPTION);
        return response == JOptionPane.YES_OPTION;
    }
	
    /**
     * This method contains main client loop in which it 
     * performs cyclic connection to the server, running the game 
     * and provides user decision to play or not to play again. 
     * It also clears the game objects and prepares new board 
     * before new game.
     */
	public void clientHandle()
	{
		 while (true) 
		 {
			establishConnection();
          
            runClient();

            if (!wantsToPlayAgain())
            {
    	        sendMessage("QUIT");
                System.exit(0);
            }
     /*       model.resetModel();
            View.prepareNextMatch();*/
        }
	}
	
	
	public static void main(String args[]) throws Exception
	{
		Client c = new Client();
	}
	
	
}
