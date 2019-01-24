package org.pursuit.unit_03_assessment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import org.pursuit.unit_03_assessment.RecycleView.PlanetAdapter;
import org.pursuit.unit_03_assessment.model.Attributes;
import org.pursuit.unit_03_assessment.model.Planets;
import org.pursuit.unit_03_assessment.network.PlanetService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RecyclerActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    public static final String TAG = "Response";
    @NonNull
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);
        recyclerView = findViewById(R.id.planet_item_view);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://raw.githubusercontent.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        PlanetService planetService = retrofit.create(PlanetService.class);
        Call<Planets> planet = planetService.getPlanetList();
        planet.enqueue(new Callback<Planets>() {
            private Call<Planets> call;
            private Response<Planets> response;

            @Override
            public void onResponse( Call<Planets> call, Response<Planets> response) {
                this.call = call;
                this.response = response;
                recyclerView.setAdapter(new PlanetAdapter(response.body().getPlanets()));

                recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
            }

            @Override
            public void onFailure(Call<Planets> call, Throwable t) {
                Log.d(TAG, "onResponse: " + t.toString());


            }
        });

    }
}
    /*
     * TODO: Add logic that will:
     * TODO 1. Make Retrofit instance for this endpoint: https://raw.githubusercontent.com/JDVila/storybook/master/planets.json
     * TODO 2. Make data model objects based on JSON
     * TODO 3. Make a service interface with method(s) to make a GET request
     * TODO 4. Make a request to the JSON endpoint using the Retrofit instance and the service
     * TODO 5. Subclass a RecyclerView Adapter
     * TODO 6. Subclass a RecyclerView ViewHolder
     * TODO 7. Pass list to RecyclerView
     * TODO 8. Display planet name in a RecyclerView tile
     * TODO 9. Implement an OnClickListener for the itemview
     * TODO 10. Pass the Planet Name, Number, and Image URL data to DisplayActivity when tile is clicked
     */


