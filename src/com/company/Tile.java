package com.company;

public class Tile {
    String tileType;
    char tileChar;
    String tileColor;
    String spacing = " ";
    String defaultColor = "[0m";
    public Tile(String tType) {
        this.tileType = tType;

        switch(tType){
            case "Grass":
                this.tileColor = "[42m";
                this.tileChar = ' ';
                break;

            case "Rock":
                this.tileColor = "[40;47m";
                this.tileChar = ' ';
                break;
        }
    }

    //String info() {return "This tile is of type: " + tileType + " and is represented by:  " + printTile();}

    String printTile() {return (char)27 + tileColor + spacing + tileChar + spacing + (char)27 + defaultColor;}
}
