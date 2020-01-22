package com.company;

import javax.swing.*;

public class Gem {
    public char gemcolor;
    public int[] gemPosition;
    public ImageIcon imggem;

    public Gem(char gemcolor,int[] gemPosition){
        this.gemcolor=gemcolor;
        this.gemPosition=gemPosition;
        this.imggem = new ImageIcon(getClass().getResource("/images/jewels/" +gemcolor+".png"));
    }



    public char getGemcolor() {
        return gemcolor;
    }

    public int[] getGemPosition() {
        return gemPosition;
    }


    public ImageIcon getImggem() {
        return imggem;
    }


}
