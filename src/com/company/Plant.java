package com.company;

public class Plant {
    boolean enabled = true;
    int recharge; //Kun t?? on 100 tai jotain niin kukka spawnaa uusiks.
    int chargeSpeed = 5;

    String name;
    int value;
    int tAmount = 1; //Kuinka paljon juttuja t?st? kasvista saa
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

    String info() {return
            "This plant is of type: " + name + " and is represented by:  " + printPlant()+"\n"+
            "You can use the follow commands on this plant: take\n";
    }

    void plantLogic() {
        if (!this.enabled) {
            recharge += chargeSpeed;
        }
        //Jotain muutakin vois t?nne lis?t?
    }

    Position returnPos() {return pos;}

    String printPlant() {return (char)27 + bgColor + spacing + plantChar + spacing + (char)27 + defaultColor;}

    void resetPlant() {
        this.recharge = 0;
        this.enabled = false;
    }

    Item take() {
        resetPlant();
        return new Item(name,1,value);
    }

    boolean isColliding(Entity e) {
        if (this.returnPos().x == e.returnPos().x && this.returnPos().y == e.returnPos().y){
            return true;
        } else {
            return false;
        }
    }

    void setBgColor(String colorCode) {this.bgColor = colorCode;}
}
