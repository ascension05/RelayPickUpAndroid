package com.relaypickup.relaypickupandroid.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

import com.relaypickup.relaypickupandroid.controllers.fragments.CustomerInfoFragment;
import com.relaypickup.relaypickupandroid.controllers.fragments.ParcelInfoFragment;

public class CreateParcelPageAdapter extends FragmentPagerAdapter {

    private Fragment mPrimaryItem;

    //Default Constructor
    public CreateParcelPageAdapter(FragmentManager mgr) {
        super(mgr);
    }

    @Override
    public int getCount() {
        return(2);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return CustomerInfoFragment.newInstance();
            case 1:
                return ParcelInfoFragment.newInstance();
            default:
                return null;
        }
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0:
                return "Customer Info";
            case 1:
                return "Package Info";
            case 2:
                return "Receiver Info";
            default:
                return null;
        }
    }

    @Override
    public int getItemPosition(Object object) {
        // TODO: be smarter about this
        if (object == mPrimaryItem) {
            // Re-use the current fragment (its position never changes)
            return POSITION_UNCHANGED;
        }

        return POSITION_NONE;
    }

    @Override
    public void setPrimaryItem(ViewGroup container, int position, Object object) {
        super.setPrimaryItem(container, position, object);
        mPrimaryItem = (Fragment) object;
    }
}
