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
    private static int cookie1_amount = 15;
    private int cookie2_amount = 100;
    private int cookie3_amount = 500;
    private int cookie4_amount = 3000;
    private int cookie5_amount = 10000;
    private int cookie6_amount = 40000;
    private int cookie7_amount = 10000;
    private double mPrice;
    private String mPrices;

    private static int cookie1_base_amount = 15;
    private static int cookie2_base_amount = 100;
    private static int cookie3_base_amount = 500;
    private static int cookie4_base_amount = 3000;
    private static int cookie5_base_amount = 10000;
    private static int cookie6_base_amount = 40000;
    private static int cookie7_base_amount = 10000;

    public int CPS = 0;
    private int timertest = 0;

    Button mCookie0;
    Button mCookie1;
    Button mCookie2;
    Button mCookie3;
    Button mCookie4;
    Button mCookie5;
    Button mCookie6;
    Button mCookie7;

    public TextView mCPS;
    public TextView mBankDisplay;
    TextView mCookie1Price;
    TextView mCookie2Price;
    TextView mCookie3Price;
    TextView mCookie4Price;
    TextView mCookie5Price;
    TextView mCookie6Price;
    TextView mCookie7Price;

    Bank mBank;

    public Building[] mBuildings;



    public TimerTask mTimerTask = new TimerTask() {
        @Override
        public void run() {
            timertest += 1;
            mBank.mBankBalance += (CPS / 10.0);
            mHandler.obtainMessage(1).sendToTarget();
            Log.d(COUNT, "Timer: " + timertest);
        }
    };



    //    May need to do something about this Handler
    private Handler mHandler = new Handler() {
        public void handleMessage(Message msg) {
            mCPS.setText("CPS: " + (CPS / 10.0));
            mBankDisplay.setText("" + mBank.getBalance());
        }
    };


    public double addBuildingPrice(int baseCost, double buildingNumber ){
        mPrice = baseCost * (Math.pow(1.15, buildingNumber));
        Log.d(TAG, "mPrice: " +mPrice);
        mPrice = Math.round(mPrice);
        return (int) mPrice;
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

        mBankDisplay = (TextView) findViewById(R.id.bankdisplay);
        mCPS = (TextView) findViewById(R.id.cpsdisplay);
        mCookie1Price = (TextView) findViewById(R.id.cookie1_price);
        mCookie2Price = (TextView) findViewById(R.id.cookie2_price);
        mCookie3Price = (TextView) findViewById(R.id.cookie3_price);
        mCookie4Price = (TextView) findViewById(R.id.cookie4_price);
        mCookie5Price = (TextView) findViewById(R.id.cookie5_price);
        mCookie6Price = (TextView) findViewById(R.id.cookie6_price);
        mCookie7Price = (TextView) findViewById(R.id.cookie7_price);

        mBank = new Bank();
        mBuildings = new Building[7];
        mBuildings[0] = new Building();
        mBuildings[1] = new Building();
        mBuildings[2] = new Building();
        mBuildings[3] = new Building();
        mBuildings[4] = new Building();
        mBuildings[5] = new Building();
        mBuildings[6] = new Building();

        mBankDisplay.setText("" + mBank.getBalance());
        mCPS.setText("CPS: " + (CPS / 10.0));

        mCookie0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mBank.deposit(cookie0_amount);
                mBankDisplay.setText("" + mBank.getBalance());
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
                    mPrices = String.valueOf(+mPrice);
                    mCookie1Price.setText(mPrices);
                        Log.d(TAGS, "buildingPrice is rounded: " +cookie1_amount);

                    CPS += 1;
                    mCPS.setText("CPS: " + (CPS / 10.0));
                    Log.d(TAG, "CPS = " + CPS);
//                    Log.d(TAG, "mC1Number is: " + mBuildings[0].numberOfC1Buildings());
                    mBankDisplay.setText("" + mBank.getBalance());

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
                    mPrices = String.valueOf(+mPrice);
                    mCookie2Price.setText(mPrices);

                    CPS += 5;
                    mCPS.setText("CPS: " + (CPS / 10.0));
//                    Log.d(TAG, "mC2Number is: " + mBuildings[1].numberOfC2Buildings());
                    mBankDisplay.setText("" + mBank.getBalance());
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
                    mPrices = String.valueOf(mPrice);
                    mCookie3Price.setText(mPrices);

                    CPS += 40;
                    mCPS.setText("CPS: " + (CPS / 10.0));

//                    Log.d(TAG, "mC3Number is: " + mBuildings[2].numberOfC3Buildings());
                    mBankDisplay.setText("" + mBank.getBalance());
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
                    mPrices = String.valueOf(mPrice);
                    mCookie4Price.setText(mPrices);

                    CPS += 100;
                    mCPS.setText("CPS: " + (CPS / 10.0));
//                    Log.d(TAG, "mC4Number is: " + mBuildings[3].numberOfC4Buildings());
                    mBankDisplay.setText("" + mBank.getBalance());
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
                    mPrices = String.valueOf(mPrice);
                    mCookie5Price.setText(mPrices);

                    CPS += 400;
                    mCPS.setText("CPS: " + (CPS / 10.0));
//                    Log.d(TAG, "mC5Number is: " + mBuildings[4].numberOfC5Buildings());
                    mBankDisplay.setText("" + mBank.getBalance());
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
                    mPrices = String.valueOf(mPrice);
                    mCookie6Price.setText(mPrices);

                    CPS += 1000;
                    mCPS.setText("CPS: " + (CPS / 10.0));
//                    Log.d(TAG, "mC6Number is: " + mBuildings[5].numberOfC6Buildings());
                    mBankDisplay.setText("" + mBank.getBalance());

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
                    mPrices = String.valueOf(mPrice);
                    mCookie7Price.setText(mPrices);

                    CPS += 4000;
                    mCPS.setText("CPS: " + (CPS / 10.0));
//                    Log.d(TAG, "mC6Number is: " + mBuildings[5].numberOfC6Buildings());
                    mBankDisplay.setText("" + mBank.getBalance());

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



