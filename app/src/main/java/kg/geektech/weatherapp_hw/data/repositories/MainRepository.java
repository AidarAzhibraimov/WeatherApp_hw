package kg.geektech.weatherapp_hw.data.repositories;

import androidx.lifecycle.MutableLiveData;

import javax.inject.Inject;

import kg.geektech.weatherapp_hw.common.Resource;
import kg.geektech.weatherapp_hw.data.models.MainResponse;
import kg.geektech.weatherapp_hw.data.remote.WeatherApi;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainRepository {

    private WeatherApi api;

    @Inject
    public MainRepository(WeatherApi api) {
        this.api = api;
    }

    public MutableLiveData<Resource<MainResponse>> getWeather(String city) {
        MutableLiveData<Resource<MainResponse>> liveData = new MutableLiveData<>();
        liveData.setValue(Resource.loading());
        api.getWeather(city,"a6617172164eca881577390cab718471","metric")
                .enqueue(new Callback<MainResponse>() {
            @Override
            public void onResponse(Call<MainResponse> call, Response<MainResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    liveData.setValue(Resource.success(response.body()));
                } else {
                    liveData.setValue(Resource.error(response.message(), null));
                }
            }

            @Override
            public void onFailure(Call<MainResponse> call, Throwable t) {
                liveData.setValue(Resource.error(t.getLocalizedMessage(), null));
            }
        });
        return liveData;
    }
}
