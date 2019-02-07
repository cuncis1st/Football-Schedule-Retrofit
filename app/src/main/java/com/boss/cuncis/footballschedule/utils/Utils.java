package com.boss.cuncis.footballschedule.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Utils {
    public static String getDate(String inputDate) {
        Date parsed = null;
        String outputDate = "";

        SimpleDateFormat df_input = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
        SimpleDateFormat df_output = new SimpleDateFormat("E, dd MMM yyyy", Locale.US);

        try {
            parsed = df_input.parse(inputDate);
            outputDate = df_output.format(parsed);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return outputDate;
    }
}
