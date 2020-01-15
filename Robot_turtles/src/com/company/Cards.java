package com.company;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;

public class Cards extends Game {
    private char blueCard = 'b';
    private char yellowCard = 'y';
    private char purpleCard = 'p';
    private char laserCard = 'l';
    private int deckshuffleLength= 37;
    private ArrayList<Character> deckshuffle = new ArrayList<>();
    protected ArrayDeque<Character> deck = new ArrayDeque<>();
    private static int numberBlueCard= 18,numberYellowCard = 8,numberOfPurpleCard = 8,numberOfLaserCard= 3;


    //Liste pour pouvoir stocker ce que le joueur à dans sa main
    private ArrayList<Character> playerHand = new ArrayList<>();


    //Liste pour pouvoir stocker ce que le joueur à mis dans sa file d'instruction
    private ArrayDeque<Character> hiddenCards = new ArrayDeque<>();
    public  Cards(){

        //On ajoute les cartes dans un deck
        for (int i =0;i<=numberBlueCard;i++){
            deckshuffle.add(blueCard);
        }
        for (int i =0;i<=numberYellowCard;i++){
            deckshuffle.add(yellowCard);
        }
        for (int i =0;i<=numberOfPurpleCard;i++){
            deckshuffle.add(purpleCard);
        }
        for (int i =0;i<=numberOfLaserCard;i++){
            deckshuffle.add(laserCard);
        }
        //On mélange puis on ajoute les cartes dans un deck
        Collections.shuffle(deckshuffle);
        for (int i=0;i<deckshuffleLength;i++){
            deck.push(deckshuffle.get(i));

        }

        fiveCardToPlayerHand();

    }



    /*
    * Fonction pour la carte bleu
    * On crée une liste pour voir si la tortue peut y aller
    * Si la case est inexistante ou indiponible on regarde le type de l'objet
    * On execute une action en fonction de l'objet
    * */

    public static void blueEffect(Player player){
        if(numberBlueCard>0){
            int x = player.getPosition()[0];
            int y =player.getPosition()[1];
        if (player.getDirection()=='E') {
            int[] position= new int[]{x,y+ 1};
            if (isValidPosition(position)){
                player.setPosition(position);
            }
            else{
                getObject(position,player);
            }

        }
        else if (player.getDirection() == 'S') {
            int[] position= new int[]{x+ 1,y};

            if (isValidPosition(position)){
                player.setPosition(position);
            }
            else{
                getObject(position,player);
            }


        } else if (player.getDirection() == 'O') {
            int[] position= new int[]{x, y-1};

            if (isValidPosition(position)){
                player.setPosition(position);
            }

            else {
                getObject(position,player);
            }

        } else if (player.getDirection() == 'N') {
            int[] position= new int[]{x- 1, y};
            if (isValidPosition(position)){
                player.setPosition(position);
            }
           else {
                getObject(position,player);
            }
            }
        numberBlueCard--;}

    }

