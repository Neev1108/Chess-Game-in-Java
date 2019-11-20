package edu.sjsu.cs151.view;

import java.awt.*;
import javax.swing.*;

/**
 * Creating a JFrame of size 2000 x 2000
 */



public class ChessBoard {
	
	protected JPanel [][] squares;
	protected JFrame boardFrame;
	protected Container container;


	 
    /** Creates a new instance of Board */
    public ChessBoard() 
    {
        boardFrame = new JFrame();
        boardFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        container = boardFrame.getContentPane();
        container.setLayout(new GridLayout(8,8));
        create_squares();
        boardFrame.setSize(600,600);
        boardFrame.setVisible(true);
    }
    
    private void create_squares()
    {
        squares = new JPanel[8][8];
        for(int i = 0;i< squares.length;i++)
        {
            for(int j = 0;j < squares.length ;j++)
            {
                JPanel p = new JPanel();
                p.setBackground(setColor(i,j));
                squares[i][j] = p;
                container.add(p);
            }
        }
    }
    
    private Color setColor(int x, int y)
    {
        if((x+y)%2 == 0)
            return Color.CYAN;
        else
            return Color.ORANGE;
    }
    
    public static void main(String args[])
    {
        new ChessBoard();
    }
    
}

