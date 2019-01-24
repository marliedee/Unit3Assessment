package org.pursuit.unit_03_assessment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import org.pursuit.unit_03_assessment.R;

public class DisplayActivity extends AppCompatActivity {

    private TextView planetTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        planetTextView = findViewById(R.id.planet_textview);
        Intent intent = getIntent();
        planetTextView.setText(intent.getStringExtra("name"));
        planetTextView.setText(intent.getStringExtra("number"));
        planetTextView.setText(intent.getStringExtra("image"));



        /*
        * TODO: Add logic that will:
        * TODO 1. Receive values from sending intent
        * TODO 2. Create a TextView instance for the Planet Name
        * TODO 3. Create a TextView instance for the Planet Number count
        * TODO 4. Create an ImageView for the image url
        * TODO 5. Display each value in views - Strings for TextViews, and Picasso for the ImageView
        */
    }
}
