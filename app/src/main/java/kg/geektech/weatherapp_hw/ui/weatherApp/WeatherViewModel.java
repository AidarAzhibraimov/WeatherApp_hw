package kg.geektech.weatherapp_hw.ui.weatherApp;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import kg.geektech.weatherapp_hw.App;
import kg.geektech.weatherapp_hw.common.Resource;
import kg.geektech.weatherapp_hw.data.models.MainResponse;

public class WeatherViewModel extends ViewModel {

    public LiveData <Resource<MainResponse>> weatherLiveData;

    public void getWeather(){
        weatherLiveData = App.repository.getWeather();
    }


}
