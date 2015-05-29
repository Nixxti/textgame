package com.company;
import java.util.Scanner;
public class Main {
    public static boolean playing = true;
    private static Scanner input = new Scanner(System.in);
    public static int c = 0;

    public static void main(String[] args) {
        Entity[] entities = new Entity[]{
                new Entity_Player(new Position(16,16),'P'),
                new Entity_NPC(new Position(11,18),'N'),
                new Entity_Merchant(new Position(1,1),'M')
        };
        Plant[] plants = new Plant[] {
                new Plant(new Position(9,0),"Amikki",100),
                new Plant(new Position(9,1),"Taponlehti",50),
                new Plant(new Position(9,2),"Karvamaksaruoho",45),
                new Plant(new Position(9,3),"Lapinkaura",100),
                new Plant(new Position(9,4),"Lapinkaura",100),
                new Plant(new Position(8,0),"Lapinkaura",100),
                new Plant(new Position(8,1),"Lapinkaura",50),
                new Plant(new Position(8,2),"Suomukka",45),
                new Plant(new Position(8,3),"Pahtakeltto",100),
                new Plant(new Position(8,4),"Tikankontti",100),

                new Plant(new Position(2,19),"Taponlehti",100),
                new Plant(new Position(3,19),"Valkolehdokki",50),
                new Plant(new Position(4,19),"Suomukka",45),
                new Plant(new Position(5,19),"Taponlehti",100),
                new Plant(new Position(6,19),"Valkolehdokki",100),

                new Plant(new Position(0,8),"Taponlehti",100),
                new Plant(new Position(1,8),"Valkolehdokki",50),
                new Plant(new Position(2,8),"Suomukka",45),
                new Plant(new Position(0,11),"Taponlehti",100),
                new Plant(new Position(1,11),"Valkolehdokki",100),
        };
        Map overworld = new Map(20,20,entities,plants);
        for (Entity e : entities) {
            e.updateMap(overworld);
        }
        //Pelin loppumiseen vaikuttavat muuttujat
        int timerDefault = 240;
        int rentTimer = 120;
        int rentCost = 1000;
        int roundsSurvived = 0;

        while(playing) {
            if (rentTimer <= 0) {
                if(entities[0].inventory.money < rentCost) {
                    System.out.println("YOU DO NOT HAVE ENOUGH MONEY TO PAY RENT, THANK YOU FOR PLAYING.");
                    System.out.println(String.format("You survive %d round",roundsSurvived));
                    break;
                } else {
                    roundsSurvived+=1;
                    System.out.println(String.format("Congratulations! You survived round %d, good luck on round %d",roundsSurvived,roundsSurvived+1));
                    entities[0].inventory.money -= rentCost;
                    rentTimer = timerDefault;
                    rentCost = rentCost*2;
                }
            }
            rentTimer-=1;
            overworld.generateStringMap();
            System.out.println(String.format("Your rent is due, you have %d days to get %d$\n",rentTimer,rentCost));
            for (Entity e : entities) {e.think();}
            for (Plant p : plants){p.plantLogic();}
            handleInput(entities[c]);
        }
        System.out.println("Game Terminated");
    }

    private static void handleInput(Entity e) {//Looppaa inputtia ja jänniä input trickkejä
        System.out.println("Insert a command (North, East, South, West | Examine, Take | Sell | Inventory | Quit | [control])");
        while(true) {
            System.out.print("\nCommand: ");
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
