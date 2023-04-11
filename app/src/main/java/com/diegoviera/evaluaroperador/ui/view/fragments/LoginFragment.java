package com.diegoviera.evaluaroperador.ui.view.fragments;

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
import com.diegoviera.evaluaroperador.domain.model.EvaluadorModel;
import com.diegoviera.evaluaroperador.ui.Utils.CustomEditTextMessageIcon;
import com.diegoviera.evaluaroperador.ui.viewmodel.EvaluadorViewModel;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.HasSupportFragmentInjector;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link LoginFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class LoginFragment extends BaseFragment implements HasSupportFragmentInjector, Injectable {

    @Inject
    ViewModelProvider.Factory viewModelFactory;

    //VIEW MODELS
    private EvaluadorViewModel evaluadorViewModel;

    @BindView(R.id.etUsuario)
    CustomEditTextMessageIcon etUsuario;
    @BindView(R.id.etPassword)
    CustomEditTextMessageIcon etPassword;
    @BindView(R.id.btnIniciarSesion)
    Button btnIngresar;

    public LoginFragment() {
        // Required empty public constructor
    }

    public static LoginFragment newInstance(Bundle bundle) {
        LoginFragment fragment = new LoginFragment();
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
        View view = inflater.inflate(R.layout.fragment_login, container, false);
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
        //PRIMERO CREAMOS LOS USUARIOS PARA LA BD
        createEvaluadores();
    }

    private void createEvaluadores() {
        //LISTAMOS LOS EVALUADORES
        List<EvaluadorModel> evaluadorModels = new ArrayList<>();
        EvaluadorModel eval01 = new EvaluadorModel(1,"user01","123456","Juan Pedro","Sanchez Lopez","Cargo 01","Negocio 01");
        EvaluadorModel eval02 = new EvaluadorModel(2,"user02","123456","Raul Augusto","Viera Zegarra","Cargo 02","Negocio 01");
        EvaluadorModel eval03 = new EvaluadorModel(3,"user03","123456","Maria Julia","Gamboa García","Cargo 03","Negocio 02");
        evaluadorModels.add(eval01);
        evaluadorModels.add(eval02);
        evaluadorModels.add(eval03);
        evaluadorViewModel.insertAllEvaluadores(evaluadorModels);
    }

    @Override
    public void onResume() {
        super.onResume();
        initEvents();
    }

    private void initEvents() {
        //ACCIÓN INGRESAR
        btnIngresar.setOnClickListener(view -> {
            goToFragment(HomeFragment.newInstance(new Bundle()));
        });

    }
}