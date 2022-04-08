package com.example.hotel_reservation_system;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class HotelGuestDetailsFragment extends Fragment {

    View view;
    ProgressBar progressBar;
    List<GuestListData> guestListResponseData;
    ReservationData reservationData;
    String res_number;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.hotel_guest_details_fragment, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TextView hotelRecapTextView = view.findViewById(R.id.hotel_recap_text_view);

        String hotelName = getArguments().getString("hotel name");
        String hotelPrice = getArguments().getString("hotel price");
        String hotelAvailability = getArguments().getString("hotel availability");
        String checkInDate = getArguments().getString("check in date");
        String checkOutDate = getArguments().getString("check out date");
        String numberOfGuests = getArguments().getString("number of guests");

        hotelRecapTextView.setText("Please enter guests details for " +hotelName
                                    + " from checkIn on " + checkInDate + " and checkOut on " + checkOutDate +
                                    ". The cost will be $ "+hotelPrice+ " and availability is " +hotelAvailability);

        RecyclerView recyclerView = view.findViewById(R.id.guest_list_recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        guestListResponseData = populateList(numberOfGuests);
        GuestListAdapter guestListAdapter = new GuestListAdapter(getActivity(), guestListResponseData);
        recyclerView.setAdapter(guestListAdapter);

        Button nextButton = view.findViewById(R.id.next_button);

        ReservationData reservationData = new ReservationData(1L, hotelName, checkInDate, checkOutDate, guestListResponseData);

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Api.getClient().createPost(reservationData, new Callback<String>() {
                    @Override
                    public void success(String confirmation, Response response) {

                        Bundle bundle = new Bundle();
                        bundle.putString("confirmation", confirmation);

                        HotelConfirmationFragment hotelConfirmationFragment = new HotelConfirmationFragment();
                        hotelConfirmationFragment.setArguments(bundle);

                        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.main_layout, hotelConfirmationFragment);
                        fragmentTransaction.remove(HotelGuestDetailsFragment.this);
                        fragmentTransaction.addToBackStack(null);
                        fragmentTransaction.commit();
                    }

                    @Override
                    public void failure(RetrofitError error) {
                        Toast.makeText(getActivity(), error.toString(), Toast.LENGTH_LONG).show();
                    }
                });

            }
        });


    }

    private ArrayList<GuestListData> populateList(String num){

        ArrayList<GuestListData> list = new ArrayList<>();

        for(int i = 0; i < Integer.valueOf(num); i++){
            GuestListData guestListData = new GuestListData();
            guestListData.setId(Long.valueOf(i));
            list.add(guestListData);
        }

        return list;
    }
}
