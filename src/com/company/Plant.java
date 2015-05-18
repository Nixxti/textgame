package com.company;

public class Plant {
    String name;
    int value;
    Position pos;

    char plantChar;
    String bgColor;
    String spacing = " ";
    String defaultColor = "[0m";
    public Plant(Position pos, String name, int value) {
        this.pos = pos;
        this.name = name;
        this.bgColor = "[42m";
        this.value = value;
        this.plantChar = name.toCharArray()[0];

    }

    String info() {return "This plant is of type: " + name + " and is represented by:  " + printPlant();}

    Position returnPos() {return pos;}

    String printPlant() {return (char)27 + bgColor + spacing + plantChar + spacing + (char)27 + defaultColor;}

    Item take() {return new Item(name,value);}

    void setBgColor(String colorCode) {this.bgColor = colorCode;}
}
