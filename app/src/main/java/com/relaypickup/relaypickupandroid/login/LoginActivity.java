package com.relaypickup.relaypickupandroid.login;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.relaypickup.relaypickupandroid.MainActivity;
import com.relaypickup.relaypickupandroid.Net.RelayPickupNetService.RelayPickupNetCalls;
import com.relaypickup.relaypickupandroid.Net.utils.NetworkAsyncTask;
import com.relaypickup.relaypickupandroid.R;
import com.relaypickup.relaypickupandroid.databinding.ActivityLoginBinding;
import com.relaypickup.relaypickupandroid.login.model.LoginFields;
import com.relaypickup.relaypickupandroid.models.RelayPickupUser;


import android.databinding.DataBindingUtil;


public class LoginActivity extends AppCompatActivity implements NetworkAsyncTask.Listeners, RelayPickupNetCalls.Callbacks{
    private LoginViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setupBindings(savedInstanceState);
    }

    private void setupBindings(Bundle savedInstanceState) {
        ActivityLoginBinding activityBinding = DataBindingUtil.setContentView(this, R.layout.activity_login);
        viewModel = ViewModelProviders.of(this).get(LoginViewModel.class);
        if (savedInstanceState == null) {
            viewModel.init();
        }
        activityBinding.setModel(viewModel);
        setupButtonClick();
    }

    private void setupButtonClick() {
        viewModel.getButtonClick().observe(this, new Observer<LoginFields>() {
            @Override
            public void onChanged(LoginFields loginModel) {
                Toast.makeText(LoginActivity.this,
                        "Email " + loginModel.getEmail() + ", Password " + loginModel.getPassword(),
                        Toast.LENGTH_SHORT).show();

                LoginActivity.this.executeConnexionRequest(loginModel.getEmail(), loginModel.getPassword());


            }
        });

    }

    @Override
    public void onResponse(@Nullable RelayPickupUser user) {
        // When getting response, we update UI
        if (user != null) {
            Toast.makeText(LoginActivity.this,
                    "User address id is " + user.getIdAddress(),
                    Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);
        }

    }

    @Override
    public void onFailure() {
        // When getting error, we update UI
        this.updateUIWhenStopingHTTPRequest("An error happened !");
    }

    @Override
    public void onPreExecute() {
        this.updateUIWhenStartingHTTPRequest();
    }

    @Override
    public void doInBackground() { }

    @Override
    public void onPostExecute(String json) {
        this.updateUIWhenStopingHTTPRequest(json);
    }

    // 4 - Execute HTTP request and update UI
    private void executeConnexionRequest(String userMail, String password){
        this.updateUIWhenStartingHTTPRequest();
        RelayPickupNetCalls.fetchUserConnexion(this, userMail, password);
    }


    private void updateUIWhenStartingHTTPRequest(){
        Toast.makeText(LoginActivity.this,
                "Calling...",
                Toast.LENGTH_SHORT).show();
    }

    private void updateUIWhenStopingHTTPRequest(String response){
        Toast.makeText(LoginActivity.this,
                response,
                Toast.LENGTH_SHORT).show();
    }

}
