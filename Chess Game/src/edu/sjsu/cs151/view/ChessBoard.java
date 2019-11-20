package edu.sjsu.cs151.view;

import java.awt.*;
import javax.swing.*;

/**
 * This program creates the ChessBoard with
 * all the pieces placed correctly on the board.
 * 
 * @author Sehajmeet Sohal
 *
 */

public class ChessBoard {

	protected JButton[][] squares;
	protected JFrame boardFrame;
	protected Container container;

	/**
	 * Creates a new instance of Board
	 * 
	 */
	public ChessBoard() {
		boardFrame = new JFrame();
		boardFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		container = boardFrame.getContentPane();
		container.setLayout(new GridLayout(8, 8));
		createSquares();
		boardFrame.setSize(600, 600);
		boardFrame.setVisible(true);

	}

	/**
	 * The method for creating the squares of the 
	 * board and putting all the pieces on the Board.
	 */
	private void createSquares() {
		squares = new JButton[8][8];
		for (int i = 0; i < squares.length; i++) {
			for (int j = 0; j < squares.length; j++) {
				JButton button = new JButton();
				if (i == 1) {
					ImageIcon blackPawn = new ImageIcon(("blackPawn.png"));
					button.setIcon(blackPawn);
				}

				if (i == 6) {
					ImageIcon whitePawn = new ImageIcon(("whitePawn.png"));
					button.setIcon(whitePawn);
				}

				if (i == 0 && (j == 0 || j == 7)) {
					ImageIcon blackRook = new ImageIcon(("blackRook.png"));
					button.setIcon(blackRook);
				}

				if (i == 7 && (j == 0 || j == 7)) {
					ImageIcon whiteRook = new ImageIcon(("whiteRook.png"));
					button.setIcon(whiteRook);
				}

				if (i == 0 && (j == 1 || j == 6)) {
					ImageIcon blackKnight = new ImageIcon(("blackKnight.png"));
					button.setIcon(blackKnight);
				}

				if (i == 7 && (j == 1 || j == 6)) {
					ImageIcon whiteKnight = new ImageIcon(("whiteKnight.png"));
					button.setIcon(whiteKnight);
				}

				if (i == 0 && (j == 2 || j == 5)) {
					ImageIcon blackBishop = new ImageIcon(("blackBishop.png"));
					button.setIcon(blackBishop);
				}

				if (i == 7 && (j == 2 || j == 5)) {
					ImageIcon whiteBishop = new ImageIcon(("whiteBishop.png"));
					button.setIcon(whiteBishop);
				}

				if (i == 0 && j == 3) {
					ImageIcon whiteBlack = new ImageIcon(("whiteBlack.png"));
					button.setIcon(whiteBlack);
				}

				if (i == 7 && j == 3) {
					ImageIcon whiteQueen = new ImageIcon(("whiteQueen.png"));
					button.setIcon(whiteQueen);
				}

				if (i == 0 && j == 4) {
					ImageIcon blackKing = new ImageIcon(("blackKing.png"));
					button.setIcon(blackKing);
				}

				if (i == 7 && j == 4) {
					ImageIcon whiteKing = new ImageIcon(("whiteKing.png"));
					button.setIcon(whiteKing);
				}

				button.setBackground(setColor(i, j));

				squares[i][j] = button;
				container.add(button);

			}
		}
	}

	/**
	 * Helper method for determining the color of the square
	 * 
	 * @param x The vertical variable
	 * @param y The horizontal variable
	 * @return The color of the square
	 */
	private Color setColor(int x, int y) {
		if ((x + y) % 2 == 0)
			return Color.CYAN;
		else
			return Color.ORANGE;
	}
	
	public final static ChessBoard getChessBoard() {
		return new ChessBoard();
		
	}

	public static void main(String[] args) {
		getChessBoard();
	}

}
