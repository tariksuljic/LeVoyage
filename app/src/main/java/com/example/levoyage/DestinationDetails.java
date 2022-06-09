package com.example.levoyage;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class DestinationDetails extends AppCompatActivity {

    private ImageView imageView;
    private TextView title;
    private TextView description;
    private TextView price;
    private FloatingActionButton mapButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_destination_details);

        ActionBar actionBar=getSupportActionBar();
        actionBar.setHomeAsUpIndicator(R.drawable.back_button);


        imageView = findViewById(R.id.details_image);
        title = findViewById(R.id.destination_title);
        description = findViewById(R.id.details_description);
        price=findViewById(R.id.destination_price);
        mapButton = findViewById(R.id.floating_location_button);


        Bundle extras = getIntent().getExtras(); //get intend that passed from source activity and extras that was added to intent
        if (extras!=null) //Check is data passed to intent
        {
            //setTitle(extras.getString(ExploreFragment.EXTRA_TITLE)); //Set action bar title to the news title
            setTitle(null);
            imageView.setImageResource(extras.getInt(ExploreFragment.EXTRA_IMAGE)); //Set title text
            title.setText(extras.getString(ExploreFragment.EXTRA_TITLE)); //Set description text
            description.setText(extras.getString(ExploreFragment.EXTRA_DESCRIPTION)); //Set image source
            price.setText("$"+extras.getInt(ExploreFragment.EXTRA_PRICE));//Set price text
        }
    }



}