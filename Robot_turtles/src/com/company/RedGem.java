package com.company;

public class RedGem implements Gem{			// Est spawn lorsque il y a 3 joueurs
	char redGem = 'r';
	@Override
	public void spawn() {
		plateau[0,0] = this.redGem;
	}

	@Override
	public boolean isTaken() {
		if(plateau[0,0]==this.redGem) {
			return false;
		}
		else {
			return true;
		}
	}
}
