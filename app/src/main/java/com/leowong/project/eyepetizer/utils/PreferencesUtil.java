package com.leowong.project.eyepetizer.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by wangliugeng on 2015/6/9.
 */
public class PreferencesUtil {

    public static void writePreferences(Context mContext, String key, Object value) {
        if (value == null)
            return;
        String type = value.getClass().getSimpleName();
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(mContext);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        if ("Integer".equals(type)) {
            editor.putInt(key, (Integer) value);
        } else if ("Boolean".equals(type)) {
            editor.putBoolean(key, (Boolean) value);
        } else if ("String".equals(type)) {
            editor.putString(key, (String) value);
        } else if ("Float".equals(type)) {
            editor.putFloat(key, (Float) value);
        } else if ("Long".equals(type)) {
            editor.putLong(key, (Long) value);
        } else {
            Log.e("PreferencesUtil", "save value type error");
            return;
        }
        editor.apply();
    }

    public static void writePreferences(Context mContext, String fileName, String key, Object value) {
        if (value == null)
            return;
        String type = value.getClass().getSimpleName();
        SharedPreferences sharedPreferences = mContext.getSharedPreferences(fileName, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        if ("Integer".equals(type)) {
            editor.putInt(key, (Integer) value);
        } else if ("Boolean".equals(type)) {
            editor.putBoolean(key, (Boolean) value);
        } else if ("String".equals(type)) {
            editor.putString(key, (String) value);
        } else if ("Float".equals(type)) {
            editor.putFloat(key, (Float) value);
        } else if ("Long".equals(type)) {
            editor.putLong(key, (Long) value);
        } else {
            Log.e("PreferencesUtil", "save value type error");
            return;
        }
        editor.apply();
    }

    public static void writePreferences(Context mContext, String fileName, String key, List<String> values) {
        if (values == null)
            return;
        SharedPreferences sharedPreferences = mContext.getSharedPreferences(fileName, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Set<String> stringSet = new HashSet<>(values.size());
        for (String value : values) {
            stringSet.add(value);
        }
        editor.putStringSet(key, stringSet);
        editor.apply();
    }

    public static void writePreferences(Context mContext, String key, List<String> values) {
        if (values == null)
            return;
        String type = values.getClass().getSimpleName();
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(mContext);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Set<String> stringSet = new HashSet<>(values.size());
        for (String value : values) {
            stringSet.add(value);
        }
        editor.putStringSet(key, stringSet);
        editor.apply();
    }

    public static List<String> readPreferences(Context mContext, String key) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(mContext);
        Set<String> stringSet = sharedPreferences.getStringSet(key, null);
        List<String> values = new ArrayList<String>();
        if (stringSet != null) {
            for (String s : stringSet) {
                values.add(s);
            }
        }
        return values;
    }

    public static String readPreferences(Context context, String key, String defValue) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        return sharedPreferences.getString(key, defValue);
    }

    public static String readPreferences(Context context, String fileName, String key, String defValue) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(fileName, Context.MODE_PRIVATE);
        return sharedPreferences.getString(key, defValue);
    }

    public static int readPreferences(Context context, String key, int defValue) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        return sharedPreferences.getInt(key, defValue);
    }

    public static int readPreferences(Context context, String fileName, String key, int defValue) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(fileName, Context.MODE_PRIVATE);
        return sharedPreferences.getInt(key, defValue);
    }

    public static boolean readPreferences(Context context, String key, boolean defValue) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        return sharedPreferences.getBoolean(key, defValue);
    }

    public static boolean readPreferences(Context context, String fileName, String key, boolean defValue) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(fileName, Context.MODE_PRIVATE);
        return sharedPreferences.getBoolean(key, defValue);
    }
}
