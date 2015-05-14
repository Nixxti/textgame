package com.company;

public class Tile {
    String tileType;
    char tileChar;
    String tileColor;
    String spacing = " ";
    String defaultColor = "[0m";
    public Tile(String tType, char tChar) {
        this.tileType = tType;
        this.tileChar = tChar;

        switch(tType){
            case "Grass":
                this.tileColor = "[42m";
                break;

            case "Rock":
                this.tileColor = "[30;37m";
                break;
        }
    }

    String info() {
        return "This tile is of type: " + tileType + " and is represented by:  " + printTile();
    }

    String printTile() {
        return (char)27 + tileColor + spacing + tileChar + spacing + (char)27 + defaultColor;
    }
}
