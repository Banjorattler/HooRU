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
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    Toast message;
    TextView textViewName;
    EditText editTextName;
    DatePicker datePicker;
    Button buttonSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textViewName = findViewById(R.id.textViewName);
        initializeDatePicker();
        initializeAndValidate();
    }

    public void makeIntent(){
        Intent intent = new Intent(this, DisplayInfo.class);
        editTextName = (EditText) findViewById(R.id.editTextName);
        String name = editTextName.getText().toString();
        intent.putExtra("Name", name);
        datePicker = findViewById((R.id.datePicker));
        int day = datePicker.getDayOfMonth();
        intent.putExtra("Day", day);
        int month = datePicker.getMonth();
        intent.putExtra("Month", month);
        int year = datePicker.getYear();
        intent.putExtra("Year", year);
        String currentDate = currentDate();
        intent.putExtra("CurrentDate", currentDate);
        startActivity(intent);
    }

    public String currentDate(){
        return Calendar.getInstance().toString();
    }

    public void initializeDatePicker(){
        datePicker = findViewById(R.id.datePicker);
        datePicker.setCalendarViewShown(false);
        datePicker.setSpinnersShown(true);
        datePicker.setMaxDate(System.currentTimeMillis() - 1000);
        datePicker.getYear();
        datePicker.getMonth();
        datePicker.getDayOfMonth();
    }

    public void initializeAndValidate(){

        editTextName = findViewById(R.id.editTextName);
        buttonSubmit = findViewById(R.id.buttonSubmit);

        editTextName.setOnFocusChangeListener(new View.OnFocusChangeListener(){
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (editTextName.getText().toString().equals("")) {
                    buttonSubmit.setEnabled(false);
                    CharSequence errorButton = "Enter Name";
                    buttonSubmit.setText(errorButton);
                }else{
                    CharSequence validButton = "Submit";
                    buttonSubmit.setText(validButton);
                    buttonSubmit.setEnabled(true);
                    buttonSubmit.findFocus();
                    buttonSubmit.setOnClickListener(new View.OnClickListener(){
                        @Override
                        public void onClick(View v) {
                            makeIntent();
                        }
                    });
                }
            }
        });
    }
}
