package Animation;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.*;
import javax.swing.Timer;

import javax.swing.JFrame;

public class SecondPawnShape extends JFrame implements ActionListener {
	int x;
	int y;
	
	int width;
	Timer tm = new Timer(5, this);

	
	
	public SecondPawnShape() {
		
		tm.start();
	}
	
	
	public void draw(Graphics2D g2) {
			
		Rectangle2D.Double body2 = new Rectangle2D.Double(x + 800, y+ width -10 , width-20, width/6 +10);
		g2.setColor(Color.pink);
		g2.fill(body2);
		g2.draw(body2);
		
		
		Rectangle2D.Double column2 = new Rectangle2D.Double(x + 800 , y , width/6, width);
		g2.fill(column2);
		g2.draw(column2);
		
		
		Rectangle2D.Double crown2 = new Rectangle2D.Double(x + 800, y - 20, width/2, width/5);
		g2.fill(crown2);
		g2.draw(crown2);

		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		x = x + velX;
		repaint();
	}
	
	public static void main(String[] args) {
		SecondPawnShape pawn = new SecondPawnShape();
		JFrame frame = new JFrame();
		frame.setSize(600, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.add(pawn);
		
		
	}
	
}
