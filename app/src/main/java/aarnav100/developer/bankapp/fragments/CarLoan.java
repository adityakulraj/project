package aarnav100.developer.bankapp.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import aarnav100.developer.bankapp.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class CarLoan extends Fragment {


    public CarLoan() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_car_loan, container, false);
    }

}
