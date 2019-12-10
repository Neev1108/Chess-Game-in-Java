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
	
	
	
	public void connectToServer()
	{
		
			JFrame playerScreen = new JFrame("Server Identification");
			playerScreen.setSize(400, 300);
			playerScreen.setVisible(true);

			String input = JOptionPane.showInputDialog("Please enter the IP address of the server");
			

			

			
			
			


			
			playerScreen.setVisible(true);		
	}
	
	public static void main(String args[]) throws Exception
	{
		Client c = new Client();
		c.connectToServer();
	}
	
	
}
