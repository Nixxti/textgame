package com.company;
//import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        //Scanner input = new Scanner(System.in);
        Map overworld = new Map(50,50);
        Object[] objects = new Object[]{new Player(new Position(10,10),'P')};
        overworld.generateTileMap();
        overworld.generateEntityMap(objects);
        overworld.printTileMap();
        System.out.println();
    }
}
