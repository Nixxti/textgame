package com.company;

public class Item {
    String name;
    int value;
    int amount;
    boolean enabled = true;
    public Item(String name, int amount,int value) {
        this.name = name;
        this.value = value;
        this.amount = amount;
    }

    int sell(Entity seller, Entity buyer) {
        System.out.println(String.format("%s sold %dx %s for %d$ each to %s",seller.printEntity(),amount,name,value,buyer.printEntity()));
        this.enabled = false;
        return value;
    }
}
