package com.company;

public class Entity_Player extends Entity {

    String[] messages_casual = new String[] {
        "\"Yay, I'm so happy.\"\n",
        "\"I'm having the time of my life!\"\n"
    };
    public Entity_Player(Position pos, char pChar) {
        this.pos = pos;
        this.entityChar = pChar;
        this.inventory = new Inventory(5);
    }

    void think() {
        if (map.entities[Main.c] == this) {
            System.out.println(String.format("%s thinks: %s",printEntity(),messages_casual[random.nextInt(messages_casual.length)]));
        }
    }
}
