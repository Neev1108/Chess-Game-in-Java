package edu.sjsu.cs151.view;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;


/**
 * This program creates the ChessBoard with
 * all the pieces placed correctly on the board.
 * 
 * @author Sehajmeet Sohal
 *
 */

public class ChessBoard{

	protected JButton[][] squares;
	protected JFrame outerFrame;
	protected Container container;
	protected JPanel boardPanel;
	int x = -1;
	int y = -1;
	public Icon image;
	/**
	 * Creates a new instance of Board
	 * 
	 */
	public ChessBoard() {
		
		//Creates Frame
		outerFrame = new JFrame();
		container = outerFrame.getContentPane();
		outerFrame.setSize(650, 800);
		
		//Creates board
		boardPanel = new JPanel();
		boardPanel.setLayout(new GridLayout(8, 8));
		container.add(boardPanel, BorderLayout.CENTER);
		createSquares();

		//Creates topPanel for buttons
		JPanel topPanel = new JPanel();
		topPanel.setLayout(new FlowLayout());
		topPanel.setSize(650, 75);
		
		//Creating the newGame button
		JButton newGame = new JButton("NEW GAME");
		newGame.setPreferredSize(new Dimension(120, 50));
		newGame.setBackground(Color.cyan);

		//Creating the quitGame button
		JButton quitGame = new JButton("QUIT GAME");
		quitGame.setPreferredSize(new Dimension(120, 50));
		newGame.setBackground(Color.pink);
		
		//newGame button functionality
		newGame.addActionListener(newGameRecurs -> {
			outerFrame.dispose();

			View.playerScreen();;
		});
		
		//quitGame button functionality
		quitGame.addActionListener(exit -> {
			outerFrame.dispose();
			System.exit(1);
		});
		
		topPanel.add(newGame);
		topPanel.add(quitGame);
		container.add(topPanel, BorderLayout.NORTH);
		
		
		//creates southPanel for text box area
		JPanel southPanel = new JPanel();
		southPanel.setSize(650, 75);
		JTextArea textArea = new JTextArea("Welcome to our chess game!");
		textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setVerticalScrollBarPolicy(
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setPreferredSize(new Dimension(400, 75));
        southPanel.add(scrollPane);
		container.add(southPanel, BorderLayout.SOUTH);
		
		
		//display Frame
		outerFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		outerFrame.setVisible(true);
		
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
					int dummyX = i;
					int dummyY = j;
					button.addActionListener(event -> {
						move(button,dummyX,dummyY,blackPawn);
						
				});
				}
				else if (i == 6) {
					ImageIcon whitePawn = new ImageIcon(("whitePawn.png"));
					button.setIcon(whitePawn);
					int dummyX = i;
					int dummyY = j;
					button.addActionListener(event -> {
						move(button,dummyX,dummyY,whitePawn);
				});
				}

				else if (i == 0 && (j == 0 || j == 7)) {
					ImageIcon blackRook = new ImageIcon(("blackRook.png"));
					button.setIcon(blackRook);
					int dummyX = i;
					int dummyY = j;
					button.addActionListener(event -> {
						move(button,dummyX,dummyY, blackRook);
				});
				}

				else if (i == 7 && (j == 0 || j == 7)) {
					ImageIcon whiteRook = new ImageIcon(("whiteRook.png"));
					button.setIcon(whiteRook);
					int dummyX = i;
					int dummyY = j;
					button.addActionListener(event -> {
						move(button,dummyX,dummyY, whiteRook);
				});
				}

				else if (i == 0 && (j == 1 || j == 6)) {
					ImageIcon blackKnight = new ImageIcon(("blackKnight.png"));
					button.setIcon(blackKnight);
					int dummyX = i;
					int dummyY = j;
					button.addActionListener(event -> {
						move(button,dummyX,dummyY, blackKnight);
				});
				}

				else if (i == 7 && (j == 1 || j == 6)) {
					ImageIcon whiteKnight = new ImageIcon(("whiteKnight.png"));
					button.setIcon(whiteKnight);
					int dummyX = i;
					int dummyY = j;
					button.addActionListener(event -> {
						move(button,dummyX,dummyY, whiteKnight);
				});
				}

				else if (i == 0 && (j == 2 || j == 5)) {
					ImageIcon blackBishop = new ImageIcon(("blackBishop.png"));
					button.setIcon(blackBishop);
					int dummyX = i;
					int dummyY = j;
					button.addActionListener(event -> {
						move(button,dummyX,dummyY, blackBishop);
				});
				}

				else if (i == 7 && (j == 2 || j == 5)) {
					ImageIcon whiteBishop = new ImageIcon(("whiteBishop.png"));
					button.setIcon(whiteBishop);
					int dummyX = i;
					int dummyY = j;
					button.addActionListener(event -> {
						move(button,dummyX,dummyY, whiteBishop);
				});
				}

				else if (i == 0 && j == 3) {
					ImageIcon whiteBlack = new ImageIcon(("blackQueen.png"));
					button.setIcon(whiteBlack);
					int dummyX = i;
					int dummyY = j;
					button.addActionListener(event -> {
						move(button,dummyX,dummyY, whiteBlack);
				});
				}

				else if (i == 7 && j == 3) {
					ImageIcon whiteQueen = new ImageIcon(("whiteQueen.png"));
					button.setIcon(whiteQueen);
					int dummyX = i;
					int dummyY = j;
					button.addActionListener(event -> {
						move(button,dummyX,dummyY, whiteQueen);
				});
				}

				else if (i == 0 && j == 4) {
					ImageIcon blackKing = new ImageIcon(("blackKing.png"));
					button.setIcon(blackKing);
					int dummyX = i;
					int dummyY = j;
					button.addActionListener(event -> {
						move(button,dummyX,dummyY, blackKing);
				});
				}

				else if (i == 7 && j == 4) {
					ImageIcon whiteKing = new ImageIcon(("whiteKing.png"));
					button.setIcon(whiteKing);
					int dummyX = i;
					int dummyY = j;
					button.addActionListener(event -> {
						move(button,dummyX,dummyY, whiteKing);
				});
				}

				button.setBackground(setColor(i, j));

				squares[i][j] = button;
				boardPanel.add(button);
				int dummyX = i;
				int dummyY = j;
				button.addActionListener(event -> {
					if (this.x == -1 && y == -1) {
						x = dummyX;
						y = dummyY;
						image = getImage(dummyX, dummyY);
					} else 
						button.setIcon(image);
					
				});

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

	public Icon getImage(int x, int y) {
		Icon image = squares[x][y].getIcon();
		return image;
	}

/*	For quicker testing purposes
 * 	public static void main(String[] args) {
		getChessBoard();
	}
*/
	
	
	public void move(JButton button,int dummyX, int dummyY, ImageIcon icon) {
		if (this.x == -1 && y == -1) {
			x = dummyX;
			y = dummyY;
			image = getImage(dummyX, dummyY);
		} else {
			button.setIcon(image);
		
		}
	}
}


