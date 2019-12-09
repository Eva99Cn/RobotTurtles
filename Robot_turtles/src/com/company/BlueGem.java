package com.company;

public class BlueGem implements Gem{	// Est spawn lorsqu'il y a 3 ou 4 joueurs
	char blueGem = 'b';
	@Override
	public void spawn() {
		plateau[6][0] = this.blueGem;
	}

	@Override	
	public boolean isTaken() {
		if(plateau[6,0]==this.blueGem) {
			return false;
		}
		else {
			return true;
		}
		
	}

}
