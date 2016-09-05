package com.wu.allen.propetyanimationdemo;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button btn1,btn2,btn3,btn4,btn5,btn6;
    TextView tv1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn3 = (Button) findViewById(R.id.btn3);
        btn4 = (Button) findViewById(R.id.btn4);
        btn5 = (Button) findViewById(R.id.btn5);
        btn6 = (Button) findViewById(R.id.btn6);
        tv1 = (TextView)findViewById(R.id.tv1);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn1:
                valueAnimator();
                break;
            case R.id.btn2:
                objectAnimator1();
                break;
            case R.id.btn3:
                objectAnimator2();
                break;
            case R.id.btn4:
                objectAnimator3();
                break;
            case R.id.btn5:
                objectAnimator4();
                break;
            case R.id.btn6:
                objectAnimator5();
                break;

        }

    }

    /**
     * AnimatorSet 来进行组合动画
     */
    private void objectAnimator5() {
        ObjectAnimator moveIn = ObjectAnimator.ofFloat(tv1, "translationX", -500f, 0f);
        ObjectAnimator rotate = ObjectAnimator.ofFloat(tv1, "rotation", 0f, 360f);
        ObjectAnimator fadeInOut = ObjectAnimator.ofFloat(tv1, "alpha", 1f, 0f, 1f);
        AnimatorSet animSet = new AnimatorSet();
        animSet.play(rotate).with(fadeInOut).after(moveIn);
        animSet.setDuration(5000);
        animSet.start();

        animSet.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                Toast.makeText(MainActivity.this,"AnimatorSet end",Toast.LENGTH_LONG).show();
            }
        });
    }

    private void objectAnimator4() {
        ObjectAnimator animator = ObjectAnimator.ofFloat(tv1, "scaleY", 1f, 3f, 1f);
        animator.setDuration(5000);
        animator.start();
    }

    private void objectAnimator3() {
        // 获取 tv1 当前的 translationX 位置
        float curTranslationX = tv1.getTranslationX();
        ObjectAnimator animator = ObjectAnimator.ofFloat(tv1, "translationX", curTranslationX, -500f, curTranslationX);
        animator.setDuration(5000);
        animator.start();
    }

    private void objectAnimator2() {
        ObjectAnimator animator = ObjectAnimator.ofFloat(tv1, "rotation", 0f, 360f);
        animator.setDuration(5000);
        animator.start();
    }

    private void objectAnimator1() {
        ObjectAnimator an = ObjectAnimator.ofFloat(tv1,"alpha",1f,0f,1f);
        an.setDuration(5000);
        an.start();
    }

    private void valueAnimator() {
        ValueAnimator anim = ValueAnimator.ofFloat(0f, 1f);
        anim.setDuration(300);
        anim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float currentValue = (float) animation.getAnimatedValue();
                Log.d("TAG", "cuurent value is " + currentValue);
            }
        });
        anim.start();
    }
}
