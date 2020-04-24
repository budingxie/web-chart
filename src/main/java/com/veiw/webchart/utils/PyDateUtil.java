package com.veiw.webchart.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author pengyou@xiaomi.com
 * @date 2020/4/24
 */
public class PyDateUtil {
    /**
     * 日期转化
     * 2018-08-11T17:03:39.300928+08:00
     * 2018-08-11 17:04:09
     *
     * @param timeStr 2018-08-11T17:03:39.300928+08:00
     * @return 2018-08-11 17:04:09
     */
    public static String dateStr2formatStr(String timeStr) throws ParseException {
        String str = "";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSSSSX");
        Date date = sd.parse(timeStr);
        str = sdf.format(date);
        return str;
    }
}