    private static boolean isValidPosition(int[] newPosition) {
        boolean ans=true;
        //Regarde si la tortue ne dépasse pas les limites
        if(newPosition[0] < 0 || newPosition[0] > 7||newPosition[1] < 0||newPosition[1] > 7){
            ans=false;

        }
        //regarde si la position est vide
        else if ((plateau[newPosition[0]][newPosition[1]])!=' '){
            ans = false;
        }


        return ans;
    }
    //Fonction qui regarde ce qui ce trouve sur le chemin
    private static void getObject(int[] newPosition,Player player){
        //S'il dépasse on le renvoi à sa position de départ
        if(numberOfPlayers<4){
                if(newPosition[0] < 0 || newPosition[0] > 7||newPosition[1] < 0||newPosition[1] > 6){
                   player.returnToStartingPoint();
                }}
        else {
            if(newPosition[0] < 0 || newPosition[0] > 7||newPosition[1] < 0||newPosition[1] > 7){
                player.returnToStartingPoint();
            }
        }
        //On regarde si la tortue heurte un mur, si oui elle fait demi tour
        if (plateau[newPosition[0]][newPosition[1]]=='S'||plateau[newPosition[0]][newPosition[1]]=='I'){
            player.uTurn();
        }

        //si la tortue touche un joyau on met son boolean win en vrai
        if (newPosition[0] == gem1.getGemPosition()[0] && newPosition[1] == gem1.getGemPosition()[1]) {
            player.setWin(true);
        }
    else{
        player.uTurn();
    }
    if (newPosition[0] == gem2.getGemPosition()[0] && newPosition[1] == gem2.getGemPosition()[1]) {
            player.setWin(true);
        }
    else{
       player.uTurn();
    }
    if (numberOfPlayers ==3 ) {
            if (newPosition[0] == gem3.getGemPosition()[0] && newPosition[1] == gem3.getGemPosition()[1]) {
                player.setWin(true);
            }
            else {
              player.uTurn();
            }
            }




    // On regarde si la tortue en heurte une autre
    for (int i = 0; i < players.size(); i++) {
        if (plateau[newPosition[0]][newPosition[1]] == players.get(i).getTurtleName()) {
            if(numberOfPlayers==2){
                players.get(i).uTurn();
                player.uTurn();
                break;
            }
            else{
            players.get(i).returnToStartingPoint();
            player.returnToStartingPoint(); }
            break;
        }
    }

    }



   public static void yellowEffect(Player player){
       if(numberYellowCard>0) {
           if (player.getDirection() == 'E') {
               player.setDirection('N');

           } else if (player.getDirection() == 'N') {
               player.setDirection('O');
           } else if (player.getDirection() == 'O') {
               player.setDirection('S');
           } else if (player.getDirection() == 'S') {
               player.setDirection('E');
           }
           numberYellowCard--;
       }
        }
        public static void purpleEffect(Player player) {
            if (numberOfPurpleCard > 0) {

                if (player.getDirection() == 'E') {
                    player.setDirection('S');



                } else if (player.getDirection() == 'N') {
                    player.setDirection('E');

                } else if (player.getDirection() == 'O') {
                    player.setDirection('N');

                } else if (player.getDirection() == 'S') {
                    player.setDirection('O');

                }
                System.out.println(player.getDirection());

                numberOfPurpleCard--;

            }
        }

