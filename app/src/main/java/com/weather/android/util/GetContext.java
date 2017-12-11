package com.weather.android.util;

import android.app.Application;
import android.content.Context;

/**
 * Created by liqihao on 2017/11/28.
 */

public class GetContext extends Application{
    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
    }
    public static Context getContext() {
        return context;
    }
}
