package Animation;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

public class stationaryTile implements MoveableShape {
	int x;
	int y;
	int width;
	Color color;
	
	
	public stationaryTile(int x, int y, int width) {
		this.x = x;
		this.y = y;
		this.width = width;
	}
	
	
	
	public void draw(Graphics2D g2) {
		int tileNumber = 8;
			
		
		//tiles on left
		for (int i = 0; i < tileNumber; i++)
		{
			Rectangle2D.Double tile = new Rectangle2D.Double(x + 500, y + (width*i), width, width);
			if (i%2 == 0)
			{
				g2.setColor(Color.black);
			}
			else
			{
				g2.setColor(Color.white);
			}
			g2.fill(tile);
			g2.draw(tile);
		}	
		
		//Tiles on right
		
		
		for (int i = 0; i < tileNumber; i++)
		{
			Rectangle2D.Double tile = new Rectangle2D.Double(x + 900, y+ (width * i) , width, width);
			if (i%2 == 0)
			{
				g2.setColor(Color.white);
			}
			else
			{
				g2.setColor(Color.black);
			}
			g2.fill(tile);
			g2.draw(tile);
		}	
		
	
		
	}



	@Override
	public void move() {
		
	}

}
