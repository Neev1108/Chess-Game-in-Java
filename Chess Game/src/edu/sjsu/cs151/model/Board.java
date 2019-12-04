package edu.sjsu.cs151.model;

/**
 * Created by Sehajmeet and Neeval on 10/27/2019
 */
public class Board {

	// an empty board instance field
	private Tile[][] board;
	
	private King whiteKing;
	private King blackKing;

	private static Board obj;

	// private constructor to force use of 
	private Board() {
		this.board = new Tile [8][8];
		createNewBoard();
	}

	//Static method to get instance of board
	public static Board getInstance() {
		if (obj == null)
			obj = new Board();
		return obj;
	}

	public Tile[][] getArray(){
		return board;
	}
 

	//Method returns the board with tiles on it 
	public Tile getTile(int x, int y) {
		return board[x][y];
	}
	
	// initializes the board array with the pieces, every other empty space is set
	// as null
	public void createNewBoard() {
	
		// sets black player pieces
		for (int i = 0; i < 8; i++) {
			board[1][i] = new Tile(1, i, new Pawn(false));
			board[1][i].getPiece().setCurrentTile(board[1][i]);
		}
		board[0][4] = new Tile(0, 4, new King(false));
		board[0][4].getPiece().setCurrentTile(board[0][4]);
		board[0][3] = new Tile(0, 3, new Queen(false));
		board[0][0] = new Tile(0, 0, new Rook(false));
		board[0][7] = new Tile(0, 7, new Rook(false));
		board[0][1] = new Tile(0, 1, new Knight(false));
		board[0][6] = new Tile(0, 6, new Knight(false));
		board[0][2] = new Tile(0, 2, new Bishop(false));
		board[0][5] = new Tile(0, 5, new Bishop(false));
		
		blackKing = (King)board[0][4].getPiece();
		
		// sets white player pieces
		for (int i = 0; i < 8; i++) {
			board[6][i] = new Tile(6, i, new Pawn(true));
			board[6][i].getPiece().setCurrentTile(board[6][i]);
		}
	
		board[7][4] = new Tile(7, 4, new King(true));
		board[7][4].getPiece().setCurrentTile(board[7][4]);
		board[7][3] = new Tile(7, 3, new Queen(true));
		board[7][0] = new Tile(7, 0, new Rook(true));
		board[7][7] = new Tile(7, 7, new Rook(true));
		board[7][1] = new Tile(7, 1, new Knight(true));
		board[7][6] = new Tile(7, 6, new Knight(true));
		board[7][2] = new Tile(7, 2, new Bishop(true));
		board[7][5] = new Tile(7, 5, new Bishop(true));
	
		whiteKing = (King)board[7][4].getPiece();
		
		// sets everything else null
		for (int i = 2; i < 6; i++) {
			for (int j = 0; j < 8; j++) {
				board[i][j] = new Tile(i, j, null);
			}
		}
		
		
		
	}
	
	public King getWhiteKing()
	{
		return whiteKing;
	}
	
	public King getBlackKing()
	{
		return blackKing;
	}
	
	public void setWhiteKing(King k)
	{
		whiteKing = k;
	}
	
	public void setBlackKing(King k)
	{
		blackKing = k;
	}
	
}
