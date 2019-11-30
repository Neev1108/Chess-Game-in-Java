package edu.sjsu.cs151.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.locks.ReentrantLock;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.Timer;

import edu.sjsu.cs151.controller.Message;
import edu.sjsu.cs151.model.*;
import edu.sjsu.cs151.view.*;
import edu.sjsu.cs151.controller.*;

import java.awt.event.*;
/**
 * This program creates a simple moving animation
 * 
 * @author Sehajmeet and Neeval
 *
 */
public class View implements Runnable {
	
	public static BlockingQueue<Message> queue;
	private static final int ICON_WIDTH = 400;
	private static final int ICON_HEIGHT = 100;
	private static final int PAWN_WIDTH = 100;
	ReentrantLock lock;
	

	public View(BlockingQueue<Message> queue2, ReentrantLock lock) {
		this.lock = lock;
		this.queue = queue2;
	}

	public void run() {
		/**
		 * Creating a JFrame of size 2000 x 2000
		 */

		JFrame frame = new JFrame();
		frame.setSize(1000, 500);

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
		JLabel backg = new JLabel(new ImageIcon("background.png"));
		backg.setLayout(new FlowLayout());
		JPanel pnl = new JPanel();
		
		backg.add(pnl);
		pnl.add(startButton);
		frame.add(backg);
		frame.setVisible(true);


		startButton.addActionListener(event -> {
			
			// was doing some thread testing lock.wait will make the view thread wait, but I still have to figure out how to start the model's thread
			
			//synchronized(lock) {
			//try {
				NewGameMessage newGame = new NewGameMessage();
				queue.add(newGame);
				//lock.wait();
				
			//} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
			//}
			//}
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

		
		JLabel background = new JLabel(new ImageIcon("background.png"));
		background.setLayout(new FlowLayout());

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
		background.add(white);
		background.add(black);

		chooseColor.setFont(font1);
		chooseColor.setEditable(false);

		background.add(chooseColor);
		playerScreen.add(background);
		playerScreen.setVisible(true);

		/**
		 * The actionListener for selecting the white color
		 */
		white.addActionListener(event2 -> {
			queue.add(new PlayerChosenMessage("White", true));
			playerScreen.dispose();
			JFrame frame = new ChessBoard();
			  frame = setIdealFrame(frame);
			  
		});
		
		/**
		 * The actionListener for selecting the black color
		 */
		black.addActionListener(event3 -> {
			queue.add(new PlayerChosenMessage("Black", false));
			playerScreen.dispose();
			JFrame frame = new ChessBoard();
			  frame = setIdealFrame(frame);
		});

	}
	
	
	public static JFrame setIdealFrame(JFrame frame) {
		frame.setSize(600, 750);
		JPanel bottomPanel = new JPanel();
		bottomPanel.setLayout(new FlowLayout());
		
		//Creating the newGame button
		JButton newGame = new JButton("NEW GAME");
		newGame.setPreferredSize(new Dimension(200,50 ));
		newGame.setBackground(Color.cyan);

		//Creating the quitGame button
		JButton quitGame = new JButton("QUIT GAME");
		quitGame.setPreferredSize(new Dimension(100, 50));
		newGame.setBackground(Color.pink);
		
		JTextArea textArea = new JTextArea("Welcome to our chess game!");
		textArea.setEditable(false);
		JScrollPane scrollpane = new JScrollPane(textArea);
		scrollpane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollpane.setPreferredSize(new Dimension(200,75));
		bottomPanel.add(scrollpane);
		
		//newGame button functionality
		newGame.addActionListener(newGameRecurs -> {
			frame.dispose();

			View.playerScreen();;
		});
		
		//quitGame button functionality
		quitGame.addActionListener(exit -> {
			NewGameMessage QuitGame = new NewGameMessage();
			queue.add(QuitGame);
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
	
	public static View init(BlockingQueue<Message> queue, ReentrantLock lock) {
		View view = new View(queue, lock);
		return view;
		
	}
	
	public BlockingQueue<Message> getQueue() {
		return this.queue;
	}

	

}
