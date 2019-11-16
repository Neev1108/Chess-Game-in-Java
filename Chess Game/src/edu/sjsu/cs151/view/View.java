package edu.sjsu.cs151.view;

import java.awt.*;
import javax.swing.*;
import javax.swing.*;




	/**
	 * This program creates a simple moving animation
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
			final MoveableShape quiz = new stationaryTile(0,0,100);
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
			

			JPanel pnl = new JPanel(new GridBagLayout());

			pnl.add(startButton);
			frame.add(pnl);
			frame.setVisible(true);
			
			startButton.addActionListener(event -> {
				
				//start a new frame for the pick color screen
				frame.dispose();
				JFrame game = playerScreen();
				JPanel pn2 = new JPanel(new FlowLayout());
				
				//textField asking the player to choose a color
				JTextField chooseColor = new JTextField("PLEASE CHOOSE A COLOR");
				chooseColor.setPreferredSize(new Dimension(300,75));
				Font font1 = new Font("SansSerif", Font.BOLD, 20);
				
				//Buttons are in the shape of pawns that are black and white
				//This only works on my computer(I think?), Still need to create an image folder in the project so we cans store our images when someones runs
				Icon wPawn = new ImageIcon("C:\\Users\\Neevalk\\Downloads\\Chess_pdt60.png"); 
				Icon bPawn = new ImageIcon("C:\\\\Users\\\\Neevalk\\\\Downloads\\\\Chess_plt60.png");
				JButton white = new JButton(wPawn);
				JButton black = new JButton(bPawn);
				
				//adding everything
				pn2.add(white);
				pn2.add(black);
				
				chooseColor.setFont(font1);
				chooseColor.setEditable(false);
				
				pn2.add(chooseColor);
				game.add(pn2);
				
				
				
				/* Action listener for only 1 button. Still need to somehow implement model into this. 
				 * Need to set current player to the respective button pressed and then start game.
				 * Basically the same logic in our main game class. For now just bring both action 
				 * listeners to the same page with a startGame static method. The method should have 
				 * a parameter of the player color chosen, but for now empty parameter is fine.
				 */
				white.addActionListener(event2 ->{
					
				});
				
				
				
			});
			
			
		}
		
		
		
		
		public static JFrame playerScreen() {
			JFrame game = new JFrame("Chess Game");
			game.setSize(400,300);
			game.setVisible(true);
			return game;
		}
		
		
		
		/* This method needs to be filled out. Pretty much the chessBoard, New Game, and Exit buttons HAVE to be on here. 
		 * Priorities:
		 * 1. Chess Board
		 * 2. New Game and Exit game
		 * 
		 * Second options:
		 * 1. Graveyard of some sort
		 * 2. Message Screen
		 * 3. Undo turn button
		 * 
		public static JFrame startGameScreen() {
			JFrame game = new JFrame();
			//set size, idk a good size yet
		}
*/
	}


