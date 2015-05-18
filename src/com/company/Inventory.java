package com.company;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
    int size;
    List<Item> Inventory = new ArrayList();

    public Inventory(int size) {
        this.size = size;
    }

    void addItem(Item i){
        Inventory.add(i);
    }

    void printInventory()  {
        System.out.println("Your inventory: ");
        for (Item i : Inventory) {
            System.out.println(i.name + " | " + i.value);
        }
    }
}
