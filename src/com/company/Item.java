package com.company;

public class Item {
    String name;
    int value;
    int amount;

    public Item(String name, int amount,int value) {
        this.name = name;
        this.value = value;
        this.amount = amount;
    }

    int sell() {return value;}

    void use() {/*Jotain*/}
}
