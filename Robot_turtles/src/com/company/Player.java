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
    private ArrayList<Wall> Walls = new ArrayList<>();

    protected Wall iceWall ;
    protected Wall iceWall2;
    protected Wall stoneWall;
    protected Wall stoneWall2;
    protected  Wall stoneWall3;

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
        iceWall = new Wall('I',new int[]{10,1});
        iceWall2 = new Wall('I',new int[]{10,1});
        stoneWall = new Wall('S',new int[]{10,2});
        stoneWall2 = new Wall('S',new int[]{10,2});
        stoneWall3= new Wall('S',new int[]{10,2});



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

    public Obstacle getObstacle() {
        return obstacle;
    }

    public Wall getIceWall() {
        return iceWall;
    }

    public void setIceWall(Wall iceWall) {
        this.iceWall = iceWall;
    }

    public Wall getIceWall2() {
        return iceWall2;
    }

    public void setIceWall2(Wall iceWall2) {
        this.iceWall2 = iceWall2;
    }

    public Wall getStoneWall() {
        return stoneWall;
    }

    public void setStoneWall(Wall stoneWall) {
        this.stoneWall = stoneWall;
    }

    public Wall getStoneWall2() {
        return stoneWall2;
    }

    public void setStoneWall2(Wall stoneWall2) {
        this.stoneWall2 = stoneWall2;
    }

    public Wall getStoneWall3() {
        return stoneWall3;
    }

    public void setStoneWall3(Wall stoneWall3) {
        this.stoneWall3 = stoneWall3;
    }
}
