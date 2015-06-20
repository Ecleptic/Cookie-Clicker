package com.example.cameron.cookieclicker;

import android.nfc.Tag;
import android.os.Build;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;


public class MainActivity extends ActionBarActivity {
    private static final String TAG = "MainActivity";
    private int cookie0_amount = 1;
    private int cookie1_amount = -15;
    private int cookie2_amount = -100;
    private int cookie3_amount = -500;
    private int cookie4_amount = -3000;
    private int cookie5_amount = -10000;
    private int cookie6_amount = -40000;


    Button mCookie0;
    Button mCookie1;
    Button mCookie2;
    Button mCookie3;
    Button mCookie4;
    Button mCookie5;
    Button mCookie6;
    Button mCookie7;
    TextView mBankDisplay;
    Bank mBank;


    public Building[] mBuildings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBank = new Bank();

        mBankDisplay = (TextView) findViewById(R.id.bankdisplay);

        mCookie0 = (Button) findViewById(R.id.cookie0);


        mCookie1 = (Button) findViewById(R.id.cookie1);
        mCookie2 = (Button) findViewById(R.id.cookie2);
        mCookie3 = (Button) findViewById(R.id.cookie3);
        mCookie4 = (Button) findViewById(R.id.cookie4);
        mCookie5 = (Button) findViewById(R.id.cookie5);
        mCookie6 = (Button) findViewById(R.id.cookie6);


        mBuildings = new Building[6];
        mBuildings[0] = new Building();
        mBuildings[1] = new Building();
        mBuildings[2] = new Building();
        mBuildings[3] = new Building();
        mBuildings[4] = new Building();
        mBuildings[5] = new Building();


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
                    mBankDisplay.setText("" + mBank.getBalance());
                }
            }
        });

        mCookie2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ((mBank.mBankBalance + cookie2_amount) >= 0) {
                    mBank.deposit(cookie2_amount);
                    mBankDisplay.setText("" + mBank.getBalance());
                }
            }
        });

        mCookie3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ((mBank.mBankBalance + cookie3_amount) >= 0) {
                    mBank.deposit(cookie3_amount);
                    mBankDisplay.setText("" + mBank.getBalance());
                }
            }
        });

        mCookie4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ((mBank.mBankBalance + cookie4_amount) >= 0) {
                    mBank.deposit(cookie4_amount);
                    mBankDisplay.setText("" + mBank.getBalance());
                }
            }
        });

        mCookie5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ((mBank.mBankBalance + cookie5_amount) >= 0) {
                    mBank.deposit(cookie5_amount);
                    mBankDisplay.setText("" + mBank.getBalance());
                }
            }
        });

        mCookie6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Log.d(TAG, "bank balance + cookie amount... " + (mBank.mBankBalance + cookie6_amount));
                if ((mBank.mBankBalance + cookie6_amount) >= 0) {
                    mBank.deposit(cookie6_amount);
                    mBankDisplay.setText("" + mBank.getBalance());
//                    Log.d(TAG, "bank Balance after setting text is " + mBank.mBankBalance);

                } else {
//                    Log.d(TAG, "bank Balance is " + mBank.mBankBalance);
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



