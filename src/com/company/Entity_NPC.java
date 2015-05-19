package com.company;

public class Entity_NPC extends Entity {
    String[] messages_collision = new String[]{
            "\"Wow, this %s-person is standing way too close to me.\"\n",
            "\"Please, %s, for the love of god please back away, I don't want to communicate with you.\"\n",
            "\"I wish this %s-guy would drop dead.\"\n"
    };
    public Entity_NPC(Position pos, char nChar) {
        this.entityChar = nChar;
        this.pos = pos;
        this.inventory = new Inventory(5);
    }
    void think() {
        for (Entity e : map.entities) {
            if (e != this && this.isColliding(e)) {
                System.out.println(String.format("%s thinks: " + messages_collision[random.nextInt(messages_collision.length)],this.printEntity(), e.printEntity()));
            }
        }
    }
}
