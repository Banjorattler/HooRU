package edu.ranken.ewilson.hooru;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.Button;
import android.widget.Toast;

import java.time.Year;
import java.util.Calendar;

import static android.provider.AlarmClock.EXTRA_MESSAGE;


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

        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makeIntent();
        }
        });

    }

    public void makeIntent(){
        Intent intent = new Intent(this, DisplayInfo.class);
        editTextName = (EditText) findViewById(R.id.editTextName);
        String message = editTextName.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }

    public void initializeDatePicker(){
        datePicker = findViewById(R.id.datePicker);
        datePicker.setCalendarViewShown(false);
        datePicker.setSpinnersShown(true);
        datePicker.setMaxDate(System.currentTimeMillis() - 1000);
    }

    public void datePicked (){

        int day = datePicker.getDayOfMonth();
        int month = datePicker.getMonth();
        int year = datePicker.getYear();
        Calendar currentTime = Calendar.getInstance();

        if((year > currentTime.get(Calendar.YEAR) || (month > currentTime.get(Calendar.MONTH)) || year > currentTime.get(Calendar.DAY_OF_MONTH))){
            Toast.makeText(this, "Enter a date that is not a future date.", Toast.LENGTH_LONG).show();
            buttonSubmit.setEnabled(false);
        }else{
            buttonSubmit.setEnabled(true);
        }

    }
}
