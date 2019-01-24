package org.pursuit.unit_03_assessment.RecycleView;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.pursuit.unit_03_assessment.DisplayActivity;
import org.pursuit.unit_03_assessment.R;
import org.pursuit.unit_03_assessment.model.Attributes;
import org.w3c.dom.Text;

public class PlanetViewHolder extends RecyclerView.ViewHolder {

    private TextView planetTextView;
    private Intent intentSent;
    TextView planetName;
    TextView planetNumber;
    ImageView planetImage;

    public PlanetViewHolder(@NonNull View itemView) {
        super(itemView);
        planetTextView = itemView.findViewById(R.id.planet_item_view);
        planetName = itemView.findViewById(R.id.planet_textview);
        planetNumber = itemView.findViewById(R.id.planet_textview_two);
        planetImage = itemView.findViewById(R.id.planet_imageview);

    }

    public void onBind(final Attributes attributes) {
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intentSent = new Intent(itemView.getContext().getApplicationContext(), DisplayActivity.class);
                intentSent.putExtra("name", attributes.getName());
                intentSent.putExtra("number", attributes.getNumber());
                intentSent.putExtra("image", attributes.getImage());
                itemView.getContext().startActivity(intentSent);
            }
        });

    }
}
