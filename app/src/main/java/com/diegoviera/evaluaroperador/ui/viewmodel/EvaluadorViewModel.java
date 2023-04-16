package com.diegoviera.evaluaroperador.ui.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.diegoviera.evaluaroperador.data.repository.EvaluadorRepository;
import com.diegoviera.evaluaroperador.domain.model.EvaluadorModel;

import java.util.List;

import javax.inject.Inject;


public class EvaluadorViewModel extends AndroidViewModel {

    private EvaluadorRepository evaluadorRepository;

    @Inject
    public EvaluadorViewModel(@NonNull Application application,
                              @NonNull EvaluadorRepository evaluadorRepository) {
        super(application);
        this.evaluadorRepository = evaluadorRepository;
    }


    // BASE DE DATOS LOCAL

    //Evaluadores

    public List<EvaluadorModel> getAllEvaluadores() {
        return evaluadorRepository.getAllEvaluadores();
    }

    public EvaluadorModel getEvaluador(String usuario, String password) {
        return evaluadorRepository.getEvaluador(usuario, password);
    }

    public void insertAllEvaluadores(List<EvaluadorModel> evaluadorModels) {
        evaluadorRepository.registraEvaluadores(evaluadorModels);
    }



}
