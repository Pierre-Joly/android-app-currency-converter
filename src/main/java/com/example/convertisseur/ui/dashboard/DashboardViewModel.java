package com.example.convertisseur.ui.dashboard;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

public class DashboardViewModel extends ViewModel {

    private final MutableLiveData<List<String>> mTexts;
    private String[] currency = new String[]{"USD", "EUR", "JPY", "GBP", "CNY", "AUD", "CAD", "CHF", "HKD", "SGD"};
    final Double[] ratedollar = new Double[]{1.00, 1.03, 148.26, 0.90, 7.30, 1.59, 1.37, 1.01, 7.85, 1.42};

    public DashboardViewModel() {
        mTexts = new MutableLiveData<>();
        List<String> texts = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            texts.add("1 " + currency[i] + " = " + ratedollar[i] + " USD ");
        }
        mTexts.setValue(texts);
    }

    public LiveData<List<String>> getTexts() {
        return mTexts;
    }
}
