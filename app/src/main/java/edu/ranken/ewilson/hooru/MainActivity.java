package edu.ranken.ewilson.hooru;

import android.app.DatePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    TextView textViewName;
    EditText editTextName;
    DatePicker datePicker;
    Button buttonSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewName = findViewById(R.id.textViewName);
        editTextName = findViewById(R.id.editTextName);
        initializeDatePicker();
        buttonSubmit = findViewById(R.id.buttonSubmit);
    }

    public void initializeDatePicker(){

        datePicker = findViewById(R.id.datePicker);
        datePicker.setCalendarViewShown(false);
        datePicker.setSpinnersShown(true);

    }
}
