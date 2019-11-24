package edu.sjsu.cs151.view;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.*;

/**
 * This program creates the ChessBoard with all the pieces placed correctly on
 * the board.
 * 
 * @author Sehajmeet Sohal
 *
 */

public class ChessBoard extends JPanel implements MouseListener, MouseMotionListener {

	protected JButton[][] squares;
	protected JFrame outerFrame;
	protected Container container;
	protected JPanel boardPanel;
	public int x = -1;
	public int y = -1;
	public Icon image;

	/**
	 * Creates a new instance of Board
	 * 
	 */
	public ChessBoard() {

		// Creates Frame
		outerFrame = new JFrame();
		container = outerFrame.getContentPane();
		outerFrame.setSize(650, 800);

		// Creates board
		boardPanel = new JPanel();
		boardPanel.setLayout(new GridLayout(8, 8));
		container.add(boardPanel, BorderLayout.CENTER);
		createSquares();

		// Creates topPanel for buttons
		JPanel topPanel = new JPanel();
		topPanel.setLayout(new FlowLayout());
		topPanel.setSize(650, 75);

		// Creating the newGame button
		JButton newGame = new JButton("NEW GAME");
		newGame.setPreferredSize(new Dimension(120, 50));
		newGame.setBackground(Color.cyan);

		// Creating the quitGame button
		JButton quitGame = new JButton("QUIT GAME");
		quitGame.setPreferredSize(new Dimension(120, 50));
		newGame.setBackground(Color.pink);

		// newGame button functionality
		newGame.addActionListener(newGameRecurs -> {
			outerFrame.dispose();

			View.playerScreen();
			;
		});

		// quitGame button functionality
		quitGame.addActionListener(exit -> {
			outerFrame.dispose();
			System.exit(1);
		});

		topPanel.add(newGame);
		topPanel.add(quitGame);
		container.add(topPanel, BorderLayout.NORTH);

		// creates southPanel for text box area
		JPanel southPanel = new JPanel();
		southPanel.setSize(650, 75);
		JTextArea textArea = new JTextArea("Welcome to our chess game!");
		textArea.setEditable(false);
		JScrollPane scrollPane = new JScrollPane(textArea);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setPreferredSize(new Dimension(400, 75));
		southPanel.add(scrollPane);
		container.add(southPanel, BorderLayout.SOUTH);

		// display Frame
		outerFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		outerFrame.setVisible(true);
	}

