package com.allenwu.leaksample;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;

/**
 * Created by allen on 2016/10/18.
 */

public class Sample2Activity extends Activity {

    /**
     * Instances of static inner classes do not hold an implicit
     * reference to their outer class.
     */
    private static class MyHandler extends Handler {
        private final WeakReference<Sample2Activity> mActivity;

        public MyHandler(Sample2Activity activity) {
            mActivity = new WeakReference<Sample2Activity>(activity);
        }

        @Override
        public void handleMessage   (Message msg) {
            Sample2Activity activity = mActivity.get();
            if (activity != null) {
                // ...
            }
        }
    }

    private final MyHandler mHandler = new MyHandler(this);

    /**
     * Instances of anonymous classes do not hold an implicit
     * reference to their outer class when they are "static".
     */
    private static final Runnable sRunnable = new Runnable() {
        @Override
        public void run() { /* ... */ }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Post a message and delay its execution for 10 minutes.
        mHandler.postDelayed(sRunnable, 1000 * 60 * 10);
        // Go back to the previous Activity.
        finish();
    }
}
