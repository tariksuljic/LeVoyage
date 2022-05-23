package com.example.levoyage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Login extends AppCompatActivity implements View.OnClickListener{

    Button buttonLogin;
    EditText editTextUsername, editTextPassword;
    TextView textViewRegisterLink;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editTextUsername = (EditText) findViewById(R.id.editTextUsername);
        editTextPassword = (EditText) findViewById(R.id.editTextPassword);

        buttonLogin = (Button) findViewById(R.id.buttonLogin);
        textViewRegisterLink = (TextView) findViewById(R.id.textViewRegisterLink);
        buttonLogin.setOnClickListener(this);
        textViewRegisterLink.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.buttonLogin:

                startActivity(new Intent(this, Home.class));
                break;
            case R.id.textViewRegisterLink:
                startActivity(new Intent(this, Register.class));
                break;

        }
    }
}