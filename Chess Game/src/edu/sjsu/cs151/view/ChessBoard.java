package edu.sjsu.cs151.view;

import java.awt.*;
import java.awt.event.*;
import java.util.concurrent.BlockingQueue;

import javax.swing.*;

import edu.sjsu.cs151.controller.Message;
import edu.sjsu.cs151.controller.MoveMessage;

public class ChessBoard extends JFrame implements MouseListener, MouseMotionListener {

	private static final long serialVersionUID = 1L;
	/**
	 * Pane field so we can get implement mousePressed and mouse dragged, and mouse
	 * released ChessBoard will be a JPanel JLabel for each chessPiece so we can
	 * input ImageIcon x and y will hold the previous locations for mouseClicked
	 */
	JLayeredPane pane;
	JPanel chessBoard;
	JLabel chessPiece;
	int x;
	int y;
	BlockingQueue<Message> queue;

	int currentPosition;
	int endPosition;
	Container endTile;
	Container startTile;
	Component pieceImage;
	Component pieceImage2;

	// Board size dimensions
	final Dimension BOARD_SIZE = new Dimension(600, 600);

	/**
	 * The constructor of the ChessBoard which places the images of the pieces on
	 * the board.
	 * 
	 * @param queue The queue for the messages
	 */
	public ChessBoard(BlockingQueue<Message> queue) {

		// adding the pane with the mouse listeners
		this.queue = queue;
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
		JLabel blackRook = new JLabel(new ImageIcon(getClass().getResource("/resources/blackRook.png")));
		JPanel panel = (JPanel) chessBoard.getComponent(0);
		panel.add(blackRook);

		JLabel blackKnight = new JLabel(new ImageIcon(getClass().getResource("/resources/blackKnight.png")));
		JPanel panel2 = (JPanel) chessBoard.getComponent(1);
		panel2.add(blackKnight);

		JLabel blackBishop = new JLabel(new ImageIcon(getClass().getResource("/resources/blackBishop.png")));
		JPanel panel3 = (JPanel) chessBoard.getComponent(2);
		panel3.add(blackBishop);

		JLabel blackKing = new JLabel(new ImageIcon(getClass().getResource("/resources/blackKing.png")));
		JPanel panel4 = (JPanel) chessBoard.getComponent(3);
		panel4.add(blackKing);

		JLabel blackQueen = new JLabel(new ImageIcon(getClass().getResource("/resources/blackQueen.png")));
		JPanel panel5 = (JPanel) chessBoard.getComponent(4);
		panel5.add(blackQueen);

		JLabel blackBishop2 = new JLabel(new ImageIcon(getClass().getResource("/resources/blackBishop.png")));
		JPanel panel6 = (JPanel) chessBoard.getComponent(5);
		panel6.add(blackBishop2);

		JLabel blackKnight2 = new JLabel(new ImageIcon(getClass().getResource("/resources/blackKnight.png")));
		JPanel panel7 = (JPanel) chessBoard.getComponent(6);
		panel7.add(blackKnight2);

		JLabel blackRook2 = new JLabel(new ImageIcon(getClass().getResource("/resources/blackRook.png")));
		JPanel panel8 = (JPanel) chessBoard.getComponent(7);
		panel8.add(blackRook2);

		for (int i = 8; i < 16; i++) {
			JLabel blackPawn = new JLabel(new ImageIcon(getClass().getResource("/resources/blackPawn.png")));
			JPanel panels = (JPanel) chessBoard.getComponent(i);
			panels.add(blackPawn);
		}

		// adds white pieces
		for (int i = 48; i < 56; i++) {
			JLabel whitePawn = new JLabel(new ImageIcon(getClass().getResource("/resources/whitePawn.png")));
			JPanel panels2 = (JPanel) chessBoard.getComponent(i);
			panels2.add(whitePawn);
		}

		JLabel whiteRook = new JLabel(new ImageIcon(getClass().getResource("/resources/whiteRook.png")));
		JPanel panel56 = (JPanel) chessBoard.getComponent(56);
		panel56.add(whiteRook);

		JLabel whiteKnight = new JLabel(new ImageIcon(getClass().getResource("/resources/whiteKnight.png")));
		JPanel panel57 = (JPanel) chessBoard.getComponent(57);
		panel57.add(whiteKnight);

		JLabel whiteBishop = new JLabel(new ImageIcon(getClass().getResource("/resources/whiteBishop.png")));
		JPanel panel58 = (JPanel) chessBoard.getComponent(58);
		panel58.add(whiteBishop);

		JLabel whiteKing = new JLabel(new ImageIcon(getClass().getResource("/resources/whiteKing.png")));
		JPanel panel59 = (JPanel) chessBoard.getComponent(59);
		panel59.add(whiteKing);

		JLabel whiteQueen = new JLabel(new ImageIcon(getClass().getResource("/resources/whiteQueen.png")));
		JPanel panel60 = (JPanel) chessBoard.getComponent(60);
		panel60.add(whiteQueen);

		JLabel whiteBishop2 = new JLabel(new ImageIcon(getClass().getResource("/resources/whiteBishop.png")));
		JPanel panel61 = (JPanel) chessBoard.getComponent(61);
		panel61.add(whiteBishop2);

		JLabel whiteKnight2 = new JLabel(new ImageIcon(getClass().getResource("/resources/whiteKnight.png")));
		JPanel panel62 = (JPanel) chessBoard.getComponent(62);
		panel62.add(whiteKnight2);

		JLabel whiteRook2 = new JLabel(new ImageIcon(getClass().getResource("/resources/whiteRook.png")));
		JPanel panel63 = (JPanel) chessBoard.getComponent(63);
		panel63.add(whiteRook2);

	}

