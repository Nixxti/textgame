package com.company;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
    int size;
    List<Item> inventory = new ArrayList<>();

    public Inventory(int size) {this.size = size;}

    void addItem(Item i){
        for (Item item : inventory) {
            if (item.name.equals(i.name) && item.value == i.value){
                System.out.println("Added " + i.amount + "x " + i.name + " to your existing stack of "+item.amount+"!");
                item.amount+=i.amount;
                return;
            }
        }
        inventory.add(i);
        System.out.println("Added " + i.amount + "x " + i.name + " to inventory!");
    }

    void printInventory()  {
        System.out.println("Your inventory: ");
        for (Item i : inventory) {
            System.out.println(i.amount + "x " + i.name + " | " + i.value + "$");
        }
        System.out.println("Items in inventory: " + itemsInInventory());
    }

    int itemsInInventory() {
        int amount = 0;
        for (Item i : inventory){
            amount+=i.amount;
        }
        return amount;
    }
}
