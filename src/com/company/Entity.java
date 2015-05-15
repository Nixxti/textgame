package com.company;

import java.util.Arrays;
import java.util.Random;

public class Entity {
    //Miten kyseinen entity esitetään ruudulla
    char entityChar;
    String defaultColor = "[0m";
    String fgColor = "[0m";
    String bgColor;
    String spacing = " ";

    Map map; //Annan entityille kopion mapista että ne 'näkee'
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

    void think() {
        System.out.println(entityChar + " thinks: I want to die please just kill me now holy shit." );
    }

    boolean isColliding(Entity e) {
        if (this.returnPos().x == e.returnPos().x && this.returnPos().y == e.returnPos().y){
            return true;
        } else {
            return false;
        }
    }
    void action(String a) {}
}
