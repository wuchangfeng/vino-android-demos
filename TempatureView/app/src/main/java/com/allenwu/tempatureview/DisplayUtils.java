package com.allenwu.tempatureview;

import android.content.Context;
import android.util.TypedValue;

/**
 * Created by allen on 2016/12/16.
 */

public class DisplayUtils {

    public static int dp2px(float dp,Context context) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp,
                context.getResources().getDisplayMetrics());
    }

    public static int sp2px(float sp,Context context) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, sp,
                context.getResources().getDisplayMetrics());
    }
}
