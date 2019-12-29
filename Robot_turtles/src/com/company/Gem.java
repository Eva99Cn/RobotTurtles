package com.company;

import javax.swing.*;

public class Gem extends Player {
    public char gemcolor;
    public int[] gemPosition;
    public ImageIcon imggem;

    public Gem(char gemcolor,int[] gemPosition){
        this.gemcolor=gemcolor;
        this.gemPosition=gemPosition;
        this.imggem = new ImageIcon(getClass().getResource("/images/jewels/"+gemcolor+".png"));
    }

    public Gem() {
    }

    public char getGemcolor() {
        return gemcolor;
    }

    public int[] getGemPosition() {
        return gemPosition;
    }

    public void setGemPosition(int[] gemPosition) {
        this.gemPosition = gemPosition;
    }

    public ImageIcon getImggem() {
        return imggem;
    }

    public boolean gemTaken(Player player){
       boolean ans = false;
        if(player.getPosition()[0]==getGemPosition()[0]&&player.getPosition()[1]==getGemPosition()[1]){
            ans = true;
        }
        else{
            ans=false;
        }
    return ans;
    }

}
