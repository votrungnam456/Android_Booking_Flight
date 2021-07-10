package com.example.bookingfilght.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public interface callAPI {

    Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
    callAPI callapi = new Retrofit.Builder().baseUrl("https://6092bf0a85ff51001721390f.mockapi.io/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(callAPI.class);


}
