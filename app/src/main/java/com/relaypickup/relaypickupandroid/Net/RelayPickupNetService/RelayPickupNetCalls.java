package com.relaypickup.relaypickupandroid.Net.RelayPickupNetService;


import android.support.annotation.Nullable;

import com.relaypickup.relaypickupandroid.models.RelayPickupUser;

import java.lang.ref.WeakReference;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class RelayPickupNetCalls {

    // 1 - Creating a callback
    public interface Callbacks {
        void onResponse(@Nullable RelayPickupUser user);
        void onFailure();
    }

    // Public method to start fetching users following by Jake Wharton
    public static void fetchUserConnexion(Callbacks callbacks, String userMail, String userPassword){

        // Create a weak reference to callback (avoid memory leaks)
        final WeakReference<Callbacks> callbacksWeakReference = new WeakReference<Callbacks>(callbacks);

        // Get a Retrofit instance and the related endpoints
        RelayPickupNetService relayPickupNetService = RelayPickupNetService.retrofit.create(RelayPickupNetService.class);

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
}
