package com.example.sql_database;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void addUser(View view) {
        Intent intent = new Intent(this, Save.class);
        startActivity(intent);
    }

    public void viewUser(View view) {
        Intent intent = new Intent(this, display.class);
        startActivity(intent);
    }
}
