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
		if(y < 0 || y > 690)
			y--;
		y++;
	}
	
	public void draw(Graphics2D g2) {
	
		Rectangle2D.Double bottomBase = new Rectangle2D.Double(x + 515, y+ width -10 , width-30, width/6);
		g2.setColor(Color.pink);
		g2.fill(bottomBase);
		g2.draw(bottomBase);
		
		Rectangle2D.Double middleBase = new Rectangle2D.Double(x + 525, y+ width -16 , width-50, width/6);
		g2.setColor(Color.pink);
		g2.fill(middleBase);
		g2.draw(middleBase);
		
		
		Rectangle2D.Double column = new Rectangle2D.Double(x + 540 , y+50, width/6 + 5, width-50);
		g2.fill(column);
		g2.draw(column);
		
		
		Ellipse2D.Double crown = new Ellipse2D.Double(x + 530, y + 10, width/2.5, width/2.5);
		g2.fill(crown);
		g2.draw(crown);
		
		Ellipse2D.Double crownBase = new Ellipse2D.Double(x + 518, y + 48, width/1.5, width/7);
		g2.fill(crownBase);
		g2.draw(crownBase);
		
		
	}
	
}
