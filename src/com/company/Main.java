package com.company;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Entity[] entities = new Entity[]{new Entity_Player(new Position(9,9),'P'),new Entity_NPC(new Position(8,8),'N')};
        Map overworld = new Map(20,20,entities);
        for (Entity e : entities) {
            e.updateMap(overworld);
        }
        overworld.generateTileMap();
        overworld.generateStringMap();
        //overworld.printStringMap();
        //Ei pysty vielä breakkaa looppia, ei jaksa.
        while(true) {
            System.out.println("Please insert a command (North, East, South, West)");
            entities[0].move(input.nextLine());
            overworld.generateStringMap();
            entities[0].think();
            entities[1].think();
        }
    }
}
