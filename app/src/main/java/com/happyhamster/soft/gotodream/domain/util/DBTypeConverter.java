package com.happyhamster.soft.gotodream.domain.util;

import android.arch.persistence.room.TypeConverter;

import java.util.Date;

/**
 * Created by Vilgodskiy_Sergey on 13.06.2017.
 */
public class DBTypeConverter {

    @TypeConverter
    public static Date fromTimestamp(Long value) {
        return value == null ? null : new Date(value);
    }

    @TypeConverter
    public static Long dateToTimestamp(Date date) {
        return date == null ? null : date.getTime();
    }
}
