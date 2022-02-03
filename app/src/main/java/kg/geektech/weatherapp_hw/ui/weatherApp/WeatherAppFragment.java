package kg.geektech.weatherapp_hw.ui.weatherApp;

import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import kg.geektech.weatherapp_hw.R;
import kg.geektech.weatherapp_hw.base.BaseFragment;
import kg.geektech.weatherapp_hw.common.Resource;
import kg.geektech.weatherapp_hw.data.models.MainResponse;
import kg.geektech.weatherapp_hw.databinding.FragmentWeatherAppBinding;

public class WeatherAppFragment extends BaseFragment<FragmentWeatherAppBinding> {

    private WeatherViewModel viewModel;

    @Override
    protected FragmentWeatherAppBinding bind() {
        return FragmentWeatherAppBinding.inflate(getLayoutInflater());
    }

    @Override
    protected void setupObservers() {
        viewModel.weatherLiveData.observe(getViewLifecycleOwner(), resource -> {
            switch (resource.status){
                case SUCCESS: {
                    viewBinding.progress.setVisibility(View.GONE);
                    setData(resource.data);
                    break;
                }
                case ERROR: {
                    viewBinding.progress.setVisibility(View.GONE);
                    Toast.makeText(requireContext(), "Error data", Toast.LENGTH_SHORT).show();
                    break;
                }
                case LOADING: {
                    viewBinding.progress.setVisibility(View.VISIBLE);
                    break;
                }
            }
        });
    }
    @Override
    public void onResume() {
        super.onResume();
        Calendar uh = Calendar.getInstance();
        int timeOfDay = uh.get(Calendar.HOUR_OF_DAY);

        if (timeOfDay >= 0 && timeOfDay < 12) {
            viewBinding.ivWeather.setImageResource(R.drawable.ic_graphic);
        } else if (timeOfDay >= 12 && timeOfDay < 24) {
            viewBinding.ivWeather.setImageResource(R.drawable.ic_weather);
        }
    }
    public static String getDate(Integer milliSeconds, String dateFormat) {
        SimpleDateFormat formatter = new SimpleDateFormat(dateFormat);
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(milliSeconds);
        return formatter.format(calendar.getTime());
    }

    private void setData(MainResponse data) {
        viewBinding.some.setText(data.getMain().getTemp().toString());
        viewBinding.tv35.setText(data.getMain().getTempMax().toString());
        viewBinding.tvName.setText(data.getName());
        viewBinding.tv27.setText(data.getMain().getTempMin().toString());
        viewBinding.textViewHumidity.setText(data.getMain().getHumidity().toString() + "%");
        viewBinding.textViewBarometer.setText(data.getMain().getPressure().toString() + "mBar");
        viewBinding.textViewWind.setText(data.getWind().getSpeed().toString() + "km/h");
        viewBinding.tvSunsetS.setText(getDate(data.getSys().getSunset(), "hh:mm")+ "Am");
        viewBinding.tvSunriseE.setText(getDate(data.getSys().getSunrise(),"hh:mm")+ "Pm");
        viewBinding.tvDaytime.setText(getDate(data.getDt(),"hh:mm" ));

    }

    @Override
    protected void setupListeners() {

    }

    @Override
    protected void setupViews() {
        viewModel = new ViewModelProvider(requireActivity()).get(WeatherViewModel.class);

    }

    @Override
    protected void callRequest() {
        viewModel.getWeather();
    }
}