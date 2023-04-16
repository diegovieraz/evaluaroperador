package com.diegoviera.evaluaroperador.ui.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.diegoviera.evaluaroperador.data.repository.EvaluadorRepository;
import com.diegoviera.evaluaroperador.domain.model.EvaluadoModel;

import java.util.List;

import javax.inject.Inject;

public class EvaluadoViewModel extends AndroidViewModel {

    private EvaluadorRepository evaluadorRepository;

    @Inject
    public EvaluadoViewModel(@NonNull Application application,
                             @NonNull EvaluadorRepository evaluadorRepository) {
        super(application);
        this.evaluadorRepository = evaluadorRepository;
    }

    // BASE DE DATOS LOCAL

    //Evaluados

    public List<EvaluadoModel> getAllEvaluados() {
        return evaluadorRepository.getAllEvaluados();
    }

    public EvaluadoModel getEvaluadoXId(Integer id) {
        return evaluadorRepository.getEvaluadorXId(id);
    }

    public EvaluadoModel getEvaluadoXNombre(String nombre) {
        return evaluadorRepository.getEvaluadorXNombre(nombre);
    }

    public void insertAllEvaluados(List<EvaluadoModel> evaluadoModels) {
        evaluadorRepository.registraEvaluados(evaluadoModels);
    }


}
