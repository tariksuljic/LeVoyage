package com.example.levoyage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class BookingActivity extends AppCompatActivity {


    private TextView title,fullName,email,numberOfPersons,totalPrice;
    private Button increment,decrement,book;
    int count=0;

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

            }
        });


    }






}