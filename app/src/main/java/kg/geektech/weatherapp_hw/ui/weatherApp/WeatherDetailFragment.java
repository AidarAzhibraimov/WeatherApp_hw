package kg.geektech.weatherapp_hw.ui.weatherApp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import dagger.hilt.android.AndroidEntryPoint;
import kg.geektech.weatherapp_hw.R;
import kg.geektech.weatherapp_hw.base.BaseFragment;
import kg.geektech.weatherapp_hw.databinding.FragmentWeatherDetailBinding;

@AndroidEntryPoint
public class WeatherDetailFragment extends BaseFragment<FragmentWeatherDetailBinding> {

    private WeatherDetailViewModel viewModel;

    public WeatherDetailFragment() {
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(requireActivity()).get(WeatherDetailViewModel.class);

    }

    @Override
    protected FragmentWeatherDetailBinding bind() {
        return FragmentWeatherDetailBinding.inflate(getLayoutInflater());
    }

    @Override
    protected void setupObservers() {

    }

    @Override
    protected void setupListeners() {
        viewBinding.btnGetCity.setOnClickListener(view -> {
            WeatherDetailFragmentDirections.ActionWeatherDetailFragmentToWeatherAppFragment action = WeatherDetailFragmentDirections.actionWeatherDetailFragmentToWeatherAppFragment();
            action.setCity(viewBinding.etCityName.getText().toString());
            controller.navigate(action);
        });

    }

    @Override
    protected void setupViews() {

    }

    @Override
    protected void callRequest() {

    }
}