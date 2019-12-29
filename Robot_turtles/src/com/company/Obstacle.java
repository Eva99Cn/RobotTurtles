package com.company;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;


public class Obstacle {
    public char obstacleType;
    public int[] wallPos;
    private char stoneWall='S';
    private char iceWall='I';
    private char woodenBox='W';
    public int numberOfStoneWall=3;
    public int numberOfIceWall =2;
    public Obstacle(){
    }
    public boolean destroyable(char obstacleType){
        boolean ans = false;
        if(obstacleType==iceWall){
            ans= true;
        }
        else{
            ans = false;
        }

        return ans;
    }
    public boolean movableWall(char wall){
        boolean ans=false;
        if(wall==woodenBox){
            ans= true;
        }
        else{
            ans = false;
        }

        return ans;
    }

    public int getNumberOfIceWall() {
        return numberOfIceWall;
    }

    public int getNumberOfStoneWall() {
        return numberOfStoneWall;
    }

    public void reduceNumberOfStoneWall(){
        numberOfStoneWall--;
    }
    public void reduceNumberOfIceWall(){
        numberOfIceWall--;
    }

    public char getIceWall() {
        return iceWall;
    }
    public char getStoneWall(){
        return stoneWall;
    }
}





