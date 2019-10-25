package Package;

public class Moves {
public int x;
public int y;

public Moves(int x, int y) {
	this.x = x;
	this.y= y;
}

public String getMove() {
	return "(" + x + "," + y + ")";
}
}
