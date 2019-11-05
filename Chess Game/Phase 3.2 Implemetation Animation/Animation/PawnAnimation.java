package Animation;
import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;

public class PawnAnimation {
	private static final int ICON_WIDTH = 400;
	private static final int ICON_HEIGHT = 100;
	private static final int PAWN_WIDTH = 100;
	
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		
		final MoveableShape shape = new PawnShape(0, 0 , PAWN_WIDTH);
		final MoveableShape quiz = new stationaryTile(0, 0, PAWN_WIDTH);
		
		ShapeIcon icon = new ShapeIcon(shape, ICON_WIDTH, ICON_HEIGHT);
		final JLabel label = new JLabel(icon);
		frame.add(label);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
		
		ShapeIcon tile =  new ShapeIcon(quiz, ICON_WIDTH, ICON_HEIGHT);
		final JLabel label2 = new JLabel(tile);
		frame.setLayout(new GridLayout());
		frame.add(label2);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
		
		//ShapeIcon icon = new ShapeIcon(shape, ICON_WIDTH, ICON_HEIGHT);
		//ShapeIcon tile =  new ShapeIcon(quiz, ICON_WIDTH,  ICON_HEIGHT);
		//final JLabel label = new JLabel(icon);
		//final JLabel label2 = new JLabel(tile);
		//frame.setLayout(new GridLayout());
		//frame.add(label2);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//frame.pack();
		//frame.setVisible(true);
		
		
		
		
		final int DELAY = 50;
		
		Timer t = new Timer(DELAY, event -> {
			shape.move();
			label.repaint();
			
			
		});
		
		t.start();
	}

}
