package com.example.a09_18074161_thaihuyhoang.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface APIService {
    Gson gson = new GsonBuilder()
            .setDateFormat("yyyy-MM-dd HH:mm:ss")
            .create();

    APIService apiService = new Retrofit.Builder()
            .baseUrl("https://60aafdfc66f1d0001777356d.mockapi.io/api/users/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(APIService.class);

    @GET("cart")
    Call<List<Cart>> findAll();

    @DELETE("cart/{id}")
    Call<Cart> deleteUser(@Path("id") String id);

    @POST("cart")
    Call<Cart> addUser(@Body Cart user);

    @PUT("cart/{id}")
    Call<Cart> updateUser(@Path("id") String id,
                          @Body Cart user);
}
