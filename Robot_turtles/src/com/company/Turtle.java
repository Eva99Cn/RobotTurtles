package com.company;

import java.util.*;

public class Turtle {
	private char color;
	private int x; // pos ligne
	private int y; // pos colonne
	private List<Integer> pos = new ArrayList<>();
	private char direction; // t -> top , b -> bot , l -> left , r -> right
	
	public Turtle(char color) {
		this.color=color;
		this.pos=pos;
		this.direction=direction;
	}
	// If card == goForward -> turtle.goForward
	public void goForward(){
		switch(direction) {
		case 't':
			
			break;
		case 'l':
			direction = 'b';
			break;
		case 'b':
			direction = 'r';
			break;
		case 'r':
			direction = 't';
			break;
		}
	}
	// If card == turnLeft -> turtle.turnLeft ( À faire dans le gameplay)
	public void turnLeft() {
		switch(direction) {
		case 't':
			direction = 'l';
			break;  
		case 'l':
			direction = 'b';
			break;
		case 'b':
			direction = 'r';
			break;
		case 'r':
			direction = 't';
			break;
		}
	}
	// If card == turnRight -> turtle.turnRight ( À faire dans le gameplay)
	public void turnRight() {
		switch(direction) {
		case 't':
			direction = 'r';
			break;
		case 'r':
			direction = 'b';
			break;
		case 'b':
			direction = 'l';
			break;
		case 'l':
			direction = 't';
			break;
		}
	}
	public void takeGem() {
		if(pos[][]==)
	}
}
