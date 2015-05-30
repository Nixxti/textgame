package com.company;

public class Plant {
    boolean enabled = true;
    int recharge = 0; //Kun t?? on 100 tai jotain niin kukka spawnaa uusiks.
    int chargeSpeed = 5;

    String name;
    int value;
    int tAmount = 1; //Kuinka paljon juttuja tästä kasvista saa
    Position pos;

    char plantChar;
    String fgColor;
    String bgColor;
    String spacing = " ";
    String defaultColor = "[0m";
    public Plant(Position pos, String name, int value) {
        this.pos = pos;
        this.name = name;
        this.fgColor = "[31;";
        this.value = value;
        this.plantChar = name.toCharArray()[0];
    }

    String info() {return
            String.format("%-5sThis plant is named %s and it looks like %s.\n%-5sYou can use the follow commands on this plant: Take, Stomp\n"," ",this.name,this.printPlant()," ");
    }

    void plantLogic() {
        if (!this.enabled) {
            recharge += chargeSpeed;
            if (recharge >= 100) {
                this.enabled = true;
                recharge = 0;
            }
        }
    }

    Position returnPos() {return pos;}

    String printPlant() {return (char)27 + (fgColor+bgColor) + spacing + plantChar + spacing + (char)27 + defaultColor;}

    void resetPlant() {
        this.recharge = 0;
        this.enabled = false;
    }

    Item take() {
        resetPlant();
        return new Item(name,1,value);
    }

    boolean isColliding(Entity e) {
        return this.returnPos().x == e.returnPos().x && this.returnPos().y == e.returnPos().y;
    }

    void setBgColor(String colorCode) {this.bgColor = colorCode.substring(1);}
}
