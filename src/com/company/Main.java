package com.company;

public class Main {
    public static void main(String[] args) {
        Map overworld = new Map(10,10);
        overworld.Generate();
        overworld.ShowMap();
    }
}
