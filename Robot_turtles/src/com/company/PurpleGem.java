package com.company;

public class PurpleGem implements Gem{	// Est spawn lorsqu'il y a 4 joueurs
	char purpleGem = 'p';
	@Override
	public void spawn() {
		plateau[1,0] = this.purpleGem;
		
	}

	@Override
	public boolean isTaken() {
		if(plateau[1,0]==this.purpleGem) {
			return false;
		}
		else {
			return true;
		}
	}

}
