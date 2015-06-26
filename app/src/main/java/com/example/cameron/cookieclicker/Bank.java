package com.example.cameron.cookieclicker;

import android.util.Log;

import java.util.ArrayList;

/**
 * Created by Cameron on 6/18/15.
 */
public class Bank {
    private static final String TAG = "Bank";
    double mBankBalance = (1000000000);

    public void purchase(int amount) {
        mBankBalance -= amount;
    }

    public void purchaselong(long amount){
        mBankBalance -= amount;
    }

    public void deposit(int amount) {
        mBankBalance += amount;
    }

    public double getBalance() {
        double total = mBankBalance;
//        return total;
        return mBankBalance;
    }
}

