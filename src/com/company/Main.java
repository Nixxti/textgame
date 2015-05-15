package com.company;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Map overworld = new Map(10,10);
        Entity[] entities = new Entity[]{new Player(new Position(9,9),'P'),new NPC(new Position(2,2),'N')};
        overworld.generateTileMap();
        overworld.generateStringMap();
        overworld.placeEntitiesInMap(entities);
        overworld.printStringMap();

        while(true) {
            //System.out.println(entities[0].returnPos().x + " " + entities[0].returnPos().y);
            System.out.println("Where do you want to go? (North,East,South,West)");
            entities[0].move(input.nextLine());
            overworld.generateStringMap();
            overworld.placeEntitiesInMap(entities);
            overworld.printStringMap();
            entities[0].updateMap(overworld);
            entities[0].think();
        }
    }
}
