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
		
	public void runClient()
	{
		try
		{
        	while ((incomingMessage = in.readLine()) != null)
	        {
	        	if (incomingMessage.equals("Server shutting down"))
	        	{
	        		System.out.println("Successful shutdown");
	        		serverClose();
	        	}
	        }
		}
		catch (SocketException se)
		 {
			System.out.println("failed shutdown");
			 serverClose();
		 }
		catch(Exception e)
		{
			System.out.println("Oops");
			e.printStackTrace(System.out);
		}
        finally {
        	try {socket.close();} catch (IOException e1) {}
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
	
	public static void main(String args[]) throws Exception
	{
		Client c = new Client();
	}
	
	
}
