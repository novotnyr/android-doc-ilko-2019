package com.github.novotnyr.android.ilko;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;


public class MasterFragment extends Fragment {
    private ListView cityListView;

    public MasterFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_master, container, false);

        final TemperatureViewModel temperatureViewModel = ViewModelProviders.of(getActivity()).get(TemperatureViewModel.class);

        cityListView = root.findViewById(R.id.cityListView);
        cityListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String city = (String) parent.getAdapter().getItem(position);
                temperatureViewModel.setSelectedCity(city);
            }
        });

        return root;
    }

}
