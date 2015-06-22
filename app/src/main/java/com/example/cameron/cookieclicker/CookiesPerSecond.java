package com.example.cameron.cookieclicker;

/**
 * Created by Cameron on 6/21/15.
 */
public class CookiesPerSecond {
    int cookies;

    public double add(double number){
        cookies += number;

        number /= 10;
        return number;
    }

}
