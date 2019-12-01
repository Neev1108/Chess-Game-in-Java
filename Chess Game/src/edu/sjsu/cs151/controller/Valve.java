package edu.sjsu.cs151.controller;

/** Interface that performs certain action in response to Message. 
 *  Each type of Message has corresponding Valve.
 *  See ValveResponse enum class and Controller mainLoop.
 **/
public interface Valve {
	public ValveResponses execute(Message message);
}
