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
			pos[x,y] = pos[x,y+1];
			break;
		case 'l':
			pos[x,y] = pos[x-1,y];
			break;
		case 'b':
			pos[x,y] = pos[x,y-1];
			break;
		case 'r':
			pos[x,y] = pos[x+1,y];
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
	
	// On change la valeur isTaken de la gemme correspondante pour indiquer qu'il a été prise
	// Le faire avant que la tortue change de place sinon la tortue va écraser la gemme 
	public void takeGem() {
		if(pos[x,y]=='b') {
			
		}
		else if (pos[x,y]=='g') {
			
		}
		else if (pos[x,y]=='r') {
			
		}
		else if (pos[x,y]=='p') {
			
		}
		else {
			
		}
		
	}
}
