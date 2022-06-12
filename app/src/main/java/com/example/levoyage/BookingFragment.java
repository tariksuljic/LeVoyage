package com.example.levoyage;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.List;

public class BookingFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private String mParam1;
    private String mParam2;

    View view;
    private ListView listView;
    User user;

    public BookingFragment(User user){
        this.user=user;

    }

    public BookingFragment() {

    }


    public static BookingFragment newInstance(String param1, String param2) {
        BookingFragment fragment = new BookingFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);

        }

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {





        view=inflater.inflate(R.layout.fragment_booking,container,false);
        List<Booking> bookings = UserDatabase.getDatabase(getActivity()).myBookingDAO().getBookingsByUserId(user.getId());
        String[] listItems = new String[bookings.size()];
        int i = 0;
        for (Booking b : bookings) {
            listItems[i] = "\nDestination: " + b.getDestinationTitle() + "\nPrice: " + b.getTotalPrice();
            i++;
        }

        listView=view.findViewById(R.id.booking_list_view);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                getActivity(), R.layout.custom_list_booking, listItems


        );

        listView.setAdapter(adapter);



        return view;
    }


}
