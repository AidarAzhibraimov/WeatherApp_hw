package kg.geektech.weatherapp_hw.ui.weatherApp;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;
import kg.geektech.weatherapp_hw.App;
import kg.geektech.weatherapp_hw.common.Resource;
import kg.geektech.weatherapp_hw.data.models.MainResponse;
import kg.geektech.weatherapp_hw.data.repositories.MainRepository;

@HiltViewModel
public class WeatherViewModel extends ViewModel {

    private MainRepository repository;
    private String city;

    @Inject
    public WeatherViewModel(MainRepository repository) {
        this.repository = repository;
    }

    public LiveData <Resource<MainResponse>> weatherLiveData;

    public void getWeather(String city){
        weatherLiveData = repository.getWeather(city);
    }


}

