package com.example.hotel_reservation_system;

import java.util.List;

import retrofit.Callback;
import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.POST;

public interface ApiInterface {

    // API's endpoints
    @GET("/hotels")
    public void getHotelsLists(Callback<List<HotelListData>> callback);

    @POST("/guests")
    public void createPost(@Body ReservationData reservationData, Callback<String> callback);

}
