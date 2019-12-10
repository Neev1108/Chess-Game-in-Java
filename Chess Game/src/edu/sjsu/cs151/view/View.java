package edu.sjsu.cs151.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.LinkedList;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.locks.ReentrantLock;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.Timer;

import edu.sjsu.cs151.model.*;
import edu.sjsu.cs151.controller.*;

import java.awt.event.*;

/**
 * This program creates a simple moving animation and the GUI component of our
 * game.
 * 
 * @author Sehajmeet and Neeval
 *
 */
public class View implements Runnable {

	public static BlockingQueue<Message> queue;
	private static final int ICON_WIDTH = 400;
	private static final int ICON_HEIGHT = 100;
	private static final int PAWN_WIDTH = 100;
	private static ChessBoard chessBoardFrame;
	boolean canMove;
	LinkedList<String> gameInfo = new LinkedList<String>();
	JTextArea textArea;

	public View(BlockingQueue<Message> queue) {
		View.queue = queue;
		chessBoardFrame = new ChessBoard(queue);
		run();
	}

	/**
	 * Method to make the the animation move
	 */
	public void run() {
		/**
		 * Creating a JFrame of size 2000 x 2000
		 */

		/*
		 * JFrame frame = new JFrame(); frame.setSize(1000, 500);
		 */
		/**
		 * Creating three MoveableShape objects
		 */
		/*
		 * final MoveableShape shape = new PawnShape(0, 0, PAWN_WIDTH); final
		 * MoveableShape quiz = new stationaryTile(0, 0, 100); final MoveableShape bish
		 * = new BishopShape(0, 0, PAWN_WIDTH);
		 */
		/**
		 * Creating the first chess piece animation
		 */
		/*
		 * ShapeIcon icon = new ShapeIcon(shape, ICON_WIDTH, ICON_HEIGHT); final JLabel
		 * label = new JLabel(icon); frame.setVisible(true);
		 * frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); frame.add(label);
		 */
		/**
		 * Creating the second chess piece animation
		 */
		/*
		 * ShapeIcon bishop = new ShapeIcon(bish, ICON_WIDTH, ICON_HEIGHT); final JLabel
		 * label3 = new JLabel(bishop); frame.setVisible(true);
		 * frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 * 
		 * frame.add(label3);
		 */
		/**
		 * Creating the tiles of the chess board
		 */
		/*
		 * ShapeIcon tile = new ShapeIcon(quiz, ICON_WIDTH, ICON_HEIGHT); final JLabel
		 * label2 = new JLabel(tile); frame.setVisible(true);
		 * frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); frame.add(label2);
		 * 
		 * final int DELAY = 5;
		 */
		/**
		 * The timer for the animation
		 */
		/*
		 * Timer t = new Timer(DELAY, event -> { shape.move(); label.repaint();
		 * bish.move(); label3.repaint();
		 * 
		 * });
		 * 
		 * t.start();
		 */
		/**
		 * Creating the button for starting the chess game
		 */
		// JButton startButton = new JButton("START CHESS GAME");

		// Creating a GridBagLayout for our output
		/*
		 * JLabel backg = new JLabel(new ImageIcon("background.png")); JLabel backg =
		 * new JLabel(new
		 * ImageIcon(getClass().getResource("/resources/background.png")));
		 * backg.setLayout(new FlowLayout()); JPanel pnl = new JPanel();
		 * 
		 * backg.add(pnl); pnl.add(startButton); frame.add(backg);
		 * frame.setVisible(true);
		 * 
		 * startButton.addActionListener(event -> {
		 */
		// was doing some thread testing lock.wait will make the view thread wait, but I
		// still have to figure out how to start the model's thread

		// synchronized(lock) {
		// try {
		/*
		 * try { queue.put(new NewGameMessage());// Add to queue
		 * 
		 * printMessageQueue(); } catch (InterruptedException e1) {
		 * e1.printStackTrace(); } // lock.wait();
		 * 
		 * // } catch (InterruptedException e) { // TODO Auto-generated catch block //
		 * e.printStackTrace(); // } // } // start a new frame for the pick color screen
		 * frame.dispose();
		 * 
		 * playerScreen();
		 * 
		 * });
		 */

		playerScreen();
	}

