package com.example.cs125finalproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class StartActivity extends AppCompatActivity {

    private EditText maxNumhrs;
    private Button startButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start);

        maxNumhrs = findViewById(R.id.startMaxNumhrs);
        startButton = findViewById(R.id.startButton);

        maxNumhrs.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String input = maxNumhrs.getText().toString();
                String inputNoZeros = input.replaceAll("0", "");

                startButton.setEnabled(!input.equals("") && !inputNoZeros.equals(""));
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SettingsMenuActivity.userMaxNumHrs = Integer.toString(Integer.parseInt(maxNumhrs.getText().toString()));
                // Sets same value to another max num hrs variable in library.TaskOrganizer
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
                setContentView(R.layout.activity_main);
            }
        });
    }
}
