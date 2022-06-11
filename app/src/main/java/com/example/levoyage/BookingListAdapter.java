package com.example.levoyage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class BookingListAdapter extends BaseAdapter {

    private List<Booking> bookingList;
    private Context context;

    public BookingListAdapter(List<Booking> bookingList,Context context){
        this.bookingList=bookingList;
        this.context=context;
    }

    @Override
    public int getCount() {
        return bookingList.size();
    }

    @Override
    public Object getItem(int position) {
        return bookingList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return bookingList.indexOf(bookingList.get(position));
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater= LayoutInflater.from(context);

        convertView = inflater.inflate(R.layout.custom_list_booking, parent,false);
        Booking bookings = bookingList.get(position);

        ImageView imageView = convertView.findViewById(R.id.booked_destination_image);
        TextView titleTextView = convertView.findViewById(R.id.booked_destination_title);
        TextView priceTextView=convertView.findViewById(R.id.booked_destination_price);
        TextView dateTextView=convertView.findViewById(R.id.booked_destination_date);
        TextView personsTextView=convertView.findViewById(R.id.numOfPeople);

//        imageView.setImageResource(destinations.getImageResId());
//        titleTextView.setText(destinations.getDestination_title());
//        priceTextVew.setText("from "+destinations.getDestination_price()+"$");
//        //descriptionTextView.setText(destinations.getDescription());

        return convertView;
    }
}
