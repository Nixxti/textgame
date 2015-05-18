package com.company;

public class Entity_Player extends Entity {

    String[] messages_casual = new String[] {
        "\"Wow, I'm so depressed.\"\n",
        "\"I want to die.\"\n"
    };
    public Entity_Player(Position pos, char pChar) {
        this.pos = pos;
        this.entityChar = pChar;
        this.inventory = new Inventory(10);
    }

    void think() {
        System.out.println(printEntity() + " thinks: " + messages_casual[random.nextInt(messages_casual.length)]);
    }

}
