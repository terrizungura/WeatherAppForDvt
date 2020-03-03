package com.tererai.weatherapp.utils;

import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateUtil {
    private static String DAY_FORMAT = "EEEE";
    private static String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";

    private static final String TAG = DateUtil.class.getSimpleName();

    public static String getDay(String currentDate) {
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATE_FORMAT, Locale.getDefault());
            SimpleDateFormat simpleDayFormat = new SimpleDateFormat(DAY_FORMAT, Locale.getDefault());
            Date date = simpleDateFormat.parse(currentDate);
            return simpleDayFormat.format(date);
        } catch (Exception ex) {
            Log.e(TAG, "DateUtil Exception: " + ex.getMessage());
        }
        return "Unknown Day";
    }
}
