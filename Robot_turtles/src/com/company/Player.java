package com.company;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayDeque;
import java.util.ArrayList;

public class Player extends Panneau {
    private char turtleName;
    private char direction;
    private int position[];
    private int choice;
    private Cards deck;
    private int startingPoint[];
    private boolean win;
    private boolean turn;
    public Obstacle obstacle;



    public ImageIcon imgPlayer;




    public Player(char turtleName, char direction, int position[], int startingPoint[], Cards deck){

        this.turtleName = turtleName;
        this.direction = direction;
        this.position = position;
        this.deck = deck;
        this.startingPoint = startingPoint;
        this.imgPlayer= new ImageIcon(getClass().getResource("/images/characters/"+turtleName+"-"+direction+".png"));
        turn= false;
        this.obstacle = new Obstacle();


    }

    public Player() {
    }

    public void moveTurtle(){

    }
    public ImageIcon getImgPlayer() {


        return imgPlayer;
    }

    public void setImgPlayer(ImageIcon imgPlayer) {
        this.imgPlayer = imgPlayer;
    }

    public char getTurtleName() {
        return turtleName;
    }

    public char getDirection() {
        return direction;
    }

    public void setDirection(char direction) {
        this.imgPlayer= new ImageIcon(getClass().getResource("/images/characters/"+getTurtleName()+"-"+direction+".png"));
        this.direction = direction;

    }

    public int[] getPosition() {
        return position;
    }

    public void setPosition(int[] position) {
        this.position = position;
    }

    public int getChoice() {
        return choice;
    }

    public void setChoice(int choice) {
        this.choice = choice;
    }

    public Cards getDeck() {
        return deck;
    }


    public int[] getStartingPoint() {
        return startingPoint;
    }

    public boolean isWin() {
        return win;
    }

    public void setWin(boolean win) {
        this.win = win;
    }
}
