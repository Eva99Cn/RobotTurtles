package com.company;

import java.util.ArrayList;
import java.util.List;

public class RedTurtle extends Turtle{
	private char color;
	private int x; // pos ligne
	private int y; // pos colonne
	private List<Integer> pos = new ArrayList<>();
	private char direction; // t -> top , b -> bot , l -> left , r -> right
	
	public RedTurtle(char color) {
		super(color);
		this.color='r'; 	// A voir si on garde un char , vu que right = 'r'
		if(nbJoueur==2) {
			this.pos=pos[7,1]; // Position par défaut quand 2 joueurs
		}
		else if(nbJoueur==3||nbJoueur==4) {
			this.pos=pos[7,0]; // Position par défaut quand 3/4 joueurs
		}
		this.direction='b';
	}
	
}
