package Model;

public class Board {
		private final Tile[][] board;
		
		public Board() {
			this.board = new Tile[8][8];
			createNewBoard();
			
		}
		
		public void createNewBoard() {
			
			//sets black player pieces
			for(int i = 0; i < 8; i++){
		        board[1][i].setPiece(new Pawn(Piece.PieceColor.Black));
		        }
	        board[0][4].setPiece(new King(Piece.PieceColor.Black));
	        board[0][3].setPiece(new Queen(Piece.PieceColor.Black));
			board[0][0].setPiece(new Rook(Piece.PieceColor.Black));
		    board[0][7].setPiece(new Rook(Piece.PieceColor.Black));
		    board[0][1].setPiece(new Knight(Piece.PieceColor.Black));
		    board[0][6].setPiece(new Knight(Piece.PieceColor.Black));
		    board[0][2].setPiece(new Bishop(Piece.PieceColor.Black));
		    board[0][5].setPiece(new Bishop(Piece.PieceColor.Black));
		     
		     
		    // sets white player pieces
		    for (int i=0; i < 8; i++) {
		    	board[6][i].setPiece(new Pawn(Piece.PieceColor.White));
		    }
		    
		     board[7][4].setPiece(new King(Piece.PieceColor.White));
		     board[7][3].setPiece(new Queen(Piece.PieceColor.White));
		     board[7][0].setPiece(new Rook(Piece.PieceColor.White));
			 board[7][7].setPiece(new Rook(Piece.PieceColor.White));
			 board[7][1].setPiece(new Knight(Piece.PieceColor.White));
			 board[7][6].setPiece(new Knight(Piece.PieceColor.White));
			 board[7][2].setPiece(new Bishop(Piece.PieceColor.White));
		     board[7][5].setPiece(new Bishop(Piece.PieceColor.White));
		     
		     
		     //sets colors for tiles
		     for(int i = 0; i < 8; i++){
		            for(int j = 0; j < 8; j++) {
		      
		                if ((i + j) % 2 == 0)
		                	board[i][j] = new Tile(Tile.tileColor.White);
		                else
		                	board[i][j] = new Tile(Tile.tileColor.Black);
		            }
		        }
		     
		   
		}
		
		public void printBoard() {
			for(int i = 0; i < 8; i++){
	            for(int j = 0; j < 8; j++) {
	            	if (board[i][j] == null) {
	            		System.out.println(" - ");
	            	}
	            	else {
	            	System.out.print(board[i][j].getPiece().getPieceName().charAt(0));
	            }
		}
	}
		}
	}

