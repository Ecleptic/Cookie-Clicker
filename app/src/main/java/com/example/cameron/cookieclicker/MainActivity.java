package com.example.cameron.cookieclicker;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.math.*;
import java.util.Timer;
import java.util.TimerTask;
import java.lang.Number;


public class MainActivity extends ActionBarActivity {
    private static final String TAG = "MainActivity";
    private static final String TAGS = "CookiePrices";
    private static final String COUNT = "Count";

    private int cookie0_amount = 1;
    private int cookie1_amount = 15;
    private int cookie2_amount = 100;
    private int cookie3_amount = 500;
    private int cookie4_amount = 3000;
    private int cookie5_amount = 10000;
    private int cookie6_amount = 40000;
    private int cookie7_amount = 10000;
    private int cookie8_amount = 1667000;
    private int cookie9_amount = 123456700;
    private long cookie10_amount = 4000000000L;
    private long cookie11_amount = 75000000000L;

    private double mPrice;
    private String mPrices;
    private double CPSS;

    private static int cookie1_base_amount = 15;
    private static int cookie2_base_amount = 100;
    private static int cookie3_base_amount = 500;
    private static int cookie4_base_amount = 3000;
    private static int cookie5_base_amount = 10000;
    private static int cookie6_base_amount = 40000;
    private static int cookie7_base_amount = 10000;
    private static int cookie8_base_amount = 1667000;
    private static int cookie9_base_amount = 123456700;
    private static long cookie10_base_amount = 4000000000L;     // "L" at the end because it's a long?
    private static long cookie11_base_amount = 75000000000L;    // "L" at the end because it's a long?


    public double CPS = 0.0;
    private int timertest = 0;

    Button mCookie0;
    Button mCookie1;
    Button mCookie2;
    Button mCookie3;
    Button mCookie4;
    Button mCookie5;
    Button mCookie6;
    Button mCookie7;
    Button mCookie8;
    Button mCookie9;
    Button mCookie10;
    Button mCookie11;

    public TextView mCPS;
    public TextView mBankDisplay;
    TextView mCookie1Price;
    TextView mCookie2Price;
    TextView mCookie3Price;
    TextView mCookie4Price;
    TextView mCookie5Price;
    TextView mCookie6Price;
    TextView mCookie7Price;
    TextView mCookie8Price;
    TextView mCookie9Price;
    TextView mCookie10Price;
    TextView mCookie11Price;

    Bank mBank;

    public Building[] mBuildings;


    public TimerTask mTimerTask = new TimerTask() {
        @Override
        public void run() {
//            timertest += 1;
            mBank.mBankBalance += (CPS);
            mHandler.obtainMessage(1).sendToTarget();
            Log.d(COUNT, "Timer: " + timertest);
//            Log.d(TAG, "CPS: " +CPS);
        }
    };

