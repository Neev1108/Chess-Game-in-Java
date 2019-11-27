package edu.sjsu.cs151.controller;
import java.util.concurrent.BlockingQueue;

public class NewGameMessage implements Message {
String startgame;

public NewGameMessage(String startgame) {
	this.startgame = startgame;
}



}
