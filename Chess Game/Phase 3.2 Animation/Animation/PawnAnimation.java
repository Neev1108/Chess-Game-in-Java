package Animation;

import java.awt.GridBagLayout;

import javax.swing.*;

public class PawnAnimation {
	private static final int ICON_WIDTH = 400;
	private static final int ICON_HEIGHT = 100;
	private static final int PAWN_WIDTH = 100;

	public static void main(String[] args) {
		JFrame frame = new JFrame();

		final MoveableShape shape = new PawnShape(0, 0, PAWN_WIDTH);
		final MoveableShape quiz = new stationaryTile(0, 0, 0);
		final MoveableShape bish = new Bishop(0,0, PAWN_WIDTH);


	
		

		ShapeIcon icon = new ShapeIcon(shape, ICON_WIDTH, ICON_HEIGHT);
		final JLabel label = new JLabel(icon);
		frame.setSize(2000, 2000);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(label);

		ShapeIcon bishop = new ShapeIcon(bish, ICON_WIDTH, ICON_HEIGHT);
		final JLabel label3 = new JLabel(bishop);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(label3);

		ShapeIcon tile = new ShapeIcon(quiz, ICON_WIDTH, ICON_HEIGHT);
		final JLabel label2 = new JLabel(tile);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(label2);
		
		
		

		
		final int DELAY = 5;

		Timer t = new Timer(DELAY, event -> {
			shape.move();
			label.repaint();
			bish.move();
			label3.repaint();

		});

		t.start();
		
		final int FIELD_WIDTH = 20;
		final JTextField textField = new JTextField(FIELD_WIDTH);
		
		
		
		JButton startButton = new JButton("START CHESS GAME");
		startButton.addActionListener(event -> textField.setText("Press the start button!"));
		
        JPanel pnl = new JPanel(new GridBagLayout()); 

        pnl.add(startButton);
        frame.add(pnl);
		frame.setVisible(true);
		
	}

}
