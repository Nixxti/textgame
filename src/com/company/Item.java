package com.company;

public class Item {
    String name;
    int value;

    public Item(String name, int value) {
        this.name = name;
        this.value = value;
    }

    int sell() {return value;}

    void use() {/*Jotain*/ }
}
