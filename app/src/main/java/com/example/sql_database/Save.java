package com.example.sql_database;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Save extends AppCompatActivity {

    EditText etUsername, etnumber;
    DatabaseAdapter databaseAdapter = new DatabaseAdapter(this);
    long id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save);

        etUsername = (EditText) findViewById(R.id.etUsername);
        etnumber = (EditText) findViewById(R.id.etnumber);
    }

    public void saveData(View view) {
        String userName = etUsername.getText().toString();
        String userPhonenumber = etnumber.getText().toString();
        etUsername.setText("");
        etnumber.setText("");
        if (userName.isEmpty()) {
            etUsername.setError("Field cannot be empty");
        } else if (userPhonenumber.isEmpty()) {
            etnumber.setError("Field cannot be empty");
        } else {
            id = databaseAdapter.insertData(userName, userPhonenumber);
            if (id < 0) {
                Toast toast = Toast.makeText(getApplicationContext(), "added Unsuccesfull!", Toast.LENGTH_SHORT);
                toast.show();
            } else {
                Toast toast = Toast.makeText(getApplicationContext(), "added Successfully", Toast.LENGTH_SHORT);
                toast.show();
            }
        }
    }
}