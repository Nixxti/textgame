package com.company;

public class Player extends Entity {
    public Player(Position pos, char pChar) {
        this.pos = pos;
        this.entityChar = pChar;
    }

    void think() {
        System.out.println(printEntity() + " thinks: \"Wow, I want to die holy shit please kill me.\"");
    }
}
