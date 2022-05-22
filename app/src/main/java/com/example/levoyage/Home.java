package com.example.levoyage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Home extends AppCompatActivity implements View.OnClickListener {

    Button buttonLogout;
    EditText editTextName, editTextAge, editTextUsername;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        editTextName = (EditText) findViewById(R.id.editTextName);
        editTextAge = (EditText) findViewById(R.id.editTextAge);
        editTextUsername= (EditText) findViewById(R.id.editTextUsername);

        buttonLogout = (Button) findViewById(R.id.buttonLogout);


        buttonLogout.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.buttonLogout:
                startActivity(new Intent(this, Login.class));
                break;
        }
    }
}