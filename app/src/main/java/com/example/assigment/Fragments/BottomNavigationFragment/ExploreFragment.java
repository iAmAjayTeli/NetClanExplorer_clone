package com.example.assigment.Fragments.BottomNavigationFragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.assigment.Adapters.FragmentAdapters;
import com.example.assigment.R;
import com.example.assigment.databinding.FragmentExploreBinding;
import com.example.assigment.databinding.FragmentPersonalBinding;

public class ExploreFragment extends Fragment {
 FragmentExploreBinding binding;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding=FragmentExploreBinding.inflate(getLayoutInflater());
        // Inflate the layout for this fragment
        View view =binding.getRoot();

        // Create and set up a PagerAdapter (you need to implement this)
        binding.viewPager.setAdapter(new FragmentAdapters(getChildFragmentManager()));
        binding.tabLayout.setupWithViewPager(binding.viewPager);

        // Connect the TabLayout and ViewPager
        binding.tabLayout.setupWithViewPager(binding.viewPager);

        return view;
    }
}