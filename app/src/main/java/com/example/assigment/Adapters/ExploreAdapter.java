package com.example.assigment.Adapters;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.assigment.Models.ExploreModel;
import com.example.assigment.R;

import java.util.ArrayList;

public class ExploreAdapter extends RecyclerView.Adapter<ExploreAdapter.ViewHolder> {

     ImageView img;
    TextView name, adress, hobby1, hobby2, hobby3, availability;

    ArrayList<ExploreModel> list;
    Context context;

    public ExploreAdapter(ArrayList<ExploreModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ExploreAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.sample_desigb,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ExploreAdapter.ViewHolder holder, int position) {
        final ExploreModel model = list.get(position);
        img.setImageResource(model.getImg());
        name.setText(model.getName());
        adress.setText(model.getAdress());
        hobby1.setText(model.getHobby1());
        hobby2.setText(model.getHobby2());
        hobby3.setText(model.getHobby3());
        availability.setText(model.getAvailability());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img= itemView.findViewById(R.id.img);
            name=itemView.findViewById(R.id.name);
            adress=itemView.findViewById(R.id.adress);
            hobby1=itemView.findViewById(R.id.hobby1);
            hobby2=itemView.findViewById(R.id.hobby2);
            hobby3=itemView.findViewById(R.id.hobby3);
            availability=itemView.findViewById(R.id.availability);



        }
    }
}
