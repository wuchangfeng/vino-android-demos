package com.wu.allen.valueandobjectdemo;

import android.animation.TypeEvaluator;

/**
 * Created by allen on 2016/9/5.
 */

public class PointEvaluator implements TypeEvaluator {

    @Override
    public Object evaluate(float fraction, Object startValue, Object endValue) {
        // 强转成 point 对象
        Point startPoint = (Point) startValue;
        Point endPoint = (Point) endValue;
        // 根据 fraction 来获得当前动画的坐标值
        float x = startPoint.getX() + fraction * (endPoint.getX() - startPoint.getX());
        float y = startPoint.getY() + fraction * (endPoint.getY() - startPoint.getY());
        // 封装到新的 point 中返回
        Point point = new Point(x, y);
        return point;
    }
}
