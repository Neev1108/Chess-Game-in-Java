package Model;


public class Tile {
	private Piece piece; //the piece that occupies the tile
	//x and y coordinates of the tile
	private int x; 
	private int y;
	
	//Constructor to initialize coordinates and piece
	public Tile(int x, int y, Piece piece) {
		this.piece = piece;
		this.x = x;
		this.y = y;
	}
	
	
	//getter and setter methods for our instance fields
	public Piece getPiece() { 
	    return this.piece; 
	} 
	public void setPiece(Piece piece) { //replaces the piece on the tile by the new piece
		this.piece = piece ;
	}
	
	public int getX() { 
	    return this.x; 
	} 
	  
	public void setX(int x) { 
	    this.x = x; 
    } 
	  
	public int getY() { 
	    return this.y; 
	} 
	  
	public void setY(int y) { 
	    this.y = y; 
	} 
	
	
	}
	


