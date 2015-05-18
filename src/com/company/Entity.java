package com.company;

import java.util.Arrays;
import java.util.Random;

public class Entity {
    //Miten kyseinen entity esitetään ruudulla
    char entityChar;
    String defaultColor = "[0m";
    String bgColor;
    String spacing = " ";

    Map map; //Annan entityille kopion mapista että ne 'näkee'
    Inventory inventory; //Tasku homma

    Position pos;
    Position posBounds;
    int movSpeed = 1; //Parempi että tätä arvoa ei ikinä koroteta.
    String[] dirN = {"n","north"};
    String[] dirE = {"e","east"};
    String[] dirS = {"s","south"};
    String[] dirW = {"w","west"};

    Random random = new Random();
    public Entity(){}

    void move(String dir) {
        if (Arrays.asList(dirN).contains((dir.toLowerCase())) && pos.y > 0){
            pos.y -= movSpeed;
        }

        if (Arrays.asList(dirE).contains((dir.toLowerCase())) && pos.x < map.mapWidth-1){
            pos.x += movSpeed;
        }

        if (Arrays.asList(dirS).contains((dir.toLowerCase())) && pos.y < map.mapHeight-1){
            pos.y += movSpeed;
        }

        if (Arrays.asList(dirW).contains((dir.toLowerCase())) && pos.x > 0){
            pos.x -= movSpeed;
        }
    }

    Position returnPos() {
        return pos;
    }

    String printEntity() {
        return (char)27 + bgColor + spacing + entityChar + spacing + (char)27 + defaultColor;
    }

    void setBgColor(String colorCode) {
        this.bgColor = colorCode;
    }

    void updateMap(Map map){
        this.map = map;
    }

    void think(){}

    boolean isColliding(Entity e) {
        if (this.returnPos().x == e.returnPos().x && this.returnPos().y == e.returnPos().y){
            return true;
        } else {
            return false;
        }
    }

    boolean action(String a) {
        switch(a.toLowerCase()) {
            case "q":
            case "quit":
                Main.playing = false;
                return true;

            case "n":   //Tarkoituksella tehty jotta tää shitti hyväksyy monta eri arvoa.
            case "north":
            case "e":
            case "east":
            case "s":
            case "south":
            case "w":
            case "west":
                move(a);
                return true;


            case "i":
            case "inv":
            case "inventory":
                inventory.printInventory();
                return false;

            case "control":
                int c = Main.input.nextInt();
                if (c < map.entities.length) {
                    Main.c = c;
                    System.out.println("You are now controlling " + printEntity());

                    return true;
                } else {
                    System.out.println("Invalid input!");
                    return false;
                }
            default:
                System.out.println(printEntity() + ": Sorry, I can't do that.");
                return false;
        }
    }
}
