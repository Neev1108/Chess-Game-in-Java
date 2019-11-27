package edu.sjsu.cs151.view;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
 
public class ChessBoard extends JFrame implements MouseListener, MouseMotionListener {
	JLayeredPane pane;
	JPanel chessBoard;
	JLabel chessPiece;
	int x;
	int y;
	final Dimension BOARD_SIZE = new Dimension(600,600);
	
	public ChessBoard() {
		pane = new JLayeredPane();
		  getContentPane().add(pane);
		  pane.setPreferredSize(BOARD_SIZE);
		  pane.addMouseListener(this);
		  pane.addMouseMotionListener(this);
		
		  chessBoard = new JPanel();
		  pane.add(chessBoard, JLayeredPane.DEFAULT_LAYER);
		  chessBoard.setLayout(new GridLayout(8, 8));
		  chessBoard.setPreferredSize(BOARD_SIZE);
		  chessBoard.setBounds(0, 0, BOARD_SIZE.width, BOARD_SIZE.height);
		  
		  for (int i = 0; i < 64; i++) {
			  JPanel tile = new JPanel(new BorderLayout());
			  chessBoard.add(tile);
			 
			  int row = (i / 8) % 2;
			  
			  if (row == 0) 
			  tile.setBackground( i % 2 == 0 ? Color.GRAY : Color.orange );
			  else 
			  tile.setBackground( i % 2 == 0 ? Color.orange : Color.GRAY );
		  }
		  
		  JLabel blackRook = new JLabel( new ImageIcon("blackRook.png") );
		  JPanel panel = (JPanel)chessBoard.getComponent(0);
		  panel.add(blackRook);
		  
		  JLabel blackKnight = new JLabel( new ImageIcon("blackKnight.png") );
		  JPanel panel2 = (JPanel)chessBoard.getComponent(1);
		  panel2.add(blackKnight);
		  
		  JLabel blackBishop = new JLabel( new ImageIcon("blackBishop.png") );
		  JPanel panel3 = (JPanel)chessBoard.getComponent(2);
		  panel3.add(blackBishop);
		  
		  JLabel blackKing = new JLabel( new ImageIcon("blackKing.png") );
		  JPanel panel4 = (JPanel)chessBoard.getComponent(3);
		  panel4.add(blackKing);
		  
		  JLabel blackQueen = new JLabel( new ImageIcon("blackQueen.png") );
		  JPanel panel5 = (JPanel)chessBoard.getComponent(4);
		  panel5.add(blackQueen);
		  
		  JLabel blackBishop2 = new JLabel( new ImageIcon("blackBishop.png") );
		  JPanel panel6 = (JPanel)chessBoard.getComponent(5);
		  panel6.add(blackBishop2);
		  
		  JLabel blackKnight2 = new JLabel( new ImageIcon("blackKnight.png") );
		  JPanel panel7 = (JPanel)chessBoard.getComponent(6);
		  panel7.add(blackKnight2);
		  
		  JLabel blackRook2 = new JLabel( new ImageIcon("blackRook.png") );
		  JPanel panel8 = (JPanel)chessBoard.getComponent(7);
		  panel8.add(blackRook2);
		  
		  for(int i = 8; i < 16; i++) {
			  JLabel blackPawn = new JLabel( new ImageIcon("blackPawn.png") );
			  JPanel panels = (JPanel)chessBoard.getComponent(i);
			  panels.add(blackPawn);
		  }
		  
		  for(int i= 48; i< 56; i++) {
		  JLabel whitePawn = new JLabel( new ImageIcon("whitePawn.png") );
		  JPanel panels2 = (JPanel)chessBoard.getComponent(i);
		  panels2.add(whitePawn);
		  }  
		  
		  JLabel whiteRook = new JLabel( new ImageIcon("whiteRook.png") );
		  JPanel panel56 = (JPanel)chessBoard.getComponent(56);
		  panel56.add(whiteRook);
		  
		  JLabel whiteKnight = new JLabel( new ImageIcon("whiteKnight.png") );
		  JPanel panel57 = (JPanel)chessBoard.getComponent(57);
		  panel57.add(whiteKnight);
		  
		  JLabel whiteBishop = new JLabel( new ImageIcon("whiteBishop.png") );
		  JPanel panel58 = (JPanel)chessBoard.getComponent(58);
		  panel58.add(whiteBishop);
		  
		  JLabel whiteKing = new JLabel( new ImageIcon("whiteKing.png") );
		  JPanel panel59 = (JPanel)chessBoard.getComponent(59);
		  panel59.add(whiteKing);
		  
		  JLabel whiteQueen = new JLabel( new ImageIcon("whiteQueen.png") );
		  JPanel panel60 = (JPanel)chessBoard.getComponent(60);
		  panel60.add(whiteQueen);
		  
		  JLabel whiteBishop2 = new JLabel( new ImageIcon("whiteBishop.png") );
		  JPanel panel61 = (JPanel)chessBoard.getComponent(61);
		  panel61.add(whiteBishop2);
		  
		  JLabel whiteKnight2 = new JLabel( new ImageIcon("whiteKnight.png") );
		  JPanel panel62 = (JPanel)chessBoard.getComponent(62);
		  panel62.add(whiteKnight2);
		  
		  JLabel whiteRook2 = new JLabel( new ImageIcon("whiteRook.png") );
		  JPanel panel63 = (JPanel)chessBoard.getComponent(63);
		  panel63.add(whiteRook2);
		  
		  
	}
		  
		
		  public void mousePressed(MouseEvent e){
			  //keep chess piece null
			  chessPiece = null;
			  
			  //get component on chessBoard at point clicked
			  Component comp =  chessBoard.findComponentAt(e.getX(), e.getY());
			 
			  //if person clicks empty tile, just return so they can pick a different tile
			  if (comp instanceof JPanel) 
			  return;
			 
			  //store location in x and y
			  Point parentLocation = comp.getParent().getLocation();
			  x = parentLocation.x - e.getX();
			  y = parentLocation.y - e.getY();
			  
			  //store the chessPiece in a chessPiece
			  chessPiece = (JLabel)comp;
			  chessPiece.setLocation(e.getX() + x, e.getY() + y);
			  chessPiece.setSize(chessPiece.getWidth(), chessPiece.getHeight());
			  pane.add(chessPiece, JLayeredPane.DRAG_LAYER);
			  }
			 
			  //drag the chess piece around
			  
			  public void mouseDragged(MouseEvent me) {
			  if (chessPiece == null) return;
			 chessPiece.setLocation(me.getX() + x, me.getY() + y);
			 }
			 
			  //Drop the chess piece back onto the chess board
			 
			  public void mouseReleased(MouseEvent e) {
				  //if no chessPiece initialized means nothing was mouse pressed
			  if(chessPiece == null) return;
			 
			  chessPiece.setVisible(false);
			  Component c =  chessBoard.findComponentAt(e.getX(), e.getY());
			 
			  if (c instanceof JLabel){
			  Container parent = c.getParent();
			  parent.remove(0);
			  parent.add( chessPiece );
			  }
			  else {
			  Container parent = (Container)c;
			  parent.add( chessPiece );
			  }
			 
			  chessPiece.setVisible(true);
			  }
			 
			  public void mouseClicked(MouseEvent e) {
			  
			  }
			  public void mouseMoved(MouseEvent e) {
			 }
			  public void mouseEntered(MouseEvent e){
			  
			  }
			  public void mouseExited(MouseEvent e) {
			  
			  }
	
}