	/**
	 * The method that displays the Player screen which lets the player to choose
	 * the color.
	 */
	public void playerScreen() {
		JFrame playerScreen = new JFrame("Player Screen");
		playerScreen.setSize(400, 300);
		playerScreen.setBackground(Color.black);
		playerScreen.setVisible(true);

		JLabel background = new JLabel(new ImageIcon("resources/background.png"));
		// Icon background = new ImageIcon("/resources/background.png");

		background.setLayout(new FlowLayout());

		// textField asking the player to choose a color
		JTextField chooseColor = new JTextField("PLEASE CHOOSE A COLOR");
		chooseColor.setPreferredSize(new Dimension(300, 75));
		Font font1 = new Font("SansSerif", Font.ITALIC, 20);
		chooseColor.setBackground(Color.white);

		// Buttons are in the shape of pawns that are black and white
		// Button for rules for anyone unfamiliar
		Icon whitePawn = new ImageIcon(getClass().getResource("/resources/whitePawn.png"));
		Icon blackPawn = new ImageIcon(getClass().getResource("/resources/blackPawn.png"));
		JButton white = new JButton(whitePawn);
		JButton black = new JButton(blackPawn);
		JButton rules = new JButton("Rules");
		

		// adding everything
		background.add(white);
		background.add(black);
		background.add(rules);

		chooseColor.setFont(font1);
		chooseColor.setEditable(false);

		background.add(chooseColor);
		playerScreen.add(background);
		playerScreen.setVisible(true);

		/**
		 * The actionListener for selecting the white color
		 */
		white.addActionListener(event2 -> {
			queue.add(new PlayerChosenMessage("White"));
			playerScreen.dispose();
			// JFrame frame = new ChessBoard(queue);
			// frame = setIdealFrame(frame);
			chessBoardFrame = (ChessBoard) setIdealFrame(chessBoardFrame);

		});

		/**
		 * The actionListener for selecting the black color
		 */
		black.addActionListener(event3 -> {
			queue.add(new PlayerChosenMessage("Black"));
			playerScreen.dispose();
			// JFrame frame = new ChessBoard(queue);
			// frame = setIdealFrame(frame);
			chessBoardFrame = (ChessBoard) setIdealFrame(chessBoardFrame);
		});
		
		
		//Action listener for the rules screen 
		rules.addActionListener(event3 -> {
			JFrame rulesScreen = new JFrame();
			rulesScreen.setSize(1000, 400);
			
			
			JTextArea rule = new JTextArea();
			rule.append("Hello users. This is our chess game. Some important rules to remember in chess. \n"
					+ "Players pick sides. White goes first. \n"
					+ "Goal of the game is to take players pieces and checkmating the king. \n "
					+ "Checking the king means putting him in the position where you can take the piece.\n "
					+ "Checkmating means no further movements can be made to opponenent's king, thus stopping from making any further movements \n"
					+ "\n"
					+ "Pieces and their movements: \n"
					+ "1. Pawn: There are 8 pawns on the board. On the first turn they can be moven twice up, but afterwards can only take 1. \n  They can ONLY cut diagonally in one tile move \n"
					+ "2. King: The main piece. Can only move 1 tile but in any direction. Must move when checked or if checkmated, game is over. \n"
					+ "3. Queen: Can make a move in any direction with as much tiles as it wants. \n"
					+ "4. Rook: The castle looking piece. Can make a move in any horizontal or vertical direction with no limits on tiles. \n"
					+ "5. Knight: Horse piece. Can only move in any L-direction, taking 2 tiles in the vertical direction and 1 tile in the horizontal. \n"
					+ "6. Bishop: This piece can make a move in the diagonal direction with no limits on tiles. \n"
					+ "\n"
					+ "NOTE: To move the pieces please click and drag, then release on the tile you want. \n"
					+ "You cannot jump over pieces unless you are a knight. \n"
					+ "\n"
					+ "Finally the game is a work in progress so there may be bugs in the game that may have gone unnoticed. \n"
					+ "Chess itself is a very complex game, so there are many edge cases on the bugs that have to be handled. \n"
					+ "If a bug goes unnoticed, please contact me at neevalkumar@gmail.com. Thank you.");
			rule.setEditable(false);
			rulesScreen.add(rule);
			
			rulesScreen.setVisible(true);
		});

	}

