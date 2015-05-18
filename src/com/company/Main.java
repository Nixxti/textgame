package com.company;
import java.util.Scanner;
public class Main {
    public static boolean playing = true;
    public static Scanner input = new Scanner(System.in);
    public static int c;
    public static void main(String[] args) {
        Entity[] entities = new Entity[]{
                new Entity_Player(new Position(9,9),'P'),
                new Entity_NPC(new Position(8,8),'N')
                };
        c = 0;
        Plant[] plants = new Plant[] {
                new Plant(new Position(9,0),"Cannibis",100),
                new Plant(new Position(9,1),"Cannibis",100),
                new Plant(new Position(9,2),"Cannibis",100),
                new Plant(new Position(9,3),"Cannibis",100),
                new Plant(new Position(9,4),"Cannibis",100),
                new Plant(new Position(8,0),"Cannibis",100),
                new Plant(new Position(8,1),"Cannibis",100),
                new Plant(new Position(8,2),"Cannibis",100),
                new Plant(new Position(8,3),"Cannibis",100),
                new Plant(new Position(8,4),"Cannibis",100)
        };
        Map overworld = new Map(10,10,entities,plants);
        for (Entity e : entities) {
            e.updateMap(overworld);
        }
        overworld.generateTileMap();
        //overworld.generateStringMap();
        //overworld.printStringMap();
        //Ei pysty vielä breakkaa looppia, ei jaksa.
        while(playing) {
            overworld.generateStringMap();
            entities[0].think();
            entities[1].think();
            handleInput(entities[c]);
        }
        System.out.println("Game Terminated");

    }

    static void handleInput(Entity e) {//Looppaa inputtia.
        while(true) {
            System.out.println("Insert a command (North, East, South, West | quit)");
            if (e.action(input.nextLine()) == true) { //Kun action funktio returnaa 'true' niin peli piirtää mapin uusiks
                break;
            }
        }
    }
}
