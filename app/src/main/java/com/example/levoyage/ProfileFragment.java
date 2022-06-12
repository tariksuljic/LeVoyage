package com.example.levoyage;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class ProfileFragment extends Fragment {
    public static final String USER_EXTRA = "MainActivity/EXTRA_USER_ID";
    private TextView username,name,lastname,email,dateofbirth,namesurname,gotoedit;
    private Button logoutButton;
    private User user;

    public ProfileFragment(User user) {
        this.user = user;
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile,
                container, false);
        username = view.findViewById(R.id.usernametv);
        name = view.findViewById(R.id.nametv);
        lastname = view.findViewById(R.id.lastNametv);
        email = view.findViewById(R.id.emailtv);
        dateofbirth = view.findViewById(R.id.birthdaytv);
        namesurname = view.findViewById(R.id.name_surname);

        username.setText(user.getUsername());
        name.setText(user.getName());
        lastname.setText(user.getSurname());
        email.setText(user.getEmail());
        dateofbirth.setText(user.getBirthYear());
        namesurname.setText(user.getName()+" "+user.getSurname());
        TextView gotoedit = view.findViewById(R.id.editProfileTV);
        gotoedit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), EditProfile.class);
                intent.putExtra(USER_EXTRA, user.getId());
                startActivity(intent);
            }
        });




        logoutButton = (Button) view.findViewById(R.id.button_logout);
        logoutButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(getActivity(), Login.class);
                startActivity(intent);
            }
        });
        return view;
    }

}
