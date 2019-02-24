package com.example.forexjapan.activity.customerDetail.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.forexjapan.activity.customerDetail.tabs.additionalInformation.AdditinalInformationFragment;
import com.example.forexjapan.activity.customerDetail.tabs.customerDetail.CustomerDetailFragment;
import com.example.forexjapan.activity.customerDetail.tabs.kycFragment.KycFragment;

public class PagerTabAdapter extends FragmentStatePagerAdapter {

    int tabCount;

    //tab titles
    private String[] tabTitles = new String[]{"Kyc Method", "Customer Detail", "Additional Information"};

    public PagerTabAdapter(FragmentManager fm, int tabCount) {
        super(fm);
        //initializing tabCount variable
        this.tabCount = tabCount;
    }

    // overriding getPageTitle()
    @Override
    public CharSequence getPageTitle(int position) {

        return tabTitles[position];

//        switch (position) {
//            case 0:
//                return "BREAKUP";
//            case 1:
//                return "CANCELLATION";
//            case 2:
//                return "DATE CHAGE";
//            case 3:
//            default:
//                return "BAGGAGE";
//        }
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                KycFragment breackupFragment = new KycFragment();
                return breackupFragment;
            case 1:
                CustomerDetailFragment cancellationFragment = new CustomerDetailFragment();
                return  cancellationFragment;
            case 2:
                AdditinalInformationFragment changeDateFragment = new AdditinalInformationFragment();
                return  changeDateFragment;

            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return tabCount;

    }
}
