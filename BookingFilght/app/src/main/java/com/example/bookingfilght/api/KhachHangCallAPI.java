package com.example.bookingfilght.api;

import com.example.bookingfilght.Models.KhachHangDTO;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public interface KhachHangCallAPI{

    Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
    KhachHangCallAPI callapi = new Retrofit.Builder().baseUrl("https://6092bf0a85ff51001721390f.mockapi.io/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(KhachHangCallAPI.class);

    @GET("USER")
    Call<List<KhachHangDTO>> getAll();

}
