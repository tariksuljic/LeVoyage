package com.example.levoyage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class DestinationListAdapter extends BaseAdapter {

    private List<Destinations> destinationsList;
    private Context context;

    public DestinationListAdapter(List<Destinations> destinationsList, Context context) {
        this.destinationsList = destinationsList;
        this.context = context;
    }
    @Override
    public int getCount() {
        return destinationsList.size();
    }

    @Override
    public Object getItem(int position) {
        return destinationsList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return destinationsList.indexOf(destinationsList.get(position));
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        convertView = inflater.inflate(R.layout.custom_list_destinations, parent,false);
        Destinations destinations = destinationsList.get(position);

        ImageView imageView = convertView.findViewById(R.id.item_image);
        TextView titleTextView = convertView.findViewById(R.id.item_title);
        TextView descriptionTextView = convertView.findViewById(R.id.item_description);

        imageView.setImageResource(destinations.getImageResId());
        titleTextView.setText(destinations.getTitle());
        descriptionTextView.setText(destinations.getDescription());

        return convertView;
    }
}
