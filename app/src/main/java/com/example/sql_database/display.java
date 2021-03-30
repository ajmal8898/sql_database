package com.example.sql_database;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class display extends AppCompatActivity {
    TextView userview;
    DatabaseAdapter databaseAdapter = new DatabaseAdapter(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        userview = (TextView) findViewById(R.id.username);

        String data = databaseAdapter.getData();
        if (data.isEmpty()) {
            userview.setText("No Data Found");
        } else {
            userview.setText(data);
        }
    }
}