	/**
	 * The method for creating the squares of the board and putting all the pieces
	 * on the Board.
	 */
	private void createSquares() {
		squares = new JButton[8][8];
		for (int i = 0; i < squares.length; i++) {
			for (int j = 0; j < squares.length; j++) {
				JButton button = new JButton();
				if (i == 1) {
					int dummyX = i;
					int dummyY = j;
					ImageIcon blackPawn = new ImageIcon(("blackPawn.png"));
					button.setIcon(blackPawn);
					button.addActionListener(event -> {

						if (x == -1 && y == -1) {
							x = dummyX;
							y = dummyY;
							image = getImage(squares, dummyX, dummyY);
						} else {
							button.setIcon(image);
						
						}
					});
				}

				if (i == 6) {
					int dummyX = i;
					int dummyY = j;
					ImageIcon whitePawn = new ImageIcon(("whitePawn.png"));
					button.setIcon(whitePawn);
					button.addActionListener(event -> {
						if (x == -1 && y == -1) {
							x = dummyX;
							y = dummyY;
							image = getImage(squares, dummyX, dummyY);
						} else {
							button.setIcon(image);
							
						}
					});
				}

				if (i == 0 && (j == 0 || j == 7)) {

					int dummyX = i;
					int dummyY = j;
					ImageIcon blackRook = new ImageIcon(("blackRook.png"));
					button.setIcon(blackRook);
					button.addActionListener(event -> {
						if (x == -1 && y == -1) {
							x = dummyX;
							y = dummyY;
							image = getImage(squares, dummyX, dummyY);
						} else {
							button.setIcon(image);
							
						}
					});
				}

				if (i == 7 && (j == 0 || j == 7)) {

					int dummyX = i;
					int dummyY = j;
					ImageIcon whiteRook = new ImageIcon(("whiteRook.png"));
					button.setIcon(whiteRook);
					button.addActionListener(event -> {
						if (x == -1 && y == -1) {
							x = dummyX;
							y = dummyY;
							image = getImage(squares, dummyX, dummyY);
						} else {
							button.setIcon(image);

						}
					});
				}

				if (i == 0 && (j == 1 || j == 6)) {

					int dummyX = i;
					int dummyY = j;
					ImageIcon blackKnight = new ImageIcon(("blackKnight.png"));
					button.setIcon(blackKnight);
					button.addActionListener(event -> {
						if (x == -1 && y == -1) {
							x = dummyX;
							y = dummyY;
							image = getImage(squares, dummyX, dummyY);
						} else {
							button.setIcon(image);
							squares[x][y].removeAll();

						}
					});

				}

				if (i == 7 && (j == 1 || j == 6)) {

					int dummyX = i;
					int dummyY = j;
					ImageIcon whiteKnight = new ImageIcon(("whiteKnight.png"));
					button.setIcon(whiteKnight);
					button.addActionListener(event -> {
						if (x == -1 && y == -1) {
							x = dummyX;
							y = dummyY;
							image = getImage(squares, dummyX, dummyY);
						} else {
							button.setIcon(image);
							squares[x][y].removeAll();

						}
					});

				}

				if (i == 0 && (j == 2 || j == 5)) {

					int dummyX = i;
					int dummyY = j;
					ImageIcon blackBishop = new ImageIcon(("blackBishop.png"));
					button.setIcon(blackBishop);
					button.addActionListener(event -> {
						if (x == -1 && y == -1) {
							x = dummyX;
							y = dummyY;
							image = getImage(squares, dummyX, dummyY);
						} else {
							button.setIcon(image);
							squares[x][y].removeAll();

						}
					});

				}

				if (i == 7 && (j == 2 || j == 5)) {

					int dummyX = i;
					int dummyY = j;
					ImageIcon whiteBishop = new ImageIcon(("whiteBishop.png"));
					button.setIcon(whiteBishop);
					button.addActionListener(event -> {
						if (x == -1 && y == -1) {
							x = dummyX;
							y = dummyY;
							image = getImage(squares, dummyX, dummyY);
						} else {
							button.setIcon(image);
						
						}
					});
				}

				if (i == 0 && j == 3) {

					int dummyX = i;
					int dummyY = j;
					ImageIcon blackQueen = new ImageIcon(("blackQueen.png"));
					button.setIcon(blackQueen);
					button.addActionListener(event -> {
						if (x == -1 && y == -1) {
							x = dummyX;
							y = dummyY;
							image = getImage(squares, dummyX, dummyY);
						} else {
							button.setIcon(image);
							
						}
					});
				}

				if (i == 7 && j == 3) {

					int dummyX = i;
					int dummyY = j;
					ImageIcon whiteQueen = new ImageIcon(("whiteQueen.png"));
					button.setIcon(whiteQueen);
					button.addActionListener(event -> {
						if (x == -1 && y == -1) {
							x = dummyX;
							y = dummyY;
							image = getImage(squares, dummyX, dummyY);
						} else {
							
						}
					});
				}

				if (i == 0 && j == 4) {

					int dummyX = i;
					int dummyY = j;
					ImageIcon blackKing = new ImageIcon(("blackKing.png"));
					button.setIcon(blackKing);
					button.addActionListener(event -> {
						if (x == -1 && y == -1) {
							x = dummyX;
							y = dummyY;
							image = getImage(squares, dummyX, dummyY);
						} else {
							button.setIcon(image);

						}
					});
				}

				if (i == 7 && j == 4) {

					int dummyX = i;
					int dummyY = j;
					ImageIcon whiteKing = new ImageIcon(("whiteKing.png"));
					button.setIcon(whiteKing);
					button.addActionListener(event -> {
						if (x == -1 && y == -1) {
							x = dummyX;
							y = dummyY;
							image = getImage(squares, dummyX, dummyY);
						} else {
							button.setIcon(image);
							squares[x][y].removeAll();

							x = -1;
							y = -1;
						}
					});
				}

				button.setBackground(getColor(i, j));


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
	private Color getColor(int x, int y) {
		if ((x + y) % 2 == 0)
			return Color.white;
		else
			return Color.cyan;
	}

	public final static ChessBoard getChessBoard() {
		return new ChessBoard();

	}

	public Icon getImage(JButton[][] squares, int x, int y) {

		Icon image = squares[x][y].getIcon();
		return image;

	}

	public static void main(String[] args) {
		getChessBoard();
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}



}
