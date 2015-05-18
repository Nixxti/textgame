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

    Position returnPos() {return pos;}

    String printEntity() {return (char)27 + bgColor + spacing + entityChar + spacing + (char)27 + defaultColor;}

    void setBgColor(String colorCode) {this.bgColor = colorCode;}

    void updateMap(Map map){this.map = map;}

    void think(){}

    boolean isColliding(Entity e) {
        if (this.returnPos().x == e.returnPos().x && this.returnPos().y == e.returnPos().y){
            return true;
        } else {
            return false;
        }
    }

    int action(String a) {
        switch(a.toLowerCase()) { // 0 = Ei jatku, 1 = jatkuu, 2 = uusi komento pyydetään
            case "q":
            case "quit":
                Main.playing = false;
                return 1;

            case "n":   //Tarkoituksella tehty jotta tää shitti hyväksyy monta eri arvoa.
            case "north":
            case "e":
            case "east":
            case "s":
            case "south":
            case "w":
            case "west":
                move(a);
                return 1;


            case "i":
            case "inv":
            case "inventory":
                inventory.printInventory();
                return 0;

            case "control":
                System.out.println("Type the ID of the entity you want to control ( 0 - "+ (map.entities.length-1) +")");
                int c;
                try{
                    c = Main.input.nextInt();
                    if (c < map.entities.length) {
                        Main.c = c;
                        System.out.println("You will be controlling controlling " + map.entities[c].printEntity() + " on the next map update");
                        return 2;
                    } else {
                        System.out.println("Invalid input!");
                        return 0;
                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                    return 0;
                }
            default:
                System.out.println(printEntity() + ": Sorry, I can't do that.");
                return 0;
        }
    }
}
