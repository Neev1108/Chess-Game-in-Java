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
	private PrintWriter out;
	private String incomingMessage;
	
	public Client()
	{
		establishConnection();
		runClient();
	}
	
	public Client(Socket s)
	{
		socket = s;
	}
	
	public void establishConnection()
	{
		while(true)
		{
			String input = JOptionPane.showInputDialog("Please enter the IP address of the server");
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
		        out = new PrintWriter(socket.getOutputStream(), true);
		        break;
	        }
	        catch(IOException e)
	        {
	        	System.out.println("Failed to connect to the server");
	        	e.printStackTrace(System.out);
	        	if(socket != null)
	        		try {socket.close();} catch (IOException e1) {}
	        	JOptionPane.showMessageDialog(null, "No server found at IP address " + input, "No server found at IP address " + input, JOptionPane.ERROR_MESSAGE);
	        	return;
	        }
			finally{
				System.out.println("Connection successful");
			}
			
		}
	}
	
	
	public void receiveMessage()
	{
		 try 
		 {
             incomingMessage = in.readLine();
         } 
		 catch(Exception e1)
		 {
        	System.out.println("Exception! - cannot read from the input buffer");
        	e1.printStackTrace(System.out);
		 }
	}
	
	public void runClient()
	{
		try
		{
	        while (true) 
	        {
	        	receiveMessage();
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
		        	if(incomingMessage.startsWith("SERVER CLOSE"))
			    	{
		        		break;
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
	
	
	
	
	
	
	private void sendMessage(String string) {
		// TODO Auto-generated method stub
		
	}

	public static void main(String args[]) throws Exception
	{
		Client c = new Client();
	}
	
	
}
