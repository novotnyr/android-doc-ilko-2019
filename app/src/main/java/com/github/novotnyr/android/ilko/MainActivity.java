package com.github.novotnyr.android.ilko;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (isSinglePanelMode()) {
            final TemperatureViewModel temperatureViewModel = ViewModelProviders.of(this).get(TemperatureViewModel.class);
            temperatureViewModel.getSelectedCity().observe(this, new Observer<String>() {
                @Override
                public void onChanged(String city) {
                    MainActivity.this.onCityChanged(city);
                }
            });

            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.activity_main, new MasterFragment())
                    .commit();
        }
    }

    private void onCityChanged(String city) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.activity_main, new DetailFragment())
                .addToBackStack(null)
                .commit();
    }

    private boolean isSinglePanelMode() {
        return findViewById(R.id.activity_main) != null;
    }
}
