package com.company;

import javax.swing.*;
import java.util.ArrayList;

public class Player extends Game {
    private char turtleName;
    private char direction;
    private int[] position;
    private Cards deck;
    private int[] startingPoint;
    private boolean win;
    private ArrayList<Wall> Walls = new ArrayList<>();

    protected Wall iceWall ;
    protected Wall iceWall2;
    protected Wall stoneWall;
    protected Wall stoneWall2;
    protected  Wall stoneWall3;
    protected  int numberofStoneWall;
    protected int numberofIceWall;


    public ImageIcon imgPlayer;




    public Player(char turtleName, char direction, int[] position, int[] startingPoint, Cards deck){

        this.turtleName = turtleName;
        this.direction = direction;
        this.position = position;
        this.deck = deck;
        this.startingPoint = startingPoint;
        this.imgPlayer= new ImageIcon(getClass().getResource("/images/characters/"+turtleName+"-"+direction+".png"));
        this.iceWall = new Wall('I',new int[]{99,1});
        this.iceWall2 = new Wall('I',new int[]{99,1});
        this.stoneWall = new Wall('S',new int[]{99,2});
        this.stoneWall2 = new Wall('S',new int[]{99,2});
        this.stoneWall3= new Wall('S',new int[]{99,2});
        this.numberofStoneWall=3;
        this.numberofIceWall=2;
        this.win=false;


    }

    public Player() {
    }

    public ImageIcon getImgPlayer() {


        return imgPlayer;
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
        plateau[getPosition()[0]][getPosition()[1]]=' ';
        plateau[position[0]][position[1]]=getTurtleName();
        this.position = position;
    }
//Fonction qui permet à la tortue de revenir à sa position de départ
    public void returnToStartingPoint(){
        this.position = startingPoint;
        this.direction = 'S';
        this.imgPlayer= new ImageIcon(getClass().getResource("/images/characters/"+getTurtleName()+"-"+direction+".png"));

    }
    //Fonction qui permet à la tortue de faire un demi-tour
    public  void uTurn(){

        if (direction=='E'){
          this.direction='O';
        }
        else if (direction=='N'){

            this.direction='S';
        }
        else if (direction=='O'){

           this.direction='E';
        }
        else if (direction=='S'){
           this.direction='N';
        }
        this.imgPlayer= new ImageIcon(getClass().getResource("/images/characters/"+getTurtleName()+"-"+direction+".png"));


    }

    public void turnCounterClockWise(){
        if (direction == 'E') {
            this.direction='N';

        } else if (direction == 'N') {
            this.direction='O';
        } else if (direction == 'O') {
            this.direction='S';
        } else if (direction == 'S') {
            this.direction='E';
        }
        this.imgPlayer= new ImageIcon(getClass().getResource("/images/characters/"+getTurtleName()+"-"+direction+".png"));

    }
    public void turnClockWise(){
        if (direction == 'E') {
            this.direction='S';

        } else if (direction == 'N') {
            this.direction='E';
        } else if (direction == 'O') {
            this.direction='N';
        } else if (direction == 'S') {
            this.direction='O';
        }
        this.imgPlayer= new ImageIcon(getClass().getResource("/images/characters/"+getTurtleName()+"-"+direction+".png"));

    }



    public Cards getDeck() {
        return deck;
    }


    public boolean isWin() {
        return win;
    }

    public void setWin(boolean win) {
        this.win = win;
    }



    public Wall getIceWall() {
        return iceWall;
    }



    public Wall getIceWall2() {
        return iceWall2;
    }



    public Wall getStoneWall() {
        return stoneWall;
    }


    public Wall getStoneWall2() {
        return stoneWall2;
    }


    public Wall getStoneWall3() {
        return stoneWall3;
    }



    public int getNumberofStoneWall() {
        return numberofStoneWall;
    }

    public void reduceNumberofStoneWall() {
        this.numberofStoneWall = numberofStoneWall-1;
    }

    public int getNumberofIceWall() {
        return numberofIceWall;
    }

    public void reduceNumberofIceWall() {
        this.numberofIceWall = numberofIceWall-1;
    }
}
