package com.example.cameron.cookieclicker;

import android.os.Handler;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {
    private static final String TAG = "MainActivity";

    private int cookie0_amount = 1;
    private int cookie1_amount = -15;
    private int cookie2_amount = -100;
    private int cookie3_amount = -500;
    private int cookie4_amount = -3000;
    private int cookie5_amount = -10000;
    private int cookie6_amount = -40000;
    private long CPS = 0;


    Button mCookie0;
    Button mCookie1;
    Button mCookie2;
    Button mCookie3;
    Button mCookie4;
    Button mCookie5;
    Button mCookie6;
    Button mCookie7;

    TextView mBankDisplay;
    TextView mCPS;
    TextView mCookie1Price;
    TextView mCookie2Price;
    TextView mCookie3Price;
    TextView mCookie4Price;
    TextView mCookie5Price;
    TextView mCookie6Price;

    Bank mBank;

    public Building[] mBuildings;

    private Handler mHandler = new Handler();
    private boolean wasRun = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBank = new Bank();


        mCookie0 = (Button) findViewById(R.id.cookie0);

        mCookie1 = (Button) findViewById(R.id.cookie1);
        mCookie2 = (Button) findViewById(R.id.cookie2);
        mCookie3 = (Button) findViewById(R.id.cookie3);
        mCookie4 = (Button) findViewById(R.id.cookie4);
        mCookie5 = (Button) findViewById(R.id.cookie5);
        mCookie6 = (Button) findViewById(R.id.cookie6);

        mBankDisplay = (TextView) findViewById(R.id.bankdisplay);
        mCPS = (TextView) findViewById(R.id.cps);
        mCookie1Price = (TextView) findViewById(R.id.cookie1_price);
        mCookie2Price = (TextView) findViewById(R.id.cookie2_price);
        mCookie3Price = (TextView) findViewById(R.id.cookie3_price);
        mCookie4Price = (TextView) findViewById(R.id.cookie4_price);
        mCookie5Price = (TextView) findViewById(R.id.cookie5_price);
        mCookie6Price = (TextView) findViewById(R.id.cookie6_price);

        mBuildings = new Building[6];
        mBuildings[0] = new Building();
        mBuildings[1] = new Building();
        mBuildings[2] = new Building();
        mBuildings[3] = new Building();
        mBuildings[4] = new Building();
        mBuildings[5] = new Building();


        mBankDisplay.setText("" + mBank.getBalance());


        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (wasRun) {
                    mCPS.setText("" +CPS);
                    //whatever you want to do if run
                    //you can add you want to increase variable here
                }
                mHandler.postDelayed(this, 1000);
            }
        }1000); // 1 seconds


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
                if ((mBank.mBankBalance + cookie1_amount) >= 0) {
                    mBank.deposit(cookie1_amount);
                    mBuildings[0].addC1Building(1);
                    CPS += 1;
                    Log.d(TAG, "CPS = " + CPS);
//                    Log.d(TAG, "mC1Number is: " + mBuildings[0].numberOfC1Buildings());
                    mBankDisplay.setText("" + mBank.getBalance());
                }
            }
        });

        mCookie2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ((mBank.mBankBalance + cookie2_amount) >= 0) {
                    mBank.deposit(cookie2_amount);
                    mBuildings[1].addC2Building(1);
//                    Log.d(TAG, "mC2Number is: " + mBuildings[1].numberOfC2Buildings());
                    mBankDisplay.setText("" + mBank.getBalance());
                }
            }
        });

        mCookie3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ((mBank.mBankBalance + cookie3_amount) >= 0) {
                    mBank.deposit(cookie3_amount);
                    mBuildings[2].addC3Building(1);
//                    Log.d(TAG, "mC3Number is: " + mBuildings[2].numberOfC3Buildings());
                    mBankDisplay.setText("" + mBank.getBalance());
                }
            }
        });

        mCookie4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ((mBank.mBankBalance + cookie4_amount) >= 0) {
                    mBank.deposit(cookie4_amount);
                    mBuildings[3].addC4Building(1);
//                    Log.d(TAG, "mC4Number is: " + mBuildings[3].numberOfC4Buildings());
                    mBankDisplay.setText("" + mBank.getBalance());
                }
            }
        });

        mCookie5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ((mBank.mBankBalance + cookie5_amount) >= 0) {
                    mBank.deposit(cookie5_amount);
                    mBuildings[4].addC5Building(1);
//                    Log.d(TAG, "mC5Number is: " + mBuildings[4].numberOfC5Buildings());
                    mBankDisplay.setText("" + mBank.getBalance());
                }
            }
        });

        mCookie6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ((mBank.mBankBalance + cookie6_amount) >= 0) {
                    mBank.deposit(cookie6_amount);
                    mBuildings[5].addC6Building(1);
//                    Log.d(TAG, "mC6Number is: " + mBuildings[5].numberOfC6Buildings());
                    mBankDisplay.setText("" + mBank.getBalance());

                } else {
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



