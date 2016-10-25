package com.allenwu.leaksample;

import android.app.Activity;
import android.os.Bundle;
import android.os.SystemClock;

/**
 * Created by allen on 2016/10/23.
 */

public class Sample4Activity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample3);
        leakSample();
        finish();
    }

    private void leakSample() {
        new MyThread().start();
    }

    private  class MyThread extends Thread {
        @Override
        public void run() {
            while (true) {
                SystemClock.sleep(1000);
            }
        }
    }
}
