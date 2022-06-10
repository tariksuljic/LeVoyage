package com.example.levoyage;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.AlertDialog;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class DestinationDetails extends AppCompatActivity {

    private static final int NOTIFICATION_ID = 0;
    private ImageView imageView;
    private TextView title;
    private TextView description;
    private TextView price;
    private Button book_button;

    public static final String CHANNEL_ID = "My channel";

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
        book_button = findViewById(R.id.book_button);


        Bundle extras = getIntent().getExtras(); //get intend that passed from source activity and extras that was added to intent
        if (extras!=null) //Check is data passed to intent
        {
            setTitle(extras.getString(ExploreFragment.EXTRA_TITLE)); //Set action bar title to the news title
            imageView.setImageResource(extras.getInt(ExploreFragment.EXTRA_IMAGE)); //Set title text
            title.setText(extras.getString(ExploreFragment.EXTRA_TITLE)); //Set description text
            description.setText(extras.getString(ExploreFragment.EXTRA_DESCRIPTION)); //Set image source
            price.setText("$"+extras.getInt(ExploreFragment.EXTRA_PRICE));//Set price text
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
        {
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, "Custom channel", NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);
            manager.cancel(NOTIFICATION_ID);
        }

        book_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new AlertDialog.Builder(DestinationDetails.this).setTitle("Le Voyage").setMessage("Congrats!\nYou have successfully booked your destination").show();
                Intent intent = new Intent(DestinationDetails.this, Notifications.class);
                PendingIntent pendingIntent = PendingIntent.getActivity(DestinationDetails.this, 0, intent, PendingIntent.FLAG_IMMUTABLE);

                NotificationCompat.Builder builder = new NotificationCompat.Builder(DestinationDetails.this, CHANNEL_ID);

                builder.setContentTitle("Le Voyage").setContentText("Congrats!\nYou have successfully booked your destination").setSmallIcon(R.mipmap.ic_launcher).addAction(R.mipmap.ic_launcher,"SNOOZE",pendingIntent);

                NotificationManagerCompat managerCompat = NotificationManagerCompat.from(DestinationDetails.this);
                managerCompat.notify(1, builder.build());
            }
        });
    }
}