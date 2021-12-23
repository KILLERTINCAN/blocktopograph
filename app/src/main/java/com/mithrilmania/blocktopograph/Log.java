package com.mithrilmania.blocktopograph;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;

import java.io.PrintWriter;
import java.io.StringWriter;

public class Log {

    public static final String ANA_PARAM_CREATE_WORLD_TYPE = "cw_type";
    public static final String ANA_PARAM_MAINACT_MENU_TYPE = "mam_type";
    public static final int ANA_PARAM_MAINACT_MENU_TYPE_OPEN = 123;
    public static final int ANA_PARAM_MAINACT_MENU_TYPE_HELP = 130;
    public static final int ANA_PARAM_MAINACT_MENU_TYPE_ABOUT = 199;

    private static final String LOG_TAG = "Blocktopo";

//    private static PrintWriter mFileLogger;

    private static String prependClassName(@NonNull Object caller, @NonNull String msg) {
        Class<?> clazz = caller instanceof Class ? (Class<?>) caller : caller.getClass();
        return clazz.getSimpleName() + ": " + msg;
    }

    public static void d(@NonNull Object caller, @NonNull String msg) {
        android.util.Log.d(LOG_TAG, prependClassName(caller, msg));
    }

    public static void d(@NonNull Object caller, @NonNull Throwable throwable) {
        StringWriter sw = new StringWriter(4096);
        PrintWriter pw = new PrintWriter(sw);
        throwable.printStackTrace(pw);
        android.util.Log.e(LOG_TAG, prependClassName(caller, sw.toString()));
        pw.close();
    }

    public static void e(@NonNull Object caller, @NonNull String msg) {
        d(caller, msg);
    }

    public static void e(@NonNull Object caller, @NonNull Throwable throwable) {
        d(caller, throwable);
    }
}
