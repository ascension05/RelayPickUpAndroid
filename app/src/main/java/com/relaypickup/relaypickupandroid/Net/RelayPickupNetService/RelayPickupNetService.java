package com.relaypickup.relaypickupandroid.Net.RelayPickupNetService;

import com.relaypickup.relaypickupandroid.models.RelayPickupUser;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface RelayPickupNetService {

    public static final String ENDPOINT = "http://relaypickup.com/";

    public static final Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(ENDPOINT)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    @GET("api/SSO/Authenticate//{usermail}/{password}")
    Call<RelayPickupUser> connexion(@Path("usermail") String userMail, @Path("password") String userPassword);
}
