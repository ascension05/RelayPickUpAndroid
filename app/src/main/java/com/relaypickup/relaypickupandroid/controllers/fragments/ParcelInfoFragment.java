package com.relaypickup.relaypickupandroid.controllers.fragments;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.relaypickup.relaypickupandroid.R;
import com.relaypickup.relaypickupandroid.databinding.FragmentParcelInfoBinding;
import com.relaypickup.relaypickupandroid.models.ParcelInfoViewModel;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ParcelInfoFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ParcelInfoFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ParcelInfoFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private FragmentParcelInfoBinding binding;
    private ParcelInfoViewModel viewModel;


    public ParcelInfoFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment ParcelInfoFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ParcelInfoFragment newInstance() {
        ParcelInfoFragment fragment = new ParcelInfoFragment();
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
                inflater, R.layout.fragment_parcel_info, container, false);
        viewModel = ViewModelProviders.of(this).get(ParcelInfoViewModel.class);
        binding.setLifecycleOwner(this);
        if (savedInstanceState == null) {
            viewModel.init();
        }
        binding.setMyModel(viewModel);
        return binding.getRoot();
    }



    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

    public ParcelInfoViewModel getViewModel() {
        return viewModel;
    }
}
