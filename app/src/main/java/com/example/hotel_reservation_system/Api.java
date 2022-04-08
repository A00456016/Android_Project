package com.example.hotel_reservation_system;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit.RestAdapter;
import retrofit.converter.GsonConverter;

public class Api {

    public static ApiInterface getClient() {

        RestAdapter adapter = new RestAdapter.Builder()
                .setEndpoint("http://10.0.2.2:8080/")
                .build();

        ApiInterface api = adapter.create(ApiInterface.class);
        return api;
    }
}