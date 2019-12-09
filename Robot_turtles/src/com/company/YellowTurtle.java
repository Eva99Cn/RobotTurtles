package com.company;

import java.util.ArrayList;
import java.util.List;

public class YellowTurtle extends Turtle{
	private char color;
	private int x; // pos ligne
	private int y; // pos colonne
	private List<Integer> pos = new ArrayList<>();
	private char direction; // t -> top , b -> bot , l -> left , r -> right
	
	public YellowTurtle(char color) {
		super(color);
		this.color='b';
		if(nbJoueur==4) {
			this.pos=pos[7,7]; // Position par défaut quand 4 joueurs
		}
		this.direction='b';
	}
	
}