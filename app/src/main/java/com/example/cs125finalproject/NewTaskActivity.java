package com.example.cs125finalproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.santalu.maskedittext.MaskEditText;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class NewTaskActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private EditText taskName;
    private Spinner priority;
    private EditText hours;
    private MaskEditText DOC;
    private Button addButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_task);

        taskName = findViewById(R.id.taskName);
        priority = findViewById(R.id.priority);
        hours = findViewById(R.id.hours);
        DOC = findViewById(R.id.DOC);
        addButton = findViewById(R.id.addButton);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.priority, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        priority.setAdapter(adapter);
        priority.setOnItemSelectedListener(this);

        taskName.addTextChangedListener(addButtonEnabler);
        hours.addTextChangedListener(addButtonEnabler);
        DOC.addTextChangedListener(addButtonEnabler);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
                setContentView(R.layout.activity_main);
            }
        });
    }

    private TextWatcher addButtonEnabler = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            String taskNameInput = taskName.getText().toString().trim();
            String hoursInput = hours.getText().toString();
            String hoursInputZeroTrimmed = hours.getText().toString().replaceAll("0", "");
            String dateInput = DOC.getText().toString();

            addButton.setEnabled(!taskNameInput.isEmpty() && !hoursInput.isEmpty() && !hoursInputZeroTrimmed.isEmpty() && validDate(dateInput));
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };

    private boolean validDate(String date) {
        SimpleDateFormat newDateFormat = new SimpleDateFormat("dd/MM/yy", Locale.US);
        try {
            Date newDate = newDateFormat.parse(date);
            String[] checkDate = date.split("/");
            if (Integer.parseInt(checkDate[0]) > 31 || Integer.parseInt(checkDate[1]) > 12 || Integer.parseInt(checkDate[2]) != 19) {
                throw new NullPointerException();
            }
            return newDate.after(new Date());
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
