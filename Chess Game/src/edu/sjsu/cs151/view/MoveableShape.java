package edu.sjsu.cs151.view;

import java.awt.Graphics2D;

/**
   A shape that can be moved around.
*/
public interface MoveableShape
{
   /**
      Draws the shape.
      @param g2 the graphics context
   */
   void draw(Graphics2D g2);
 
  
   
   void move();
}
