package Animation;

import java.awt.GridBagLayout;

import javax.swing.*;

/**
 * This program creates a simple moving animation
 * @author Sehajmeet and Neeval
 *
 */
public class PawnAnimation {
	private static final int ICON_WIDTH = 400;
	private static final int ICON_HEIGHT = 100;
	private static final int PAWN_WIDTH = 100;

	public static void main(String[] args) {
		/**
		 * Creating a JFrame of size 2000 x 2000
		 */
		
		JFrame frame = new JFrame();
		frame.setSize(2000, 2000);

		/**
		 * Creating three MoveableShape objects
		 */
		final MoveableShape shape = new PawnShape(0, 0, PAWN_WIDTH);
		final MoveableShape quiz = new stationaryTile(0, 0, 100);
		final MoveableShape bish = new Bishop(0, 0, PAWN_WIDTH);

		/**
		 * Creating the first chess piece animation
		 */
		ShapeIcon icon = new ShapeIcon(shape, ICON_WIDTH, ICON_HEIGHT);
		final JLabel label = new JLabel(icon);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(label);

		/**
		 * Creating the second chess piece animation
		 */
		ShapeIcon bishop = new ShapeIcon(bish, ICON_WIDTH, ICON_HEIGHT);
		final JLabel label3 = new JLabel(bishop);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(label3);

		/**
		 * Creating the tiles of the chess board
		 */
		ShapeIcon tile = new ShapeIcon(quiz, ICON_WIDTH, ICON_HEIGHT);
		final JLabel label2 = new JLabel(tile);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(label2);

		final int DELAY = 5;

		/** 
		 * The timer for the animation
		 */
		Timer t = new Timer(DELAY, event -> {
			shape.move();
			label.repaint();
			bish.move();
			label3.repaint();

		});

		t.start();

		final int FIELD_WIDTH = 20;
		final JTextField textField = new JTextField(FIELD_WIDTH);
		
		/** 
		 * Creating the button for starting the chess game
		 */
		JButton startButton = new JButton("START CHESS GAME");
		startButton.addActionListener(event -> textField.setText("Press the start button!"));

		JPanel pnl = new JPanel(new GridBagLayout());

		pnl.add(startButton);
		frame.add(pnl);
		frame.setVisible(true);
		
	}

}
