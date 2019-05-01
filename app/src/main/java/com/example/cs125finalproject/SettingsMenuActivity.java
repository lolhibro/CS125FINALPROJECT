package com.example.cs125finalproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SettingsMenuActivity extends AppCompatActivity {

    public static String userMaxNumHrs = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings_menu);
    }
}
