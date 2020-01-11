package com.company;

import javax.swing.*;

public class Wall extends Game {
        protected char wallType;
        protected   int[] wallPos;
    public ImageIcon imgWall;




    Wall(char wallType, int[] wallPos){
            this.wallType=wallType;
            this.wallPos=wallPos;
        this.imgWall = new ImageIcon(getClass().getResource("/images/tiles/"+wallType+".png"));
        }


        public boolean destroyable(){
            boolean ans = false;
            if(wallType=='I'){
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



}
