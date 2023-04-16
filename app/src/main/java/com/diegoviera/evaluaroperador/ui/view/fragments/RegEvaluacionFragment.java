package com.diegoviera.evaluaroperador.ui.view.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.diegoviera.evaluaroperador.R;

public class RegEvaluacionFragment extends Fragment {

    public RegEvaluacionFragment() {
        // Required empty public constructor
    }

    public static RegEvaluacionFragment newInstance(Bundle bundle) {
        RegEvaluacionFragment fragment = new RegEvaluacionFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_reg_evaluacion, container, false);
    }
}