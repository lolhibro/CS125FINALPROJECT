package com.example.cs125finalproject;

import android.app.Application;
import android.content.Context;

public class getMainActivityContext extends Application {

    private static Context mContext;

    public static Context getContext() {
        return mContext;
    }

    public static void setContext(Context c) {
        mContext = c;
    }
}
