package edu.sjsu.cs151.view;

import java.awt.Color;

import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

/**
 * This class implements the MovevableShape interface and creates a movable
 * bishop piece.
 * 
 * @author Neeval
 *
 */
public class BishopShape implements MoveableShape {

	/**
	 * The instance fields
	 */
	int x;
	int y;
	int width;

	/**
	 * Constructor for the class
	 * 
	 * @param x     The vertical coordinate
	 * @param y     The horizontal coordinate
	 * @param width The width of the piece
	 */
	public BishopShape(int x, int y, int width) {
		this.x = x;
		this.y = y;
		this.width = width;
	}

	/**
	 * Method to move the bishop piece
	 */
	public void move() {
		if (y < 0 || y > 680)
			y--;
		y++;
	}

	/**
	 * Method to draw the bishop piece using 2D Graphics shapes.
	 */
	public void draw(Graphics2D g2) {

		Rectangle2D.Double body = new Rectangle2D.Double(x + 910 - 200, y + width - 10, width - 35, width / 6 + 10);
		g2.setColor(Color.blue);
		g2.fill(body);
		g2.draw(body);

		Rectangle2D.Double column = new Rectangle2D.Double(x + 930 - 200, y, width - 80, width);
		g2.fill(column);
		g2.draw(column);

		Polygon tri = new Polygon(new int[] { x + 930 - 200, x + 940 - 200, 950 - 200 }, new int[] { y, y - 45, y }, 3);
		g2.fill(tri);
		g2.draw(tri);

		Ellipse2D.Double ov = new Ellipse2D.Double(x + 932 - 200, y - 50, width / 6, 30);
		g2.fill(ov);
		g2.draw(ov);

	}

}
