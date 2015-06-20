package com.example.cameron.cookieclicker;

import android.util.Log;

import java.util.ArrayList;

/**
 * Created by Cameron on 6/18/15.
 */
public class Bank {
    private static final String TAG = "Bank";
//    private ArrayList<Double> mTransactions;
    int mBankBalance = 0;

    public void withdraw(double amount) {
//        mTransactions.add(-amount);
        mBankBalance -= amount;
        if (getBalance() < 0) {
//            if empty, we have to cancel the current click. But that should be done on the clicking side.
            Log.d(TAG, "Overdrafting from Cookie Bank");
        }
    }

    public void deposit(double amount) {
//        mTransactions.add(amount);
        mBankBalance += amount;
    }

    public double getBalance() {
//        double total = 0;
//        for (int i = 0; i < mTransactions.size(); i++) {
//            total += mTransactions.get(i);
//        }

        int total = mBankBalance;
        return total;
    }
}

