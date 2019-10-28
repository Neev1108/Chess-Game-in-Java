package Model;

public class Moves {
public Tile currentPos;
public Tile endPos;
public Player player;
public Piece pieceMoved;
public Piece destinationPiece;

public Moves(Player player, Tile currentPos, Tile endPos) {
	this.player = player;
	this.currentPos = currentPos;
	this.endPos = endPos;
	pieceMoved = currentPos.getPiece();
	destinationPiece = endPos.getPiece();
}

public Tile getEndPos() {
	return endPos;
}

public Player getPlayer() {
	return player;
}

public Piece getPieceMoved() {
	return pieceMoved;
}

public Tile getCurrentPos() {
	return currentPos;
}

public Piece getDestinationPiece() {
	return destinationPiece;
}



}