	/**
	 * Method to change the pieces when a piece is pressed.
	 * 
	 * @param e MouseEvent
	 */
	public void mousePressed(MouseEvent e) {
		// keep chess piece null, so we can store to drop later when we mouse press
		chessPiece = null;

		// get component on chessBoard at point clicked
		pieceImage = chessBoard.findComponentAt(e.getX(), e.getY());

		// System.out.println("pieceImage " + pieceImage);
		// System.out.println("MousePressed: e.getX " + e.getX() + " e.getY " +
		// e.getY());

		startTile = pieceImage.getParent();
		// System.out.println("startTile " + startTile);
		// if person clicks empty tile, just return so they can choose a piece instead
		if (pieceImage instanceof JPanel)
			return;

		// store the pieceImage in a chessPiece and sets the location image from the
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
		// System.out.println("MouseDragged: e.getX " + e.getX() + " e.getY " +
		// e.getY());

	}

	/**
	 * This method changes the position of the piece when the piece is dragged and
	 * dropped back onto the chess board.
	 * 
	 * @param e The MouseEvent
	 */
	public void mouseReleased(MouseEvent e) {
		// if no chessPiece initialized means nothing was mouse pressed
		if (chessPiece == null) {
			return;
		}

		endPosition = (e.getX() / 75) + (8 * (e.getY() / 75));

		pieceImage2 = chessBoard.findComponentAt(e.getX(), e.getY());

		String pI2 = pieceImage2.toString();
		String substring = pI2.substring(0, 18);
		int i = substring.compareTo("javax.swing.JPanel");
		if (i == 0) {
			endTile = (Container) pieceImage2;
		} else {
			endTile = pieceImage2.getParent();
		}

		try {
			MoveMessage message = new MoveMessage(currentPosition, endPosition);
			queue.put(message);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
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
	 * The unused mouseMoved method
	 * 
	 * @param e The mouseEvent
	 */

	public void mouseMoved(MouseEvent e) {
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
	 * Method to return the tile with the piece on it.
	 * 
	 * @param currentPosition The start position of the piece
	 * @param endPosition The end position of the piece
	 */
	public void movePiece(int currentPosition, int endPosition) {
		getTileAt(currentPosition).add(chessPiece);
		getTileAt(endPosition).remove(0);
	}

	/**
	 * THis method gets the queue with the messages in it.
	 * @param queue The empty blocking queue
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
	 * Method for updating the ChessBoard
	 * 
	 * @param canMove Boolean value to check if the move is valid or not
	 */
	public void updateChessBoardFrame(boolean canMove) {
		if (canMove) {
			Container tile = pieceImage.getParent(); // gets the parent component of the piece, which is the tile
			tile.add(chessPiece);
			endTile.removeAll();
			endTile.add(chessPiece);
			chessPiece.setVisible(true);
			updateBoard();
		} else {
			startTile.add(chessPiece);
			chessPiece.setVisible(true);
			updateBoard();
		}
	}

}
