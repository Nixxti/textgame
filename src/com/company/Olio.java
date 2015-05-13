package com.company;

/**
 * Created by Oskari on 13.5.2015.
 */
public class Olio {
    int olioValue = 0;
    public Olio(int x, int y) {
        olioValue = x+y;

    }
    public void Kerro() {
        System.out.println(olioValue);
    }
}