    //Carte laser A revoir
    public void laserEffect(Player player) {
        // Pour éviter de l'initialiser dans toute les boucles for
        if (player.getDirection() == 'S') {
            for (int i = player.getPosition()[0]; i <= 7; i++) { // On regarde chaque case en dessous

                if(laserToWall(i,player.getPosition()[1])){
                    break;
                }
               else if (plateau[i][player.getPosition()[1]] == 'b' || plateau[i][player.getPosition()[1]] == 'p' || plateau[i][player.getPosition()[1]] == 'r') {
                    player.uTurn(); // Si �a touche un joyau
                     break;
                 }
                 else {

                    for (int j = 0; j < players.size(); j++) {
                        if (plateau[i+1][player.getPosition()[1]] == players.get(j).getTurtleName()) {
                            if (numberOfPlayers == 2) {
                                players.get(j).uTurn();
                                break;
                            } else {
                                players.get(j).returnToStartingPoint();
                                break;
                            }
                        }
                    }
                }
            }
        } else if (player.getDirection() == 'N') {
            for (int i = player.getPosition()[0]; i >= 0; i--) { // On regarde chaque case au dessus
                if(laserToWall(i,player.getPosition()[1])){
                    break;
                } else if (plateau[i][player.getPosition()[1]] == 'b' || plateau[i][player.getPosition()[1]] == 'p' || plateau[i][player.getPosition()[1]] == 'r') {
                   player.uTurn(); // Si la touche un joyau
                    break;
                } else {
//Laser sur un Joueur
                    for (int j = 0; j < players.size(); j++) {
                        if (plateau[i-1][player.getPosition()[1]] == players.get(j).getTurtleName()) {
                            if (numberOfPlayers == 2) {
                                players.get(j).uTurn();
                                break;
                            } else {
                                players.get(j).returnToStartingPoint();
                                break;
                            }
                        }
                    }
                }
            }
        } else if (player.getDirection() == 'E') {
            for (int i = player.getPosition()[1]; i <= 7; i++) { // On regarde chaque case � droite
                if(laserToWall(player.getPosition()[0],i)){
                    break;
                }  else if (plateau[player.getPosition()[0]][i] == 'b' || plateau[player.getPosition()[0]][i] == 'p' || plateau[player.getPosition()[0]][i] == 'r') {
                    player.uTurn(); // Si �a touche un joyau
                    break;
                } else {

                    for (int j = 0; j < players.size(); j++) {
                        if (plateau[player.getPosition()[0]][i+1] == players.get(j).getTurtleName()) {
                            if (numberOfPlayers == 2) {
                                players.get(j).uTurn();
                                break;
                            } else {
                                players.get(j).returnToStartingPoint();
                                break;
                            }
                        }
                    }
                }
            }
        } else if (player.getDirection() == 'O') {
            for (int i = player.getPosition()[0]; i >= 0; i--) { // On regarde chaque case � gauche
                if(laserToWall(player.getPosition()[1],i)){
                    break;
                } else if (plateau[player.getPosition()[0]][i] == 'b' || plateau[player.getPosition()[0]][i] == 'p' || plateau[player.getPosition()[0]][i] == 'r') {
                   player.uTurn(); // Si �a touche un joyau
                    break;
                } else {

                    for (int j = 0; j < players.size(); j++) {
                        if (plateau[player.getPosition()[0]][i-1] == players.get(j).getTurtleName()) {
                            if (numberOfPlayers == 2) {
                                players.get(j).uTurn();
                                break;
                            } else {
                                players.get(j).returnToStartingPoint();
                                break;
                            }
                        }
                    }
                }

            }
        }
    }



public boolean laserToWall(int x, int y){
        for (int i=0;i<walls.size();i++){
            if(walls.get(i).getWallPos()[0]==x && walls.get(i).getWallPos()[1]==y){
                if (walls.get(i).destroyable()){
                    walls.get(i).setWallPos(new int[] {99,1});
                    plateau[x][y] = ' ';
                    return true;
                }
                return true;
            }
        }
        return false;
}




//Fonction pour remplir la main de l'utilisateur si il n'a que 5 cartes
        public void fiveCardToPlayerHand(){

                for (int i=getPlayerHand().size();i<5;i++){
                    addPlayerHand(deck.pop());
                }
            }
//Fonction pour faire défausser la main du joueur
        public void cardToDiscard(char choice){
            for (int i=0;i<getPlayerHand().size();i++){
                if (getPlayerHand().get(i)==choice){
                    getPlayerHand().remove(i);
                    break;
                }
            }

        }


    public void addPlayerHand(char card) {
        playerHand.add(card);
    }
    public void removePlayerHand(int indiceCard) {
        playerHand.remove(indiceCard);
    }
    public void addHiddenCards(char card) {

        hiddenCards.add(card);
    }


    public ArrayDeque<Character> getHiddenCards() {
        return hiddenCards;
    }

    public ArrayList<Character> getPlayerHand() {
        return playerHand;
    }

    public void addCardToPlayerHand(char choice){
        int indexCard=-1;
        int compteur=0;
        if (player.getDeck().getPlayerHand().size()>0) {
            for (int i = 0; i < player.getDeck().getPlayerHand().size(); i++) {
                if (choice == (player.getDeck().getPlayerHand()).get(i)) {
                    player.getDeck().addHiddenCards((player.getDeck().getPlayerHand()).get(i));
                    indexCard = i;
                    player.getDeck().removePlayerHand(indexCard);

                    System.out.println("Carte ajouté au programme");
                    compteur++;
                    break;
                }
            }
            if(compteur==0){
                System.out.println("La carte n'est pas dans votre main");
            }
        }
        else {
            System.out.println("Tu n'as plus de cartes");
        }

    }



}
