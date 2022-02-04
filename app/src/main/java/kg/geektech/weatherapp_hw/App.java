package kg.geektech.weatherapp_hw;

import android.app.Application;

import dagger.hilt.android.HiltAndroidApp;
import kg.geektech.weatherapp_hw.data.remote.RetrofitClient;
import kg.geektech.weatherapp_hw.data.remote.WeatherApi;
import kg.geektech.weatherapp_hw.data.repositories.MainRepository;

@HiltAndroidApp
public class App extends Application {

    /*private RetrofitClient client;
    private WeatherApi api;
    public static MainRepository repository;*/

    @Override
    public void onCreate() {
        super.onCreate();
        /*client = new RetrofitClient();
        api = client.provideApi();
        repository = new MainRepository(api);*/
    }
}
