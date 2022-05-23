package com.example.levoyage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class PrivremeniActivityBuduciFragment extends AppCompatActivity {

    private ListView listView;
    public static final String EXTRA_IMAGE = "EXTRA_IMAGE";
    public static final String EXTRA_TITLE = "EXTRA_TITLE";
    public static final String EXTRA_DESCTIPRION = "EXTRA_DESCRIPTION";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_explore);

        listView = findViewById(R.id.list_view_container);

        DestinationListAdapter destinationListAdapter = new DestinationListAdapter(getDestinations(),this);
        listView.setAdapter(destinationListAdapter);

        listView.setOnItemClickListener(onItemClickListener);
    }

    private AdapterView.OnItemClickListener onItemClickListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Destinations destinations = (Destinations) parent.getItemAtPosition(position);
            Intent intent = new Intent(PrivremeniActivityBuduciFragment.this, DestinationDetails.class);
            intent.putExtra(EXTRA_IMAGE,destinations.getImageResId());
            intent.putExtra(EXTRA_TITLE,destinations.getTitle());
            intent.putExtra(EXTRA_DESCTIPRION,destinations.getDescription());
            startActivity(intent);
        }
    };

    private List<Destinations> getDestinations()
    {
        List<Destinations> destinationsList = new ArrayList<>();
        destinationsList.add(new Destinations(R.drawable.maldivi,"Maldives", "The Maldive Islands are a series of coral atolls built up from the crowns of a submerged ancient volcanic mountain range. All the islands are low-lying, none rising to more than 6 feet (1.8 metres) above sea level. Barrier reefs protect the islands from the destructive effects of monsoons."));
        destinationsList.add(new Destinations(R.drawable.sarajevo,"Sarajevo", "Sarajevo is a city of cafes and gardens, as one of its main features, having been for so long on caravan trails, is transporting goods from the east to the west and vice versa."));
        destinationsList.add(new Destinations(R.drawable.paris,"Paris", "Paris, city and capital of France, situated in the north-central part of the country. People were living on the site of the present-day city, located along the Seine River some 233 miles (375 km) upstream from the river's mouth on the English Channel (La Manche), by about 7600 bce."));
        return destinationsList;
    }
}