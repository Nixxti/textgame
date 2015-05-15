package com.company;

public class Entity_Player extends Entity {
    public Entity_Player(Position pos, char pChar) {
        this.pos = pos;
        this.entityChar = pChar;
    }

    void think() {
        System.out.println(printEntity() + " thinks: \"Wow, I want to die holy shit please kill me.\"");
    }
}
