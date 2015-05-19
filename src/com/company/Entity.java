package com.company;

import java.util.Arrays;
import java.util.Random;

public class Entity {
    //Miten kyseinen entity esitetään ruudulla
    char entityChar;
    String defaultColor = "[0m";
    String fgColor = "[33;";
    String bgColor;
    String spacing = " ";

    Map map; //Annan entityille kopion mapista että ne 'näkee'
    Inventory inventory; //Tasku homma

    Position pos;
    int movSpeed = 1; //Parempi että tätä arvoa ei ikinä koroteta.
    String[] dirN = {"n","north"};
    String[] dirE = {"e","east"};
    String[] dirS = {"s","south"};
    String[] dirW = {"w","west"};

    Random random = new Random();
    public Entity(){}

    boolean isWalkable(int x, int y) {
        if (!map.tileMap[y][x].canWalkOn) {
            System.out.println(String.format("%s can't walk on %s!",this.printEntity(),map.tileMap[y][x].printTile()));
            return false;
        }else {
            return true;
        }
    }
    int move(String dir) {
        if (Arrays.asList(dirN).contains((dir.toLowerCase())) && pos.y > 0){
            if (isWalkable(this.pos.x,this.pos.y-movSpeed)) {
                pos.y -= movSpeed;
            } else {
                return 0;
            }
        }

        if (Arrays.asList(dirE).contains((dir.toLowerCase())) && pos.x < map.mapWidth-1){
            if (isWalkable(this.pos.x+movSpeed,this.pos.y)) {
                pos.x += movSpeed;
            } else {
                return 0;
            }
        }

        if (Arrays.asList(dirS).contains((dir.toLowerCase())) && pos.y < map.mapHeight-1){
            if (isWalkable(this.pos.x,this.pos.y+movSpeed)) {
                pos.y += movSpeed;
            }else {
                return 0;
            }
        }

        if (Arrays.asList(dirW).contains((dir.toLowerCase())) && pos.x > 0){
            if (isWalkable(this.pos.x-movSpeed,this.pos.y)) {
                pos.x -= movSpeed;
            }else {
                return 0;
            }
        }
        return 1;
    }

    Position returnPos() {return pos;}

    String printEntity() {return (char)27 + (fgColor+bgColor) + spacing + entityChar + spacing + (char)27 + defaultColor;}

    void setBgColor(String colorCode) {this.bgColor = colorCode.substring(1);}

    void updateMap(Map map){this.map = map;}

    void think(){}

    String description() {
        return String.format("%-3s looks like a NPC.\n %-3s There are no special commands to use on this person.",this.printEntity()," ");
    }

    void examine() {
        System.out.println(String.format("%s looks around...\n",printEntity()));
        boolean plantsHere = false;
        boolean entityHere = false;
        for (Plant p : map.plants) {
            if (p.isColliding(this) && p.enabled){
                System.out.println(p.info());
                plantsHere = true;
            }
        }

        for (Entity e : map.entities) {
            if (e.isColliding(this) && this != e){
                System.out.println(e.description());
                entityHere = true;
            }
        }
        if (!plantsHere && !entityHere) {
            System.out.println(String.format("%s didn't find anything here!",printEntity()));
        }
    }

    void take() {
        boolean plantsHere = false;
        for (Plant p : map.plants) {
            if (p.isColliding(this) && p.enabled){
                if (inventory.itemsInInventory()+p.tAmount > inventory.size) {
                    System.out.println(String.format("Oh no! %s's Inventory is full!",printEntity()));
                } else {
                    System.out.println(String.format("%s harvests %s!",printEntity(),p.printPlant()));
                    inventory.addItem(p.take());
                }
                plantsHere = true;
            }
        }
        if (!plantsHere) {
            System.out.println(String.format("%s attempts to take air but fails miserably.",printEntity()));
        }
    }
    void stompPlant() {
        boolean plantsHere = false;
        for (Plant p : map.plants) {
            if (p.isColliding(this) && p.enabled){
                p.resetPlant();
                System.out.println(String.format("%s brutally stomps the %s-plant, completely disintegrating it.",printEntity(),p.printPlant()));
                plantsHere = true;
            }
        }
        if (!plantsHere) {
            System.out.println(String.format("%s stomps the empty ground, good job.",printEntity()));
        }
    }
    int control() {
        System.out.println(String.format("Type the ID of the entity you want to control ( 0 - %d )",map.entities.length-1));
        int c;
        try{
            c = Main.input.nextInt();
            if (c < map.entities.length) {
                Main.c = c;
                System.out.println(String.format("You will be controlling controlling %s on the next map update",map.entities[c].printEntity()));
                return 2;
            } else {
                System.out.println("Invalid input!");
                return 0;
            }
        } catch (Exception e) {
            System.out.println(String.format("Invalid input! ( %s )",e.getMessage()));
            return 0;
        }
    }

    boolean isColliding(Entity e) {
        return this.returnPos().x == e.returnPos().x && this.returnPos().y == e.returnPos().y;
    }

    int action(String a) {
        switch(a.toLowerCase()) { // 0 = Ei jatku, 1 = jatkuu, 2 = "Press any key to continue"-tyyppinen juttu
            case "q":case "quit":
                Main.playing = false;
                return 1;

            case "n":case "north":case "e":case "east":case "s":case "south":case "w":case "west":
                return move(a);

            case "i":case "inv":case "inventory":
                inventory.printInventory();
                return 0;

            case "control":
                return control();

            case "ex":case "exam":case "examine":
                examine();
                return 0;

            case "t":case "take":
                take();
                return 0;

            case "stomp":
                stompPlant();
                return 0;

            default:
                System.out.println(String.format("%s: Sorry, I can't do that.",printEntity()));
                return 0;
        }
    }
}
