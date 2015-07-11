package com.example.cameron.cookieclicker;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.Serializable;
import java.util.Timer;
import java.util.TimerTask;


public class UpgradesActivity extends ActionBarActivity {
    private static final String TAG = "MainActivity";
    private static final String TAGS = "CookiePrices";
    private static final String COUNT = "Count";
    public static final String EXTRA = "CPS";

    private int cookie0_amount = 1;
    Button mCookie0;
    public TextView mCPS;
    public TextView mBankDisplay;
    Bank mBank;
    public Serializable CPS;



    public TimerTask mTimerTask = new TimerTask() {
        @Override
        public void run() {
//            timertest += 1;
            mBank.mBankBalance += ((int) CPS/ 10);
            mHandler.obtainMessage(1).sendToTarget();
//            Log.d(COUNT, "Timer: " + timertest);
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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        CPS = getIntent().getStringExtra(EXTRA);

        Timer mTimer = new Timer();
        mTimer.scheduleAtFixedRate(mTimerTask, 1000, 100);

        mCookie0 = (Button) findViewById(R.id.cookie0);
        mBankDisplay = (TextView) findViewById(R.id.bankdisplay);
        mCPS = (TextView) findViewById(R.id.cpsdisplay);
        mBank = new Bank();
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

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_settings, menu);
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
