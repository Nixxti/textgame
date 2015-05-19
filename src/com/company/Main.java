package com.company;
import java.util.Scanner;
public class Main {
    public static boolean playing = true;
    public static Scanner input = new Scanner(System.in);
    public static int c = 0;
    public static void main(String[] args) {
        Entity[] entities = new Entity[]{
                new Entity_Player(new Position(9,9),'P'),
                new Entity_NPC(new Position(8,8),'N')
        };
        Plant[] plants = new Plant[] {
                new Plant(new Position(9,0),"Cannibis",100),
                new Plant(new Position(9,1),"Cannibis",50),
                new Plant(new Position(9,2),"Cannibis",45),
                new Plant(new Position(9,3),"Cannibis",100),
                new Plant(new Position(9,4),"Cannibis",100),
                new Plant(new Position(8,0),"Cannibis",100),
                new Plant(new Position(8,1),"Cannibis",100),
                new Plant(new Position(8,2),"Cannibis",100),
                new Plant(new Position(8,3),"Cannibis",57),
                new Plant(new Position(8,4),"Cannibis",99),
                new Plant(new Position(8,4),"Cannibis",100)
        };
        Map overworld = new Map(10,10,entities,plants);
        overworld.generateTileMap();
        for (Entity e : entities) {
            e.updateMap(overworld);
        }

        while(playing) {
            overworld.generateStringMap();
            for (Entity e : entities) {e.think();}
            for (Plant p : plants){p.plantLogic();}
            handleInput(entities[c]);
        }
        System.out.println("Game Terminated");
    }

    static void handleInput(Entity e) {//Looppaa inputtia ja jänniä input trickkejä
        System.out.println("Insert a command (North, East, South, West | Examine, Take | Inventory | Quit | [control])");
        while(true) {
            switch (e.action(input.nextLine())) {
                case 1:
                    return;
                case 2:
                    System.out.println("Press enter to continue...");
                    input.nextLine();
                    input.nextLine();
                    return;
            }
        }
    }
}
