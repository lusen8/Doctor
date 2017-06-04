package com.example.lusen.doctor.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lusen.doctor.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class BottomSecondFragment extends Fragment {


    public BottomSecondFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view;
        view = inflater.inflate(R.layout.fragment_bottom_second, container, false);
        return view;
    }

}
