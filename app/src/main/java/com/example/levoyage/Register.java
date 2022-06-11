package com.example.levoyage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Register extends AppCompatActivity implements View.OnClickListener {

    Button buttonRegister;
    EditText editTextName, editTextLastName, editTextAge, editTextUsernameRegister, editTextEmail, editTextPassword;

    public static final String USER_ID = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        editTextName = (EditText) findViewById(R.id.editTextName);
        editTextLastName = (EditText) findViewById(R.id.editTextLastName);
        editTextAge = (EditText) findViewById(R.id.editTextAge);
        editTextUsernameRegister = (EditText) findViewById(R.id.editTextUsernameRegister);
        editTextEmail = (EditText) findViewById(R.id.editTextEmail);
        editTextPassword = (EditText) findViewById(R.id.editText_Password);
        buttonRegister = (Button) findViewById(R.id.buttonRegister);

        buttonRegister.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.buttonRegister:
                String new_user_username = editTextUsernameRegister.getText().toString();

                User tempUser = null;
                tempUser = UserDatabase.getDatabase(this).myUserDAO().getUserByUsername(new_user_username);


                if (tempUser == null)
                {
                    User newUser = new User(editTextName.getText().toString(), editTextLastName.getText().toString()
                                            ,editTextEmail.getText().toString(),Integer.parseInt(editTextAge.getText().toString()),editTextUsernameRegister.getText().toString(),editTextPassword.getText().toString());
                    UserDatabase.getDatabase(this).myUserDAO().addUser(newUser);

                    int new_id = UserDatabase.getDatabase(this).myUserDAO().getUserIDByUsername(editTextUsernameRegister.getText().toString());

                    Intent intent = new Intent(Register.this, Login.class);
                    intent.putExtra(USER_ID, new_id);
                    startActivity(intent);
                }
                else
                {
                    Toast.makeText(this, "Username is not available", Toast.LENGTH_SHORT).show();
                }

                break;
        }
    }
}