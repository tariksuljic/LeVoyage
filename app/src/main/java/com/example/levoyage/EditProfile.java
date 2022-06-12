package com.example.levoyage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class EditProfile extends AppCompatActivity implements View.OnClickListener {

    Button buttonUpdate;
    EditText editTextName, editTextLastName, editTextPassword;
    User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        editTextName = (EditText) findViewById(R.id.nametv);
        editTextLastName = (EditText) findViewById(R.id.lastNametv);
        editTextPassword = (EditText) findViewById(R.id.editText_Password);
        buttonUpdate = (Button) findViewById(R.id.buttonUpdate);
        Bundle extras = getIntent().getExtras();
        int id = extras.getInt(ProfileFragment.USER_EXTRA);
        user = UserDatabase.getDatabase(this).myUserDAO().getUser(id);
        editTextName.setText(user.getName());
        editTextLastName.setText(user.getSurname());
        editTextPassword.setText(user.getPassword());



        buttonUpdate.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.buttonUpdate:
                String name = editTextName.getText().toString();
                String lastName = editTextLastName.getText().toString();
                String password = editTextPassword.getText().toString();
                user.setName(name);
                user.setSurname(lastName);
                user.setPassword(password);
                UserDatabase.getDatabase(this).myUserDAO().updateUser(user);
                Intent intent = new Intent(EditProfile.this, Home.class);
                startActivity(intent);


                break;
        }
    }
}