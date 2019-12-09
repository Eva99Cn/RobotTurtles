package com.company;

public class GreenGem implements Gem{	// Est spawn lorsqu'il y a 2 ou 3 joueurs
	char greenGem = 'g';
	@Override
	public void spawn() {
		plateau[3,0] = this.greenGem;
	}

	@Override
	public boolean isTaken() {
		if(plateau[3,0]==this.greenGem) {
			return false;
		}
		else {
			return true;
		}
	}

}
