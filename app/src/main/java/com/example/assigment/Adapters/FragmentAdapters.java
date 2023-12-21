package com.example.assigment.Adapters;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.assigment.Fragments.BusinessFragment;
import com.example.assigment.Fragments.MerchantFragment;
import com.example.assigment.Fragments.PersonalFragment;

public class FragmentAdapters extends FragmentPagerAdapter {
    public FragmentAdapters(@NonNull FragmentManager fm) {
        super(fm);
    }


    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0: return new PersonalFragment();
            case 1: return new BusinessFragment();
            case 2: return new MerchantFragment();
            default: return new PersonalFragment();

        }

    }

    @Override
    public int getCount() {
        return 3;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        String title=null;
        if(position==0){
            title="Personal";
        }
        else if(position==1)
        {
            title="Business";
        }
        else if(position==2){
            title="Merchant";
        }
        return title;
    }
}
