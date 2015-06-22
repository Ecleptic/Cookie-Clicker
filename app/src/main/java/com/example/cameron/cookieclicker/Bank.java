package com.example.cameron.cookieclicker;

import android.util.Log;

import java.util.ArrayList;

/**
 * Created by Cameron on 6/18/15.
 */
public class Bank {
    private static final String TAG = "Bank";
    int mBankBalance = 10000000;

    public void purchase(int amount) {
        mBankBalance -= amount;
        if (getBalance() < 0) {
            Log.d(TAG, "Overdrafting from Cookie Bank");
        }
    }

    public void deposit(int amount) {
        mBankBalance += amount;
    }

    public int getBalance() {
        int total = mBankBalance;
//        return total;
        return mBankBalance;
    }
}

