package com.example.convertisseur.ui.home;



import static java.lang.Math.floor;
import static java.lang.Math.round;

import androidx.databinding.ObservableField;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.convertisseur.R;

import java.util.Arrays;
import java.util.List;

public class HomeViewModel extends ViewModel {

    public final MutableLiveData<Double> inD = new MutableLiveData<Double>();
    public final MutableLiveData<Double> outD = new MutableLiveData<Double>();
    public final ObservableField<String> inS = new ObservableField<String>();
    public final ObservableField<String> outS = new ObservableField<String>();
    public final ObservableField<String> currencyS = new ObservableField<String>();
    private String virN = "";
    private boolean state = false;
    private String[] currency = new String[]{"USD", "EUR", "JPY", "GBP", "CNY", "AUD", "CAD", "CHF", "HKD", "SGD"};
    private int a = 0;
    private Double b = 0.;
    public int i = 0;
    public int j = 1;
    private Double[][] rate = new Double[10][10];
    public ObservableField<Integer> flagIn = new ObservableField<>();
    public ObservableField<Integer> flagOut = new ObservableField<>();

    public HomeViewModel() {
        final Double[] ratedollar = new Double[]{1., 1.025910, 148.255394, 0.894684, 7.300677, 1.589240, 1.373412, 1.012898, 7.850062, 1.421946};
        for (int k = 0; k < 10; k++) {
            for (int l = 0; l < 10; l++) {
                rate[k][l] = (round(ratedollar[k] / ratedollar[l] *1e7)/1e7);
            }
        }
        inD.setValue(0.);
        outD.setValue(0.);
        inS.set(Double.toString(inD.getValue()));
        outS.set(Double.toString(outD.getValue()));
        currencyS.set(currency[i]+"/"+currency[j]);
        flagIn.set(R.drawable.flag_us);
        flagOut.set(R.drawable.flag_e);
    }

    private Double roundCurrency(Double num) {
        return round(num * 1e2)/1e2;
    }

    public void setIn(Double in) {
        inD.setValue(Double.valueOf((int)floor(in) + "." + virN));
        currencyS.set(currency[i]+"/"+currency[j]);
        inS.set(Double.toString(inD.getValue()));
        setOut();
    }

    private void setOut() {
        outD.setValue(roundCurrency(rate[i][j]*inD.getValue()));
        outS.set(Double.toString(outD.getValue()));
    }

    public void addNumber(Double num) {
        if (state == false){
            setIn((double)floor(inD.getValue())*10+num);
        }
        else {
            virN = virN + (int) round(num);
            setIn(inD.getValue());
        }
    }

    public void clear() {
        virN = "";
        setIn(0.);
        state = false;
    }

    public void Switch() {
        a = i;
        i = j;
        j = a;
        a = flagIn.get();
        flagIn.set(flagOut.get());
        flagOut.set(a);
        setIn(inD.getValue());
    }

    public void vir() {
        if (state) {state = false;}
        else {state = true;}
    };

    public void delete() {
        if (!state) {
        setIn((inD.getValue() - inD.getValue()%10)/10);
        }
        else {
            if (virN.length()>0) {
            virN = virN.substring(0, virN.length()-1);
            setIn(inD.getValue());
            }
        }

    }

}
