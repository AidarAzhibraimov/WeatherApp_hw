package kg.geektech.weatherapp_hw.data.remote;

import kg.geektech.weatherapp_hw.data.models.MainResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WeatherApi {

    @GET("weather")
    Call<MainResponse> getWeather(
            @Query("q") String city,
            @Query("appid") String appId,
            @Query("units") String temp
    );

}
