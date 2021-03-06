package edu.sjsu.cs151.controller;

/**
 * This class represents an attempted move event sent from the View when the
 * user drags a chess piece
 */
public class MoveMessage implements Message {

	private int currentPosition, endPosition;

	/**
	 * Message for an attempted move
	 * 
	 * @param currentPosition start position
	 * @param endPosition     end position
	 */
	public MoveMessage(int currentPosition, int endPosition) {
		this.currentPosition = currentPosition;
		this.endPosition = endPosition;
	}

	/**
	 * Start position getter method
	 * 
	 * @return start position
	 */
	public int getCurrentPosition() {
		return currentPosition;
	}

	/**
	 * End position getter method
	 * 
	 * @return end position
	 */
	public int getEndPosition() {
		return endPosition;
	}

}
