package com.company.course.web.utils;

import java.util.Date;

public class TimeUtils {
    public static int getSecondTimestamp(Date date){
        if (null == date) { return 0; }
        String timestamp = String.valueOf(date.getTime()/1000);
        return Integer.valueOf(timestamp);
    }
}
