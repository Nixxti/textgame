package com.company;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
    int size;
    int money = 0;
    List<Item> inventory = new ArrayList<>();

    public Inventory(int size) {this.size = size;}

    void addItem(Item i){
        for (Item item : inventory) {
            if (item.name.equals(i.name) && item.value == i.value){
                System.out.println(String.format("%5sAdded %dx %s to your existing stack of %d!"," ",i.amount,i.name,item.amount));
                item.amount+=i.amount;
                return;
            }
        }
        inventory.add(i);
        System.out.println(String.format("%5sAdded %dx %s to inventory!"," ",i.amount,i.name));
    }

    void printInventory()  {
        System.out.println("Your inventory:");
        System.out.println(String.format("%-18s | %s","Name","Value(ea)"));
        for (Item i : inventory) {
            System.out.println(String.format("%sx %-15s | %s$",i.amount,i.name,i.value));
        }
        System.out.println(String.format("\nItems in inventory: %d (Max. %d)",itemsInInventory(),size));
        System.out.println(String.format("Cash money: %d$",money));
    }

    int itemsInInventory() {
        int amount = 0;
        for (Item i : inventory){
            amount+=i.amount;
        }
        return amount;
    }
}
