package com.company;

public class Entity_Merchant extends  Entity {

    String[] messages_collision = new String[]{
            "\"Hey there, %s, got anything new to sell?\"\n",
            "\"Welcome to my store, %s.\"\n",
            "\"Better sell me some flowers before your rent is due.\"\n"
    };

    public Entity_Merchant(Position pos, char nChar) {
        this.entityChar = nChar;
        this.pos = pos;
        this.inventory = new Inventory(50);
        this.canTrade = true;
    }

    void think() {
        for (Entity e : map.entities) {
            if (e != this && this.isColliding(e)) {
                System.out.println(String.format("%s thinks: " + messages_collision[random.nextInt(messages_collision.length)],this.printEntity(), e.printEntity()));
            }
        }
    }

    String description() {
        return String.format("%-3s is the town merchant.\n %-3s You can use the following commands on this person: Sell, Buy, List.",this.printEntity()," ");
    }
}
