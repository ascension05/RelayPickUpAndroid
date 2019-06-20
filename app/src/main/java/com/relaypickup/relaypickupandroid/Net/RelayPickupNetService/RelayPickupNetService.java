package com.relaypickup.relaypickupandroid.Net.RelayPickupNetService;

import com.relaypickup.relaypickupandroid.models.Parcel;
import com.relaypickup.relaypickupandroid.models.RelayPickupUser;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface RelayPickupNetService {

    public static final String ENDPOINT = "https://relaypickup.com/";



    OkHttpClient client = new OkHttpClient.Builder().addInterceptor(new Interceptor() {
        @Override
        public Response intercept(Chain chain) throws IOException {
            Request newRequest  = chain.request().newBuilder()
                    .addHeader("Authorization", "Bearer " + "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1bmlxdWVfbmFtZSI6ImF1ZHJleUBnbWFpbC5jb20iLCJyb2xlIjoiVXNlciIsIm5iZiI6MTU1ODI3ODIyNywiZXhwIjoxNjIxNDM2NjI3LCJpYXQiOjE1NTgyNzgyMjd9.2kgNy1x3ebLob4R8FRAjch6kzsxaM036dYrqu_R6Umk")
                    .build();
            return chain.proceed(newRequest);
        }
    }).build();

    public static final Retrofit retrofit = new Retrofit.Builder()
            .client(client)
            .baseUrl(ENDPOINT)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    public static final Retrofit retrofitForAuth = new Retrofit.Builder()
            .baseUrl(ENDPOINT)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    @GET("api/SSO/Authenticate/{usermail}/{password}")
    Call<RelayPickupUser> connexion(@Path("usermail") String userMail, @Path("password") String userPassword);

    @POST("api/PackageService/CreatePackage")
    @Headers({ "Content-Type: application/json"})
    Call<Object> createParcel(@Body Parcel parcel);

    @GET("api/PackageService/GetPackageByCode/{packageCode}")
    Call<Parcel> followParcel(@Path("packageCode") String code);
}
