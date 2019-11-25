package edu.sjsu.cs151.model;


public class Tile {
	private Piece piece; //the piece that occupies the tile
	//row and col coordinates of the tile
	private int row; 
	private int col;
	private boolean isOccupied;
	
	//Constructor to initialize coordinates and piece
	public Tile(int row, int col, Piece piece) {
		this.piece = piece;
		this.row = row;
		this.col = col;
		if (piece == null)
		{
			isOccupied = false;
		}
		else
		{
			isOccupied = true;
		}
	}
	
	
	//getter and setter methods for our instance fields
	public Piece getPiece() { 
	    return this.piece; 
	} 
	public void setPiece(Piece piece) { //replaces the piece on the tile by the new piece
		this.piece = piece ;
	}
	
	public int getRow() { 
	    return this.row; 
	} 
	  
	public void setX(int row) { 
	    this.row = row; 
    } 
	  
	public int getCol() { 
	    return this.col; 
	} 
	  
	public void setCol(int col) { 
	    this.col = col; 
	} 
	
	public boolean getIsOccupied()
	{
		return isOccupied;
	}
	
	public void setIsOccupied(boolean b)
	{
		isOccupied = b;
	}
}