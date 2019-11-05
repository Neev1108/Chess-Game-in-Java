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
		Rectangle2D.Double tile1 = new Rectangle2D.Double(x + 100, y+ width -10 , 90, 90);
		g2.setColor(Color.black);
		g2.fill(tile1);
		g2.draw(tile1);
		
		Rectangle2D.Double tile2 = new Rectangle2D.Double(x + 100, y+ width + 80 , 90, 90);
		g2.setColor(Color.white);
		g2.fill(tile2);
		g2.draw(tile2);
		
		Rectangle2D.Double tile3 = new Rectangle2D.Double(x + 100, y+ width + 170 , 90, 90);
		g2.setColor(Color.black);
		g2.fill(tile3);
		g2.draw(tile3);
		
		Rectangle2D.Double tile4 = new Rectangle2D.Double(x + 100, y+ width + 260 , 90, 90);
		g2.setColor(Color.white);
		g2.fill(tile4);
		g2.draw(tile4);
		
		Rectangle2D.Double tile5 = new Rectangle2D.Double(x + 500, y+ width - 10 , 90, 90);
		g2.setColor(Color.white);
		g2.fill(tile5);
		g2.draw(tile5);
		
		Rectangle2D.Double tile6 = new Rectangle2D.Double(x + 500, y+ width  + 80 , 90, 90);
		g2.setColor(Color.black);
		g2.fill(tile6);
		g2.draw(tile6);
		
		Rectangle2D.Double tile7 = new Rectangle2D.Double(x + 500, y+ width  + 170 , 90, 90);
		g2.setColor(Color.white);
		g2.fill(tile7);
		g2.draw(tile7);
		
		Rectangle2D.Double tile8 = new Rectangle2D.Double(x + 500, y+ width  + 260 , 90, 90);
		g2.setColor(Color.black);
		g2.fill(tile8);
		g2.draw(tile8);
		
		
	
		
	}



	@Override
	public void move() {
		
	}

}