    private Handler mHandler = new Handler() {
        public void handleMessage(Message msg) {
            mCPS.setText("CPS: " + (CPS));
            String result = String.format("%.0f", mBank.mBankBalance);
            mBankDisplay.setText("" + result);
        }
    };


    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        long factor = (long) Math.pow(10, places);
        value = value * factor;
        long tmp = Math.round(value);
        return (double) tmp / factor;
    }

    public double addBuildingPrice(int baseCost, double buildingNumber) {
        mPrice = baseCost * (Math.pow(1.15, buildingNumber));
        mPrice = Math.round(mPrice);
        Log.d(TAG, "mPrice: " + mPrice);
        return (int) mPrice;
    }

    public long addBuildingPriceLong(long baseCost, double buildingNumber) {
        mPrice = baseCost * (Math.pow(1.15, buildingNumber));
        mPrice = Math.round(mPrice);
        Log.d(TAG, "mPrice: " + mPrice);
        return (long) mPrice;
    }


    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Timer mTimer = new Timer();
        mTimer.scheduleAtFixedRate(mTimerTask, 1000, 1000);

        mCookie0 = (Button) findViewById(R.id.cookie0);
        mCookie1 = (Button) findViewById(R.id.cookie1);
        mCookie2 = (Button) findViewById(R.id.cookie2);
        mCookie3 = (Button) findViewById(R.id.cookie3);
        mCookie4 = (Button) findViewById(R.id.cookie4);
        mCookie5 = (Button) findViewById(R.id.cookie5);
        mCookie6 = (Button) findViewById(R.id.cookie6);
        mCookie7 = (Button) findViewById(R.id.cookie7);
        mCookie8 = (Button) findViewById(R.id.cookie8);
        mCookie9 = (Button) findViewById(R.id.cookie9);
        mCookie10 = (Button) findViewById(R.id.cookie10);
        mCookie11 = (Button) findViewById(R.id.cookie11);


        mBankDisplay = (TextView) findViewById(R.id.bankdisplay);
        mCPS = (TextView) findViewById(R.id.cpsdisplay);
        mCookie1Price = (TextView) findViewById(R.id.cookie1_price);
        mCookie2Price = (TextView) findViewById(R.id.cookie2_price);
        mCookie3Price = (TextView) findViewById(R.id.cookie3_price);
        mCookie4Price = (TextView) findViewById(R.id.cookie4_price);
        mCookie5Price = (TextView) findViewById(R.id.cookie5_price);
        mCookie6Price = (TextView) findViewById(R.id.cookie6_price);
        mCookie7Price = (TextView) findViewById(R.id.cookie7_price);
        mCookie8Price = (TextView) findViewById(R.id.cookie8_price);
        mCookie9Price = (TextView) findViewById(R.id.cookie9_price);
        mCookie10Price = (TextView) findViewById(R.id.cookie10_price);
        mCookie11Price = (TextView) findViewById(R.id.cookie11_price);


        mBank = new Bank();
        mBuildings = new Building[12];
        mBuildings[0] = new Building();
        mBuildings[1] = new Building();
        mBuildings[2] = new Building();
        mBuildings[3] = new Building();
        mBuildings[4] = new Building();
        mBuildings[5] = new Building();
        mBuildings[6] = new Building();
        mBuildings[7] = new Building();
        mBuildings[8] = new Building();
        mBuildings[9] = new Building();
        mBuildings[10] = new Building();
        mBuildings[11] = new Building();


        mBankDisplay.setText("" + mBank.getBalance());
        mCPS.setText("CPS: " + (CPS));

        mCookie0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mBank.deposit(cookie0_amount);
                String result = String.format("%.0f", mBank.mBankBalance);
                mBankDisplay.setText("" + result);
            }
        });

        mCookie1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ((mBank.mBankBalance - cookie1_amount) >= 0) {
                    mBank.purchase(cookie1_amount);
                    mBuildings[0].addC1Building(1);

                    addBuildingPrice(cookie1_base_amount, mBuildings[0].numberOfC1Buildings());
                    Log.d(TAGS, "buildingPrice is: " + mPrice);
                    cookie1_amount = (int) mPrice;
                    mPrices = String.valueOf(+cookie1_amount);
                    mCookie1Price.setText(mPrices);
                    Log.d(TAGS, "buildingPrice is rounded: " + cookie1_amount);
                    CPS += .1;
                    CPS = round(CPS, 1);

                    mCPS.setText("CPS: " + (CPS));
                    Log.d(TAG, "CPS = " + CPS);
//                    Log.d(TAG, "mC1Number is: " + mBuildings[tgtgggtg0].numberOfC1Buildings());
                    String result = String.format("%.0f", mBank.mBankBalance);
                    mBankDisplay.setText("" + result);
                }
            }
        });

        mCookie2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ((mBank.mBankBalance - cookie2_amount) >= 0) {
                    mBank.purchase(cookie2_amount);
                    mBuildings[1].addC2Building(1);

                    addBuildingPrice(cookie2_base_amount, mBuildings[1].numberOfC2Buildings());
                    Log.d(TAGS, "buildingPrice is: " + mPrice);
                    cookie2_amount = (int) mPrice;
                    mPrices = String.valueOf(+cookie2_amount);
                    mCookie2Price.setText(mPrices);

                    CPS += .5;
                    mCPS.setText("CPS: " + (CPS));
//                    Log.d(TAG, "mC2Number is: " + mBuildings[1].numberOfC2Buildings());
                    String result = String.format("%.0f", mBank.mBankBalance);
                    mBankDisplay.setText("" + result);
                }
            }
        });

        mCookie3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ((mBank.mBankBalance - cookie3_amount) >= 0) {
                    mBank.purchase(cookie3_amount);
                    mBuildings[2].addC3Building(1);

                    addBuildingPrice(cookie3_base_amount, mBuildings[2].numberOfC3Buildings());
                    Log.d(TAGS, "buildingPrice is: " + mPrice);
                    cookie3_amount = (int) mPrice;
                    mPrices = String.valueOf(+cookie3_amount);
                    mCookie3Price.setText(mPrices);

                    CPS += 4;
                    mCPS.setText("CPS: " + (CPS));

//                    Log.d(TAG, "mC3Number is: " + mBuildings[2].numberOfC3Buildings());
                    String result = String.format("%.0f", mBank.mBankBalance);
                    mBankDisplay.setText("" + result);
                }
            }
        });

        mCookie4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ((mBank.mBankBalance - cookie4_amount) >= 0) {
                    mBank.purchase(cookie4_amount);
                    mBuildings[3].addC4Building(1);

                    addBuildingPrice(cookie4_base_amount, mBuildings[3].numberOfC4Buildings());
                    Log.d(TAGS, "buildingPrice is: " + mPrice);
                    cookie4_amount = (int) mPrice;
                    mPrices = String.valueOf(+cookie4_amount);
                    mCookie4Price.setText(mPrices);

                    CPS += 10;
                    mCPS.setText("CPS: " + (CPS));
//                    Log.d(TAG, "mC4Number is: " + mBuildings[3].numberOfC4Buildings());
                    String result = String.format("%.0f", mBank.mBankBalance);
                    mBankDisplay.setText("" + result);
                }
            }
        });

        mCookie5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ((mBank.mBankBalance - cookie5_amount) >= 0) {
                    mBank.purchase(cookie5_amount);
                    mBuildings[4].addC5Building(1);

                    addBuildingPrice(cookie5_base_amount, mBuildings[4].numberOfC5Buildings());
                    Log.d(TAGS, "buildingPrice is: " + mPrice);
                    cookie5_amount = (int) mPrice;
                    mPrices = String.valueOf(+cookie5_amount);
                    mCookie5Price.setText(mPrices);

                    CPS += 40;
                    mCPS.setText("CPS: " + (CPS));
//                    Log.d(TAG, "mC5Number is: " + mBuildings[4].numberOfC5Buildings());
                    String result = String.format("%.0f", mBank.mBankBalance);
                    mBankDisplay.setText("" + result);
                }
            }
        });

        mCookie6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ((mBank.mBankBalance - cookie6_amount) >= 0) {
                    mBank.purchase(cookie6_amount);
                    mBuildings[5].addC6Building(1);

                    addBuildingPrice(cookie6_base_amount, mBuildings[5].numberOfC6Buildings());
                    Log.d(TAGS, "buildingPrice is: " + mPrice);
                    cookie6_amount = (int) mPrice;
                    mPrices = String.valueOf(+cookie6_amount);
                    mCookie6Price.setText(mPrices);

                    CPS += 100;
                    mCPS.setText("CPS: " + (CPS));
//                    Log.d(TAG, "mC6Number is: " + mBuildings[5].numberOfC6Buildings());
                    String result = String.format("%.0f", mBank.mBankBalance);
                    mBankDisplay.setText("" + result);
                }
            }
        });

        mCookie7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ((mBank.mBankBalance - cookie7_amount) >= 0) {
                    mBank.purchase(cookie7_amount);
                    mBuildings[6].addC7Building(1);

                    addBuildingPrice(cookie7_base_amount, mBuildings[6].numberOfC7Buildings());
                    Log.d(TAGS, "buildingPrice is: " + mPrice);
                    cookie7_amount = (int) mPrice;
                    mPrices = String.valueOf(+cookie7_amount);
                    mCookie7Price.setText(mPrices);

                    CPS += 400;
                    mCPS.setText("CPS: " + (CPS));
//                    Log.d(TAG, "mC6Number is: " + mBuildings[5].numberOfC6Buildings());
                    String result = String.format("%.0f", mBank.mBankBalance);
                    mBankDisplay.setText("" + result);
                }
            }
        });

        mCookie8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ((mBank.mBankBalance - cookie8_amount) >= 0) {
                    mBank.purchase(cookie8_amount);
                    mBuildings[7].addC8Building(1);

                    addBuildingPrice(cookie8_base_amount, mBuildings[7].numberOfC8Buildings());
                    Log.d(TAGS, "buildingPrice is: " + mPrice);
                    cookie8_amount = (int) mPrice;
                    mPrices = String.valueOf(+cookie8_amount);
                    mCookie8Price.setText(mPrices);

                    CPS += 6666;
                    mCPS.setText("CPS: " + (CPS));
//                    Log.d(TAG, "mC6Number is: " + mBuildings[5].numberOfC6Buildings());
                    String result = String.format("%.0f", mBank.mBankBalance);
                    mBankDisplay.setText("" + result);
                }
            }
        });
        mCookie9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ((mBank.mBankBalance - cookie9_amount) >= 0) {
                    mBank.purchase(cookie9_amount);
                    mBuildings[8].addC9Building(1);

                    addBuildingPrice(cookie9_base_amount, mBuildings[8].numberOfC9Buildings());
                    Log.d(TAGS, "buildingPrice is: " + mPrice);
                    cookie9_amount = (int) mPrice;
                    mPrices = String.valueOf(+cookie9_amount);
                    mCookie9Price.setText(mPrices);

                    CPS += 98765;
                    mCPS.setText("CPS: " + (CPS));
//                    Log.d(TAG, "mC6Number is: " + mBuildings[5].numberOfC6Buildings());
                    String result = String.format("%.0f", mBank.mBankBalance);
                    mBankDisplay.setText("" + result);
                }
            }
        });
        mCookie10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ((mBank.mBankBalance - cookie10_amount) >= 0) {
                    mBank.purchaselong(cookie10_amount);
                    mBuildings[9].addC10Building(1);

                    addBuildingPriceLong(cookie10_base_amount, mBuildings[9].numberOfC10Buildings());
                    Log.d(TAGS, "buildingPrice is: " + mPrice);
                    cookie10_amount = (int) mPrice;
                    mPrices = String.valueOf(+cookie10_amount);
                    mCookie7Price.setText(mPrices);

                    CPS += 999999;
                    mCPS.setText("CPS: " + (CPS));
//                    Log.d(TAG, "mC6Number is: " + mBuildings[5].numberOfC6Buildings());
                    String result = String.format("%.0f", mBank.mBankBalance);
                    mBankDisplay.setText("" + result);
                }
            }
        });

        mCookie11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ((mBank.mBankBalance - cookie11_amount) >= 0) {
//                    This purchase may not work.... if so use purchase long.
                    mBank.purchaselong(cookie11_amount);
                    mBuildings[10].addC11Building(1);
//                    Also may not work...
                    addBuildingPriceLong(cookie11_base_amount, mBuildings[10].numberOfC11Buildings());
                    cookie11_amount = (int) mPrice;
                    mPrices = String.valueOf(+cookie11_amount);
                    mCookie11Price.setText(mPrices);

                    CPS += 10000000;
                    mCPS.setText("CPS: " +(CPS));
//                    Log.d(TAG, "mC6Number is: " + mBuildings[5].numberOfC6Buildings());
                    String result = String.format("%.0f", mBank.mBankBalance);
                    mBankDisplay.setText("" + result);
                }
            }
        });




    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}



