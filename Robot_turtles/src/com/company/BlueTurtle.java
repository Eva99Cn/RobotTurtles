package com.company;

import java.util.ArrayList;
import java.util.List;

public class BlueTurtle extends Turtle{
	private char color;
	private int x; // pos ligne
	private int y; // pos colonne
	private List<Integer> pos = new ArrayList<>();
	private char direction; // t -> top , b -> bot , l -> left , r -> right
	
	public BlueTurtle(char color) {
		super(color);
		this.color='b';
		this.pos=pos[7][6]; // Position par défaut quand 3 joueurs
		this.direction='t';
	}
	
}