	/**
	 * The method that creates all the GUI components of our Game and
	 * 
	 * @param frame The frame containing all the GUI of our game
	 * @return The frame with all the buttons and the ChessBoard with all the
	 *         pieces.
	 */
	public JFrame setIdealFrame(JFrame frame) {
		frame.setSize(600, 750);
		JPanel bottomPanel = new JPanel();
		bottomPanel.setLayout(new FlowLayout());

		// Creating the newGame button
		JButton newGame = new JButton("NEW GAME");
		newGame.setPreferredSize(new Dimension(200, 50));
		newGame.setBackground(Color.cyan);

		// Creating the quitGame button
		JButton quitGame = new JButton("QUIT GAME");
		quitGame.setPreferredSize(new Dimension(100, 50));
		quitGame.setBackground(Color.pink);

		textArea = new JTextArea();
		textArea.setEditable(false);
		JScrollPane scrollpane = new JScrollPane(textArea);
		scrollpane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollpane.setPreferredSize(new Dimension(200, 75));
		bottomPanel.add(scrollpane);

		// newGame button functionality
		newGame.addActionListener(newGameRecurs -> {
			frame.dispose();
			this.playerScreen();
			
		});

		// quitGame button functionality
		quitGame.addActionListener(exit -> {
			try {
				queue.put(new EndGameMessage()); // Add to queue
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			frame.dispose();
			System.exit(1);
		});

		bottomPanel.add(newGame);
		bottomPanel.add(quitGame);
		bottomPanel.setBackground(Color.black);
		frame.add(bottomPanel, BorderLayout.SOUTH);
		frame.setResizable(true);

		frame.setVisible(true);

		return frame;

	}


	JLayeredPane pane;
	JPanel chessBoard;
	JLabel chessPiece;
	int x;
	int y;

	int currentPosition;
	int endPosition;

	/**
	 * Method to change the pieces when a piece is pressed.
	 * 
	 * @param e MouseEvent
	 */
	public void mousePressed(MouseEvent e) {
		// keep chess piece null, so we can store to drop later when we mouse press
		chessPiece = null;

		// get component on chessBoard at point clicked
		Component pieceImage = chessBoard.findComponentAt(e.getX(), e.getY());

		// if person clicks empty tile, just return so they can choose a piece instead
		if (pieceImage instanceof JPanel)
			return;

		// store the chessPiece in a chessPiece and sets the location image from the
		// mouse pointer

		chessPiece = (JLabel) pieceImage;
		chessPiece.setLocation(e.getX() - 25, e.getY() - 25);
		chessPiece.setSize(chessPiece.getWidth(), chessPiece.getHeight());
		pane.add(chessPiece, JLayeredPane.DRAG_LAYER);
		currentPosition = (e.getX() / 75) + (8 * (e.getY() / 75));

	}

	/**
	 * This method changes the position of the piece when the piece is dragged the
	 * chess piece around.
	 * 
	 * @param e The MouseEvent
	 */

	public void mouseDragged(MouseEvent e) {
		if (chessPiece == null)
			return;
		chessPiece.setLocation(e.getX() - 25, e.getY() - 25);

	}

	/**
	 * This method changes the position of the piece when the piece is dragged and
	 * dropped back onto the chess board.
	 * 
	 * @param e The MouseEvent
	 */
	public void mouseReleased(MouseEvent e) {
		// if no chessPiece initialized means nothing was mouse pressed
		if (chessPiece == null)

			return;

		else {

			chessPiece.setVisible(false);
			endPosition = (e.getX() / 75) + (8 * (e.getY() / 75));

			System.out.println(currentPosition + " " + endPosition);
			Component pieceImage = chessBoard.findComponentAt(e.getX(), e.getY());

			if (pieceImage instanceof JLabel) {

				try {
					MoveMessage message = new MoveMessage(currentPosition, endPosition);
					queue.put(message);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				if (canMove == true) {
					Container tile = pieceImage.getParent(); // gets the parent component of the piece which is the tile
					tile.remove(0); // removes whichever piece was already there
					tile.add(chessPiece);
					updateBoard();
				} else {
					Container tile = (Container) pieceImage;// if the tile is already empty, just add as a component
					tile.add(chessPiece);
					updateBoard();
				}
			}

			chessPiece.setVisible(true);
		}

	}

	/**
	 * The unused mouseClicked method
	 * 
	 * @param e The mouseEvent
	 */

	public void mouseClicked(MouseEvent e) {

	}

	/**
	 * The unused mouseClicked method
	 * 
	 * @param e The mouseEvent
	 */
	public void mouseMoved(MouseEvent e) {
	}

	/**
	 * The unused mouseEntered method
	 * 
	 * @param e The mouseEvent
	 */
	public void mouseEntered(MouseEvent e) {

	}

	/**
	 * The unused mouseExited method
	 * 
	 * @param e The mouseEvent
	 */
	public void mouseExited(MouseEvent e) {

	}

	/**
	 * Method to print the message from the MessageQueue or throws an exception
	 */
	public void printMessageQueue() {
		try {
			System.out.println(queue.take());

		} catch (InterruptedException e) {

		}
	}

	/**
	 * Method to update the board after the pieces are moved.
	 */
	public void updateBoard() {
		pane.removeAll();
		pane.add(chessBoard, JLayeredPane.DEFAULT_LAYER);
	}

	/**
	 * Method to return the tile with the piece on it.
	 * 
	 * @param position The position of the piece
	 * @return The tile with piece on it.
	 */
	public JPanel getTileAt(int position) {
		return (JPanel) chessBoard.getComponent(position);
	}

	/**
	 * This method moves the pieces after determining a piece can be moved or not.
	 * 
	 * @param canMove The boolean value to determine the validity of the move.
	 */
	public void canmovePiece(boolean canMove) {
		this.canMove = canMove;
		chessBoardFrame.updateChessBoardFrame(canMove);
	}

	/**
	 * THis method gets the queue with the messages in it.
	 * 
	 * @return The BlockingQueue
	 */
	public BlockingQueue<Message> getQueue(BlockingQueue<Message> queue) {
		return queue;
	}

	/**
	 * THis method returns the chessBoard
	 * 
	 * @return ChessBoard
	 */
	public JPanel getChessBoard() {
		return chessBoard;
	}

	/**
	 * This method returns the chessPiece
	 * 
	 * @return ChessPiece
	 */
	public JLabel getChessPiece() {
		return chessPiece;
	}

	/**
	 * This method returns the message queue
	 * 
	 * @return The blocking queue
	 */
	public BlockingQueue<Message> getQueue() {
		return queue;
	}

	/**
	 * This method sets the game info
	 * 
	 * @param message The message of the queue
	 */
	public void setGameInfo(String message) {
		gameInfo.add(message);
	}

	/**
	 * This method prints the game info
	 */
	public void printGameInfo() {
		for (String s : gameInfo) {
			textArea.append(" \n" + s);
			gameInfo.remove(0);
		}
	}
	
	

}
