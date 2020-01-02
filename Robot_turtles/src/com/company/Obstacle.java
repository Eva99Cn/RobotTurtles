package com.company;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;


public class Obstacle {
    private ArrayList<Character> walls = new ArrayList<>();



    private  ArrayList<int[]> wallPos = new ArrayList<>();

    public Obstacle(){
        walls.add('I');
        walls.add('I');
        walls.add('S');
        walls.add('S');
        walls.add('S');

        wallPos.add(new int[]{10,1});
        wallPos.add(new int[]{11,1});
        wallPos.add(new int[]{12,1});
        wallPos.add(new int[]{13,1});
        wallPos.add(new int[]{14,1});


    }
    public boolean destroyable(char obstacleType){
        boolean ans = false;
        if(obstacleType=='I'){
            ans= true;
        }
        else{
            ans = false;
        }

        return ans;
    }
    public boolean movableWall(char wall){
        boolean ans=false;
        if(wall=='W'){
            ans= true;
        }
        else{
            ans = false;
        }

        return ans;
    }


    public void reduceNumberOfStoneWall(){
        for (int i=0;i<walls.size();i++){
            if (walls.get(i)=='S'){
                walls.remove(i);
                break;
            }
        }
    }
    public void reduceNumberOfIceWall(){
        for (int i=0;i<walls.size();i++){
            if (walls.get(i)=='S'){
                walls.remove(i);
                break;
            }
        }
    }

    public ArrayList<Character> getWalls() {
        return walls;
    }
    public ArrayList<int[]> getWallPos() {
        return wallPos;
    }

    public void setWallPos(ArrayList<int[]> wallPos) {
        this.wallPos = wallPos;
    }

}





