package com.example.levoyage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DestinationDetails extends AppCompatActivity {

    private ImageView imageView;
    private TextView title;
    private TextView description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_destination_details);


        imageView = findViewById(R.id.details_image);
        title = findViewById(R.id.destination_title);
        description = findViewById(R.id.details_description);

        Bundle extras = getIntent().getExtras(); //get intend that passed from source activity and extras that was added to intent
        if (extras!=null) //Check is data passed to intent
        {
            setTitle(extras.getString(ExploreFragment.EXTRA_TITLE)); //Set action bar title to the news title
            imageView.setImageResource(extras.getInt(ExploreFragment.EXTRA_IMAGE)); //Set title text
            title.setText(extras.getString(ExploreFragment.EXTRA_TITLE)); //Set description text
            description.setText(extras.getString(ExploreFragment.EXTRA_DESCTIPRION)); //Set image source
        }
    }
}