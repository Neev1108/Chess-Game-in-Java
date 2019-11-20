package edu.sjsu.cs151.view;

import java.awt.*;
import javax.swing.*;

/**
 * This program creates a simple moving animation
 * 
 * @author Sehajmeet and Neeval
 *
 */
public class View {
	private static final int ICON_WIDTH = 400;
	private static final int ICON_HEIGHT = 100;
	private static final int PAWN_WIDTH = 100;

	public static void main(String[] args) {
		/**
		 * Creating a JFrame of size 2000 x 2000
		 */

		JFrame frame = new JFrame();
		frame.setSize(2000, 2000);

		/**
		 * Creating three MoveableShape objects
		 */
		final MoveableShape shape = new PawnShape(0, 0, PAWN_WIDTH);
		final MoveableShape quiz = new stationaryTile(0, 0, 100);
		final MoveableShape bish = new BishopShape(0, 0, PAWN_WIDTH);

		/**
		 * Creating the first chess piece animation
		 */
		ShapeIcon icon = new ShapeIcon(shape, ICON_WIDTH, ICON_HEIGHT);
		final JLabel label = new JLabel(icon);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(label);

		/**
		 * Creating the second chess piece animation
		 */
		ShapeIcon bishop = new ShapeIcon(bish, ICON_WIDTH, ICON_HEIGHT);
		final JLabel label3 = new JLabel(bishop);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(label3);

		/**
		 * Creating the tiles of the chess board
		 */
		ShapeIcon tile = new ShapeIcon(quiz, ICON_WIDTH, ICON_HEIGHT);
		final JLabel label2 = new JLabel(tile);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(label2);

		final int DELAY = 5;

		/**
		 * The timer for the animation
		 */
		Timer t = new Timer(DELAY, event -> {
			shape.move();
			label.repaint();
			bish.move();
			label3.repaint();

		});

		t.start();

		/**
		 * Creating the button for starting the chess game
		 */
		JButton startButton = new JButton("START CHESS GAME");

		//Creating a GridBagLayout for our output
		JPanel pnl = new JPanel(new GridBagLayout());

		pnl.add(startButton);
		frame.add(pnl);
		frame.setVisible(true);


		startButton.addActionListener(event -> {

			// start a new frame for the pick color screen
			frame.dispose();
			playerScreen();

		});

	}

	public static void playerScreen() {
		JFrame playerScreen = new JFrame("Player Screen");
		playerScreen.setSize(400, 300);
		playerScreen.setBackground(Color.black);
		playerScreen.setVisible(true);

		JPanel pn2 = new JPanel(new FlowLayout());
		
		pn2.setBackground(Color.red);

		// textField asking the player to choose a color
		JTextField chooseColor = new JTextField("PLEASE CHOOSE A COLOR");
		chooseColor.setPreferredSize(new Dimension(300, 75));
		Font font1 = new Font("SansSerif", Font.ITALIC, 20);
		chooseColor.setBackground(Color.white);

		// Buttons are in the shape of pawns that are black and white
		// This only works on my computer. Still need to create an image folder in the
		// project so we cans store our images when someone runs
		Icon wPawn = new ImageIcon("whitePawn.png");
		Icon bPawn = new ImageIcon("blackPawn.png");
		JButton white = new JButton(wPawn);
		JButton black = new JButton(bPawn);

		// adding everything
		pn2.add(white);
		pn2.add(black);

		chooseColor.setFont(font1);
		chooseColor.setEditable(false);

		pn2.add(chooseColor);
		playerScreen.add(pn2);

		/**
		 * The actionListener for selecting the white color
		 */
		white.addActionListener(event2 -> {
			playerScreen.dispose();
			JFrame game = startGameScreen();

		});
		
		/**
		 * The actionListener for selecting the white color
		 */
		black.addActionListener(event3 -> {
			playerScreen.dispose();
			JFrame game = startGameScreen();
		});

	}

	public static JFrame startGameScreen() {

		// New Game and exit game buttons
		JFrame game = new JFrame("Game Screen");
		game.setSize(800, 800);
		
		//Creating a JLabel for displaying a message
		JLabel label = new JLabel(); 
	    label.setText("What would you like to do?");
	    label.setSize(100,100);

		JPanel pn3 = new JPanel();
		pn3.setBackground(Color.white);

		pn3.setLayout(new FlowLayout());
		pn3.setBounds(200, 800, 300, 100);
		
		//Creating the newGame button
		JButton newGame = new JButton("NEW GAME");
		newGame.setPreferredSize(new Dimension(150, 100));
		newGame.setBackground(Color.cyan);

		//Creating the quitGame button

		JButton quitGame = new JButton("QUIT GAME");
		quitGame.setPreferredSize(new Dimension(150, 100));
		newGame.setBackground(Color.pink);

		
		//Adding the buttons and label to the panel
		pn3.add(label);
		pn3.add(newGame);
		pn3.add(quitGame);

		game.add(pn3);
		game.setVisible(true);

		newGame.addActionListener(newGameRecurs -> {
			game.dispose();
			playerScreen();
			ChessBoard.getChessBoard();

		});

		quitGame.addActionListener(exit -> {
			game.dispose();
			System.exit(1);
		});

		return game;
	}

	/**
	 * The class that creates an instance of the 
	 * ChessBoard with all the pieces on the board.
	 * @author Sehajmeet
	 *
	 */
	public static class ChessBoard {

		protected JButton[][] squares;
		protected JFrame outerFrame;
		protected Container container;
		protected JPanel boardPanel;

		/**
		 * Creates a new instance of Board
		 * 
		 */
		public ChessBoard() {
			outerFrame = new JFrame();
			container = outerFrame.getContentPane();
			outerFrame.setSize(800, 800);
			
			boardPanel = new JPanel();
			boardPanel.setLayout(new GridLayout(8, 8));
			container.add(boardPanel, BorderLayout.CENTER);
			createSquares();

			JPanel topPanel = new JPanel();
			topPanel.setLayout(new FlowLayout());
			//Creating the newGame button
			JButton newGame = new JButton("NEW GAME");
			newGame.setPreferredSize(new Dimension(120, 50));
			newGame.setBackground(Color.cyan);

			//Creating the quitGame button
			JButton quitGame = new JButton("QUIT GAME");
			quitGame.setPreferredSize(new Dimension(120, 50));
			newGame.setBackground(Color.pink);
			
			quitGame.addActionListener(exit -> {
				outerFrame.dispose();
				System.exit(1);
			});
			
			topPanel.add(newGame);
			topPanel.add(quitGame);
			container.add(topPanel, BorderLayout.NORTH);
					
			JTextField textField = new JTextField(20);
			textField.setText("Will display an action log");
			container.add(textField, BorderLayout.SOUTH);
			
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
					boardPanel.add(button);

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

		

	}
}
