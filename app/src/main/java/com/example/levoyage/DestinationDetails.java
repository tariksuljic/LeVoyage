package com.example.levoyage;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class DestinationDetails extends AppCompatActivity {

    public static final String EXTRA_IMAGE = "EXTRA_IMAGE";
    public static final String EXTRA_TITLE = "EXTRA_TITLE";
    public static final String EXTRA_DESCRIPTION = "EXTRA_DESCRIPTION";
    public static final String EXTRA_PRICE="EXTRA_PRICE";

    private ImageView imageView;
    private TextView title;
    private TextView description;
    private TextView price;
    private Button number;
    private Button book;
    private static final int CALL_REQUEST_CODE = 123;

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
        book=findViewById(R.id.book_button);
        number = findViewById(R.id.button_callUS);


        Bundle extras = getIntent().getExtras(); //get intend that passed from source activity and extras that was added to intent
        if (extras!=null) //Check is data passed to intent
        {
            setTitle(extras.getString(ExploreFragment.EXTRA_TITLE)); //Set action bar title to the news title
            imageView.setImageResource(extras.getInt(ExploreFragment.EXTRA_IMAGE)); //Set title text
            title.setText(extras.getString(ExploreFragment.EXTRA_TITLE)); //Set description text
            description.setText(extras.getString(ExploreFragment.EXTRA_DESCRIPTION)); //Set image source
            price.setText("$"+extras.getInt(ExploreFragment.EXTRA_PRICE));//Set price text
        }

        number.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if (ContextCompat.checkSelfPermission(DestinationDetails.this, Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {
                    {
                        onRequestPermissionsResult(CALL_REQUEST_CODE, new String[]{Manifest.permission.CALL_PHONE}, new int[]{PackageManager.PERMISSION_GRANTED});
                    }

                }
                else
                {

                    ActivityCompat.requestPermissions(DestinationDetails.this, new String[]{Manifest.permission.CALL_PHONE}, CALL_REQUEST_CODE);
                }

        }

    });
    }

    /*// Function to check and request permission
    public void checkPermission(String permission, int requestCode) {
        // Checking if permission is not granted
        if (ContextCompat.checkSelfPermission(DestinationDetails.this, Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_DENIED) {
            ActivityCompat.requestPermissions(DestinationDetails.this, new String[]{Manifest.permission.CALL_PHONE}, CALL_REQUEST_CODE);
        } else {
            Toast.makeText(DestinationDetails.this, "Permission already granted", Toast.LENGTH_SHORT).show();
        }
    }
    */


    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           @NonNull String[] permissions,
                                           @NonNull int[] grantResults)
    {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);


        if (requestCode == CALL_REQUEST_CODE) {
            if (grantResults.length > 0
                    && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Uri u = Uri.parse("tel: 0038761678862");

                // Create the intent and set the data for the
                // intent as the phone number.
                Intent i = new Intent(Intent.ACTION_DIAL, u);

                try {
                    // Launch the Phone app's dialer with a phone
                    // number to dial a call.
                    startActivity(i);
                } catch (SecurityException s) {
                    // show() method display the toast with
                    // exception message.
                    Toast.makeText(DestinationDetails.this, "Error", Toast.LENGTH_SHORT).show();
                }
            }
            else {
                Toast.makeText(DestinationDetails.this, "Call Permission Denied", Toast.LENGTH_SHORT).show();
            }
        }
    }


        public void book(View view){
            Bundle extras = getIntent().getExtras(); //get intend that passed from source activity and extras that was added to intent
            if (extras!=null) //Check is data passed to intent
            {
                Intent intent = new Intent(this, BookingActivity.class);
                intent.putExtra(EXTRA_TITLE,extras.getString(ExploreFragment.EXTRA_TITLE));
                intent.putExtra(EXTRA_PRICE,extras.getInt(ExploreFragment.EXTRA_PRICE));

                startActivity(intent);
            }

        }
}