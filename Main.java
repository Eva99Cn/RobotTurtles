import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
	
	public static void main(String[] args) {
		char[][] plateau = {{'O','O','O','O','O','X','X','X'},
							{'X','X','X','O','O','O','X','X'},
							{'X','X','X','O','O','X','X','X'},
							{'O','O','O','O','O','X','X','X'},
							{'O','X','X','X','X','X','X','X'},
							{'O','O','O','X','X','X','X','X'},
							{'X','X','O','X','X','X','X','X'},
							{'X','X','S','X','X','X','X','X'}
									};
		search(plateau);
	}
	public static void affiche(char[][] plateau) {
		for(char[] row : plateau) {
			System.out.println(Arrays.toString(row));
		}
	}
	
	public static void search(char[][] plateau) {
		// !� utiliser sur une copie de matrice sinon �a va laisser des '.' , ':' etc.! 
		plateau[0][0] = 'T';
		int posX=0;
		int posY=0;
		int [] position = {posX,posY}; // position initiale
		int counter = 0;
		int min = 1;
		int max = 4;
		affiche(plateau);
		position[0]=posY;
		position[1]=posX;
		while(counter!=100) {
			//int counterPoint=0; C'�tait pour compter le nombre de point adjacent
			System.out.println('\n');
			int randomNum = ThreadLocalRandom.current().nextInt(min, max + 1);
			switch(randomNum) {
			case 1: // Va � droite
				position[1] = position[1] +1;
				// Pour qu'il ne d�passe pas du plateau
				if(position[0]<8 && position[0]>=0 && position[1]<8 && position[1]>=0) {
					//V�rifie si c'est un passage possible
					if(plateau[position[0]][position[1]]=='O') { // Ici on passe � la case du bas
						plateau[position[0]][position[1]-1]='.'; // . = d�j� pass�
						plateau[position[0]][position[1]]='T'; // T = Tortue
					}
					else if(plateau[position[0]][position[1]]=='.') { // Ici , on repasse par une case d�j� pass�e
						/*Condition pour savoir si � c�t� de '.' y'a des '.' et 'X' , si oui , mettre un ':'
						 // C'�tait pour voir s'il y avait des '.' ou 'X' � c�t�s pour �viter de perdre du temps mais bon ...
						if(plateau[position[0]+1][position[1]-1]=='.'){
							counterPoint++;
							if(plateau[position[0]-1][position[1]-1]=='.'||plateau[position[0]-1][position[1]-1]=='X'||position[0]-1<0){
								plateau[position[0]][position[1]-1]=':';
								position[1] = position[1] - 1 ;
							}
						}*/
							plateau[position[0]][position[1]]='T';
							plateau[position[0]][position[1]-1]='.';
					}
					else {
							plateau[position[0]][position[1]]='T';
							plateau[position[0]][position[1]-1]='.';
						}
				}
					else if(plateau[position[0]][position[1]]=='X') { // Si en haut a un mur
						if(plateau[position[0]+1][position[1]-1]=='X'||position[0]+1>8) { // Regarde � droite si mur
							if(plateau[position[0]-1][position[1]-1]=='X'||position[0]-1<0) { // Regarde � gauche si mur
								plateau[position[0]][position[1]-1]=':'; // : = d�j� pass� mais cul de sac
								position[1] = position[1]-2; // On recule
							}
						}
						else {
							position[1] = position[1] -1;
						}
					}
					else if(plateau[position[0]][position[1]+1]==':') { // Passage qui m�ne � un cul de sac
						position[0] = position[0]; //on bouge pas 
						position[1] = position[1]-1;
					}
				else {
					position[1] = position[1] -1;
				}
		
				break;
			case 2:// Va en bas
				position[0] = position[0]+1;
				// Pour qu'il ne d�passe pas du plateau
				if(position[0]<8 && position[0]>=0 && position[1]<8 && position[1]>=0) {
					//V�rifie si c'est un passage possible
					if(plateau[position[0]][position[1]]=='O') { // Ici on passe � la case de droite
						plateau[position[0]-1][position[1]]='.'; // . = d�j� pass�
						plateau[position[0]][position[1]]='T'; // T = Tortue
					}
					else if(plateau[position[0]][position[1]]=='.') { // Ici , on repasse par une case d�j� pass�e
						plateau[position[0]][position[1]]='T';
						plateau[position[0]-1][position[1]]='.';
					}
					else if(plateau[position[0]][position[1]]=='X') { // Si � droite y'a un mur
						if(plateau[position[0]-1][position[1]+1]=='X'||position[1]+1>8) { // Regarde en haut
							if(plateau[position[0]-1][position[1]-1]=='X'||position[1]-1<0) { // Regarde en bas
								plateau[position[0]-1][position[1]]=':'; // : = d�j� pass� mais cul de sac
								position[0] = position[0]-2; // On recule � gauche
							}
						}
						else {
							position[0]=position[0]-1;
						}
					}
					else if(plateau[position[0]+1][position[1]]==':') { // Passage qui m�ne � un cul de sac
						position[0] = position[0]-1; //on recule
						position[1] = position[1];
					}
				}
				else {
					position[0] = position[0]-1;
				}
				
				break;
			case 3:// Regarde � gauche
				position[1] = position[1]-1;
				// Pour qu'il ne d�passe pas du plateau
				if(position[0]<8 && position[0]>=0 && position[1]<8 && position[1]>=0) {
					//V�rifie si c'est un passage possible
					if(plateau[position[0]][position[1]]=='O') { // Ici on passe � la case du haut
						plateau[position[0]][position[1]+1]='.'; // . = d�j� pass�
						plateau[position[0]][position[1]]='T'; // T = Tortue
					}
					else if(plateau[position[0]][position[1]]=='.') { // Ici , on repasse par une case d�j� pass�e
						plateau[position[0]][position[1]]='T';
						plateau[position[0]][position[1]+1]='.';
					}
					else if(plateau[position[0]][position[1]]=='X') { // Si en haut a un mur
						if(plateau[position[0]+1][position[1]+1]=='X'||position[0]+1>8) { // Regarde � droite si mur
							if(plateau[position[0]-1][position[1]+1]=='X'||position[0]-1<0) { // Regarde � gauche si mur
								plateau[position[0]][position[1]+1]=':'; // : = d�j� pass� mais cul de sac
								position[1] = position[1] + 2; // On recule1
							}
						}
						else {
							position[1]=position[1]+1;
						}
					}
					else if(plateau[position[0]][position[1]-1]==':') { // Passag1e qui m�ne � un cul de sac
						position[0] = position[0]; //on bouge pas 
						position[1] = position[1];
					}
				}
				else {
					position[1] = position[1] + 1;
				}
				
				break;
			case 4:// Regarde en haut
				position[0] = position[0]-1;
				// Pour qu'il ne d�passe pas du plateau
				if(position[0]<8 && position[0]>=0 && position[1]<8 && position[1]>=0) {
					//V�rifie si c'est un passage possible
					if(plateau[position[0]][position[1]]=='O') { // Ici on passe � la case de droite
						plateau[position[0]+1][position[1]]='.'; // . = d�j� pass�
						plateau[position[0]][position[1]]='T'; // T = Tortue
					}
					else if(plateau[position[0]][position[1]]=='.') { // Ici , on repasse par une case d�j� pass�e
						plateau[position[0]][position[1]]='T';
						plateau[position[0]+1][position[1]]='.';
					}
					else if(plateau[position[0]][position[1]]=='X') { // Si � gauche y'a un mur
						if(plateau[position[0]+1][position[1]+1]=='X'||position[1]+1>8) { // Regarde en haut
							if(plateau[position[0]+1][position[1]-1]=='X'||position[1]-1<0) { // Regarde en bas
								plateau[position[0]+1][position[1]]=':'; // : = d�j� pass� mais cul de sac
								position[0] = position[0]+2; // On recule � droite
							}
						}
						else {
							position[0] = position[0] + 1;
						}
					}
					else if(plateau[position[0]-1][position[1]]==':') { // Passage qui m�ne � un cul de sac
						position[0] = position[0] +1; //on bouge pas 
						position[1] = position[1];
					}
				}
				else {
					position[0] = position[0] +1; // Retour position d'avant
				}
				break;
			}
			counter++;
			affiche(plateau);
		}
	}
}