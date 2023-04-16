package com.diegoviera.evaluaroperador.ui.view.fragments;

import static com.diegoviera.evaluaroperador.ui.Utils.Constantes.eval01;
import static com.diegoviera.evaluaroperador.ui.Utils.Constantes.eval02;
import static com.diegoviera.evaluaroperador.ui.Utils.Constantes.eval03;
import static com.diegoviera.evaluaroperador.ui.Utils.Constantes.eval04;
import static com.diegoviera.evaluaroperador.ui.Utils.Constantes.eval05;
import static com.diegoviera.evaluaroperador.ui.Utils.Constantes.eval06;
import static com.diegoviera.evaluaroperador.ui.Utils.Constantes.eval07;
import static com.diegoviera.evaluaroperador.ui.Utils.Constantes.eval08;
import static com.diegoviera.evaluaroperador.ui.Utils.Constantes.eval09;
import static com.diegoviera.evaluaroperador.ui.Utils.Constantes.eval10;
import static com.diegoviera.evaluaroperador.ui.Utils.Constantes.eval11;
import static com.diegoviera.evaluaroperador.ui.Utils.Constantes.eval12;
import static com.diegoviera.evaluaroperador.ui.Utils.Constantes.eval13;
import static com.diegoviera.evaluaroperador.ui.Utils.Constantes.eval14;
import static com.diegoviera.evaluaroperador.ui.Utils.Constantes.evaluadoLog;
import static com.diegoviera.evaluaroperador.ui.Utils.Constantes.evaluadorModels;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

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
        etPassword.setEditTextInputType(10);
        //PRIMERO CREAMOS LOS USUARIOS PARA LA BD
        createEvaluadores();
    }

    private void createEvaluadores() {
        //LISTAMOS LOS EVALUADORES
        evaluadorModels.add(eval01);
        evaluadorModels.add(eval02);
        evaluadorModels.add(eval03);
        evaluadorModels.add(eval04);
        evaluadorModels.add(eval05);
        evaluadorModels.add(eval06);
        evaluadorModels.add(eval07);
        evaluadorModels.add(eval08);
        evaluadorModels.add(eval09);
        evaluadorModels.add(eval10);
        evaluadorModels.add(eval11);
        evaluadorModels.add(eval12);
        evaluadorModels.add(eval13);
        evaluadorModels.add(eval14);
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
            if (validarCampos()){
                Toast.makeText(getContext(),"Usuario correcto.",Toast.LENGTH_LONG).show();
                goToFragment(HomeFragment.newInstance(new Bundle()));
            } else {
                Toast.makeText(getContext(),"Usuario o password incorrecto.",Toast.LENGTH_LONG).show();
            }
        });

    }

    private boolean validarCampos() {
        boolean validUser = false;
        //SE CONSULTA A LA BD SI EL USUARIO EXISTE
        String user = etUsuario.getText();
        String password = etPassword.getText();
        EvaluadorModel evaluador = evaluadorViewModel.getEvaluador(user,password);
        if (evaluador!=null){
            if (evaluador.getId()!=0){
                evaluadoLog = evaluador;
                validUser = true;
            }
        }

        return validUser;
    }
}