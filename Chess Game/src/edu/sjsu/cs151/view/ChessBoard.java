package edu.sjsu.cs151.view;

import java.awt.*;
import java.awt.event.*;
import java.util.concurrent.BlockingQueue;

import javax.swing.*;
import edu.sjsu.cs151.controller.Message;
import edu.sjsu.cs151.controller.MoveMessage;

public class ChessBoard extends JFrame implements MouseListener, MouseMotionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/*
	 * Pane field so we can get implement mousepressed and mouse dragged, and mouse
	 * released ChessBoard will be a JPanel JLabel for each chesspiece so we can
	 * input ImageIcon x and y will hold the previous locations for mouseclicked
	 */
	JLayeredPane pane;
	JPanel chessBoard;
	JLabel chessPiece;
	int x;
	int y;
	BlockingQueue<Message> queue;
	
	int currentPosition;
	int endPosition;


	// Board size dimensions
	final Dimension BOARD_SIZE = new Dimension(600, 600);

	public ChessBoard(BlockingQueue<Message> queue) {

		// adding the pane with the mouse listeners
		pane = new JLayeredPane();
		getContentPane().add(pane);
		pane.setPreferredSize(BOARD_SIZE);
		pane.addMouseListener(this);
		pane.addMouseMotionListener(this);

		// new JPanel for chessboard
		chessBoard = new JPanel();
		pane.add(chessBoard, JLayeredPane.DEFAULT_LAYER);
		chessBoard.setLayout(new GridLayout(8, 8));
		chessBoard.setPreferredSize(BOARD_SIZE);
		chessBoard.setBounds(0, 0, BOARD_SIZE.width, BOARD_SIZE.height);

		// set colors and adds Jpanels for the tiles
		for (int i = 0; i < 64; i++) {
			JPanel tile = new JPanel(new BorderLayout());
			chessBoard.add(tile);

			int row = (i / 8) % 2;

			if (row == 0)
				tile.setBackground(i % 2 == 0 ? Color.GRAY : Color.orange);
			else
				tile.setBackground(i % 2 == 0 ? Color.orange : Color.GRAY);
		}

		// adds black pieces
		JLabel blackRook = new JLabel(new ImageIcon("blackRook.png"));
		JPanel panel = (JPanel) chessBoard.getComponent(0);
		panel.add(blackRook);

		JLabel blackKnight = new JLabel(new ImageIcon("blackKnight.png"));
		JPanel panel2 = (JPanel) chessBoard.getComponent(1);
		panel2.add(blackKnight);

		JLabel blackBishop = new JLabel(new ImageIcon("blackBishop.png"));
		JPanel panel3 = (JPanel) chessBoard.getComponent(2);
		panel3.add(blackBishop);

		JLabel blackKing = new JLabel(new ImageIcon("blackKing.png"));
		JPanel panel4 = (JPanel) chessBoard.getComponent(3);
		panel4.add(blackKing);

		JLabel blackQueen = new JLabel(new ImageIcon("blackQueen.png"));
		JPanel panel5 = (JPanel) chessBoard.getComponent(4);
		panel5.add(blackQueen);

		JLabel blackBishop2 = new JLabel(new ImageIcon("blackBishop.png"));
		JPanel panel6 = (JPanel) chessBoard.getComponent(5);
		panel6.add(blackBishop2);

		JLabel blackKnight2 = new JLabel(new ImageIcon("blackKnight.png"));
		JPanel panel7 = (JPanel) chessBoard.getComponent(6);
		panel7.add(blackKnight2);

		JLabel blackRook2 = new JLabel(new ImageIcon("blackRook.png"));
		JPanel panel8 = (JPanel) chessBoard.getComponent(7);
		panel8.add(blackRook2);

		for (int i = 8; i < 16; i++) {
			JLabel blackPawn = new JLabel(new ImageIcon("blackPawn.png"));
			JPanel panels = (JPanel) chessBoard.getComponent(i);
			panels.add(blackPawn);
		}

		// adds white pieces
		for (int i = 48; i < 56; i++) {
			JLabel whitePawn = new JLabel(new ImageIcon("whitePawn.png"));
			JPanel panels2 = (JPanel) chessBoard.getComponent(i);
			panels2.add(whitePawn);
		}

		JLabel whiteRook = new JLabel(new ImageIcon("whiteRook.png"));
		JPanel panel56 = (JPanel) chessBoard.getComponent(56);
		panel56.add(whiteRook);

		JLabel whiteKnight = new JLabel(new ImageIcon("whiteKnight.png"));
		JPanel panel57 = (JPanel) chessBoard.getComponent(57);
		panel57.add(whiteKnight);

		JLabel whiteBishop = new JLabel(new ImageIcon("whiteBishop.png"));
		JPanel panel58 = (JPanel) chessBoard.getComponent(58);
		panel58.add(whiteBishop);

		JLabel whiteKing = new JLabel(new ImageIcon("whiteKing.png"));
		JPanel panel59 = (JPanel) chessBoard.getComponent(59);
		panel59.add(whiteKing);

		JLabel whiteQueen = new JLabel(new ImageIcon("whiteQueen.png"));
		JPanel panel60 = (JPanel) chessBoard.getComponent(60);
		panel60.add(whiteQueen);

		JLabel whiteBishop2 = new JLabel(new ImageIcon("whiteBishop.png"));
		JPanel panel61 = (JPanel) chessBoard.getComponent(61);
		panel61.add(whiteBishop2);

		JLabel whiteKnight2 = new JLabel(new ImageIcon("whiteKnight.png"));
		JPanel panel62 = (JPanel) chessBoard.getComponent(62);
		panel62.add(whiteKnight2);

		JLabel whiteRook2 = new JLabel(new ImageIcon("whiteRook.png"));
		JPanel panel63 = (JPanel) chessBoard.getComponent(63);
		panel63.add(whiteRook2);

	}

	// NOTE ALL IMAGES FOR THE PIECE OR JLABELS
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
		currentPosition = (e.getX()/75) + (8 *(e.getY()/75));
		
		
	}

	// drag the chess piece around

	public void mouseDragged(MouseEvent e) {
		if (chessPiece == null)
			return;
		chessPiece.setLocation(e.getX() - 25, e.getY() - 25);

	}

	// Drop the chess piece back onto the chess board

	public void mouseReleased(MouseEvent e) {
		// if no chessPiece initialized means nothing was mouse pressed
		if (chessPiece == null)

			return;
		

		//else {

			//chessPiece.setVisible(false);
			endPosition = (e.getX()/75) + (8 * (e.getY()/75));
			
			
			System.out.println(currentPosition + " " + endPosition);
			//Component pieceImage = chessBoard.findComponentAt(e.getX(), e.getY());
			//Container jill =   pieceImage.getParent();
			//System.out.println(jill.getLocation());


			//if (pieceImage instanceof JLabel) {
				
				//Container tile = pieceImage.getParent(); // gets the parent component of the piece which is the tile
				//tile.remove(0); // removes whichever piece was already there
				// adds the piece onto the tile
				//tile.add(chessPiece);

				try {
					queue.put(new MoveMessage(currentPosition, endPosition));
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

			//else {
				//Container tile = (Container) pieceImage;// if the tile is already empty, just add as a component
				//tile.add(chessPiece);

			//}

		//}
		
		
		//chessPiece.setVisible(true);
	

	// just for interface implementation, blank methods
	public void mouseClicked(MouseEvent e) {

	}

	public void mouseMoved(MouseEvent e) {
	}

	public void mouseEntered(MouseEvent e) {

	}

	public void mouseExited(MouseEvent e) {

	}

}
