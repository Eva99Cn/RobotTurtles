package com.company;

import javax.swing.*;
import java.util.ArrayList;

public class Wall extends Panneau{
        protected char wallType;
        protected   int[] wallPos;
    public ImageIcon imgWall;




    Wall(char wallType, int[] wallPos){
            this.wallType=wallType;
            this.wallPos=wallPos;
        this.imgWall = new ImageIcon(getClass().getResource("/images/tiles/"+wallType+".png"));
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

    public char getWallType() {
        return wallType;
    }


    public int[] getWallPos() {
        return wallPos;
    }


    public void setWallPos(int[] wallPos) {
        this.wallPos = wallPos;
    }

    public boolean emptySlot(int x, int y){
        boolean ans = true;
        if(plateau[x][y]!=' '){
            ans = false;
        }
        return ans;
    }


}
