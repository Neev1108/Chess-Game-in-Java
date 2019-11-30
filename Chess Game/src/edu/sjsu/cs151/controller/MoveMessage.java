package edu.sjsu.cs151.controller;

public class MoveMessage implements Message {

	private int start, end;
		
		/**
		* Message for an attempted move
		* @param s start position
		* @param e end position
		*/
		public MoveMessage(int s, int e) {
			start = s;
			end = e;		
		}

		/**
		* Start position getter method
		* @return start position
		*/
		public int getStart() {
			return start;
		}
		
		/**
		* End position getter method
		* @return end position
		*/
		public int getEnd() {
			return end;
		}	
	

}
