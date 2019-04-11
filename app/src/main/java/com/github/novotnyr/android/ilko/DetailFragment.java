package com.github.novotnyr.android.ilko;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class DetailFragment extends Fragment {

    private TextView temperatureTextView;

    public DetailFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_detail, container, false);

        temperatureTextView = root.findViewById(R.id.temperatureTextView);

        final TemperatureViewModel temperatureViewModel = ViewModelProviders.of(getActivity()).get(TemperatureViewModel.class);
        temperatureViewModel.getSelectedCity().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String city) {
                int temperature = Math.abs(city.hashCode()) % 32;
                temperatureTextView.setText("" + temperature);
            }
        });

        return root;
    }

}
