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

import edu.sjsu.cs151.view.ChessBoard;

public class Client {
	
	Socket socket;
	BufferedReader in;
	PrintWriter out;
	
	public void establishConnection()
	{
		while(true)
		{
			String input = JOptionPane.showInputDialog("Please enter the IP address of the server");
			
			if (input == null)
			{
				break;
			}
			try
	        {
		        // Make connection and initialize streams
		        socket = new Socket(input, 4387);
		        in = new BufferedReader(new InputStreamReader(
		                socket.getInputStream()));
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
	        }
		
		}
	}
	
	public static void main(String args[]) throws Exception
	{
		Client c = new Client();
		c.establishConnection();
	}
	
	
}
