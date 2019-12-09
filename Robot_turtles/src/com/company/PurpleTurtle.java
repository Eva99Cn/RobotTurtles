package com.company;

import java.util.ArrayList;
import java.util.List;

public class PurpleTurtle extends Turtle{
	private char color;
	private int x; // pos ligne
	private int y; // pos colonne
	private List<Integer> pos = new ArrayList<>();
	private char direction; // t -> top , b -> bot , l -> left , r -> right
	
	public PurpleTurtle(char color) {
		super(color);
		this.color='b';
		if(nbJoueur==3) {
			this.pos=pos[7,6]; // Position par défaut quand 3 joueurs
		}
		else if(nbJoueur==4) {
			this.pos=pos[7,5]; // Position par défaut quand 4 joueurs
		}
		this.direction='b';
	}
	
}
