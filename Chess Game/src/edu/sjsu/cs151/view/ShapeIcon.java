package edu.sjsu.cs151.view;

import java.awt.*;
import javax.swing.*;

/**
 * This methods implements the icon interface and contain the icon that contains
 * a movable shape.
 */
public class ShapeIcon implements Icon {
	/**
	 * The constructor of the class
	 * 
	 * @param shape  The MovableShape
	 * @param width  The width of the icon
	 * @param height The height of the icon
	 */
	public ShapeIcon(MoveableShape shape, int width, int height) {
		this.shape = shape;
		this.width = width;
		this.height = height;
	}

	/**
	 * Getter method to get the width of the icon
	 */
	public int getIconWidth() {
		return width;
	}

	/**
	 * Getter method to get the height of the icon
	 */
	public int getIconHeight() {
		return height;
	}

	/**
	 * Method to draw and paint the icon.
	 */
	public void paintIcon(Component c, Graphics g, int x, int y) {
		Graphics2D g2 = (Graphics2D) g;
		shape.draw(g2);
	}

	/**
	 * The fields
	 */
	private int width;
	private int height;
	private MoveableShape shape;
}
