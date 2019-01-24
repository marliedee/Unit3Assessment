package org.pursuit.unit_03_assessment.RecycleView;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.pursuit.unit_03_assessment.R;
import org.pursuit.unit_03_assessment.model.Attributes;

import java.util.ArrayList;

public class PlanetAdapter extends RecyclerView.Adapter<PlanetViewHolder> {
   private ArrayList<Attributes> planetList;

    public PlanetAdapter(ArrayList<Attributes>planetList) {
        this.planetList = planetList;
    }

    @NonNull
    @Override
    public PlanetViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View childView = inflater.inflate(R.layout.activity_recycler, viewGroup, false);
        return new PlanetViewHolder(childView);
    }


    @Override
    public void onBindViewHolder(@NonNull PlanetViewHolder planetViewHolder, int i) {
        planetViewHolder.planetName.setText(planetList.get(i).getName());
        planetViewHolder.planetNumber.setText(planetList.get(i).getNumber());
        planetViewHolder.planetImage.setImageResource(planetList.size());
        planetViewHolder.onBind(planetList.get(i));

    }

    @Override
    public int getItemCount() {
        return planetList.size();
    }
}


