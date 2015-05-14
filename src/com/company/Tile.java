package com.company;

public class Tile {
    String tileType;
    char tileChar;
    String tileColor;

    String defaultColor = "[0m";
    public Tile(String tType, char tChar) {
        tileType = tType;
        tileChar = tChar;

        switch(tType){
            case "Grass":
                tileColor = "[32m";
                break;

            case "Rock":
                tileColor = "[30;37m";
                break;
        }
    }

    public String Info() {
        return "This tile is of type: " + tileType + " and is represented by the char " + PrintTile();
    }

    public String PrintTile() {
        return (char)27 + tileColor + tileChar + (char)27 + defaultColor;
    }
}
