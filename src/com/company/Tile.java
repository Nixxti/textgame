package com.company;

public class Tile {
    String tileType;
    char tileChar;
    String tileColor;
    String spacing = " ";
    String defaultColor = "[0m";
    boolean canWalkOn;
    public Tile(String tType) {
        this.tileType = tType;

        switch(tType){
            case "G": //Grass
                this.tileColor = "[42;1m";
                this.tileChar = ' ';
                this.canWalkOn = true;
                break;

            case "R": //Muuri
                this.tileColor = "[47;1m";
                this.tileChar = ' ';
                this.canWalkOn = false;
                break;

            case "W": //Lattia
                this.tileColor = "[40;1m";
                this.tileChar = ' ';
                this.canWalkOn = true;
                break;

            case "B": //Silta
                this.tileColor = "[41;1m";
                this.tileChar = ' ';
                this.canWalkOn = true;
                break;

            case "F": //Vesi
                this.tileColor = "[44;1m";
                this.tileChar = ' ';
                this.canWalkOn = false;
                break;
        }
    }
    String printTile() {return (char)27 + tileColor + spacing + tileChar + spacing + (char)27 + defaultColor;}
}
