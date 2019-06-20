package com.relaypickup.relaypickupandroid.controllers.fragments;



import android.os.Bundle;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


import com.relaypickup.relaypickupandroid.Net.RelayPickupNetService.RelayPickupNetCalls;
import com.relaypickup.relaypickupandroid.Net.utils.NetworkAsyncTask;
import com.relaypickup.relaypickupandroid.R;
import com.relaypickup.relaypickupandroid.adapters.CreateParcelPageAdapter;
import com.relaypickup.relaypickupandroid.models.Parcel;
import com.relaypickup.relaypickupandroid.models.RelayPickupUser;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * interface
 * to handle interaction events.
 * Use the {@link CreateParcelFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CreateParcelFragment extends Fragment implements NetworkAsyncTask.Listeners, RelayPickupNetCalls.CreateParcelCallbacks{
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    ViewPager pager;

    private Button mNextButton;
    private Button mPrevButton;



    public CreateParcelFragment() {
        super();
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CreateParcelFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CreateParcelFragment newInstance(String param1, String param2) {
        CreateParcelFragment fragment = new CreateParcelFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
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
        return inflater.inflate(R.layout.fragment_create_parcel, container, false);
    }


    private void configureViewPagerAndTabs() throws InterruptedException {
        //Get ViewPager from layout
        pager = (ViewPager)getView().findViewById(R.id.create_parcel_pager);

        //Set Adapter PageAdapter and glue it together
        if(null == getChildFragmentManager()){
            Log.e("getChildFragmentManager", "null");
        } else {
            Log.e("getChildFragmentManager", " not null");
        }
        pager.setAdapter(new CreateParcelPageAdapter(getChildFragmentManager()));

        mNextButton = (Button) getView().findViewById(R.id.next_button);
        mPrevButton = (Button) getView().findViewById(R.id.prev_button);

        mNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int position = pager.getCurrentItem();
                Log.e("getCurrentItem", ""+pager.getCurrentItem());
                Log.e("getChildCount", ""+pager.getChildCount());
                if (position == pager.getChildCount() -1) {
                    mNextButton.setText(R.string.finish);
                    ParcelInfoFragment parcelInfoFragment = (ParcelInfoFragment) ((CreateParcelPageAdapter) pager.getAdapter()).instantiateItem(pager, pager.getCurrentItem());
                    Log.e("test ", "testtze "+parcelInfoFragment.getViewModel().getParcelInfo().getCategory());
                    Parcel parcel = new Parcel();
                    parcel.setCategory("TestCategory");
                    //parcel.setDeliveryDuration(1);
                    parcel.setWeight(10);
                    //parcel.setIdHolder(1);
                    parcel.setCode("240");
                    RelayPickupUser customer = new RelayPickupUser();
                    customer.setLastName("Test");
                    parcel.setCustomer(customer);
                    parcel.setRecipientName("Roland");
                    CreateParcelFragment.this.executeCreateParcelRequest(parcel);
                }

                pager.setCurrentItem(pager.getCurrentItem() + 1);
            }
        });

        mPrevButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pager.setCurrentItem(pager.getCurrentItem() - 1);
            }
        });

        pager.addOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                updateBottomBar();
            }
        });

        updateBottomBar();


    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //Configure ViewPager
        try {
            this.configureViewPagerAndTabs();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void updateBottomBar() {
        int position = pager.getCurrentItem();
        Log.e("getCurrentItem", ""+pager.getCurrentItem());
        Log.e("getChildCount", ""+pager.getChildCount());
        if (position == pager.getChildCount() -1) {
            mNextButton.setText(R.string.finish);
        }

        mPrevButton.setVisibility(position <= 0 ? View.INVISIBLE : View.VISIBLE);
    }


    private void executeCreateParcelRequest(Parcel parcel){

        RelayPickupNetCalls.fetchCreateParcel(this, parcel);
    }


    @Override
    public void onResponse(@Nullable Parcel parcel) {

        Log.e("Net call response ", " success");
        if(null == parcel){
            Log.e("Net call response ", " parcel null");
        } else
            Log.e("Net call response ", " parcel not null " + parcel.getId());
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
