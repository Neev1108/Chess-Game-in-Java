package Animation;
import java.awt.*;
import java.awt.geom.*;

public class PawnShape implements MoveableShape {
	int x;
	int y;
	int width;
	
	
	public PawnShape(int x, int y, int width) {
		this.x = x;
		this.y = y;
		this.width = width;
	}
	
	public void move() {
		if(y < 0 || y > 600)
			y--;
		y++;
	}
	
	public void draw(Graphics2D g2) {
	
		Rectangle2D.Double body = new Rectangle2D.Double(x + 100, y+ width -10 , width-20, width/6 +10);
		g2.setColor(Color.pink);
		g2.fill(body);
		g2.draw(body);
		
		
		Rectangle2D.Double column = new Rectangle2D.Double(x + 130 , y , width/6, width);
		g2.fill(column);
		g2.draw(column);
		
		
		Rectangle2D.Double crown = new Rectangle2D.Double(x + 113, y - 20, width/2, width/5);
		g2.fill(crown);
		g2.draw(crown);
		

		
	}
	
}
