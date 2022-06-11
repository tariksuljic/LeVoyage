package com.example.levoyage;

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
import android.widget.TextView;

public class BookingActivity extends AppCompatActivity {


    private TextView title,fullName,email,numberOfPersons,totalPrice;
    private Button increment,decrement,book;
    int count=0;
    public static final String CHANNEL_ID = "My channel";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);

        title=findViewById(R.id.booking_title);
        fullName=findViewById(R.id.full_name);
        email=findViewById(R.id.email);
        numberOfPersons=findViewById(R.id.number_of_persons);
        totalPrice=findViewById(R.id.total_price);
        increment=findViewById(R.id.increment_button);
        decrement=findViewById(R.id.decrement_button);
        book=findViewById(R.id.book_now_button);


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
        {
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, "Custom Channel", NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);
        }


        increment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count++;
                numberOfPersons.setText(" "+count);
            }
        });

        decrement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(count<=0) count=0;
                else count--;

                numberOfPersons.setText(" "+count);


            }
        });

        book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(BookingActivity.this).setTitle("Le Voyage").setMessage("Congrats!\nYou have successfully booked your destination").show();
                Intent intent = new Intent(BookingActivity.this, Home.class);
                PendingIntent pendingIntent = PendingIntent.getActivity(BookingActivity.this, 0, intent, PendingIntent.FLAG_IMMUTABLE);

                NotificationCompat.Builder builder = new NotificationCompat.Builder(BookingActivity.this, CHANNEL_ID);

                builder.setContentTitle("Le Voyage").setContentText("Congrats!\nYou have successfully booked your destination").setSmallIcon(R.mipmap.ic_launcher).addAction(R.mipmap.ic_launcher,"SNOOZE",pendingIntent);

                NotificationManagerCompat managerCompat = NotificationManagerCompat.from(BookingActivity.this);
                managerCompat.notify(1, builder.build());
            }
        });


    }






}