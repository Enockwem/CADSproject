package com.example.gads;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdapterSkill extends RecyclerView.Adapter<AdapterSkill.ViewHolder> {
    List<SkillIQ> skillIQS;
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder (@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext ();
        LayoutInflater inflater = LayoutInflater.from (context);

        // Inflate the custom layout
        View viewInflater = inflater.inflate (R.layout.row_skill,parent, false);

        // returning the new holder instance
        ViewHolder viewHolder = new ViewHolder (viewInflater);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder (@NonNull ViewHolder holder, int position) {
        // Binding data to the widgets of the recyclerview
        SkillIQ skillscore = skillIQS.get (position);

        TextView textView = holder.textname;
        textView.setText (skillscore.getName ());

        TextView textView1 = holder.score_and_country;
        textView1.setText (String.format ("%s skill score, %s",skillscore.getSkilliqscore (),skillscore.getCountry ()));
    }

    @Override
    public int getItemCount () {
        return 0;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        private TextView textname;
        private TextView score_and_country;

        public ViewHolder(View itemView){
            super(itemView);

            textname = (TextView) itemView.findViewById (R.id.text_name);
            score_and_country = (TextView) itemView.findViewById (R.id.text_for_skill_score);
        }
    }

    public AdapterSkill(List<SkillIQ> skillIQS){
        this.skillIQS = skillIQS;
    }
}
