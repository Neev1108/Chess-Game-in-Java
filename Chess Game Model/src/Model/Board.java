package Model;

public class Board {

	//an empty board instance field
	private final Tile[][] board;

	//makes board equal to an new 8 by 8 array of tiles
	public Board() {
		this.board = new Tile[8][8];
		createNewBoard();

	}

	public Tile[][] getBoard() {
		return board;
	}

	public Tile getTile(int x, int y) {
		return board[x][y];
	}


	//initializes the board array with the pieces, every other empty space is set as null
	public void createNewBoard() {

		//sets black player pieces
		for(int i = 0; i < 8; i++){
			board[1][i] = new Tile( 1, i , new Pawn(false));
		}
		board[0][4] = new Tile(0,4, new King(false));
		board[0][3] = new Tile(0,3, new Queen(false));
		board[0][0] = new Tile(0,0, new Rook(false));
		board[0][7] = new Tile(0,7, new Rook(false));
		board[0][1] = new Tile(0,1, new Knight(false));
		board[0][6] = new Tile(0,6, new Knight(false));
		board[0][2] = new Tile(0,2, new Bishop(false));
		board[0][5] = new Tile(0,5, new Bishop(false));


		// sets white player pieces
		for (int i=0; i < 8; i++) {
			board[6][i] = new Tile(6, i, new Pawn(true));
		}

		board[7][4] = new Tile(7,4, new King(true));
		board[7][3] = new Tile(7,3, new Queen(true));
		board[7][0] = new Tile(7,0, new Rook(true));
		board[7][7] = new Tile(7,7, new Rook(true));
		board[7][1] = new Tile(7,1, new Knight(true));
		board[7][6] = new Tile(7,6, new Knight(true));
		board[7][2] = new Tile(7,2, new Bishop(true));
		board[7][5] = new Tile(7,5, new Bishop(true));


		//sets everything else null
		for(int i = 2; i < 6; i++){
			for(int j = 0; j < 8; j++) {
				board[i][j] = new Tile(i, j, null);
			}
		}


	}
}

