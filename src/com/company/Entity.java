package com.company;

import java.util.Arrays;

public class Entity {
    char entityChar;
    Position pos;
    int movSpeed = 1;
    String[] dirN = {"n","north"};
    String[] dirE = {"e","east"};
    String[] dirS = {"s","south"};
    String[] dirW = {"w","west"};
    public Entity(){}
    public Entity(Position pos, char eChar) {
        this.entityChar = 'E';
        this.pos = pos;
    }

    void move(String dir) {
        if (Arrays.asList(dirN).contains((dir.toLowerCase()))){
            pos.y += movSpeed;
        }

        if (Arrays.asList(dirE).contains((dir.toLowerCase()))){
            pos.x += movSpeed;
        }

        if (Arrays.asList(dirS).contains((dir.toLowerCase()))){
            pos.y -= movSpeed;
        }

        if (Arrays.asList(dirW).contains((dir.toLowerCase()))){
            pos.x -= movSpeed;
        }
    }

    Position returnPos() {
        return pos;
    }
}
