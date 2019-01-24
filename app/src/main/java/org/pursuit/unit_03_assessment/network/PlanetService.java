package org.pursuit.unit_03_assessment.network;
import org.pursuit.unit_03_assessment.model.Planets;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PlanetService {
    @GET("/JDVila/storybook/master/planets.json")
    Call<Planets> getPlanetList();
}
