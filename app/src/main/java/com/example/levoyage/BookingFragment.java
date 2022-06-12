package com.example.levoyage;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.List;

public class BookingFragment extends Fragment {

    View view;
    private ListView listView;
    User user;

    public BookingFragment(User user){
        this.user=user;

    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view=inflater.inflate(R.layout.fragment_booking,container,false);

        listView=view.findViewById(R.id.booking_list_view);
        BookingListAdapter bookingListAdapter=new BookingListAdapter(getBookings(),getActivity());
        listView.setAdapter(bookingListAdapter);
        return view;
    }

    private List<Booking> getBookings(){

        List<Booking> bookingList;
        bookingList=UserDatabase.getDatabase(getActivity()).myBookingDAO().getBookings();
        if(bookingList.isEmpty()) {
            UserDatabase.getDatabase(getActivity()).myBookingDAO().addBooking(new Booking(user.getId(), 1, 2, 3, 555));
            UserDatabase.getDatabase(getActivity()).myBookingDAO().addBooking(new Booking(user.getId(), 1, 2, 4, 555));
            bookingList=UserDatabase.getDatabase(getActivity()).myBookingDAO().getBookingsByUserId(user.getId());
        }

        return bookingList;
    }
}
