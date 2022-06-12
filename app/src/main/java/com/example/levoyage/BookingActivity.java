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
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class BookingActivity extends AppCompatActivity {


    private TextView title, totalPrice,date;
    private Button book;
    private ImageView image;
    public static final String CHANNEL_ID = "My channel";
    private int id;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeAsUpIndicator(R.drawable.back_button);

        Bundle extras=getIntent().getExtras();
        title=findViewById(R.id.booking_title);
        totalPrice=findViewById(R.id.total_price);
        book=findViewById(R.id.book_now_button);
        image=findViewById(R.id.booked_image);
        date=findViewById(R.id.date);

        if(extras!=null){
            id=extras.getInt(DestinationDetails.USER_ID);
            setTitle(extras.getString(DestinationDetails.EXTRA_TITLE));
            title.setText(extras.getString(DestinationDetails.EXTRA_TITLE));
            Log.d("PRICE",""+extras.getString(DestinationDetails.EXTRA_PRICE));
            totalPrice.setText(extras.getString(DestinationDetails.EXTRA_PRICE));
            date.setText(extras.getString(DestinationDetails.EXTRA_DATE));
            image.setImageResource(extras.getInt(DestinationDetails.EXTRA_IMAGE));

        }


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
        {
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, "Custom Channel", NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);
        }



        book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Booking booking=new Booking(id,totalPrice.getText().toString(),title.getText().toString());
                UserDatabase.getDatabase(BookingActivity.this).myBookingDAO().addBooking(booking);



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