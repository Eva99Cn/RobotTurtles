package com.company;

import com.sun.org.apache.bcel.internal.generic.ARETURN;

import javax.swing.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Cards extends Panneau {
    private char blueCard = 'b';
    private char yellowCard = 'y';
    private char purpleCard = 'p';
    private char laserCard = 'l';
    private int deckshuffleLength= 37;
    private ArrayList<Character> deckshuffle = new ArrayList<Character>();
    private ArrayDeque<Character> deck = new ArrayDeque<>();
    private static int numberBlueCard= 18;


    private ArrayList<Character> playerHand = new ArrayList<>();



    private ArrayDeque<Character> hiddenCards = new ArrayDeque<>();


    private static int numberYellowCard = 8;
    private static int numberOfPurpleCard = 8,numberOfLaserCard= 3;
    public  Cards(){

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

        Collections.shuffle(deckshuffle);
        for (int i=0;i<deckshuffleLength;i++){
            deck.push(deckshuffle.get(i));

        }
        fiveCardToPlayerHand();

    }



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
        if(newPosition[0] < 0 || newPosition[0] > 7||newPosition[1] < 0||newPosition[1] > 7){
            ans=false;

        }
        else if ((plateau[newPosition[0]][newPosition[1]])!=' '){
            ans = false;
        }


        return ans;
    }
    //Fonction qui regarde ce qui ce trouve sur le chemin
    private static void getObject(int[] newPosition,Player player){
        //On regarde si la tortue heurte un mur

    if (newPosition == gem1.getGemPosition() || newPosition == gem2.getGemPosition()) {
        player.setWin(true);
    }
    else{
        uTurn(player);
    }
    if (numberOfPlayers ==3 ) {
            if (newPosition == gem3.getGemPosition()) {
                player.setWin(true);
            }
        }


    // On regarde si la tortue en heurte une autre
    for (int i = 0; i < players.size(); i++) {
        if (plateau[newPosition[0]][newPosition[1]] == players.get(i).getTurtleName()) {
            players.get(i).setPosition(players.get(i).getStartingPoint());
            players.get(i).setDirection('S');
            player.setPosition(player.getStartingPoint());
            player.setDirection('S');
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
    private static void uTurn(Player player){
            int x = player.getPosition()[0];
            int y =player.getPosition()[1];


        if (player.getDirection()=='E'){
            player.setDirection('O');
        }
        else if (player.getDirection()=='N'){

            player.setDirection('S');
        }
        else if (player.getDirection()=='O'){

            player.setDirection('E');
        }
        else if (player.getDirection()=='S'){
            player.setDirection('N');
        }


    }
    public void laserEffect(Player player) {
        // Pour �viter de l'initialiser dans toute les boucles for
        if (player.getDirection() == 'S') {
            for (int i = player.getPosition()[0]+1; i <= 7; i++) { // On regarde chaque case en dessous
                if (plateau[i][player.getPosition()[1]] == ' ') {  // Quand le laser tire dans le vide
                    break;
                } else if (plateau[i][player.getPosition()[1]] == 'S') { // Quand le laser tire sur une pierre
                    break;
                } else if (plateau[i][player.getPosition()[1]] == 'W') { // Quand le laser tire sur le carton
                    break;
                } else if (plateau[i][player.getPosition()[1]] == 'I') {
                    plateau[i][player.getPosition()[1]] = ' '; // La glace fond
                    break;
                } else {

                    for (int j = 0; j < players.size(); j++) {
                        if (plateau[i][player.getPosition()[1]] == players.get(j).getTurtleName()) {
                            if (numberOfPlayers == 2) {
                                uTurn(players.get(j));
                                break;
                            } else {
                                players.get(j).setPosition(players.get(j).getStartingPoint());
                                break;
                            }
                        }
                    }
                }
            }
        } else if (player.getDirection() == 'N') {
            for (int i = player.getPosition()[0]+1; i >= 0; i--) { // On regarde chaque case au dessus
                if (plateau[i][player.getPosition()[1]] == ' ') {  // Quand le laser tire dans le vide
                    break;
                } else if (plateau[i][player.getPosition()[1]] == 'S') { // Quand le laser tire sur une pierre
                    break;
                } else if (plateau[i][player.getPosition()[1]] == 'W') { // Quand le laser tire sur le carton
                    break;
                } else if (plateau[i][player.getPosition()[1]] == 'I') {
                    plateau[i][player.getPosition()[1]] = ' '; // La glace fond
                    break;
                } else if (plateau[i][player.getPosition()[1]] == 'b' || plateau[i][player.getPosition()[1]] == 'p' || plateau[i][player.getPosition()[1]] == 'r') {
                    uTurn(player); // Si �a touche un joyau
                    break;
                } else {
//Laser sur un Joueur A REVOIR
                    for (int j = 0; j < players.size(); j++) {
                        if (plateau[i][player.getPosition()[1]] == players.get(j).getTurtleName()) {
                            if (numberOfPlayers == 2) {
                                uTurn(players.get(j));
                                break;
                            } else {
                                players.get(j).setPosition(players.get(j).getStartingPoint());
                                break;
                            }
                        }
                    }
                }
            }
        } else if (player.getDirection() == 'E') {
            for (int i = player.getPosition()[1]+1; i <= 7; i++) { // On regarde chaque case � droite
                if (plateau[player.getPosition()[0]][i] == ' ') {  // Quand le laser tire dans le vide
                    break;
                } else if (plateau[player.getPosition()[0]][i] == 'S') { // Quand le laser tire sur une pierre
                    break;
                } else if (plateau[player.getPosition()[0]][i] == 'W') { // Quand le laser tire sur le carton
                    break;
                } else if (plateau[player.getPosition()[0]][i] == 'I') {
                    plateau[player.getPosition()[0]][i] = ' '; // La glace fond
                    break;
                } else if (plateau[player.getPosition()[0]][i] == 'b' || plateau[player.getPosition()[0]][i] == 'p' || plateau[player.getPosition()[0]][i] == 'r') {
                    uTurn(player); // Si �a touche un joyau
                    break;
                } else {

                    for (int j = 0; j < players.size(); j++) {
                        if (plateau[player.getPosition()[0]][i] == players.get(j).getTurtleName()) {
                            if (numberOfPlayers == 2) {
                                uTurn(players.get(j));
                                break;
                            } else {
                                players.get(j).setPosition(players.get(j).getStartingPoint());
                                break;
                            }
                        }
                    }
                }
            }
        } else if (player.getDirection() == 'O') {
            for (int i = player.getPosition()[1]+1; i >= 0; i--) { // On regarde chaque case � gauche
                if (plateau[player.getPosition()[0]][i] == ' ') {  // Quand le laser tire dans le vide
                    break;
                } else if (plateau[player.getPosition()[0]][i] == 'S') { // Quand le laser tire sur une pierre
                    break;
                } else if (plateau[player.getPosition()[0]][i] == 'W') { // Quand le laser tire sur le carton
                    break;
                } else if (plateau[player.getPosition()[0]][i] == 'I') {
                    plateau[player.getPosition()[0]][i] = ' '; // La glace fond
                    break;
                } else if (plateau[player.getPosition()[0]][i] == 'b' || plateau[player.getPosition()[0]][i] == 'p' || plateau[player.getPosition()[0]][i] == 'r') {
                    uTurn(player); // Si �a touche un joyau
                    break;
                } else {

                    for (int j = 0; j < players.size(); j++) {
                        if (plateau[player.getPosition()[0]][i] == players.get(j).getTurtleName()) {
                            if (numberOfPlayers == 2) {
                                uTurn(players.get(j));
                                break;
                            } else {
                                players.get(j).setPosition(players.get(j).getStartingPoint());
                                break;
                            }
                        }
                    }
                }

            }
        }
    }








//Fonction pour remplir la main de l'utilisateur si il n'a que 5 cartes
        public void fiveCardToPlayerHand(){
                for (int i=getPlayerHand().size();i<5;i++){
                    addPlayerHand(deck.pop());
                }
            }

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
    public void removeHiddenCards() {

        hiddenCards.removeFirst();
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
