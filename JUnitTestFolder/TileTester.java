package chess;

import static org.junit.Assert.*;

import org.junit.Test;

public class TileTester {


	@Test
	public void testSetColor() {
		Tile colorOfTile = new Tile();
		colorOfTile.setColor("black");
		System.out.println("Testing....");
		assertTrue(colorOfTile.getColor().toLowerCase()  == "black" || colorOfTile.getColor().toLowerCase() == "white" );
		System.out.println("Sucess!");

	}

	@Test
	public void testSetX() {
		Tile X1 = new Tile();
		X1.setX(7);
		assert X1.getX() > 0 && X1.getX() <= 7 : "violated precondition x > 0 && x <= 7";
			
	}

	@Test
	public void testSetY() {
		Tile Y1 = new Tile();
		Y1.setY(7);
		assert Y1.getY() > 0 && Y1.getY() <= 7 : "violated precondition y > 0 && y <= 7";	
		}

	@Test
	public void testIsValid() {
		Tile coordinates = new Tile();
		boolean values = coordinates.isValid(7, 7);
		System.out.println("Testing....");
		assertTrue(values == true);
		System.out.println("Sucess!");
	}

}
