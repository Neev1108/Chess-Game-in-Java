package edu.sjsu.cs151.controller;

public class MoveMessage implements Message{

	private int currentPosition, endPosition;
		
		/**
		* Message for an attempted move
		* @param s start position
		* @param e end position
		*/
		public MoveMessage(int currentPosition, int endPosition) {
			this.currentPosition = currentPosition;
			this.currentPosition = endPosition;		
		}

		/**
		* Start position getter method
		* @return start position
		*/
		public int getCurrentPosition() {
			return currentPosition;
		}
		
		/**
		* End position getter method
		* @return end position
		*/
		public int getEndPosition() {
			return endPosition;
		}	
	
}
