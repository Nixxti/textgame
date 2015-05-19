package com.company;
import java.util.Scanner;
public class Main {
    public static boolean playing = true;
    public static Scanner input = new Scanner(System.in);
    public static int c = 0;
    public static void main(String[] args) {
        Entity[] entities = new Entity[]{
                new Entity_Player(new Position(16,2),'P'),
                new Entity_NPC(new Position(11,18),'N')
        };
        Plant[] plants = new Plant[] {
                new Plant(new Position(9,0),"Amikki",100),
                new Plant(new Position(9,1),"Taponlehti",50),
                new Plant(new Position(9,2),"Karvamaksaruoho",45),
                new Plant(new Position(9,3),"Lapinhilpi",100),
                new Plant(new Position(9,4),"Lapinkaura",100),
                new Plant(new Position(8,0),"Lapinleinikki",100),
                new Plant(new Position(8,1),"Lettorikko",50),
                new Plant(new Position(8,2),"Suovalkku",45),
                new Plant(new Position(8,3),"Pahtakeltto",100),
                new Plant(new Position(8,4),"Tikankontti",100),

                new Plant(new Position(2,19),"Tundrasara",100),
                new Plant(new Position(3,19),"Valkolehdokki",50),
                new Plant(new Position(4,19),"Suomukka",45),
                new Plant(new Position(5,19),"Taarna",100),
                new Plant(new Position(6,19),"Vuorijalava",100),

                new Plant(new Position(0,8),"Tundrasara",100),
                new Plant(new Position(1,8),"Valkolehdokki",50),
                new Plant(new Position(2,8),"Suomukka",45),
                new Plant(new Position(0,11),"Taarna",100),
                new Plant(new Position(1,11),"Vuorijalava",100),
        };
        Map overworld = new Map(20,20,entities,plants);
        for (Entity e : entities) {
            e.updateMap(overworld);
        }
        overworld.generateTileMap();

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
                    input.nextLine(); // 2 nextLine koska control komento bugaa, 2lazy2fix
                    input.nextLine();
                    return;
            }
        }
    }
}
