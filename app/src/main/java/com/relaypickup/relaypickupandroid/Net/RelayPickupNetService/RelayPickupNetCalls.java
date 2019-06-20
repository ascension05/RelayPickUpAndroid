package com.relaypickup.relaypickupandroid.Net.RelayPickupNetService;


import android.support.annotation.Nullable;
import android.util.Log;

import com.google.gson.Gson;
import com.relaypickup.relaypickupandroid.models.ErrorObject;
import com.relaypickup.relaypickupandroid.models.Parcel;
import com.relaypickup.relaypickupandroid.models.RelayPickupUser;

import java.lang.ref.WeakReference;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class RelayPickupNetCalls {

    // Creating a callback
    public interface Callbacks {
        void onResponse(@Nullable RelayPickupUser user);
        void onFailure();
    }

    // Creating a callback for create parcel
    public interface CreateParcelCallbacks {
        void onResponse(@Nullable Parcel parcel);
        void onFailure();
    }

    // Creating a callback for create parcel
    public interface FollowParcelCallbacks {
        void onResponse(@Nullable Parcel parcel);
        void onFailure();
    }

    // Public method to start fetching user
    public static void fetchUserConnexion(Callbacks callbacks, String userMail, String userPassword){

        // Create a weak reference to callback (avoid memory leaks)
        final WeakReference<Callbacks> callbacksWeakReference = new WeakReference<Callbacks>(callbacks);

        // Get a Retrofit instance and the related endpoints
        RelayPickupNetService relayPickupNetService = RelayPickupNetService.retrofitForAuth.create(RelayPickupNetService.class);

        // Create the call on RelayPickup API
        Call<RelayPickupUser> call = relayPickupNetService.connexion(userMail, userPassword);
        // Start the call
        call.enqueue(new Callback<RelayPickupUser>() {

            @Override
            public void onResponse(Call<RelayPickupUser> call, Response<RelayPickupUser> response) {
                // Call the proper callback used in controller (LoginActivity)
                if (callbacksWeakReference.get() != null) callbacksWeakReference.get().onResponse(response.body());
            }

            @Override
            public void onFailure(Call<RelayPickupUser> call, Throwable t) {
                // Call the proper callback used in controller (LoginActivity)
                if (callbacksWeakReference.get() != null) callbacksWeakReference.get().onFailure();
            }
        });
    }

    // Public method to create parcel
    public static void fetchCreateParcel(CreateParcelCallbacks callbacks, Parcel parcel){

        // Create a weak reference to callback (avoid memory leaks)
        final WeakReference<CreateParcelCallbacks> callbacksWeakReference = new WeakReference<CreateParcelCallbacks>(callbacks);

        // Get a Retrofit instance and the related endpoints
        RelayPickupNetService relayPickupNetService = RelayPickupNetService.retrofit.create(RelayPickupNetService.class);

        Log.e("createParcel request", new Gson().toJson(parcel));
        // Create the call on RelayPickup API
        Call<Object> call = relayPickupNetService.createParcel(parcel);
        // Start the call
        call.enqueue(new Callback<Object>() {

            @Override
            public void onResponse(Call<Object> call, Response<Object> response) {

                if (response.body() instanceof Parcel )
                {
                    Parcel myObj = (Parcel) response.body();
                    //handle MyPOJO
                    Log.e("createParcel response", " parcel case");

                }
                else if  (response.body() instanceof ErrorObject )
                {
                    ErrorObject myError = (ErrorObject) response.body();
                    Log.e("createParcel response", " error case");
                    //handle error object
                }

                else  //must be error object
                {
                    ErrorObject myError = (ErrorObject) response.body();
                    Log.e("createParcel response", " other case");
                    Log.e("createParcel response", new Gson().toJson(response));
                    //handle error object
                }
                // Call the proper callback used in controller (LoginActivity)
                //if (callbacksWeakReference.get() != null) callbacksWeakReference.get().onResponse(response.body());
            }

            @Override
            public void onFailure(Call<Object> call, Throwable t) {
                // Call the proper callback used in controller (LoginActivity)
                if (callbacksWeakReference.get() != null) callbacksWeakReference.get().onFailure();
            }
        });
    }

    // Public method to follow parcel
    public static void fetchFollowParcel(FollowParcelCallbacks callbacks, String code){

        // Create a weak reference to callback (avoid memory leaks)
        final WeakReference<FollowParcelCallbacks> callbacksWeakReference = new WeakReference<FollowParcelCallbacks>(callbacks);

        // Get a Retrofit instance and the related endpoints
        RelayPickupNetService relayPickupNetService = RelayPickupNetService.retrofit.create(RelayPickupNetService.class);

        // Create the call on RelayPickup API
        Call<Parcel> call = relayPickupNetService.followParcel(code);
        // Start the call
        call.enqueue(new Callback<Parcel>() {

            @Override
            public void onResponse(Call<Parcel> call, Response<Parcel> response) {
                // Call the proper callback used in controller (LoginActivity)
                if (callbacksWeakReference.get() != null) callbacksWeakReference.get().onResponse(response.body());
            }

            @Override
            public void onFailure(Call<Parcel> call, Throwable t) {
                // Call the proper callback used in controller (LoginActivity)
                if (callbacksWeakReference.get() != null) callbacksWeakReference.get().onFailure();
            }
        });
    }
}
