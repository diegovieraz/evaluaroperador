package com.diegoviera.evaluaroperador.ui.view.fragments;

import static com.diegoviera.evaluaroperador.ui.Utils.Constantes.evaluadoLog;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.diegoviera.evaluaroperador.R;
import com.diegoviera.evaluaroperador.di.Injectable;
import com.diegoviera.evaluaroperador.ui.Utils.Constantes;
import com.diegoviera.evaluaroperador.ui.viewmodel.EvaluadorViewModel;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends BaseFragment implements Injectable {

    @Inject
    ViewModelProvider.Factory viewModelFactory;

    @BindView(R.id.tv_evaluador)
    TextView tvEvaluador;
    @BindView(R.id.tv_cargo)
    TextView tvCargo;

    @BindView(R.id.btnRegistrarEvaluacion)
    Button btnRegistrarEvaluacion;
    @BindView(R.id.btnConsultarEvaluacion)
    Button btnConsultarEvaluacion;
    @BindView(R.id.btnGenerarReportes)
    Button btnGenerarReportes;

    //VIEW MODELS
    private EvaluadorViewModel evaluadorViewModel;

    public HomeFragment() {
        // Required empty public constructor
    }


    public static HomeFragment newInstance(Bundle bundle) {
        HomeFragment fragment = new HomeFragment();
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
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        evaluadorViewModel = ViewModelProviders.of(this, viewModelFactory).get(EvaluadorViewModel.class);

        initView();
    }

    private void initView() {
        //SETEAR DATOS EVALUADOR
        tvEvaluador.setText("Evaluador: "+evaluadoLog.getNombre()+" "+evaluadoLog.getApellido());
        tvCargo.setText("Cargo: "+evaluadoLog.getCargo());
    }

    @Override
    public void onResume() {
        super.onResume();
        initEvents();
    }

    private void initEvents() {
        //REDIRECCIONAMIENTO BOTONES
        btnRegistrarEvaluacion.setOnClickListener(view -> {
            goToFragment(RegEvaluacionFragment.newInstance(new Bundle()));
        });

        btnConsultarEvaluacion.setOnClickListener(view -> {

        });

        btnGenerarReportes.setOnClickListener(view -> {

        });
    }
}