package com.example.gads;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdapterLeader extends RecyclerView.Adapter<AdapterLeader.ViewHolder> {
    private List<LearningLeaders> learningLeaders;

    // Using involues inflating a layout from xml and returning the holder
    @NonNull
    @Override
    public AdapterLeader.ViewHolder onCreateViewHolder (@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext ();
        LayoutInflater inflater = LayoutInflater.from (context);

        // Inflate the custom layout
        View leaderView = inflater.inflate (R.layout.row_leader, parent,false);

        // Return a new holder instance
        ViewHolder viewHolder = new ViewHolder (leaderView);
        return viewHolder;
    }

    // Involues populating data into item through holder
    @Override
    public void onBindViewHolder (@NonNull ViewHolder holder, int position) {
        // Getting the data model based on the item position
        LearningLeaders learningLeaders1 = learningLeaders.get (position);

        // Set item views based on my views and data model
        TextView textView = holder.textName;
        textView.setText (learningLeaders1.getName ());

        TextView textView1 = holder.texthours_and_country;
        textView1.setText (String.format ("%s learning hours, %s", learningLeaders1.getLearningHours (), learningLeaders1.getCountry ()));
    }


    @Override
    public int getItemCount () {
        return learningLeaders.size ();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        private TextView textName;
        private TextView texthours_and_country;

        public ViewHolder(View itemView){
            super(itemView);

            textName = (TextView) itemView.findViewById (R.id.textLeader);
            texthours_and_country = (TextView) itemView.findViewById (R.id.hours_and_country);
        }
    }

    public AdapterLeader(List<LearningLeaders> learningLeaders1){
        learningLeaders = learningLeaders1;
    }
}
