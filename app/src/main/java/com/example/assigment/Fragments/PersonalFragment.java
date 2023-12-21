package com.example.assigment.Fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.example.assigment.Adapters.ExploreAdapter;
import com.example.assigment.Models.ExploreModel;
import com.example.assigment.R;
import com.example.assigment.databinding.FragmentPersonalBinding;

import java.util.ArrayList;

public class PersonalFragment extends Fragment {
    FragmentPersonalBinding binding;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding=FragmentPersonalBinding.inflate(getLayoutInflater());
        // Inflate the layout for this fragment
        View view= binding.getRoot();

        EditText searchPlate = binding.searchBar.findViewById(androidx.appcompat.R.id.search_src_text);
        searchPlate.setTextSize(TypedValue.COMPLEX_UNIT_SP, 13);

        ArrayList<ExploreModel> list = new ArrayList<>();
         list.add(new ExploreModel(R.drawable.pp2, "Michael Murphy", "San Francisco,  within 1 Km", "Friendship", "Coffee", "Hangout",
                 "Hi community! I am open to new connections."));
        list.add(new ExploreModel(R.drawable.pp3, "Ajay Gupta", "Vadodara gujarat-391760", "Coding", "Singing", "Movies",
                "I like guy with clever mind."));
        list.add(new ExploreModel(R.drawable.pp4, "Bibek Gupta", "Baglore India ", "Friendship", "Music", "Coffee",
                "Going to New delhi, would love to share a ride"));

        list.add(new ExploreModel(R.drawable.pp5, "jakie janson", "San Francisco,  within 1 Km", "Friendship", "Tea", "Hangout",
                "I am open minded , searching like this minded guy"));
        list.add(new ExploreModel(R.drawable.pp1, "Arvind Sharma", "Ahmedabad gujarat-391760", "Traveling", "Cricket", "Movies",
                "Hi community! I am open to new connections."));
        list.add(new ExploreModel(R.drawable.pp4, "Joseph buddhist", "USA , New York california ", "Dancing", "Chess", "Tea",
                "Hi community! I am open to new connections."));



       ExploreAdapter adapter=new ExploreAdapter(list, getContext());
        binding.recyclerView.setAdapter(adapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        binding.recyclerView.setLayoutManager(layoutManager);


        return view;
    }
}