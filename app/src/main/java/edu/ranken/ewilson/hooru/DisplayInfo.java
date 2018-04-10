package edu.ranken.ewilson.hooru;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


public class DisplayInfo extends AppCompatActivity  {

    TextView textViewDisplayInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_info);
        textViewDisplayInfo = findViewById(R.id.textViewDisplayInfo);

    }
}
