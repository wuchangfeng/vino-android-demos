package com.wu.allen.valueandobjectdemo;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.BounceInterpolator;

/**
 * Created by allen on 2016/9/5.
 */

public class MyAnimView extends View {
    public static final float RADIUS = 50f;

    private Point currentPoint;

    private Paint mPaint;

    private String color;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
        mPaint.setColor(Color.parseColor(color));
        invalidate();
    }

    public MyAnimView(Context context, AttributeSet attrs) {
        super(context, attrs);
        // 初始化画笔 paint
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setColor(Color.BLUE);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        // 绘制的逻辑由 currentPoint 对象控制
        if (currentPoint == null) {
            currentPoint = new Point(RADIUS, RADIUS);
            drawCircle(canvas);
            startAnimation();
        } else {
            drawCircle(canvas);
        }
    }

    private void drawCircle(Canvas canvas) {
        float x = currentPoint.getX();
        float y = currentPoint.getY();
        canvas.drawCircle(x, y, RADIUS, mPaint);
    }

    private void startAnimation() {
        Point startPoint = new Point(RADIUS, RADIUS);
        Point anotherPoint = new Point(getWidth()/2,getHeight() - RADIUS);
        Point endPoint = new Point(getWidth() - RADIUS, RADIUS);
        // 观察一下 ofObject() 方法
        ValueAnimator anim = ValueAnimator.ofObject(new PointEvaluator(), startPoint,anotherPoint,endPoint);
        // point 值变化 该方法就会被调用
        anim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                // 重新对 currentPoint 对象进行复制
                currentPoint = (Point) animation.getAnimatedValue();
                // 调用 invalidate() 方法 onDraw() 方法就会重新调用，此时 currentPoint
                // 对象的坐标已经改变
                invalidate();
            }
        });
        anim.setInterpolator(new BounceInterpolator());
        //anim.setInterpolator(new AccelerateInterpolator(2f));
        ObjectAnimator anim2 = ObjectAnimator.ofObject(this, "color", new ColorEvaluator(),
            "#0000FF", "#FF0000");
        AnimatorSet animSet = new AnimatorSet();
        animSet.play(anim).with(anim2);
        animSet.setDuration(5000);
        animSet.start();
    }
}
