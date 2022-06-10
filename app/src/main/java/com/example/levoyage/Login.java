package com.example.levoyage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends AppCompatActivity implements View.OnClickListener{

    Button buttonLogin;
    EditText editTextUsername, editTextPassword;
    TextView textViewRegisterLink;

    public static final String USER_ID = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editTextUsername = (EditText) findViewById(R.id.editTextUsername);
        editTextPassword = (EditText) findViewById(R.id.editText_Password);

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

                User tempUser = MyDatabase.getDatabase(this).myUserDAO().checkIfLoginLegit(editTextUsername.getText().toString(), editTextPassword.getText().toString());

                if (tempUser == null)
                {
                    Toast.makeText(this, "User doesn't exist", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Intent intent = new Intent(Login.this, Home.class);
                    intent.putExtra(USER_ID, tempUser.getId());
                    startActivity(intent);
                }
                break;

            case R.id.textViewRegisterLink:
                startActivity(new Intent(this, Register.class));
                break;

        }
    }
}