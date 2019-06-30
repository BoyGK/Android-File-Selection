package com.gkpoter.localfileselectionlibrary.util;

import android.util.Log;

public class LOG {

    private static final String TAG = "com.baiguoqing.LOG";
    private static boolean debug = true;

    public static void i(String msg) {
        if (debug) {
            Log.i(TAG, "BGQ: " + msg);
        }
    }

    public static void i(String tag, String msg) {
        if (debug) {
            Log.i(tag, "BGQ: " + msg);
        }
    }

}