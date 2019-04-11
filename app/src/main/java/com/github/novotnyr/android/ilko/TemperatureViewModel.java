package com.github.novotnyr.android.ilko;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class TemperatureViewModel extends ViewModel {
    private MutableLiveData<String> selectedCity = new MutableLiveData<>();

    public LiveData<String> getSelectedCity() {
        return selectedCity;
    }

    public void setSelectedCity(String selectedCity) {
        this.selectedCity.postValue(selectedCity);
    }
}
