package com.example.levoyage;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


import java.util.List;

public class ExploreFragment extends Fragment {

    User user;
    View view;
    private ListView listView;
    public static final String EXTRA_IMAGE = "EXTRA_IMAGE";
    public static final String EXTRA_TITLE = "EXTRA_TITLE";
    public static final String EXTRA_DESCRIPTION = "EXTRA_DESCRIPTION";
    public static final String EXTRA_PRICE="EXTRA_PRICE";
    public static final String EXTRA_NUMBER = "EXTRA_NUMBER";
    public static final String EXTRA_DATE="EXTRA_DATE";
    public static final String EXTRA_DESTINATION_ID="EXTRA_DESTINATION_ID";
    public static final String USER_ID="USER_ID";


    public ExploreFragment(User user){
        this.user=user;
    }
    public ExploreFragment(){}

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view=inflater.inflate(R.layout.fragment_explore,container,false);

        listView = view.findViewById(R.id.list_view_container);
        DestinationListAdapter destinationListAdapter = new DestinationListAdapter(getDestinations(),getActivity());
        listView.setAdapter(destinationListAdapter);

        listView.setOnItemClickListener(onItemClickListener);

        return view;

    }
    private AdapterView.OnItemClickListener onItemClickListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Destinations destinations = (Destinations) parent.getItemAtPosition(position);
            Intent intent = new Intent(getActivity() , DestinationDetails.class);
            intent.putExtra(EXTRA_IMAGE,destinations.getImageResId());
            intent.putExtra(EXTRA_TITLE,destinations.getDestination_title());
            intent.putExtra(EXTRA_DESCRIPTION,destinations.getDestination_description());
            intent.putExtra(EXTRA_PRICE,destinations.getDestination_price());
            intent.putExtra(EXTRA_NUMBER, destinations.getPhone_number());
            intent.putExtra(EXTRA_DATE, destinations.getDate());
            intent.putExtra(EXTRA_DESTINATION_ID,destinations.getDestinationId());
            intent.putExtra(USER_ID,user.getId());

            startActivity(intent);
        }
    };

    private List<Destinations> getDestinations()
    {

        List<Destinations> destinationsList;
        destinationsList = UserDatabase.getDatabase(getActivity()).myDestinationsDAO().getAllDestinations();
        if (destinationsList.isEmpty())
        {
            UserDatabase.getDatabase(getActivity()).myDestinationsDAO().addDestination(new Destinations(R.drawable.maldivi,"Maldives Full Fun Adventure Trip",
                    "The Maldive Islands are a series of coral atolls built up from the crowns of a submerged ancient volcanic mountain range. " +
                            "All the islands are low-lying, none rising to more than 6 feet (1.8 metres) above sea level. " +
                            "Barrier reefs protect the islands from the destructive effects of monsoons.", "300", "+38761678862","prvi"));
            UserDatabase.getDatabase(getActivity()).myDestinationsDAO().addDestination(new Destinations(R.drawable.sarajevo,"Sarajevo Grand Tour",
                    "Sarajevo is a city of cafes and gardens, as one of its main features, having been for so long on caravan trails, is" +
                            " transporting goods from the east to the west and vice versa.", "50", "+38761678862","drugi"));
            UserDatabase.getDatabase(getActivity()).myDestinationsDAO().addDestination( new Destinations(R.drawable.paris,"Paris",
                    "Paris, city and capital of France, situated in the north-central part of the country. People were living on the site of the present-day city," +
                            " located along the Seine River some 233 miles (375 km) upstream from the river's mouth on the English Channel (La Manche), by about 7600 bce.", "250", "+38761678862","treci"));
            destinationsList = UserDatabase.getDatabase(getActivity()).myDestinationsDAO().getAllDestinations();
        }



         return destinationsList;
    }
}
