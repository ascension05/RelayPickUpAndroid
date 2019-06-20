package com.relaypickup.relaypickupandroid.controllers.fragments;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.relaypickup.relaypickupandroid.Net.RelayPickupNetService.RelayPickupNetCalls;
import com.relaypickup.relaypickupandroid.Net.utils.NetworkAsyncTask;
import com.relaypickup.relaypickupandroid.R;
import com.relaypickup.relaypickupandroid.databinding.FragmentFollowParcelBinding;
import com.relaypickup.relaypickupandroid.models.FollowParcelFields;
import com.relaypickup.relaypickupandroid.models.FollowParcelViewModel;
import com.relaypickup.relaypickupandroid.models.Parcel;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * interface
 * to handle interaction events.
 * Use the {@link FollowParcelFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FollowParcelFragment extends Fragment implements NetworkAsyncTask.Listeners, RelayPickupNetCalls.FollowParcelCallbacks{
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private FragmentFollowParcelBinding binding;
    private FollowParcelViewModel viewModel;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    public FollowParcelFragment() {
        super();
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment FollowParcelFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static FollowParcelFragment newInstance() {
        FollowParcelFragment fragment = new FollowParcelFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_follow_parcel, container, false);
        viewModel = ViewModelProviders.of(this).get(FollowParcelViewModel.class);
        binding.setLifecycleOwner(this);
        if (savedInstanceState == null) {
            viewModel.init();
        }
        binding.setModel(viewModel);
        setupButtonClick();
        return binding.getRoot();
    }

    public FollowParcelViewModel getViewModel() {
        return viewModel;
    }

    private void setupButtonClick() {
        viewModel.getButtonClick().observe(this, new Observer<FollowParcelFields>() {
            @Override
            public void onChanged(FollowParcelFields followParcelModel) {
                Toast.makeText(getActivity(),
                        "Code " + followParcelModel.getCode(),
                        Toast.LENGTH_SHORT).show();

                FollowParcelFragment.this.executeFollowParcelRequest(followParcelModel.getCode());


            }
        });

    }

    private void executeFollowParcelRequest(String code){

        RelayPickupNetCalls.fetchFollowParcel(this, code);
    }


    @Override
    public void onResponse(@Nullable Parcel parcel) {

        Log.e("Net call response ", " success");
        if(null == parcel){
            Log.e("Net call response ", " parcel null");
        } else{
            Log.e("Net call response ", " parcel not null " + parcel.getId());
            Log.e("Net call response ", " parcel not null " + parcel.getCustomer().getFirstName());
            viewModel.getFollowParcelFields().setSender("test");
            TextView tv = getView().findViewById(R.id.tvSender);
            tv.setText(parcel.getId().toString());
            TextView tv2 = getView().findViewById(R.id.tvReceiver);
            tv2.setText(parcel.getRecipientName());
            LinearLayout parcelDetailsBox = (LinearLayout) getView().findViewById(R.id.parcelDetailsBox);
            parcelDetailsBox.setVisibility(View.VISIBLE);
        }


    }

    @Override
    public void onFailure() {
        Log.e("Net call response ", " failure");
    }

    @Override
    public void onPreExecute() {

    }

    @Override
    public void doInBackground() {

    }

    @Override
    public void onPostExecute(String success) {

    }

}
