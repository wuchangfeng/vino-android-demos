package com.allenwu.tempatureview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TempatureView tempatureView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tempatureView = (TempatureView) findViewById(R.id.temp_control);
        tempatureView.setTemp(15, 30, 15);

        tempatureView.setOnTempChangeListener(new TempatureView.OnTempChangeListener() {
            @Override
            public void change(int temp) {
                Toast.makeText(MainActivity.this, temp + "°", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
